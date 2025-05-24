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
public class PlaneServiceFactory {
    
    public IFlightManagementService createFlightManagementService(ArrayList<Flight> flights) {
        return new PlaneFlightManagementServiceImpl(flights);
    }
}
