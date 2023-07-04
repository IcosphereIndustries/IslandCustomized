package industries.icosphere.islandcustomized.features;

import industries.icosphere.islandcustomized.events.EventListener;
import industries.icosphere.islandcustomized.events.events.general.GameEndEvent;
import industries.icosphere.islandcustomized.events.events.general.GameOverEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;
import industries.icosphere.islandcustomized.islandutils.IslandUtils;

import static industries.icosphere.islandcustomized.IslandCustomized.*;

@IslandFeatureMetadata(
        name = "AutoGG",
        versionAdded = "pre-3",
        authors = {"Candycup"}
)
public class AutoGG implements IslandFeature {
    @Override
    public boolean enabled() {
        return config.autoGG.enableAutoGG();
    }

    @EventListener(value = GameEndEvent.class)
    public void onGameEnd(GameEndEvent event) {
        if (!enabled()) {
            return;
        }
        if (!IslandUtils.isOnMCCi() && !config.developerResources.enableDeveloperMode()) {
            // Player is not on MCCi.
            return;
        }

        if (IslandUtils.getCurrentGame() == IslandGameMode.UNKNOWN) {
            // Lobby or smth
            return;
        }

        try {
            client.getNetworkHandler().sendChatMessage(config.autoGG.autoGGMessage());
        } catch (NullPointerException e) {
            logger.error("Error while sending autoGG message: " + e.getMessage());
        }
    }
}
