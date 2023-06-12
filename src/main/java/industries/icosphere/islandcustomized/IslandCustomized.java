package industries.icosphere.islandcustomized;

import industries.icosphere.islandcustomized.IslandCustomizedConfig;
import net.fabricmc.api.ModInitializer;

public class IslandCustomized implements ModInitializer {
    public static final IslandCustomizedConfig config = IslandCustomizedConfig.createAndLoad();
    public static final IslandTreasureMap map = new IslandTreasureMap();

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {

        // TODO: Delete this next commit
        System.out.println("Hahahahah i'm using this on Purpose Hahahahahahahahaha");
    }
}
