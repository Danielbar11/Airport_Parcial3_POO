package core.controllers.JTables;

import core.models.Flight;
import core.models.storages.FlightStorage;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class FlightJTableController {
    
    public static void showAllFlights(JTable flightsTable) {
        ArrayList<Flight> flights = FlightStorage.getInstance().getAllFlights();
        
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Departure Airport ID", "Arrival Airport ID", "Scale Airport ID", "Departure Date", "Arrival Date", "Plane ID", "Number Passengers"}, 0);
        
        for (Flight f : flights) {
            if (f.getScaleLocation() == null) {
                String scale = "-";
                model.addRow(new Object[]{f.getId(), f.getDepartureLocation().getAirportId(), f.getArrivalLocation().getAirportId(), scale, f.getDepartureDate(), f.calculateArrivalDate() ,f.getPlane().getId(), f.getNumPassengers()});
            } else {
                model.addRow(new Object[]{f.getId(), f.getDepartureLocation().getAirportId(), f.getArrivalLocation(), f.getScaleLocation().getAirportId(), f.getDepartureDate(), f.calculateArrivalDate() ,f.getPlane().getId(), f.getNumPassengers()});
            }
        }
        
        flightsTable.setModel(model);
    }
    
}
