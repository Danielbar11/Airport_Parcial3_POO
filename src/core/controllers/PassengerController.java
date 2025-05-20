/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Passenger;
import core.models.storages.PassengerStorage;
import java.time.LocalDate;

/**
 *
 * @author ddbarraza
 */
public class PassengerController {
    
    public static Response registerPassenger(String id, String firstname, String lastname, String birthDate, String countryPhoneCode, String phone, String country) {
        try {
            long longId, longPhone;
            int intCountryPhoneCode;
            LocalDate dateBirthDate;
            
            try {
                longId = Long.parseLong(id);
                
                if (longId < 0 || longId > 999_999_999_999_999L) {
                    return new Response("Id must be in the range 0 - 999999999999999", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }
            
            if (firstname.trim().equals("")) {
                return new Response("Firstname must be not empty", Status.BAD_REQUEST);
            }
            
            if (lastname.trim().equals("")) {
                return new Response("Lastname must be not empty", Status.BAD_REQUEST);
            }
            
            try {
                dateBirthDate = LocalDate.parse(birthDate);
            } catch (Exception ex) {
                return new Response("Birth Date must be in ISO format (AAAA-MM-DD)", Status.BAD_REQUEST);
            }
            
            try {
                intCountryPhoneCode = Integer.parseInt(countryPhoneCode);
                if (intCountryPhoneCode < 0 || intCountryPhoneCode > 999) {
                    return new Response("Country Phone Code must be in range 0 - 999", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Country Phone Code must be numeric", Status.BAD_REQUEST);
            }
            
            try {
                longPhone = Long.parseLong(phone);
                if (longId < 0 || longId > 99_999_999_999L) {
                    return new Response("Phone must be in the range 0 - 99999999999", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Phone must be numeric", Status.BAD_REQUEST);
            }
            
            if (country.trim().equals("")) {
                return new Response("Country must be not empty", Status.BAD_REQUEST);
            }
            
            PassengerStorage passengerStorage = PassengerStorage.getInstance();
            if (!passengerStorage.addPassenger(new Passenger(longId, firstname, lastname, dateBirthDate, intCountryPhoneCode, longPhone, country))) {
                return new Response("A passenger with that id already exists", Status.BAD_REQUEST);
            }
            return new Response("Passenger registered successfully", Status.CREATED);
            
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    public static Response updatePassenger(String id, String firstname, String lastname, String birthDate, String countryPhoneCode, String phone, String country) {
        try {
            long longId, longPhone;
            int intCountryPhoneCode;
            LocalDate dateBirthDate;
            
            try {
                longId = Long.parseLong(id);
                
                if (longId < 0 || longId > 999_999_999_999_999L) {
                    return new Response("Id must be in the range 0 - 999999999999999", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }
            
            PassengerStorage passengerStorage = PassengerStorage.getInstance();            
            Passenger passenger = PassengerStorage.getPassenger(longId);
            
            if (passenger == null) {
                return new Response("Person not found", Status.NOT_FOUND);
            }
            
            if (firstname.trim().equals("")) {
                return new Response("Firstname must be not empty", Status.BAD_REQUEST);
            }
            
            if (lastname.trim().equals("")) {
                return new Response("Lastname must be not empty", Status.BAD_REQUEST);
            }
            
            try {
                dateBirthDate = LocalDate.parse(birthDate);
            } catch (Exception ex) {
                return new Response("Birth Date must be in ISO format (AAAA-MM-DD)", Status.BAD_REQUEST);
            }
            
            try {
                intCountryPhoneCode = Integer.parseInt(countryPhoneCode);
                if (intCountryPhoneCode < 0 || intCountryPhoneCode > 999) {
                    return new Response("Country Phone Code must be in range 0 - 999", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Country Phone Code must be numeric", Status.BAD_REQUEST);
            }
            
            try {
                longPhone = Long.parseLong(phone);
                if (longId < 0 || longId > 99_999_999_999L) {
                    return new Response("Phone must be in the range 0 - 99999999999", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Phone must be numeric", Status.BAD_REQUEST);
            }
            
            if (country.trim().equals("")) {
                return new Response("Country must be not empty", Status.BAD_REQUEST);
            }
            
            
            
    } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    
}
