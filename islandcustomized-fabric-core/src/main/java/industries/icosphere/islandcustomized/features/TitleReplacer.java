package industries.icosphere.islandcustomized.features;

import industries.icosphere.islandcustomized.IslandCustomizedCore;
import industries.icosphere.islandcustomized.events.EventListener;
import industries.icosphere.islandcustomized.events.events.battlebox.KitSelectionEvent;
import industries.icosphere.islandcustomized.events.events.battlebox.RoundLoseEvent;
import industries.icosphere.islandcustomized.events.events.battlebox.RoundWinEvent;
import industries.icosphere.islandcustomized.events.events.general.*;
import industries.icosphere.islandcustomized.events.events.skybattle.TeamDefeatEvent;
import industries.icosphere.islandcustomized.events.events.skybattle.TeamVictoryEvent;
import industries.icosphere.islandcustomized.events.events.tgttos.RoundFinishEvent;
import industries.icosphere.islandcustomized.events.events.tgttos.TimeSkipEvent;
import industries.icosphere.islandcustomized.utils.CommonUtils;
import net.minecraft.text.MutableText;

import static industries.icosphere.islandcustomized.islandutils.IslandUtils.*;

@SuppressWarnings("unused")
@IslandFeatureMetadata(
        name = "Title Customizer",
        versionAdded = "pre-1",
        authors = {"Candycup"}
)
public class TitleReplacer implements IslandFeature {
    @Override
    public boolean enabled() {
        return IslandCustomizedCore.config.messageCustomizationSection();
    }

    // General Titles

    @EventListener(GameLoadEvent.class)
    public void onGameLoad(GameLoadEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = pickRandomGameTitle();

        if (newTitle == null) {
            return;
        }

        IslandCustomizedCore.client.inGameHud.setTitle(newTitle);
    }

    @EventListener(GameWinEvent.class)
    public void onGameWin(GameWinEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = pickRandomVictoryTitle();

        if (newTitle == null) {
            return;
        }

        IslandCustomizedCore.client.inGameHud.setTitle(newTitle);
    }

    @EventListener(GameDeathEvent.class)
    public void onGameDeath(GameDeathEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = pickRandomEliminationTitle();

        if (newTitle == null) {
            return;
        }

        IslandCustomizedCore.client.inGameHud.setTitle(newTitle);
    }

    @EventListener(GameOverEvent.class)
    public void onGameLost(GameOverEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = pickRandomDefeatTitle();

        if (newTitle == null) {
            return;
        }

        IslandCustomizedCore.client.inGameHud.setTitle(newTitle);
    }

    @EventListener(GameStartingEvent.class)
    public void onGameStart(GameStartingEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = pickRandomStartingTitle();

        if (newTitle == null) {
            return;
        }

        IslandCustomizedCore.client.inGameHud.setTitle(newTitle);
    }

    @EventListener(RoundEndEvent.class)
    public void onRoundEnd(RoundEndEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = pickRandomRoundEndTitle();

        if (newTitle == null) {
            return;
        }

        IslandCustomizedCore.client.inGameHud.setTitle(newTitle);
    }

    // Battle Box

    @EventListener(KitSelectionEvent.class)
    public void onKitSelectionPhase(KitSelectionEvent event) {
        if (!enabled()) {
            return;
        }

        // Picks a random kit title from the battle box config.
        MutableText newTitle = CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.battleBox_titleReplacements.kitSelectionTitles()));

        if (newTitle == null) {
            return;
        }

        IslandCustomizedCore.client.inGameHud.setTitle(newTitle);
    }

    @EventListener(RoundWinEvent.class)
    public void onRoundWin(RoundWinEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.battleBox_titleReplacements.roundVictoryTitles()));

        if (newTitle == null) {
            return;
        }

        IslandCustomizedCore.client.inGameHud.setTitle(newTitle);
    }

    @EventListener(RoundLoseEvent.class)
    public void onRoundLost(RoundLoseEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.battleBox_titleReplacements.roundDefeatTitles()));

        if (newTitle == null) {
            return;
        }

        IslandCustomizedCore.client.inGameHud.setTitle(newTitle);
    }

    // Sky Battle

    @EventListener(TeamVictoryEvent.class)
    public void onTeamVictory(TeamVictoryEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.skyBattle_titleReplacements.teamVictoryTitles()));

        if (newTitle == null) {
            return;
        }

        IslandCustomizedCore.client.inGameHud.setTitle(newTitle);
    }

    @EventListener(TeamDefeatEvent.class)
    public void onTeamDefeat(TeamDefeatEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.skyBattle_titleReplacements.teamEliminationTitles()));

        if (newTitle == null) {
            return;
        }

        IslandCustomizedCore.client.inGameHud.setTitle(newTitle);
    }

    // HITW

    // TGTTOS
    @EventListener(RoundFinishEvent.class)
    public void onRoundFinish(RoundFinishEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.tgttos_titleReplacements.whackedTitles()));

        if (newTitle == null) {
            return;
        }

        IslandCustomizedCore.client.inGameHud.setTitle(newTitle);
    }

    @EventListener(TimeSkipEvent.class)
    public void onTimeSkip(TimeSkipEvent event) {
        if (!enabled()) {
            return;
        }

        MutableText newTitle = CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.tgttos_titleReplacements.timeSkipTitles()));

        if (newTitle == null) {
            return;
        }

        IslandCustomizedCore.client.inGameHud.setTitle(newTitle);
    }

}
