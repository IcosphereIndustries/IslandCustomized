package industries.icosphere.islandcustomized;

import industries.icosphere.islandcustomized.IslandCustomizedConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IslandCustomized implements ModInitializer {
    public static final IslandCustomizedConfig config = IslandCustomizedConfig.createAndLoad();
    public static final IslandTreasureMap map = new IslandTreasureMap();

    public static Logger logger = LoggerFactory.getLogger("IslandCustomized");

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {

        logger.info("mod minecraft :thumebs up:");

    }
}
