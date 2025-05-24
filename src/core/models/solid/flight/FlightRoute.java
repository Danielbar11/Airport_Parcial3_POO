package core.models.solid.flight;

import core.models.Location;
import java.time.Duration;

/**
 * Interface Segregation Principle: 
 * Small, focused interface for basic flight route operations
 */
public interface FlightRoute {
    Location getDepartureLocation();
    Location getArrivalLocation();
    Duration getTotalDuration();
}