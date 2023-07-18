package industries.icosphere.islandcustomized.islandutils;

import industries.icosphere.islandcustomized.IslandCustomizedCore;
import industries.icosphere.islandcustomized.utils.CommonUtils;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.text.MutableText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IslandUtils {

    /**
     * Returns the current game mode.
     *
     * @return The current game mode (IslandGameMode).
     */
    public static IslandGameMode getCurrentGame() {
        if (IslandCustomizedCore.config.developerResources.enableDeveloperMode()) {
            return IslandGameMode.SKY_BATTLE;
        }

        if (IslandCustomizedCore.client.player.getScoreboard() != null) {

            // Get first objective from scoreboard, that contains the location data
            Scoreboard scoreboard = IslandCustomizedCore.client.player.getScoreboard();
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
     *
     * @return Whether the player is on MCCi or not.
     */
    public static boolean isOnMCCi() {

        if (IslandCustomizedCore.client.getCurrentServerEntry() == null) {
            // Player is not on a server.
            return false;
        }

        return IslandCustomizedCore.client.getCurrentServerEntry().address.contains("mccisland.net");

    }

    /**
     * Picks a random game title from the config based on the current game mode.
     *
     * @return A random MutableText object containing the victory title.
     */
    public static MutableText pickRandomGameTitle() {
        IslandGameMode gameMode = getCurrentGame();
        IslandCustomizedCore.logger.info(gameMode.name());
        return switch (gameMode) {
            case HITW -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.hitw_titleReplacements.gameNameTitles()));
            case BATTLE_BOX -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.battleBox_titleReplacements.gameNameTitles()));
            case TGTTOS -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.tgttos_titleReplacements.gameNameTitles()));
            case SKY_BATTLE -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.skyBattle_titleReplacements.gameNameTitles()));
            default -> null;
        };
    }

    /**
     * Picks a random game title from the config based on the current game mode.
     *
     * @return A random MutableText object containing the victory title.
     */
    public static MutableText pickRandomStartingTitle() {
        IslandGameMode gameMode = getCurrentGame();
        IslandCustomizedCore.logger.info(gameMode.name());
        return switch (gameMode) {
            case HITW -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.hitw_titleReplacements.startTimerTitles()));
            case BATTLE_BOX -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.battleBox_titleReplacements.startTimerTitles()));
            case TGTTOS -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.tgttos_titleReplacements.startTimerTitles()));
            case SKY_BATTLE -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.skyBattle_titleReplacements.startTimerTitles()));
            default -> null;
        };
    }

    /**
     * Picks a random victory title from the config based on the current game mode.
     *
     * @return A random MutableText object containing the victory title.
     */
    public static MutableText pickRandomVictoryTitle() {
        IslandGameMode gameMode = getCurrentGame();
        IslandCustomizedCore.logger.info(gameMode.name());
        return switch (gameMode) {
            case HITW -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.hitw_titleReplacements.victoryTitles()));
            case BATTLE_BOX -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.battleBox_titleReplacements.victoryTitles()));
            case TGTTOS -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.tgttos_titleReplacements.victoryTitles()));
            case SKY_BATTLE -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.skyBattle_titleReplacements.victoryTitles()));
            default -> null;
        };
    }

    /**
     * Picks a random elimination title from the config based on the current game mode.
     *
     * @return A random MutableText object containing the defeat title.
     */
    public static MutableText pickRandomEliminationTitle() {
        IslandGameMode gameMode = getCurrentGame();
        return switch (gameMode) {
            case HITW -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.hitw_titleReplacements.eliminationTitles()));
            case SKY_BATTLE -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.skyBattle_titleReplacements.eliminationTitles()));
            default -> null;
        };
    }

    /**
     * Picks a random defeat title from the config based on the current game mode.
     *
     * @return A random MutableText object containing the defeat title.
     */
    public static MutableText pickRandomDefeatTitle() {
        IslandGameMode gameMode = getCurrentGame();
        return switch (gameMode) {
            case HITW -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.hitw_titleReplacements.defeatTitles()));
            case BATTLE_BOX -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.battleBox_titleReplacements.defeatTitles()));
            case TGTTOS -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.tgttos_titleReplacements.defeatTitles()));
            case SKY_BATTLE -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.skyBattle_titleReplacements.defeatTitles()));
            default -> null;
        };
    }

    /**
     * Picks a random round end title from the config based on the current game mode.
     *
     * @return A random MutableText object containing the defeat title.
     */
    public static MutableText pickRandomRoundEndTitle() {
        IslandGameMode gameMode = getCurrentGame();
        return switch (gameMode) {
            case BATTLE_BOX -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.battleBox_titleReplacements.roundEndTitles()));
            case TGTTOS -> CommonUtils.parseColorCodes((String) CommonUtils.pickRandom(IslandCustomizedCore.config.tgttos_titleReplacements.roundEndTitles()));
            default -> null;
        };
    }
}
