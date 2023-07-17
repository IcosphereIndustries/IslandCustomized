package industries.icosphere.islandcustomized;

import industries.icosphere.islandcustomized.events.IslandEventHandler;
import industries.icosphere.islandcustomized.features.AutoGG;
import industries.icosphere.islandcustomized.features.TitleReplacer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IslandCustomized implements ModInitializer {
    public static final industries.icosphere.islandcustomized.IslandCustomizedConfig config = industries.icosphere.islandcustomized.IslandCustomizedConfig.createAndLoad();
    public static final MinecraftClient client = MinecraftClient.getInstance();
    public static final IslandTreasureMap map = new IslandTreasureMap();
    public static IslandEventHandler eventManager = new IslandEventHandler();

    public static Logger logger = LoggerFactory.getLogger("IslandCustomized");

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        eventManager = new IslandEventHandler();

        eventManager.registerEventListener(TitleReplacer.class);
        eventManager.registerEventListener(AutoGG.class);

        logger.info("mod minecraft :thumebs up:");
    }
}
