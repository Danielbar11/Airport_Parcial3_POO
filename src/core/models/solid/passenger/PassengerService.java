/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.solid.passenger;

/**
 *
 * @author adolf
 */
import core.models.solid.passenger.PassengerManagement;
import core.models.Passenger;
import java.util.ArrayList;
import java.util.List;

/**
 * Single Responsibility Principle: Dedicated service for passenger management
 * Dependency Inversion Principle: Implements abstraction
 */
public class PassengerService implements PassengerManagement {
    
    private final List<Passenger> passengers;
    
    public PassengerService() {
        this.passengers = new ArrayList<>();
    }
    
    @Override
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
    
    @Override
    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers); // Defensive copy
    }
    
    @Override
    public int getPassengerCount() {
        return passengers.size();
    }
}
