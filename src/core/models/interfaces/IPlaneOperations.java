/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import core.models.Flight;
import java.util.ArrayList;

/**
 *
 * @author adolf
 */
interface IPlaneOperations {
    void addFlight(Flight flight);
    ArrayList<Flight> getFlights();
    int getNumFlights();
}
