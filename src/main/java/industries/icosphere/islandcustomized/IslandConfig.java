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
    @Nest
    public ParkourWarriorTitleReplacements parkourWarrior_titleReplacements = new ParkourWarriorTitleReplacements();

    @SectionHeader("advancedDeveloperOptions")
    @Nest
    public DeveloperResources developerResources = new DeveloperResources();

    public static class BattleBoxTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>();
        public List<String> defeatTitles = new ArrayList<>();
    }

    public static class SkyBattleTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>();
        public List<String> defeatTitles = new ArrayList<>();
    }

    public static class HitwTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>();
        public List<String> defeatTitles = new ArrayList<>();
    }

    public static class TgttosTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>();
        public List<String> defeatTitles = new ArrayList<>();
    }

    public static class ParkourWarriorTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>();
        public List<String> defeatTitles = new ArrayList<>();
    }

    public static class DeveloperResources {
        public String mapInstance = "https://raw.githubusercontent.com/IcosphereIndustries/IslandTreasureMap/main/v1.json";
        public boolean enableDeveloperMode = false;
    }
}
