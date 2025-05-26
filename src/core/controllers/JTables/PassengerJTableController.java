package core.controllers.JTables;

import core.models.Passenger;
import core.models.storages.PassengerStorage;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class PassengerJTableController {
    
    public static void showAllPassengers(JTable passengersTable) {
        ArrayList<Passenger> passengers = PassengerStorage.getInstance().getAllPassengers();
        
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Name", "Birthdate", "Age", "Phone", "Country", "Num Flights"}, 0);
        
        for (Passenger p : passengers) {
                model.addRow(new Object[]{p.getId(), p.getFullname(), p.getBirthDate(), p.calculateAge(), p.generateFullPhone(), p.getCountry(), p.getNumFlights()});
        }
        
        passengersTable.setModel(model);
    }
    
}
