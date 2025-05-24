/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.FlightAdapter;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Location;
import core.models.Passenger;
import core.models.Plane;
import core.models.solid.flight.FlightScheduling;
import core.models.storages.FlightStorage;
import core.models.storages.LocationStorage;
import core.models.storages.PassengerStorage;
import core.models.storages.PlaneStorage;
import java.time.LocalDateTime;

/**
 *
 * @author ddbarraza
 */
public class FlightController {
    
     public static Response createFlight(String id, String planeId, String departureLocationId, String scaleLocationId, String arrivalLocationId, String year, String month, String day, String hours, String minutes, String hoursDurationArrival, String minutesDurationArrival, String hoursDurationScale, String minutesDurationScale) {
        try {
            int intHoursArrival, intMinutesArrival, intHoursScale, intMinutesScale;
            int intYear, intMonth, intDay, intHours, intMinutes;
            
            // EXACT same validation as your original
            if (id.trim().equals("") || !id.matches("[A-Z]{3}\\d{3}")) {
                return new Response("Invalid flight ID format. Must be XXXYYY", Status.BAD_REQUEST);
            }
            
            PlaneStorage planeStorage = PlaneStorage.getInstance();
            Plane plane = planeStorage.getPlane(planeId);
            if (plane == null) {
                return new Response("Plane not found", Status.NOT_FOUND);
            }
            
            LocationStorage locationStorage = LocationStorage.getInstance();
            Location departureLocation = locationStorage.getLocation(departureLocationId);
            if (departureLocation == null) {
                return new Response("Departure location not found", Status.NOT_FOUND);
            }
            
            Location arrivalLocation = locationStorage.getLocation(arrivalLocationId);
            if (arrivalLocation == null) {
                return new Response("Arrival location not found", Status.NOT_FOUND);
            }
            
            // EXACT same year validation
            try {
                intYear = Integer.parseInt(year);
                if (year.length() > 4) {
                    return new Response("Invalid year. Must have max 4 digits", Status.BAD_REQUEST);
                }
                if (intYear > LocalDateTime.now().getYear()) {
                    return new Response("Invalid year. Must be minor than "+LocalDateTime.now().getYear(), Status.BAD_REQUEST);
                }
                if (year.trim().equals("")) {
                    return new Response("Year must be not empty", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {  
                return new Response("Year must be just numeric", Status.BAD_REQUEST);
            }
            
            // EXACT same month validation
            try {
                intMonth = Integer.parseInt(month);
                if (intMonth < 1 || intMonth > 12) {
                    return new Response("Month invalid. Must be in range [0,12]", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("Month must be selected", Status.BAD_REQUEST);
            }
            
            // EXACT same day validation
            try {
                intDay = Integer.parseInt(day);
                if (intDay < 1 || intDay > 31) {
                    return new Response("Day invalid. Must be in range [0,31]", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("Day must be selected", Status.BAD_REQUEST);
            }
            
            // EXACT same hours validation
            try {
                intHours = Integer.parseInt(hours);
                if (intHours < 0 || intHours > 23) {
                    return new Response("Invalid hours. Must be in range (00-23)", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Hours must be numeric", Status.BAD_REQUEST);
            }
            
            // EXACT same minutes validation
            try {
                intMinutes = Integer.parseInt(minutes);
                if (intMinutes < 0 || intMinutes > 59) {
                    return new Response("Invalid minutes. Must be in range (00-59)", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Minutes must be numeric", Status.BAD_REQUEST);
            }
            
            LocalDateTime dateDepartureDate = LocalDateTime.of(intYear, intMonth, intDay, intHours, intMinutes);
            
            // EXACT same arrival duration validation
            try {
                intHoursArrival = Integer.parseInt(hoursDurationArrival);
                if (intHoursArrival < 0 || intHoursArrival > 23) {
                    return new Response("Invalid hours. Must be in range (00-23)", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Hours must be numeric", Status.BAD_REQUEST);
            }
            
            try {
                intMinutesArrival = Integer.parseInt(minutesDurationArrival);
                if (intMinutesArrival < 0 || intMinutesArrival > 59) {
                    return new Response("Invalid minutes. Must be in range (00-59)", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Minutes must be numeric", Status.BAD_REQUEST);
            }
            
            // Use enhanced storage that maintains your exact interface
            FlightStorage flightStorage = FlightStorage.getInstance();
            
            // EXACT same logic for direct vs connecting flights
            if (scaleLocationId == null || scaleLocationId.trim().equals("")){
                
                if (!hoursDurationScale.equals("0") || !minutesDurationScale.equals("0")) {
                    return new Response("If no scale location is provided, scale duration must be 00:00", Status.BAD_REQUEST);
                }
                
                // Create direct flight using SOLID architecture but same interface
                if (!flightStorage.addDirectFlight(id, plane, departureLocation, arrivalLocation, dateDepartureDate, intHoursArrival, intMinutesArrival)) {
                    return new Response("A flight with that id already exists", Status.BAD_REQUEST);
                }
                return new Response("Flight created successfully", Status.CREATED);
                
            } else {
                Location scaleLocation = locationStorage.getLocation(scaleLocationId);
                if (scaleLocation == null) {
                    return new Response("Scale location don't exists", Status.BAD_REQUEST);
                }
                
                // EXACT same scale duration validation
                try {
                    intHoursScale = Integer.parseInt(hoursDurationScale);
                    if (intHoursScale < 0 || intHoursScale > 23) {
                        return new Response("Invalid hours. Must be in range (00-23)", Status.BAD_REQUEST);
                    }
                } catch (NumberFormatException ex) {
                    return new Response("Hours must be numeric", Status.BAD_REQUEST);
                }
                
                try {
                    intMinutesScale = Integer.parseInt(minutesDurationScale);
                    if (intMinutesScale < 0 || intMinutesScale > 59) {
                        return new Response("Invalid minutes. Must be in range (00-59)", Status.BAD_REQUEST);
                    }
                } catch (NumberFormatException ex) {
                    return new Response("Minutes must be numeric", Status.BAD_REQUEST);
                }

                // Create connecting flight using SOLID architecture but same interface
                if (!flightStorage.addConnectingFlight(id, plane, departureLocation, scaleLocation, arrivalLocation, dateDepartureDate, intHoursArrival, intMinutesArrival, intHoursScale, intMinutesScale)) {
                    return new Response("A flight with that id already exists", Status.BAD_REQUEST);
                }
                return new Response("Flight created successfully", Status.CREATED);
            }
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    public static Response addPassengerToFlight(String passengerId, String flightId) {
        try {
            long longPassengerId;     
            
            // Use enhanced storage but same interface
            FlightStorage flightStorage = FlightStorage.getInstance();
            FlightAdapter flight = flightStorage.getFlight(flightId);
            if (flight == null) {
                return new Response("Flight not found", Status.BAD_REQUEST);
            }
            
            // EXACT same passenger ID validation
            try {
                longPassengerId = Long.parseLong(passengerId);      
                if (longPassengerId < 0 || longPassengerId > 999_999_999_999_999L) {
                    return new Response("Id must be in the range 0 - 999999999999999", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }
            
            PassengerStorage passengerStorage = PassengerStorage.getInstance();
            Passenger passenger = passengerStorage.getPassenger(longPassengerId);
            if (passenger == null) {
                return new Response("Passenger not found", Status.NOT_FOUND);
            }
            
            // EXACT same capacity validation
            if(flight.getNumPassengers() >= flight.getPlane().getMaxCapacity()){
                return new Response("Plane already have max capacity", Status.BAD_REQUEST);
            }

            // EXACT same duplicate passenger validation
            if (flight.getPassengers().contains(passenger)) {
                return new Response("Passenger already added to flight", Status.BAD_REQUEST);
            }

            // Add passenger using adapter (maintains same functionality)
            flight.addPassenger(passenger);
            passenger.addFlight(flight.getModernFlight());
            return new Response("Passenger added successfully", Status.OK);

        } catch (Exception e) {
            return new Response("Internal server error", Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    public static Response delayFlight(String flightId, String hours, String minutes) {
        try {
            int intHours, intMinutes;
            
            // EXACT same validation
            if (flightId.isEmpty()) {
                return new Response("Flight Id is required", Status.BAD_REQUEST);
            }
            
            try {
                intHours = Integer.parseInt(hours);
                intMinutes = Integer.parseInt(minutes);
                
                if (intHours < 0 || intMinutes < 0) {
                    return new Response("Delay must be positive", Status.BAD_REQUEST);
                }
                if (intHours == 0 && intMinutes == 0) {
                    return new Response("Delay must be greater than 00:00", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("Hours and minutes must be numeric", Status.BAD_REQUEST);
            }
            
            // Use enhanced storage but same interface
            FlightStorage flightStorage = FlightStorage.getInstance();
            FlightAdapter flight = flightStorage.getFlight(flightId);
            
            if (flight == null) {
                return new Response("Flight not found", Status.NOT_FOUND);
            }
            
            // Use adapter delay method (maintains same functionality)
            flight.delay(intHours, intMinutes);
            return new Response("Flight delayed successfully", Status.OK);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    //set flight id combo box
    //set departure location
    // set arrival location
    // set scale location 
}
