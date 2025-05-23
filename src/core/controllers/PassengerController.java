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
import java.time.LocalDateTime;

/**
 *
 * @author ddbarraza
 */
public class PassengerController {
    
    public static Response registerPassenger(String id, String firstname, String lastname, String year, String month, String day, String countryPhoneCode, String phone, String country) {
        try {
            long longId, longPhone;
            int intCountryPhoneCode, intYear, intMonth, intDay;
            
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
            try {
                intMonth = Integer.parseInt(month);
                if (intMonth < 1 || intMonth > 12) {
                    return new Response("Month invalid. Must be in range [0,12]", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("Month must be selected", Status.BAD_REQUEST);
            }
            try {
                intDay = Integer.parseInt(day);
                if (intDay < 1 || intDay > 31) {
                    return new Response("Day invalid. Must be in range [0,31]", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("Day must be selected", Status.BAD_REQUEST);
            }
            
            LocalDate birthDate = LocalDate.of(intYear, intMonth, intDay);
            
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
            if (!passengerStorage.addPassenger(new Passenger(longId, firstname, lastname, birthDate, intCountryPhoneCode, longPhone, country))) {
                return new Response("A passenger with that id already exists", Status.BAD_REQUEST);
            }
            return new Response("Passenger registered successfully", Status.CREATED);
            
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    public static Response updatePassenger(String id, String firstname, String lastname, String year, String month, String day, String countryPhoneCode, String phone, String country) {
        try {
            long longId, longPhone;
            int intCountryPhoneCode, intYear, intMonth, intDay;
            
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
            try {
                intMonth = Integer.parseInt(month);
                if (intMonth < 1 || intMonth > 12) {
                    return new Response("Month invalid. Must be in range [0,12]", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("Month must be selected", Status.BAD_REQUEST);
            }
            try {
                intDay = Integer.parseInt(day);
                if (intDay < 1 || intDay > 31) {
                    return new Response("Day invalid. Must be in range [0,31]", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("Day must be selected", Status.BAD_REQUEST);
            }
            
            LocalDate birthDate = LocalDate.of(intYear, intMonth, intDay);
            
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
            Passenger passenger = passengerStorage.getPassenger(longId);
            
            if(passenger == null){
                return new Response("Passenger not found", Status.BAD_REQUEST);
            }else{
                passenger.setFirstname(firstname);
                passenger.setLastname(lastname);
                passenger.setBirthDate(birthDate);
                passenger.setCountryPhoneCode(intCountryPhoneCode);
                passenger.setPhone(longPhone);
                passenger.setCountry(country);
                return new Response("Passenger info was updated successfully", Status.OK);
            }
            
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
