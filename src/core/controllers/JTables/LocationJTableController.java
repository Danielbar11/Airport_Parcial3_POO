package core.controllers.JTables;

import core.models.Location;
import core.models.storages.LocationStorage;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class LocationJTableController {
    
    public static void showLocations(JTable locationsTable) {
        ArrayList<Location> locations = LocationStorage.getInstance().getAllLocations();
        
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Name", "City", "Country", "Latitude", "Longitude"}, 0);
        
        for (Location l : locations) {
                model.addRow(new Object[]{l.getAirportId(), l.getAirportName(), l.getAirportCity(), l.getAirportCountry(), l.getAirportLatitude(), l.getAirportLongitude()});
        }
        
        locationsTable.setModel(model);
    }
    
}
