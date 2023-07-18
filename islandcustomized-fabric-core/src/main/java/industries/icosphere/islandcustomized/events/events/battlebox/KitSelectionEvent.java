package industries.icosphere.islandcustomized.events.events.battlebox;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

/**
 * Event that is fired when you're faced to choose one of the kits the game provides for you.
 * <p>
 * More specifically, when the "Select your kit" title is displayed on the screen.
 */
public class KitSelectionEvent implements IslandEvent {

    public IslandGameMode gameMode = IslandGameMode.BATTLE_BOX;

}
