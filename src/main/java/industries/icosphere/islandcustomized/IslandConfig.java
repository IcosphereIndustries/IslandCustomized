package industries.icosphere.islandcustomized;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Nest;
import io.wispforest.owo.config.annotation.SectionHeader;

import java.util.ArrayList;
import java.util.List;

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
        public List<String> victoryTitles = new ArrayList<>(List.of("<#55FF55>&lVictory!"));
        public List<String> defeatTitles = new ArrayList<>(List.of("<#FF5555>&lEliminated"));
    }

    public static class SkyBattleTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>(List.of("<#55FF55>&lVictory!"));
        public List<String> defeatTitles = new ArrayList<>(List.of("<#FF5555>&lEliminated"));
    }

    public static class HitwTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>(List.of("<#55FF55>&lVictory!"));
        public List<String> defeatTitles = new ArrayList<>(List.of("<#FF5555>&lEliminated"));
    }

    public static class TgttosTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>(List.of("<#55FF55>&lVictory!"));
        public List<String> defeatTitles = new ArrayList<>(List.of("<#FF5555>&lEliminated"));
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
