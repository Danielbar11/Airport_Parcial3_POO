/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Plane;
import core.models.storages.PlaneStorage;

/**
 *
 * @author ddbarraza
 */
public class PlaneController {
    
    public static Response createPlane(String id, String brand, String model, String maxCapacity, String airline) {
        try {
            int intMaxCapacity;
            
            if (id == null || !id.matches("[A-Z]{2}\\d{5}")) {
                return new Response("Invalid plane ID format must be XXYYYYY", Status.BAD_REQUEST);
            }
            
            if (brand.trim().equals("")) {
                return new Response("Brand must be not empty", Status.BAD_REQUEST);
            }
            
            if (model.trim().equals("")) {
                return new Response("Model must be not empty", Status.BAD_REQUEST);
            }
            
            try {
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
    
    
    
}
