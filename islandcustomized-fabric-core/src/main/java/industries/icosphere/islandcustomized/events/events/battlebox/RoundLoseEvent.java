package industries.icosphere.islandcustomized.events.events.battlebox;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when your team loses the round.
 * <p>
 * More specifically, when the "Round Lost!" title is displayed on the screen.
 */
public class RoundLoseEvent implements IslandEvent {

    public IslandGameMode gameMode = IslandGameMode.BATTLE_BOX;

}
