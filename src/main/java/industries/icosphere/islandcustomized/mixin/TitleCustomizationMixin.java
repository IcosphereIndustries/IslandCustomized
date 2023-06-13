package industries.icosphere.islandcustomized.mixin;

import industries.icosphere.islandcustomized.IslandCustomized;
import industries.icosphere.islandcustomized.islandutils.IslandUtils;
import io.wispforest.owo.config.ui.ConfigScreen;
import io.wispforest.owo.ui.core.*;
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
import static industries.icosphere.islandcustomized.IslandCustomized.client;
import static industries.icosphere.islandcustomized.islandutils.IslandUtils.*;


@Mixin(ClientPlayNetworkHandler.class)
public class TitleCustomizationMixin {
    @Shadow @Final private static Logger LOGGER;

    @Inject(at = @At("TAIL"), method = "onTitle")
    private void onTitle(TitleS2CPacket packet, CallbackInfo ci) {
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
            IslandCustomized.logger.info(newTitle.getString());
            client.inGameHud.setTitle(newTitle);
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.GLOBAL.titles.defeat"))) {
            MutableText newTitle = pickRandomDefeatTitle();
            if (newTitle == null) {
                return;
            }
            IslandCustomized.logger.info(newTitle.getString());
            client.inGameHud.setTitle(newTitle);
        }
    }
}
