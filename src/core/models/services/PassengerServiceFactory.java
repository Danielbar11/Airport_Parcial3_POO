/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.services;

import core.models.Flight;
import java.util.ArrayList;

/**
 *
 * @author adolf
 */
public class PassengerServiceFactory {
    
    public INameService createNameService() {
        return new NameServiceImpl();
    }
    
    public IContactService createContactService() {
        return new ContactServiceImpl();
    }
    
    public IAgeCalculationService createAgeCalculationService() {
        return new AgeCalculationServiceImpl();
    }
    
    public IFlightManagementService createFlightManagementService(ArrayList<Flight> flights) {
        return new FlightManagementServiceImpl(flights);
    }
}
