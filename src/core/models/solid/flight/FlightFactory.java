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
import core.models.solid.passenger.PassengerManagement;
import core.models.solid.flight.FlightScheduling;
import core.models.solid.flight.DirectFlightRoute;
import core.models.solid.flight.ConnectingFlightRouteImpl;
import core.models.Flight;
import core.models.Plane;
import core.models.Location;
import java.time.LocalDateTime;
import java.time.Duration;

/**
 * Dependency Inversion Principle: Factory depends on abstractions
 * Maintains compatibility with original constructors
 */
public class FlightFactory {
    
    private final PassengerManagement passengerService;
    private final FlightScheduling scheduleService;
    
    public FlightFactory(PassengerManagement passengerService, 
                        FlightScheduling scheduleService) {
        this.passengerService = passengerService;
        this.scheduleService = scheduleService;
    }
    
    /**
     * Creates direct flight - equivalent to original first constructor
     */
    public Flight createDirectFlight(String id, Plane plane, 
                                   Location departureLocation, Location arrivalLocation,
                                   LocalDateTime departureDate, 
                                   int hoursDurationArrival, int minutesDurationArrival) {
        
        Duration duration = Duration.ofHours(hoursDurationArrival)
                                  .plusMinutes(minutesDurationArrival);
        
        FlightRoute route = new DirectFlightRoute(departureLocation, arrivalLocation, duration);
        
        Flight flight = new Flight(id, plane, route, departureDate, passengerService);
        plane.addFlight(flight);
        return flight;
    }
    
    /**
     * Creates connecting flight - equivalent to original second constructor
     */
    public Flight createConnectingFlight(String id, Plane plane,
                                       Location departureLocation, Location scaleLocation, 
                                       Location arrivalLocation, LocalDateTime departureDate,
                                       int hoursDurationArrival, int minutesDurationArrival,
                                       int hoursDurationScale, int minutesDurationScale) {
        
        Duration scaleDuration = Duration.ofHours(hoursDurationScale)
                                       .plusMinutes(minutesDurationScale);
        Duration arrivalDuration = Duration.ofHours(hoursDurationArrival)
                                         .plusMinutes(minutesDurationArrival);
        
        FlightRoute route = new ConnectingFlightRouteImpl(departureLocation, scaleLocation, 
                                                        arrivalLocation, scaleDuration, arrivalDuration);
        
        Flight flight = new Flight(id, plane, route, departureDate, passengerService);
        plane.addFlight(flight);
        return flight;
    }
}
