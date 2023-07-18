package industries.icosphere.islandcustomized;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import industries.icosphere.islandcustomized.exceptions.CriticallyMalformedConfigError;
import industries.icosphere.islandcustomized.exceptions.InvalidAPIResponse;
import industries.icosphere.islandcustomized.exceptions.MalformedAPIResponseError;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * IslandTreasureMap is a database that contains updating information about MCCi.
 * <p>
 * <a href="https://github.com/IcosphereIndustries/IslandTreasureMap">IslandTreasureMap on GitHub</a>
 */
public class IslandTreasureMap {
    private JsonObject treasureMap;
    private HashMap<String, Object> cachedData = new HashMap<>();

    public IslandTreasureMap() {
        try {
            fetchData();
        } catch (MalformedAPIResponseError e) {
            throw new InvalidAPIResponse("The IslandTreasureMap API returned a malformed response that couldn't be parsed as JSON. (" + e.getMessage() + ")");
        }
    }

    /**
     * Gets a value from the treasure map.
     *
     * @param key The key to get the value of. Example: gameData.BATTLE_BOX.name
     * @return The value of the key. Example: "Battle Box"
     */
    public String getFromTreasureMap(String key) {
        if (this.cachedData.containsKey(key)) {
            return (String) this.cachedData.get(key);
        }

        String[] keyParts = key.split("\\.");

        JsonElement jsonElement = this.treasureMap;
        for (String keyPart : keyParts) {
            jsonElement = jsonElement.getAsJsonObject().get(keyPart);
            if (jsonElement == null) {
                return null;
            }
        }

        this.cachedData.put(key, jsonElement.getAsString());
        return jsonElement.getAsString();
    }

    /**
     * Gets a value from the treasure map.
     *
     * @param key The key to get the value of. Example: gameData.somethingsomething.intvalue
     * @return The value of the key. Example: 12
     */
    public int getFromTreasureMapAsInt(String key) {
        if (this.cachedData.containsKey(key)) {
            return (int) this.cachedData.get(key);
        }

        String[] keyParts = key.split("\\.");

        JsonElement jsonElement = this.treasureMap;
        for (String keyPart : keyParts) {
            jsonElement = jsonElement.getAsJsonObject().get(keyPart);
            if (jsonElement == null) {
                return 0;
            }
        }

        this.cachedData.put(key, jsonElement.getAsString());
        return jsonElement.getAsInt();
    }

    public void refresh() {
        this.cachedData.clear();
        fetchData();
    }

    private void fetchData() {
        try {
            // Make a GET request to the IslandTreasureMap API
            URL url = new URL(IslandCustomizedCore.config.developerResources.mapInstance());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();

            if (status != 200) {
                throw new InvalidAPIResponse("The IslandTreasureMap API returned a non-200 response code. (" + status + "). GitHub raw content servers down? URL: " + IslandCustomizedCore.config.developerResources.mapInstance());
            }

            // Read the response
            BufferedReader in = new BufferedReader(new java.io.InputStreamReader(con.getInputStream()));

            // Parse the response as JSON
            this.treasureMap = new Gson().fromJson(in, JsonObject.class);
            con.disconnect();

            try {
                IslandCustomizedCore.logger.info("Successfully fetched data from the IslandTreasureMap API.");
            } catch (NullPointerException e) {
                // Logger is null lol - this always happens at startup
            }
        } catch (java.net.MalformedURLException e) {
            throw new CriticallyMalformedConfigError("The mapInstance URL is malformed. (" + IslandCustomizedCore.config.developerResources.mapInstance() + ")");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (MalformedAPIResponseError e) {
            throw new InvalidAPIResponse("The IslandTreasureMap API returned a malformed response that couldn't be parsed as JSON. (" + e.getMessage() + ")");
        }
    }
}
