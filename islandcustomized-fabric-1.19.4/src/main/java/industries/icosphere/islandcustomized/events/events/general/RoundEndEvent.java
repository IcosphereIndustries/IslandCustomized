package industries.icosphere.islandcustomized.events.events.general;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when the round ends. Not game, round.
 * <p>
 * More specifically, when the "Round Over!" title is displayed on the screen.
 */
public class RoundEndEvent implements IslandEvent {

    public IslandGameMode gameMode;

    public RoundEndEvent(IslandGameMode gameMode) {
        this.gameMode = gameMode;
    }

}
