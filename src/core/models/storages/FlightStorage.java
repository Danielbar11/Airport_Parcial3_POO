/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storages;

import core.controllers.utils.FlightAdapter;
import core.models.Flight;
import core.models.Location;
import core.models.Plane;
import core.models.solid.flight.FlightFactory;
import core.models.solid.flight.FlightScheduleService;
import core.models.solid.flight.FlightScheduling;
import core.models.solid.passenger.PassengerManagement;
import core.models.solid.passenger.PassengerService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ddbarraza
 */
public class FlightStorage {
    
    private static FlightStorage instance;
    
    // Keep your original flights list for compatibility
    private ArrayList<FlightAdapter> flights;
    
    // SOLID architecture components (hidden from existing code)
    private final Map<String, Flight> modernFlights;
    private final FlightFactory flightFactory;
    private final PassengerManagement globalPassengerService;
    private final FlightScheduling scheduleService;

    public FlightStorage() {
        // Initialize original structure
        this.flights = new ArrayList<>();
        
        // Initialize SOLID components
        this.modernFlights = new HashMap<>();
        this.globalPassengerService = new PassengerService();
        this.scheduleService = new FlightScheduleService();
        this.flightFactory = new FlightFactory(globalPassengerService, scheduleService);
    }
    
    public static FlightStorage getInstance() {
        if (instance == null) {
            instance = new FlightStorage();
        }
        return instance;
    }
    
    /**
     * EXACT same method signature and behavior as your original
     * But now creates SOLID-compliant flights underneath
     */
    public boolean addFlight(FlightAdapter flight) {
        // EXACT same duplicate check logic
        for (FlightAdapter f : this.flights) {
            if (f.getId().equals(flight.getId())) {
                return false;
            }
        }

        // EXACT same sorting logic preserved
        int index = 0;
        while (index < flights.size()) {
            String currentId = flights.get(index).getId();
            String newId = flight.getId();

            String lettersCurrent = currentId.substring(0, 3);
            String lettersNew = newId.substring(0, 3);
            int letterComparison = lettersCurrent.compareTo(lettersNew);

            if (letterComparison > 0) {
                break;
            } else if (letterComparison == 0) {
                int numberCurrent = Integer.parseInt(currentId.substring(3));
                int numberNew = Integer.parseInt(newId.substring(3));

                if (numberCurrent > numberNew) {
                    break;
                }
            }
            index++;
        }

        // Add to both collections for compatibility
        this.flights.add(index, flight);
        this.modernFlights.put(flight.getId(), flight.getModernFlight());
        return true;
    }
    
    /**
     * Helper method to create direct flights using SOLID architecture
     * This replaces the need to construct Flight objects manually
     */
    public boolean addDirectFlight(String id, Plane plane, 
                                 Location departureLocation, Location arrivalLocation,
                                 LocalDateTime departureDate, 
                                 int hoursDurationArrival, int minutesDurationArrival) {
        
        // Check if flight already exists
        if (getFlight(id) != null) {
            return false;
        }
        
        // Create using SOLID architecture
        Flight modernFlight = flightFactory.createDirectFlight(
            id, plane, departureLocation, arrivalLocation, 
            departureDate, hoursDurationArrival, minutesDurationArrival
        );
        
        // Wrap in adapter for compatibility
        FlightAdapter adapter = new FlightAdapter(modernFlight);
        
        // Use existing addFlight method to maintain sorting
        return addFlight(adapter);
    }
    
    /**
     * Helper method to create connecting flights using SOLID architecture
     */
    public boolean addConnectingFlight(String id, Plane plane,
                                     Location departureLocation, Location scaleLocation,
                                     Location arrivalLocation, LocalDateTime departureDate,
                                     int hoursDurationArrival, int minutesDurationArrival,
                                     int hoursDurationScale, int minutesDurationScale) {
        
        // Check if flight already exists
        if (getFlight(id) != null) {
            return false;
        }
        
        // Create using SOLID architecture
        Flight modernFlight = flightFactory.createConnectingFlight(
            id, plane, departureLocation, scaleLocation, arrivalLocation,
            departureDate, hoursDurationArrival, minutesDurationArrival,
            hoursDurationScale, minutesDurationScale
        );
        
        // Wrap in adapter for compatibility
        FlightAdapter adapter = new FlightAdapter(modernFlight);
        
        // Use existing addFlight method to maintain sorting
        return addFlight(adapter);
    }

    /**
     * EXACT same method as your original - no changes needed
     */
    public FlightAdapter getFlight(String id) {
        for (FlightAdapter flight : this.flights) {
            if (flight.getId().equals(id)) {
                return flight;
            }
        }
        return null;
    }
    
    /**
     * EXACT same method as your original - no changes needed
     */
    public boolean delFlight(int id) {
        for (FlightAdapter flight : this.flights) {
            if (Integer.parseInt(flight.getId()) == id) {
                this.flights.remove(flight);
                this.modernFlights.remove(flight.getId()); // Keep collections in sync
                return true;
            }
        }
        return false;
    }
    
    /**
     * Enhanced delete method by string ID
     */
    public boolean delFlight(String id) {
        for (FlightAdapter flight : this.flights) {
            if (flight.getId().equals(id)) {
                this.flights.remove(flight);
                this.modernFlights.remove(id); // Keep collections in sync
                return true;
            }
        }
        return false;
    }
    
    /**
     * EXACT same method as your original - no changes needed
     */
    public ArrayList<FlightAdapter> getAllFlights() {
        return this.flights;
    }
    
    /**
     * Access to modern SOLID-compliant flights for advanced operations
     */
    public ArrayList<Flight> getModernFlights() {
        return new ArrayList<>(modernFlights.values());
    }
    
    /**
     * Get the underlying services for advanced operations
     */
    public PassengerManagement getPassengerService() {
        return globalPassengerService;
    }
    
    public FlightScheduling getScheduleService() {
        return scheduleService;
    }
    
    /**
     * Clear all flights
     */
    public void clearAll() {
        flights.clear();
        modernFlights.clear();
    }
    
}
