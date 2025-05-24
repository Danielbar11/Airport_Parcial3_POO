/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.solid.flight;

/**
 *
 * @author adolf
 */
import core.models.solid.flight.FlightRoute;
import core.models.Location;
import java.time.Duration;

/**
 * Open/Closed Principle: Open for extension, closed for modification
 * Interface Segregation Principle: Only implements needed methods
 */
public class DirectFlightRoute implements FlightRoute {
    
    private final Location departureLocation;
    private final Location arrivalLocation;
    private final Duration duration;
    
    public DirectFlightRoute(Location departureLocation, Location arrivalLocation, 
                           Duration duration) {
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.duration = duration;
    }
    
    @Override
    public Location getDepartureLocation() {
        return departureLocation;
    }
    
    @Override
    public Location getArrivalLocation() {
        return arrivalLocation;
    }
    
    @Override
    public Duration getTotalDuration() {
        return duration;
    }
}
