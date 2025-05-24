/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.services;

import java.time.LocalDateTime;

/**
 *
 * @author adolf
 */
public class FlightSchedulerImpl implements IFlightScheduler {
    
    @Override
    public LocalDateTime delayDeparture(LocalDateTime currentDepartureDate, int hours, int minutes) {
        return currentDepartureDate.plusHours(hours).plusMinutes(minutes);
    }
}
