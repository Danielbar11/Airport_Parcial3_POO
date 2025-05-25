
package core.JsonsReaders;

import core.models.Flight;
import core.models.Location;
import core.models.Plane;
import core.models.storages.FlightStorage;
import core.models.storages.LocationStorage;
import core.models.storages.PlaneStorage;
import java.time.LocalDateTime;
import org.json.JSONArray;
import org.json.JSONObject;


public class JsonFlightReader {
    public static void readJsonFlights() {
        try {
            JSONArray array = JsonReaderGeneric.load("src/core/Jsons/flights.json");

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                String planeId = object.getString("plane");
                String departureLocationId = object.getString("departureLocation");
                String arrivalLocationId = object.getString("arrivalLocation");

                Plane plane = PlaneStorage.getInstance().getPlane(planeId);
                Location departureLocation = LocationStorage.getInstance().getLocation(departureLocationId);
                Location arrivalLocation = LocationStorage.getInstance().getLocation(arrivalLocationId);

                LocalDateTime departureDate = LocalDateTime.parse(object.getString("departureDate"));
                int hoursArrival = object.getInt("hoursDurationArrival");
                int minutesArrival = object.getInt("minutesDurationArrival");

                Flight flight;

                if (!object.isNull("scaleLocation")) {
                    String scaleLocationId = object.getString("scaleLocation");
                    Location scaleLocation = LocationStorage.getInstance().getLocation(scaleLocationId);

                    int hoursScale = object.getInt("hoursDurationScale");
                    int minutesScale = object.getInt("minutesDurationScale");

                    flight = new Flight(object.getString("id"), plane, departureLocation, scaleLocation, arrivalLocation, departureDate, hoursArrival, minutesArrival, hoursScale, minutesScale);
                
                } else {
                    flight = new Flight(object.getString("id"), plane, departureLocation, arrivalLocation, departureDate, hoursArrival, minutesArrival);
                }

                FlightStorage.getInstance().addFlight(flight);
            }
        } catch (Exception e) {
            System.out.println("Error reading flights: " + e.getMessage());
        }
    }
    
}
