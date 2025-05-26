
package core.controllers.JTables;

import core.models.Flight;
import core.models.Passenger;
import core.models.storages.FlightStorage;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class FlightsByPassengerJTableController {
    
    public static void showFlightsByPassenger(JTable flightsByPassTable, long passengerId) {
        FlightStorage flightStorage = FlightStorage.getInstance();
        ArrayList<Flight> allFlights = flightStorage.getAllFlights();
        ArrayList<Flight> flightsByPassenger = new ArrayList<>();
        
        for (Flight f : allFlights) {
            for (Passenger p : f.getPassengers()) {
                if (p.getId() == passengerId) {
                    flightsByPassenger.add(f);
                    break;
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Departure Date", "Arrival Date"}, 0);
        
        for (Flight f : flightsByPassenger) {
            model.addRow(new Object[]{f.getId(), f.getDepartureDate().toString(), f.calculateArrivalDate().toString()});
        }
        
        flightsByPassTable.setModel(model);
    }
    
}
