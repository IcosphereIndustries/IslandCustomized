package industries.icosphere.islandcustomized.events.events.skybattle;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when your team is eliminated.
 * <p>
 * More specifically, when the "Team eliminated" title is displayed on the screen.
 */
public class TeamDefeatEvent implements IslandEvent {

    public IslandGameMode gameMode = IslandGameMode.SKY_BATTLE;

}
