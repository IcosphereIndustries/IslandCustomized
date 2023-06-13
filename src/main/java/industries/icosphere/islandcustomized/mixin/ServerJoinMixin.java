package industries.icosphere.islandcustomized.mixin;

import industries.icosphere.islandcustomized.IslandConfig;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import static industries.icosphere.islandcustomized.IslandCustomized.config;
import static industries.icosphere.islandcustomized.IslandCustomized.map;

@Mixin(ClientPlayNetworkHandler.class)
public class ServerJoinMixin {
    @Inject(at = @At("HEAD"), method = "onGameJoin")
    public void onGameJoin(GameJoinS2CPacket packet, CallbackInfo ci) {
        map.refresh();
    }
}
