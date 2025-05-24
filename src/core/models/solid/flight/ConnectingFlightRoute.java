/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.solid.flight;

/**
 *
 * @author adolf
 */
import core.models.Location;
import java.time.Duration;

/**
 * Interface Segregation Principle:
 * Extended interface for connecting flights with scale operations
 */
public interface ConnectingFlightRoute extends FlightRoute {
    Location getScaleLocation();
    Duration getScaleDuration();
    Duration getArrivalDuration();
}