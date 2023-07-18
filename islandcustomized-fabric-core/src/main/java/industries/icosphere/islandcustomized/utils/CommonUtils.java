package industries.icosphere.islandcustomized.utils;

import com.google.gson.JsonElement;
import io.wispforest.owo.config.ui.ConfigScreen;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static industries.icosphere.islandcustomized.IslandCustomizedCore.client;
import static industries.icosphere.islandcustomized.IslandCustomizedCore.config;

public class CommonUtils {

    public static MutableText mutableTextFromString(String input) {
        return Text.of(input).copy();
    }

    /**
     * Parses a string for color codes in the HEX format and returns a MutableText object with the color codes applied.
     * The color codes are in the format <#RRGGBB> where R, G, and B are hexadecimal digits. Include the < and >.
     * Sorry for the semi-unreadable code TODO cleanup :)
     *
     * @param input_ The string to parse
     * @return A MutableText object with the color codes applied
     */
    public static MutableText parseColorCodes(String input_) {
        MutableText result = mutableTextFromString("");
        MutableText input = mutableTextFromString(input_);

        // find all HEX color codes and their indices
        ArrayList<Color> colors = new ArrayList<>(Collections.emptyList());
        String[] split = input.getString().split("<#"); // Change delimiter from "#" to "<#"

        for (String s : split) {
            // TODO: Replaces all "&" with "§" in the string. Unoptimal!
            s = s.replace("&", "§");

            // check if the string starts with a color code (a series of 6 hexadecimal digits)
            if (!(s.length() >= 6)) {
                result.append(mutableTextFromString(s));
                continue;
            }

            String colorCode = s.substring(0, 6);
            try {
                // parse the HEX color code into a Color object
                Color color = Color.decode("#" + colorCode);
                colors.add(color);
                result.append(mutableTextFromString(s.substring(7)).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(color.getRGB()))));
            } catch (NumberFormatException e) {
                result.append(mutableTextFromString(s));
            }
        }
        return result;
    }

    /**
     * Picks a random element from an array
     *
     * @param array The array to pick from
     * @return A random element from the array
     */
    public static Object pickRandom(List<?> array) {
        try {
            return array.get((int) (Math.random() * array.size()));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static void displayConfigScreen() {
        ConfigScreen configScreen = ConfigScreen.create(config, client.currentScreen);
        client.setScreen(configScreen);
    }

    /**
     * Gets a value from a json.
     *
     * @param key The key to get the value of. Example: gameData.BATTLE_BOX.name
     * @return The value of the key. Example: "Battle Box"
     */
    public static String getFromJson(JsonElement json, String key) {
        String[] keyParts = key.split("\\.");

        JsonElement jsonElement = json;
        for (String keyPart : keyParts) {
            jsonElement = jsonElement.getAsJsonObject().get(keyPart);
            if (jsonElement == null) {
                return null;
            }
        }

        return jsonElement.getAsString();
    }
}
