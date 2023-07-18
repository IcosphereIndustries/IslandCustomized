package industries.icosphere.islandcustomized.events.events.general;

import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;

public class GameEndEvent implements IslandEvent {

    public IslandGameMode gameMode;

    public GameEndEvent(IslandGameMode gameMode) {
        this.gameMode = gameMode;
    }

}
