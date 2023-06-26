package industries.icosphere.islandcustomized.events.events;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when you die. This doesn't mean the game ends or your team loses, it just means you died.
 * <p>
 * More specifically, when the "Eliminated" title is displayed on the screen.
 */
public class GameDeathEvent implements IslandEvent {
    public IslandGameMode gameMode;

    /**
     * Constructs a GameDeathEvent with the specified game mode.
     *
     * @param gameMode the game mode that the death event is in
     */
    public GameDeathEvent(IslandGameMode gameMode) {
        this.gameMode = gameMode;
    }
}
