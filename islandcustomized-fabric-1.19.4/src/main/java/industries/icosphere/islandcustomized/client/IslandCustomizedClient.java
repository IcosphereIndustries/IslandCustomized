package industries.icosphere.islandcustomized.client;

import industries.icosphere.islandcustomized.UpdateChecker;
import net.fabricmc.api.ClientModInitializer;

public class IslandCustomizedClient implements ClientModInitializer {

    public static boolean updateAvailable;

    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {

        updateAvailable = UpdateChecker.checkForUpdate();

    }
}
