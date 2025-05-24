/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storages;

import core.models.Flight;
import java.util.ArrayList;

/**
 *
 * @author ddbarraza
 */
public class FlightStorage {
    
    private static FlightStorage instance;
    
    private ArrayList<Flight> flights;

    public FlightStorage() {
        this.flights = new ArrayList<>();
    }
    
    public static FlightStorage getInstance() {
        if (instance == null) {
            instance = new FlightStorage();
        }
        return instance;
    }
    
    public boolean addFlight(Flight flight) {
        for (Flight f : this.flights) {
            if (f.getId().equals(flight.getId())) {
                return false;
            }
        }

        int index = 0;
        while (index < flights.size()) {
            String currentId = flights.get(index).getId();
            String newId = flight.getId();

            String lettersCurrent = currentId.substring(0, 3);
            String lettersNew = newId.substring(0, 3);
            int letterComparison = lettersCurrent.compareTo(lettersNew);

            if (letterComparison > 0) {
                break;
            } else if (letterComparison == 0) {
                int numberCurrent = Integer.parseInt(currentId.substring(3));
                int numberNew = Integer.parseInt(newId.substring(3));

                if (numberCurrent > numberNew) {
                    break;
                }
            }
            index++;
        }

        this.flights.add(index, flight);
        return true;
    }

    
    public Flight getFlight(String id) {
        for (Flight flight : this.flights) {
            if (flight.getId().equals(id)) {
                return flight;
            }
        }
        return null;
    }
    
    public boolean delFlight(int id) {
        for (Flight flight : this.flights) {
            if (Integer.parseInt(flight.getId()) == id) {
                this.flights.remove(flight);
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Flight> getAllFlights() {
        return this.flights;
    }
    
}
