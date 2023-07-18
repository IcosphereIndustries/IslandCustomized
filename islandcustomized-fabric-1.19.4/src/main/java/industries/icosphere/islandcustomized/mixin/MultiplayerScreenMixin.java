package industries.icosphere.islandcustomized.mixin;

import industries.icosphere.islandcustomized.client.IslandCustomizedClient;
import industries.icosphere.islandcustomized.screens.UpdateNotifierScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.network.ServerInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static industries.icosphere.islandcustomized.IslandCustomizedCore.client;

@Mixin(MultiplayerScreen.class)
public class MultiplayerScreenMixin {

    @Inject(at = @At("HEAD"), method = "connect(Lnet/minecraft/client/network/ServerInfo;)V", cancellable = true)
    private void onJoin(ServerInfo entry, CallbackInfo ci) {
        if (IslandCustomizedClient.updateAvailable) {
            client.setScreen(new UpdateNotifierScreen(entry));
            ci.cancel();
        }
    }

}
