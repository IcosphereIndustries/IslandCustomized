package industries.icosphere.islandcustomized.events.events;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when the game is won.
 * <p>
 * More specifically, when the "Victory!" title is displayed on the screen.
 */
public class GameWinEvent implements IslandEvent {
    public IslandGameMode gameMode;

    public GameWinEvent(IslandGameMode gameMode) {
        this.gameMode = gameMode;
    }
}
