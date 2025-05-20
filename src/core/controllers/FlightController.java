/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Location;
import core.models.Plane;
import core.models.storages.FlightStorage;
import core.models.storages.LocationStorage;
import core.models.storages.PlaneStorage;
import java.time.LocalDateTime;

/**
 *
 * @author ddbarraza
 */
public class FlightController {
    
    public static Response createFlight(String id, Plane plane, Location departureLocation, Location arrivalLocation, LocalDateTime departureDate, int hoursDurationArrival, int minutesDurationArrival) {
        try {
            
            
            if (id == null || !id.matches("[A-Z]{3}\\d{3}")) {
                return new Response("Invalid airport ID format. Must be XXXYYY", Status.BAD_REQUEST);
            }
            
            FlightStorage flightStorage = FlightStorage.getInstance();
            if (flightStorage.getFlight(id) != null) {
                return new Response("A flight with that id already exists", Status.BAD_REQUEST);
            }
            
            PlaneStorage planeStorage = PlaneStorage.getInstance();
            Plane planeVerify = planeStorage.getPlane(plane.getId());
            if (planeVerify == null) {
                return new Response("A plane with that ID don't exists", Status.BAD_REQUEST);
            }
            
            LocationStorage locationStorage = LocationStorage.getInstance();
            Location departureLocationVerify = locationStorage.getLocation(departureLocation.getAirportId());
            if (departureLocationVerify == null) {
                Location arrivalLocationVerify = locationStorage.getLocation(arrivalLocation.getAirportId());
                if (arrivalLocationVerify == null) {
                    return new Response("Arrival location don't exists", Status.BAD_REQUEST);
                }
                return new Response("Departure location don't exists", Status.BAD_REQUEST);
            }
            
            
        }
    }
    
}
