/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.services;
import java.util.ArrayList;
import core.models.Flight;

/**
 *
 * @author adolf
 */
public interface IFlightManagementService {
    void addFlight(Flight flight);
    int getFlightCount();
}
