package industries.icosphere.islandcustomized.events.events.general;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when the player loses the game.
 * <p>
 * More specifically, when the "Game Over!" title is displayed on the screen.
 */
public class GameOverEvent implements IslandEvent {
    public IslandGameMode gameMode;

    public GameOverEvent(IslandGameMode gameMode) {
        this.gameMode = gameMode;
    }
}
