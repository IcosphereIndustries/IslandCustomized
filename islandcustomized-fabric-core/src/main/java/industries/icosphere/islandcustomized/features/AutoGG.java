package industries.icosphere.islandcustomized.features;

import industries.icosphere.islandcustomized.IslandCustomizedCore;
import industries.icosphere.islandcustomized.events.EventListener;
import industries.icosphere.islandcustomized.events.events.general.GameEndEvent;
import industries.icosphere.islandcustomized.utils.CommonUtils;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;
import industries.icosphere.islandcustomized.islandutils.IslandUtils;

@IslandFeatureMetadata(
        name = "AutoGG",
        versionAdded = "pre-3",
        authors = {"Candycup"}
)
public class AutoGG implements IslandFeature {
    @Override
    public boolean enabled() {
        return IslandCustomizedCore.config.autoGG.enableAutoGG();
    }

    @EventListener(value = GameEndEvent.class)
    public void onGameEnd(GameEndEvent event) {
        if (!enabled()) {
            return;
        }
        if (!IslandUtils.isOnMCCi() && !IslandCustomizedCore.config.developerResources.enableDeveloperMode()) {
            // Player is not on MCCi.
            return;
        }

        if (IslandUtils.getCurrentGame() == IslandGameMode.UNKNOWN) {
            // Lobby or smth
            return;
        }

        try {
            IslandCustomizedCore.client.getNetworkHandler().sendChatMessage((String) CommonUtils.pickRandom(IslandCustomizedCore.config.autoGG.autoGGMessages()));
        } catch (NullPointerException e) {
            IslandCustomizedCore.logger.error("Error while sending autoGG message: " + e.getMessage());
        }
    }
}
