package core.controllers.JTables;

import core.controllers.utils.FlightAdapter;
import core.models.Flight;
import core.models.storages.FlightStorage;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class FlightJTableController {
    
    public static void showFlights(JTable flightsTable) {
        // Only change: Use SOLID storage instead of legacy storage
        ArrayList<FlightAdapter> flights = FlightStorage.getInstance().getAllFlights();
        
        // Exact same table model as original
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Departure Airport", "Scale Airport", "Arrival Airport", "Departure Date", "Arrival Date", "Plane ID", "Number of passengers"}, 0);
        
        // Exact same logic as original - FlightAdapter provides identical interface
        for (FlightAdapter f : flights) {
            if (f.getScaleLocation() == null) {
                String scale = "-";
                model.addRow(new Object[]{f.getId(), f.getDepartureLocation().getAirportId(), scale, f.getArrivalLocation().getAirportId(), f.getDepartureDate(), f.calculateArrivalDate() ,f.getPlane().getId(), f.getNumPassengers()});
            } else {
                model.addRow(new Object[]{f.getId(), f.getDepartureLocation().getAirportId(), f.getScaleLocation().getAirportId(), f.getArrivalLocation().getAirportId(), f.getDepartureDate(), f.calculateArrivalDate() ,f.getPlane().getId(), f.getNumPassengers()});
            }
        }
        
        flightsTable.setModel(model);
    }
}
