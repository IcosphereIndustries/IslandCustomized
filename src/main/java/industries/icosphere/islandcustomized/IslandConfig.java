package industries.icosphere.islandcustomized;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Nest;
import io.wispforest.owo.config.annotation.SectionHeader;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@Modmenu(modId = "islandcustomized")
@Config(name = "islandcustomized", wrapperName = "IslandCustomizedConfig")
public class IslandConfig {
    @SectionHeader("generalUtilities")
    @Nest
    public AutoGG autoGG = new AutoGG();
    @SectionHeader("messageCustomizationSection")
    public boolean messageCustomizationSection = false;
    @Nest
    public BattleBoxTitleReplacements battleBox_titleReplacements = new BattleBoxTitleReplacements();
    @Nest
    public SkyBattleTitleReplacements skyBattle_titleReplacements = new SkyBattleTitleReplacements();
    @Nest
    public HitwTitleReplacements hitw_titleReplacements = new HitwTitleReplacements();
    @Nest
    public TgttosTitleReplacements tgttos_titleReplacements = new TgttosTitleReplacements();

    @SectionHeader("advancedDeveloperOptions")
    @Nest
    public DeveloperResources developerResources = new DeveloperResources();

    public static class BattleBoxTitleReplacements {

        public List<String> gameNameTitles = new ArrayList<>(List.of("<#FFFF55>Battle Box"));
        public List<String> kitSelectionTitles = new ArrayList<>(List.of("<#55FFFF>Select your kit"));
        public List<String> startTimerTitles = new ArrayList<>(List.of("<#55FFFF>Starting in"));
        public List<String> roundVictoryTitles = new ArrayList<>(List.of("<#55FF55>&lRound Won!"));
        public List<String> roundDefeatTitles = new ArrayList<>(List.of("<#FF5555>&lRound Lost!"));
        public List<String> roundEndTitles = new ArrayList<>(List.of("<#FF5555>&lRound Lost!"));
        public List<String> victoryTitles = new ArrayList<>(List.of("<#55FF55>&lVictory!"));
        public List<String> defeatTitles = new ArrayList<>(List.of("<#FF5555>&lGame Over!"));

    }

    public static class SkyBattleTitleReplacements {

        public List<String> gameNameTitles = new ArrayList<>(List.of("<#FFFF55>Sky Battle"));
        public List<String> startTimerTitles = new ArrayList<>(List.of("<#55FFFF>Starting in"));
        public List<String> victoryTitles = new ArrayList<>(List.of("<#55FF55>&lVictory!"));
        public List<String> teamVictoryTitles = new ArrayList<>(List.of("<#55FFFF>Team Victory!"));
        public List<String> eliminationTitles = new ArrayList<>(List.of("<#FF5555>&lEliminated"));
        public List<String> teamEliminationTitles = new ArrayList<>(List.of("<#FF5555>Team eliminated"));
        public List<String> defeatTitles = new ArrayList<>(List.of("<#FF5555>&lGame Over!"));
    }

    public static class HitwTitleReplacements {
        public List<String> gameNameTitles = new ArrayList<>(List.of("<#FFFF55>Hole in the Wall"));
        public List<String> startTimerTitles = new ArrayList<>(List.of("<#55FFFF>Starting in"));
        public List<String> victoryTitles = new ArrayList<>(List.of("<#55FF55>&lVictory!"));
        public List<String> eliminationTitles = new ArrayList<>(List.of("<#FF5555>&lEliminated"));
        public List<String> defeatTitles = new ArrayList<>(List.of("<#FF5555>&lGame Over!"));
    }

    public static class TgttosTitleReplacements {
        public List<String> gameNameTitles = new ArrayList<>(List.of("<#FFFF55>TGTTOS"));
        public List<String> startTimerTitles = new ArrayList<>(List.of("<#55FFFF>Starting in"));
        public List<String> whackedTitles = new ArrayList<>(List.of("<#55FF55>Whacked!"));
        public List<String> victoryTitles = new ArrayList<>(List.of("<#55FF55>&lVictory!"));
        public List<String> timeSkipTitles = new ArrayList<>(List.of("<#FF5555>Time Skip"));
        public List<String> defeatTitles = new ArrayList<>(List.of("<#FF5555>&lGame Over!"));

    }

    public static class ParkourWarriorTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>(List.of("<#55FF55>&lVictory!"));
        public List<String> defeatTitles = new ArrayList<>(List.of("<#FF5555>&lEliminated"));
    }

    public static class DeveloperResources {
        public String mapInstance = "https://raw.githubusercontent.com/IcosphereIndustries/IslandTreasureMap/main/v1.json";
        public boolean enableDeveloperMode = false;
    }

    public static class AutoGG {
        public boolean enableAutoGG = false;
        public String autoGGMessage = "gg";
    }
}
