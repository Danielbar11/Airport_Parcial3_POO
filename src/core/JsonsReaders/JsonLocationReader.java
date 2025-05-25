package core.JsonsReaders;

import core.models.Location;
import core.models.storages.LocationStorage;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonLocationReader {
    public static void readJsonLocations() {
        try {
            JSONArray array = JsonReaderGeneric.load("src/core/Jsons/locations.json");

            for (int i = 0; i < array.length(); i++) {
                JSONObject jso = array.getJSONObject(i);

                Location location = new Location(jso.getString("airportId"), jso.getString("airportName"), jso.getString("airportCity"), jso.getString("airportCountry"), jso.getDouble("airportLatitude"), jso.getDouble("airportLongitude"));

                LocationStorage.getInstance().addLocation(location);
            }
        } catch (Exception e) {
            System.out.println("Error reading locations: " + e.getMessage());
        }
    }
}