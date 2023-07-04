package industries.icosphere.islandcustomized.events.events.general;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when you die. This doesn't mean the game ends or your team loses, it just means you died.
 * <p>
 * More specifically, when the "Eliminated" title is displayed on the screen.
 */
public class GameDeathEvent implements IslandEvent {
    public IslandGameMode gameMode;

    public GameDeathEvent(IslandGameMode gameMode) {
        this.gameMode = gameMode;
    }
}
