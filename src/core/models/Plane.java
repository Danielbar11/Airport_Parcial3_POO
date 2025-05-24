package core.models;

import java.util.ArrayList;
import core.models.abstracts.AbstractPlane;

/**
 * Plane implementation following SOLID principles
 * Maintains exact same functionality as original
 * 
 * @author edangulo
 */
public class Plane extends AbstractPlane {
    
    private String brand;
    private String model;
    private final int maxCapacity;
    private String airline;
    private ArrayList<Flight> flights;
    
    // Service dependency (following DIP)
    private final IFlightManagementService flightService;

    public Plane(String id, String brand, String model, int maxCapacity, String airline) {
        super(id);
        this.brand = brand;
        this.model = model;
        this.maxCapacity = maxCapacity;
        this.airline = airline;
        this.flights = new ArrayList<>();
        
        // Initialize service via factory (DIP)
        PlaneServiceFactory factory = new PlaneServiceFactory();
        this.flightService = factory.createFlightManagementService(this.flights);
    }

    // Business methods - delegate to service but maintain exact same interface
    
    @Override
    public void addFlight(Flight flight) {
        flightService.addFlight(flight);
    }
    
    @Override
    public int getNumFlights() {
        return flightService.getFlightCount();
    }
    
    // All getters remain exactly the same
    public String getId() {
        return super.getId();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getAirline() {
        return airline;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }
}