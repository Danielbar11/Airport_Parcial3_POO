/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.interfaces;

import core.models.Passenger;
import java.time.LocalDateTime;

/**
 *
 * @author adolf
 */
public interface IFlightOperations {
    void addPassenger(Passenger passenger);
    LocalDateTime calculateArrivalDate();
    void delay(int hours, int minutes);
    int getNumPassengers();
}
