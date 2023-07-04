package industries.icosphere.islandcustomized.events.events.tgttos;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when you finish the round by punching a chicken at the end.
 * <p>
 * More specifically, when the "Whacked!" title is displayed on the screen.
 */
public class RoundFinishEvent implements IslandEvent {

    public IslandGameMode gameMode = IslandGameMode.TGTTOS;

}
