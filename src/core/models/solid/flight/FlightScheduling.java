/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.solid.flight;

/**
 *
 * @author adolf
 */

import core.models.Flight;
import java.time.LocalDateTime;
import java.time.Duration;

/**
 * Interface Segregation Principle:
 * Dedicated interface for flight scheduling operations
 */
public interface FlightScheduling {
    LocalDateTime calculateArrivalTime(Flight flight);
    void delayFlight(Flight flight, Duration delay);
}
