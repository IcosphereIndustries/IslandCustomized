package industries.icosphere.islandcustomized.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MCCUtils {

    public static IslandGameMode getCurrentGame() {
        if (MinecraftClient.getInstance().player.getScoreboard() != null) {
            // Get first objective from scoreboard, that contains the location data
            Scoreboard scoreboard = MinecraftClient.getInstance().player.getScoreboard();
            String locationData = null;
            // TODO: Okay this is pretty goofy (there's only a single objective)
            for (ScoreboardObjective objective : scoreboard.getObjectives()) {
                locationData = objective.getDisplayName().getString();
            }

            Pattern pattern = Pattern.compile("MCCI: (.+)", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(locationData);

            if (matcher.find()) {
                return switch (matcher.group(1).strip()) {
                    case "HOLE IN THE WALL" -> IslandGameMode.HITW;
                    case "BATTLE BOX" -> IslandGameMode.BATTLE_BOX;
                    case "TGTTOS" -> IslandGameMode.TGTTOS;
                    case "SKY BATTLE" -> IslandGameMode.SKY_BATTLE;
                    case "PARKOUR WARRIOR" -> IslandGameMode.PARKOUR_WARRIOR;
                    default -> IslandGameMode.UNKNOWN;
                };
            }
        }
        return IslandGameMode.UNKNOWN;
    }

    public static boolean isOnMCCi() {
        if (MinecraftClient.getInstance().getCurrentServerEntry() == null) {
            // Player is not on a server.
            return false;
        }

        return MinecraftClient.getInstance().getCurrentServerEntry().address.contains("mccisland.net");
    }

}
