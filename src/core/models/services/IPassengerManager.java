/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.services;

import core.models.Passenger;

/**
 *
 * @author adolf
 */
public interface IPassengerManager {
    void addPassenger(Passenger passenger);
    int getPassengerCount();
}