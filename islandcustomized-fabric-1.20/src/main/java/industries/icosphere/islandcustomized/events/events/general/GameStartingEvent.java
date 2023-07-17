package industries.icosphere.islandcustomized.events.events.general;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when the game starts.
 * <p>
 * More specifically, when the "Starting in" title is displayed on the screen.
 */
public class GameStartingEvent implements IslandEvent {
    public IslandGameMode gameMode;

    public GameStartingEvent(IslandGameMode gameMode) {
        this.gameMode = gameMode;
    }
}
