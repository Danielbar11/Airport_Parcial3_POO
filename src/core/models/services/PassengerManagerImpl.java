/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.services;

import core.models.Passenger;
import java.util.ArrayList;

/**
 *
 * @author adolf
 */
public class PassengerManagerImpl implements IPassengerManager {
    
    private final ArrayList<Passenger> passengers;
    
    public PassengerManagerImpl(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
    
    @Override
    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }
    
    @Override
    public int getPassengerCount() {
        return passengers.size();
    }
}
