/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.solid.passenger;

/**
 *
 * @author adolf
 */
import core.models.Passenger;
import java.util.List;

/**
 * Interface Segregation Principle:
 * Dedicated interface for passenger management operations
 */
public interface PassengerManagement {
    void addPassenger(Passenger passenger);
    List<Passenger> getPassengers();
    int getPassengerCount();
}
