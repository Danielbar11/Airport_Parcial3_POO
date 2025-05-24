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
public class FlightServiceFactory {
    
    public IFlightCalculator createCalculator() {
        return (IFlightCalculator) new FlightCalculatorImpl();
    }
    
    public IFlightScheduler createScheduler() {
        return new FlightSchedulerImpl();
    }
    
    public IPassengerManager createPassengerManager(ArrayList<Passenger> passengers) {
        return new PassengerManagerImpl(passengers);
    }
}