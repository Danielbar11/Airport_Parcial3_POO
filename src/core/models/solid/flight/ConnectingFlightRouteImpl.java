/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.solid.flight;

/**
 *
 * @author adolf
 */
import core.models.solid.flight.ConnectingFlightRoute;
import core.models.Location;
import java.time.Duration;

/**
 * Open/Closed Principle: New flight type without modifying existing code
 * Liskov Substitution Principle: Can substitute base FlightRoute
 */
public class ConnectingFlightRouteImpl implements ConnectingFlightRoute {
    
    private final Location departureLocation;
    private final Location scaleLocation;
    private final Location arrivalLocation;
    private final Duration scaleDuration;
    private final Duration arrivalDuration;
    
    public ConnectingFlightRouteImpl(Location departureLocation, Location scaleLocation,
                                   Location arrivalLocation, Duration scaleDuration, 
                                   Duration arrivalDuration) {
        this.departureLocation = departureLocation;
        this.scaleLocation = scaleLocation;
        this.arrivalLocation = arrivalLocation;
        this.scaleDuration = scaleDuration;
        this.arrivalDuration = arrivalDuration;
    }
    
    @Override
    public Location getDepartureLocation() {
        return departureLocation;
    }
    
    @Override
    public Location getScaleLocation() {
        return scaleLocation;
    }
    
    @Override
    public Location getArrivalLocation() {
        return arrivalLocation;
    }
    
    @Override
    public Duration getScaleDuration() {
        return scaleDuration;
    }
    
    @Override
    public Duration getArrivalDuration() {
        return arrivalDuration;
    }
    
    @Override
    public Duration getTotalDuration() {
        return scaleDuration.plus(arrivalDuration);
    }
}
