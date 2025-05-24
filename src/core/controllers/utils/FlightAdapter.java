/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;

/**
 *
 * @author adolf
 */
import core.models.solid.flight.FlightRoute;
import core.models.solid.flight.ConnectingFlightRoute;
import core.models.solid.passenger.PassengerManagement;
import core.models.solid.flight.FlightScheduling;
import core.models.Flight;
import core.models.Location;
import core.models.Passenger;
import core.models.solid.flight.FlightScheduleService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter Pattern: Provides backward compatibility for legacy Flight interface
 * while using the new SOLID-compliant architecture underneath.
 * 
 * This allows existing code to work unchanged while benefiting from 
 * the improved architecture.
 */
public class FlightAdapter {
    
    private final Flight flight;
    private final FlightScheduling scheduleService;
    
    public FlightAdapter(Flight flight) {
        this.flight = flight;
        this.scheduleService = (FlightScheduling) new FlightScheduleService();
    }
    
    // Legacy methods that delegate to new architecture
    
    public String getId() {
        return flight.getId();
    }
    
    public Location getDepartureLocation() {
        return flight.getRoute().getDepartureLocation();
    }
    
    public Location getScaleLocation() {
        FlightRoute route = flight.getRoute();
        if (route instanceof ConnectingFlightRoute) {
            return ((ConnectingFlightRoute) route).getScaleLocation();
        }
        return null; // Direct flight has no scale
    }
    
    public Location getArrivalLocation() {
        return flight.getRoute().getArrivalLocation();
    }
    
    public LocalDateTime getDepartureDate() {
        return flight.getDepartureDate();
    }
    
    public LocalDateTime calculateArrivalDate() {
        return scheduleService.calculateArrivalTime(flight);
    }
    
    public core.models.Plane getPlane() {
        return flight.getPlane();
    }
    
    public int getNumPassengers() {
        return flight.getPassengerService().getPassengerCount();
    }
    
    public void addPassenger(Passenger passenger) {
        flight.getPassengerService().addPassenger(passenger);
    }
    
    public ArrayList<Passenger> getPassengers() {
        List<Passenger> passengers = flight.getPassengerService().getPassengers();
        return new ArrayList<>(passengers);
    }
    
    public void delay(int hours, int minutes) {
        java.time.Duration delay = java.time.Duration.ofHours(hours).plusMinutes(minutes);
        scheduleService.delayFlight(flight, delay);
    }
    
    public void setDepartureDate(LocalDateTime departureDate) {
        flight.setDepartureDate(departureDate);
    }
    
    // Additional legacy compatibility methods
    public int getHoursDurationArrival() {
        if (flight.getRoute() instanceof ConnectingFlightRoute) {
            ConnectingFlightRoute route = (ConnectingFlightRoute) flight.getRoute();
            return (int) route.getArrivalDuration().toHours();
        } else {
            return (int) flight.getRoute().getTotalDuration().toHours();
        }
    }
    
    public int getMinutesDurationArrival() {
        if (flight.getRoute() instanceof ConnectingFlightRoute) {
            ConnectingFlightRoute route = (ConnectingFlightRoute) flight.getRoute();
            return (int) (route.getArrivalDuration().toMinutes() % 60);
        } else {
            return (int) (flight.getRoute().getTotalDuration().toMinutes() % 60);
        }
    }
    
    public int getHoursDurationScale() {
        if (flight.getRoute() instanceof ConnectingFlightRoute) {
            ConnectingFlightRoute route = (ConnectingFlightRoute) flight.getRoute();
            return (int) route.getScaleDuration().toHours();
        }
        return 0;
    }
    
    public int getMinutesDurationScale() {
        if (flight.getRoute() instanceof ConnectingFlightRoute) {
            ConnectingFlightRoute route = (ConnectingFlightRoute) flight.getRoute();
            return (int) (route.getScaleDuration().toMinutes() % 60);
        }
        return 0;
    }
    
    // Get the underlying SOLID-compliant Flight object
    public Flight getModernFlight() {
        return flight;
    }
}
