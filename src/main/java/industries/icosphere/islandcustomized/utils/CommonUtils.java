package industries.icosphere.islandcustomized.utils;

import net.minecraft.client.MinecraftClient;

public class CommonUtils {
    public static boolean isOnMCCi() {
        if (MinecraftClient.getInstance().getCurrentServerEntry() == null) {
            // Player is not on a server.
            return false;
        }

        return MinecraftClient.getInstance().getCurrentServerEntry().address.contains("mccisland.net");
    }
}
