package core.JsonsReaders;

import core.models.Passenger;
import core.models.storages.PassengerStorage;
import java.time.LocalDate;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonPassengerReader {
    public static void readJsonPassengers() {
        try {
            JSONArray array = JsonReaderGeneric.load("src/core/Jsons/passengers.json");

            for (int i = 0; i < array.length(); i++) {
                JSONObject jso = array.getJSONObject(i);

                Passenger passenger = new Passenger(jso.getLong("id"), jso.getString("firstname"), jso.getString("lastname"), LocalDate.parse(jso.getString("birthDate")), jso.getInt("countryPhoneCode"), jso.getLong("phone"), jso.getString("country"));

                PassengerStorage.getInstance().addPassenger(passenger);
            }
        } catch (Exception e) {
            System.out.println("Error reading passengers: " + e.getMessage());
        }
    }
}