package industries.icosphere.islandcustomized.mixin;

import industries.icosphere.islandcustomized.IslandCustomized;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;
import industries.icosphere.islandcustomized.islandutils.IslandUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.text.MutableText;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static industries.icosphere.islandcustomized.IslandCustomized.config;
import static industries.icosphere.islandcustomized.IslandCustomized.logger;
import static industries.icosphere.islandcustomized.IslandCustomized.client;
import static industries.icosphere.islandcustomized.islandutils.IslandUtils.*;
import static industries.icosphere.islandcustomized.utils.CommonUtils.mutableTextFromString;


@Mixin(ClientPlayNetworkHandler.class)
public class TitleHandlerMixin {
    @Inject(at = @At("TAIL"), method = "onTitle")
    private void titleCustomization(TitleS2CPacket packet, CallbackInfo ci) {
        if (!IslandUtils.isOnMCCi() && !config.developerResources.enableDeveloperMode()) {
            // Player is not on MCCi.
            return;
        }

        if (!config.messageCustomizationSection()) {
            // Message customization is disabled.
            return;
        }

        String titleText = packet.getTitle().getString();

        if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.GLOBAL.titles.victory"))) {
            MutableText newTitle = pickRandomVictoryTitle();

            if (newTitle == null) {
                return;
            }

            client.inGameHud.setTitle(newTitle);
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.GLOBAL.titles.defeat"))) {
            MutableText newTitle = pickRandomDefeatTitle();

            if (newTitle == null) {
                return;
            }

            client.inGameHud.setTitle(newTitle);
        }
    }

    @Inject(at = @At("TAIL"), method = "onTitle")
    private void autoGG(TitleS2CPacket packet, CallbackInfo ci) {
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
