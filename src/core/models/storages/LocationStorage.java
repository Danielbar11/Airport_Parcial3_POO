/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storages;

import core.models.Location;
import java.util.ArrayList;

/**
 *
 * @author ddbarraza
 */
public class LocationStorage {
    
    private static LocationStorage instance;
    
    private ArrayList<Location> locations;

    public LocationStorage() {
        this.locations = new ArrayList<>();
    }
    
    public static LocationStorage getInstance() {
        if (instance == null) {
            instance = new LocationStorage();
        }
        return instance;
    }
    
    public boolean addLocation(Location location) {
        for (Location l : this.locations) {
            if (l.getAirportId() == location.getAirportId()) {
                return false;
            }
        }
        this.locations.add(location);
        return true;
    }
    
    public Location getLocation(int id) {
        for (Location location : this.locations) {
            if (Integer.parseInt(location.getAirportId()) == id) {
                return location;
            }
        }
        return null;
    }
    
    public boolean delPlane(int id) {
        for (Location location : this.locations) {
            if (Integer.parseInt(location.getAirportId()) == id) {
                this.locations.remove(location);
                return true;
            }
        }
        return false;
    }
    
}
