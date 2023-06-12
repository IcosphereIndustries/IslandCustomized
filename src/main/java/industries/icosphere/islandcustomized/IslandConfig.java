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

    public static class BattleBoxTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>(List.of("Victory!"));
        public List<String> defeatTitles = new ArrayList<>(List.of("Defeat!"));
    }

    public static class SkyBattleTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>(List.of("Victory!"));
        public List<String> defeatTitles = new ArrayList<>(List.of("Defeat!"));
    }

    public static class HitwTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>(List.of("Victory!"));
        public List<String> defeatTitles = new ArrayList<>(List.of("Defeat!"));
    }

    public static class TgttosTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>(List.of("Victory!"));
        public List<String> defeatTitles = new ArrayList<>(List.of("Defeat!"));
    }

    public static class ParkourWarriorTitleReplacements {
        public List<String> victoryTitles = new ArrayList<>(List.of("Victory!"));
        public List<String> defeatTitles = new ArrayList<>(List.of("Defeat!"));
    }
}
