package industries.icosphere.islandcustomized.events.events.general;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when the game title is displayed.
 */
public class GameLoadEvent implements IslandEvent {
    public IslandGameMode gameMode;

    public GameLoadEvent(IslandGameMode gameMode) {
        this.gameMode = gameMode;
    }
}
