/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.services;

import core.models.Flight;
import java.util.ArrayList;

/**
 *
 * @author adolf
 */
public class FlightManagementServiceImpl implements IFlightManagementService {
    
    private final ArrayList<Flight> flights;
    
    public FlightManagementServiceImpl(ArrayList<Flight> flights) {
        this.flights = flights;
    }
    
    @Override
    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }
    
    @Override
    public int getFlightCount() {
        return flights.size();
    }
}
