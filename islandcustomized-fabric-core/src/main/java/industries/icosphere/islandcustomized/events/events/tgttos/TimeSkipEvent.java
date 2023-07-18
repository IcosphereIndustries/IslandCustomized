package industries.icosphere.islandcustomized.events.events.tgttos;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when a few players remain, so the game sets the timer to 20 seconds.
 * <p>
 * More specifically, when the "Time Skip" title is displayed on the screen.
 */
public class TimeSkipEvent implements IslandEvent {

    public IslandGameMode gameMode = IslandGameMode.TGTTOS;

}
