package industries.icosphere.islandcustomized.events.events;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when the minigame ends. Not round end, but game end.
 * <p>
 * More specifically, when the "Game Over!" title is displayed on the screen.
 * This title should be displayed on the client no matter if you won or lost.
 */
public class GameOverEvent implements IslandEvent {
    public IslandGameMode gameMode;

    public GameOverEvent(IslandGameMode gameMode) {
        this.gameMode = gameMode;
    }
}
