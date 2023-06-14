package industries.icosphere.islandcustomized.islandutils;

import industries.icosphere.islandcustomized.IslandCustomized;
import industries.icosphere.islandcustomized.utils.CommonUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.text.MutableText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static industries.icosphere.islandcustomized.IslandCustomized.config;
import static industries.icosphere.islandcustomized.IslandCustomized.logger;
import static industries.icosphere.islandcustomized.IslandCustomized.client;
import static industries.icosphere.islandcustomized.utils.CommonUtils.parseColorCodes;
import static industries.icosphere.islandcustomized.utils.CommonUtils.pickRandom;

public class IslandUtils {

    /**
     * Returns the current game mode.
     * @return The current game mode (IslandGameMode).
     */
    public static IslandGameMode getCurrentGame() {
        if (config.developerResources.enableDeveloperMode()) {
            return IslandGameMode.SKY_BATTLE;
        }

        if (client.player.getScoreboard() != null) {

            // Get first objective from scoreboard, that contains the location data
            Scoreboard scoreboard = client.player.getScoreboard();
            String locationData = null;

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

    /**
     * Returns whether the player is on MCCi or not.
     * @return Whether the player is on MCCi or not.
     */
    public static boolean isOnMCCi() {

        if (client.getCurrentServerEntry() == null) {
            // Player is not on a server.
            return false;
        }

        return client.getCurrentServerEntry().address.contains("mccisland.net");

    }

    /**
     * Picks a random victory title from the config based on the current game mode.
     * @return A random MutableText object containing the victory title.
     */
    public static MutableText pickRandomVictoryTitle() {
        IslandGameMode gameMode = getCurrentGame();
        logger.info(gameMode.name());
        return switch (gameMode) {
            case HITW -> parseColorCodes((String) pickRandom(config.hitw_titleReplacements.victoryTitles()));
            case BATTLE_BOX -> parseColorCodes((String) pickRandom(config.battleBox_titleReplacements.victoryTitles()));
            case TGTTOS -> parseColorCodes((String) pickRandom(config.tgttos_titleReplacements.victoryTitles()));
            case SKY_BATTLE -> parseColorCodes((String) pickRandom(config.skyBattle_titleReplacements.victoryTitles()));
            default -> null;
        };
    }

    /**
     * Picks a random defeat title from the config based on the current game mode.
     * @return A random MutableText object containing the defeat title.
     */
    public static MutableText pickRandomDefeatTitle() {
        IslandGameMode gameMode = getCurrentGame();
        return switch (gameMode) {
            case HITW -> parseColorCodes((String) pickRandom(config.hitw_titleReplacements.defeatTitles()));
            case BATTLE_BOX -> parseColorCodes((String) pickRandom(config.battleBox_titleReplacements.defeatTitles()));
            case TGTTOS -> parseColorCodes((String) pickRandom(config.tgttos_titleReplacements.defeatTitles()));
            case SKY_BATTLE -> parseColorCodes((String) pickRandom(config.skyBattle_titleReplacements.defeatTitles()));
            case PARKOUR_WARRIOR -> parseColorCodes((String) pickRandom(config.parkourWarrior_titleReplacements.defeatTitles()));
            default -> null;
        };
    }
}
