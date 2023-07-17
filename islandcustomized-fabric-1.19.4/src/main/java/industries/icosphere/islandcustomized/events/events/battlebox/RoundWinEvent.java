package industries.icosphere.islandcustomized.events.events.battlebox;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when your team wins the round.
 * <p>
 * More specifically, when the "Round Won!" title is displayed on the screen.
 */
public class RoundWinEvent implements IslandEvent {

    public IslandGameMode gameMode = IslandGameMode.BATTLE_BOX;

}
