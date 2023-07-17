package industries.icosphere.islandcustomized.events.events.skybattle;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when your team wins the game.
 * <p>
 * More specifically, when the "Team Victory!" title is displayed on the screen.
 */
public class TeamVictoryEvent implements IslandEvent {

    public IslandGameMode gameMode = IslandGameMode.SKY_BATTLE;

}
