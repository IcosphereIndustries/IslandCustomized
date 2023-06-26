package industries.icosphere.islandcustomized.mixin;

import industries.icosphere.islandcustomized.IslandCustomized;
import industries.icosphere.islandcustomized.events.events.GameDeathEvent;
import industries.icosphere.islandcustomized.events.events.GameWinEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;
import industries.icosphere.islandcustomized.islandutils.IslandUtils;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static industries.icosphere.islandcustomized.IslandCustomized.*;
import static industries.icosphere.islandcustomized.islandutils.IslandUtils.getCurrentGame;


@Mixin(ClientPlayNetworkHandler.class)
public class TitleHandlerMixin {
    @Inject(at = @At("TAIL"), method = "onTitle")
    private void titleCustomization(TitleS2CPacket packet, CallbackInfo ci) {
        if (!IslandUtils.isOnMCCi() && !config.developerResources.enableDeveloperMode()) {
            // Player is not on MCCi.
            return;
        }

        String titleText = packet.getTitle().getString();

        if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.GLOBAL.titles.victory"))) {
            eventManager.fireEvent(new GameWinEvent(getCurrentGame()));
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.GLOBAL.titles.defeat"))) {
            eventManager.fireEvent(new GameDeathEvent(getCurrentGame()));
        }
    }

    @Inject(at = @At("TAIL"), method = "onTitle")
    private void autoGG(TitleS2CPacket packet, CallbackInfo ci) {
        // todo migrate to events
        if (!config.autoGG.enableAutoGG()) {
            System.out.println("AutoGG is disabled.");
            return;
        }

        if (!IslandUtils.isOnMCCi() && !config.developerResources.enableDeveloperMode()) {
            // Player is not on MCCi.
            System.out.println("Player is not on MCCi.");
            return;
        }

        if (IslandUtils.getCurrentGame() == IslandGameMode.UNKNOWN) {
            // Lobby or smth
            return;
        }

        String titleText = packet.getTitle().getString();

        if (!titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.GLOBAL.titles.gameover"))) {
            return;
        }

        try {
            client.getNetworkHandler().sendChatMessage(config.autoGG.autoGGMessage());
        } catch (NullPointerException e) {
            logger.error("Error while sending autoGG message: " + e.getMessage());
        }

    }

}
