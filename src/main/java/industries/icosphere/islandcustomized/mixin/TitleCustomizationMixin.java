package industries.icosphere.islandcustomized.mixin;

import industries.icosphere.islandcustomized.IslandCustomized;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static industries.icosphere.islandcustomized.utils.CommonUtils.parseColorCodes;
import static industries.icosphere.islandcustomized.utils.CommonUtils.pickRandom;


@Mixin(ClientPlayNetworkHandler.class)
public class TitleCustomizationMixin {
    @Inject(at = @At("TAIL"), method = "onTitle")
    private void onTitle(TitleS2CPacket packet, CallbackInfo ci) {
        String replacementTitle = (String) pickRandom(IslandCustomized.config.skyBattle_titleReplacements.defeatTitles());
        MutableText title = parseColorCodes(replacementTitle);

        MinecraftClient.getInstance().inGameHud.setTitle(title);
    }
}
