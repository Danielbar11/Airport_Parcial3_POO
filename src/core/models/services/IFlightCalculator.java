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
public interface IFlightCalculator {

    LocalDateTime calculateArrivalTime(LocalDateTime departure, int scaleHours,
            int arrivalHours, int scaleMinutes, int arrivalMinutes);
}
