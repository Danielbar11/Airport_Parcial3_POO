package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Plane;
import core.models.storages.PlaneStorage;


public class PlaneController {
    
    public static Response createPlane(String id, String brand, String model, String maxCapacity, String airline) {
        try {
            int intMaxCapacity;
            
            if (id.trim().equals("") || !id.matches("[A-Z]{2}\\d{5}")) {
                return new Response("Invalid plane ID format. Must be XXYYYYY (X = Capital letters, Y = integers", Status.BAD_REQUEST);
            }
            
            if (brand.trim().equals("")) {
                return new Response("Brand must be not empty", Status.BAD_REQUEST);
            }
            
            if (model.trim().equals("")) {
                return new Response("Model must be not empty", Status.BAD_REQUEST);
            }
            
            try {
                if (maxCapacity.trim().equals("")) {
                    return new Response("Max capacity must be not empty", Status.BAD_REQUEST);
                }
                intMaxCapacity = Integer.parseInt(maxCapacity);
                if (intMaxCapacity < 0) {
                    return new Response("Max Capacity must be non negative", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Max Capacity must be numeric", Status.BAD_REQUEST);
            }
            
            if (airline.trim().equals("")) {
                return new Response("Airline must be not empty", Status.BAD_REQUEST);
            }
            
            PlaneStorage planeStorage = PlaneStorage.getInstance();
            if (!planeStorage.addPlane(new Plane(id, brand, model, intMaxCapacity, airline))) {
                return new Response("A plane with that ID already exists", Status.BAD_REQUEST);
            }
            
            return new Response("Plane created successfully", Status.CREATED);
            
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    //Set id plane combo box
    
}
