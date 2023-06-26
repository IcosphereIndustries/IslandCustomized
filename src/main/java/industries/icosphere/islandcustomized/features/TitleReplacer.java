package industries.icosphere.islandcustomized.features;

import industries.icosphere.islandcustomized.events.EventListener;
import industries.icosphere.islandcustomized.events.events.GameDeathEvent;
import industries.icosphere.islandcustomized.events.events.GameWinEvent;
import net.minecraft.text.MutableText;

import static industries.icosphere.islandcustomized.IslandCustomized.client;
import static industries.icosphere.islandcustomized.IslandCustomized.config;
import static industries.icosphere.islandcustomized.islandutils.IslandUtils.pickRandomDefeatTitle;
import static industries.icosphere.islandcustomized.islandutils.IslandUtils.pickRandomVictoryTitle;

@IslandFeatureMetadata(
        name = "Title Customizer",
        versionAdded = "pre-1",
        authors = {"Candycup"}
)
public class TitleReplacer implements IslandFeature {
    @Override
    public boolean enabled() {
        return config.messageCustomizationSection();
    }

    @EventListener(GameWinEvent.class)
    public void onGameWin(GameWinEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = pickRandomVictoryTitle();

        if (newTitle == null) {
            return;
        }

        client.inGameHud.setTitle(newTitle);
    }

    @EventListener(GameDeathEvent.class)
    public void onGameDeath(GameDeathEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = pickRandomDefeatTitle();

        if (newTitle == null) {
            return;
        }

        client.inGameHud.setTitle(newTitle);
    }
}
