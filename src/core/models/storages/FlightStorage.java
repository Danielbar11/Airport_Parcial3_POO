/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storages;

import core.models.Flight;
import java.util.ArrayList;

/**
 *
 * @author ddbarraza
 */
public class FlightStorage {
    
    private static FlightStorage instance;
    
    private ArrayList<Flight> flights;

    public FlightStorage() {
        this.flights = new ArrayList<>();
    }
    
    public static FlightStorage getInstance() {
        if (instance == null) {
            instance = new FlightStorage();
        }
        return instance;
    }
    
    public boolean addFlight(Flight flight) {
        for (Flight f : this.flights) {
            if (f.getId().equals(flight.getId())) {
                return false;
            }
        }
        this.flights.add(flight);
        return true;
    }
    
    public Flight getFlight(String id) {
        for (Flight flight : this.flights) {
            if (flight.getId().equals(id)) {
                return flight;
            }
        }
        return null;
    }
    
    public boolean delFlight(int id) {
        for (Flight flight : this.flights) {
            if (Integer.parseInt(flight.getId()) == id) {
                this.flights.remove(flight);
                return true;
            }
        }
        return false;
    }
    
}
