package industries.icosphere.islandcustomized.mixin;

import industries.icosphere.islandcustomized.IslandCustomized;
import industries.icosphere.islandcustomized.events.IslandEvent;
import industries.icosphere.islandcustomized.events.events.battlebox.KitSelectionEvent;
import industries.icosphere.islandcustomized.events.events.battlebox.RoundLoseEvent;
import industries.icosphere.islandcustomized.events.events.battlebox.RoundWinEvent;
import industries.icosphere.islandcustomized.events.events.general.*;
import industries.icosphere.islandcustomized.events.events.skybattle.TeamDefeatEvent;
import industries.icosphere.islandcustomized.events.events.skybattle.TeamVictoryEvent;
import industries.icosphere.islandcustomized.events.events.tgttos.RoundFinishEvent;
import industries.icosphere.islandcustomized.events.events.tgttos.TimeSkipEvent;
import industries.icosphere.islandcustomized.islandutils.IslandGameMode;
import industries.icosphere.islandcustomized.islandutils.IslandUtils;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static industries.icosphere.islandcustomized.IslandCustomized.config;
import static industries.icosphere.islandcustomized.IslandCustomized.eventManager;
import static industries.icosphere.islandcustomized.islandutils.IslandUtils.getCurrentGame;


@Mixin(ClientPlayNetworkHandler.class)
public class TitleHandlerMixin {
    @Inject(at = @At("TAIL"), method = "onTitle")
    private void titleInjector(TitleS2CPacket packet, CallbackInfo ci) {
        if (!IslandUtils.isOnMCCi() && !config.developerResources.enableDeveloperMode()) {
            // Player is not on MCCi.
            return;
        }

        String titleText = packet.getTitle().getString();

        // Global Titles
        if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.GLOBAL.titles.victory"))) {
            eventManager.fireEvent(new GameWinEvent(getCurrentGame()));
            eventManager.fireEvent(new GameEndEvent(getCurrentGame()));
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.GLOBAL.titles.defeat"))) {
            eventManager.fireEvent(new GameDeathEvent(getCurrentGame()));
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.GLOBAL.titles.game_over"))) {
            eventManager.fireEvent(new GameOverEvent(getCurrentGame()));
            eventManager.fireEvent(new GameEndEvent(getCurrentGame()));
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.GLOBAL.titles.game_starting"))) {
            eventManager.fireEvent(new GameStartingEvent(getCurrentGame()));
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.GLOBAL.titles.round_end"))) {
            eventManager.fireEvent(new RoundEndEvent(getCurrentGame()));
        }

        // Battle Box Titles
        if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.BATTLE_BOX.name"))) {
            eventManager.fireEvent(new GameLoadEvent(IslandGameMode.BATTLE_BOX));
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.BATTLE_BOX.titles.kit_selection"))) {
            eventManager.fireEvent(new KitSelectionEvent());
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.BATTLE_BOX.titles.round_won"))) {
            eventManager.fireEvent(new RoundWinEvent());
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.BATTLE_BOX.titles.round_lost"))) {
            eventManager.fireEvent(new RoundLoseEvent());
        }

        // Sky Battle Titles
        if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.SKY_BATTLE.name"))) {
            eventManager.fireEvent(new GameLoadEvent(IslandGameMode.SKY_BATTLE));
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.SKY_BATTLE.titles.team_defeat"))) {
            eventManager.fireEvent(new TeamDefeatEvent());
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.SKY_BATTLE.titles.team_victory"))) {
            eventManager.fireEvent(new TeamVictoryEvent());
            eventManager.fireEvent(new GameEndEvent(IslandGameMode.SKY_BATTLE));
        }

        // HITW Titles
        if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.HOLE_IN_THE_WALL.name"))) {
            eventManager.fireEvent(new GameLoadEvent(IslandGameMode.HITW));
        }

        // TGTTOS Titles
        // titleText.matches(IslandCustomized.map.getFromTreasureMap())
        if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.TO_GET_TO_THE_OTHER_SIDE.name"))) {
            eventManager.fireEvent(new GameLoadEvent(IslandGameMode.TGTTOS));
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.TO_GET_TO_THE_OTHER_SIDE.titles.round_finish"))) {
            eventManager.fireEvent(new RoundFinishEvent());
        } else if (titleText.matches(IslandCustomized.map.getFromTreasureMap("gameData.TO_GET_TO_THE_OTHER_SIDE.titles.time_skip"))) {
            eventManager.fireEvent(new TimeSkipEvent());
        }

    }
}
