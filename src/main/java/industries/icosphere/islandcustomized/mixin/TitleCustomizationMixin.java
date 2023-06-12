package industries.icosphere.islandcustomized.mixin;

import industries.icosphere.islandcustomized.IslandCustomized;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class TitleCustomizationMixin {
    @Inject(at = @At("TAIL"), method = "onTitle")
    private void onTitle(TitleS2CPacket packet, CallbackInfo ci) {
        if (!IslandCustomized.config.messageCustomizationSection()) {
            // Message customization is disabled.
            return;
        }
    }
}
