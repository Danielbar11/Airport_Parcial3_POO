package core.JsonsReaders;

import core.models.Plane;
import core.models.storages.PlaneStorage;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonPlaneReader {
    public static void readJsonPlanes() {
        try {
            JSONArray array = JsonReaderGeneric.load("src/core/Jsons/planes.json");

            for (int i = 0; i < array.length(); i++) {
                JSONObject jso = array.getJSONObject(i);

                Plane plane = new Plane(jso.getString("id"), jso.getString("brand"), jso.getString("model"), jso.getInt("maxCapacity"), jso.getString("airline"));

                PlaneStorage.getInstance().addPlane(plane);
            }
        } catch (Exception e) {
            System.out.println("Error reading planes: " + e.getMessage());
        }
    }
}