package core.models;

import core.models.solid.flight.FlightRoute;
import core.models.solid.passenger.PassengerManagement;
import java.time.LocalDateTime;

/**
 * Single Responsibility Principle Applied:
 * Flight class now only handles flight identity and basic data
 * No passenger management, calculations, or scheduling logic
 * 
 * @author edangulo
 */
public class Flight {
    
    private final String id;
    private final Plane plane;
    private final FlightRoute route;
    private LocalDateTime departureDate;
    
    // Dependency Inversion Principle: Depend on abstraction, not concretion
    private final PassengerManagement passengerService;
    
    public Flight(String id, Plane plane, FlightRoute route, 
                  LocalDateTime departureDate, PassengerManagement passengerService) {
        this.id = id;
        this.plane = plane;
        this.route = route;
        this.departureDate = departureDate;
        this.passengerService = passengerService;
    }
    
    // Simple getters - no business logic
    public String getId() {
        return id;
    }
    
    public Plane getPlane() {
        return plane;
    }
    
    public FlightRoute getRoute() {
        return route;
    }
    
    public LocalDateTime getDepartureDate() {
        return departureDate;
    }
    
    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }
    
    public PassengerManagement getPassengerService() {
        return passengerService;
    }
}