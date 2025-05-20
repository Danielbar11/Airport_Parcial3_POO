/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Location;
import core.models.storages.LocationStorage;

/**
 *
 * @author ddbarraza
 */
public class LocationController {
    
    public static Response createLocation(String airportId, String airportName, String airportCity, String airportCountry, String airportLatitude, String airportLongitude) {
        try {
            double doubleLatitude, doubleLongitude;
            
            if (airportId == null || !airportId.matches("[A-Z]{3}")) {
                return new Response("Invalid airport ID format. Must be XXX", Status.BAD_REQUEST);
            }
            
            if (airportName.trim().equals("")) {
                return new Response("Airport name must be not empty", Status.BAD_REQUEST);
            }
            
            if (airportCity.trim().equals("")) {
                return new Response("Airport city must be not empty", Status.BAD_REQUEST);
            }
            
            if (airportCountry.trim().equals("")) {
                return new Response("Airport country must be not empty", Status.BAD_REQUEST);
            }
            
            try {
                doubleLatitude = Double.parseDouble(airportLatitude);
                if (doubleLatitude < -90 || doubleLatitude > 90) {
                    String[] parts = String.valueOf(doubleLatitude).split("\\.");
                    if (parts.length == 2) {
                        int decimalCount = parts[1].length();
                        if (decimalCount < 0 || decimalCount > 4) {
                            return new Response("Latitude must have from 0 to 4 decimals", Status.BAD_REQUEST);
                        }
                    }
                    return new Response("Invalid Latitude. Must be in range [-90,90]", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Latitude must be numeric", Status.BAD_REQUEST);
            }
            
            try {
                doubleLongitude = Double.parseDouble(airportLongitude);
                if (doubleLongitude < -180 || doubleLatitude > 180) {
                    String[] parts = String.valueOf(doubleLongitude).split("\\.");
                    if (parts.length == 2) {
                        int decimalCount = parts[1].length();
                        if (decimalCount < 0 || decimalCount > 4) {
                            return new Response("Longitude must have from 0 to 4 decimals", Status.BAD_REQUEST);
                        }
                    }
                    return new Response("Invalid Longitude. Must be in range [-180,180]", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Longitude must be numeric", Status.BAD_REQUEST);
            }
            
            LocationStorage locationStorage = LocationStorage.getInstance();
            if (!locationStorage.addLocation(new Location(airportId, airportName, airportCity, airportCountry, doubleLatitude, doubleLongitude))) {
                return new Response("An airport with that ID already exists", Status.BAD_REQUEST);
            }
            return new Response("Airport created successfully", Status.CREATED);
            
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
    
}
