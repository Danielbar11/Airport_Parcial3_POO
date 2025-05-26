package core.controllers.JTables;

import core.models.Plane;
import core.models.storages.PlaneStorage;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class PlaneJTableController {
    
    public static void showAllPlanes(JTable planesTable) {
        ArrayList<Plane> planes = PlaneStorage.getInstance().getAllPlanes();
        
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Brand", "Model", "Max Capacity", "Airline", "Number Flights"}, 0);
        
        for (Plane p : planes) {
                model.addRow(new Object[]{p.getId(), p.getBrand(), p.getModel(), p.getMaxCapacity(), p.getAirline(), p.getNumFlights()});
        }
        
        planesTable.setModel(model);
    }
    
}
