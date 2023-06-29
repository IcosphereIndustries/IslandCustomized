package industries.icosphere.islandcustomized;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import industries.icosphere.islandcustomized.utils.CommonUtils;
import net.fabricmc.loader.api.FabricLoader;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AutoUpdate {

    public static boolean checkForUpdate() {

        String latestRelease = null;

        try {
            URL url = new URL("https://api.github.com/repos/IcosphereIndustries/IslandCustomized/releases/latest");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();

            // Read the response
            BufferedReader in = new BufferedReader(new java.io.InputStreamReader(con.getInputStream()));

            latestRelease = CommonUtils.getFromJson(new Gson().fromJson(in, JsonObject.class), "tag_name");

        } catch (Exception e) {
            System.out.println("Could not check for updates! Please check your internet connection.");
        }

        if (latestRelease == null) { return false; }

        if (!latestRelease.equals(FabricLoader.getInstance().getModContainer("islandcustomized").get().getMetadata().getVersion().getFriendlyString())) {
            return true;
        }

        return false;
    }

}
