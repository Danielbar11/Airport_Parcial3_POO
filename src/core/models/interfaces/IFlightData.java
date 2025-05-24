/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.interfaces;

import core.models.Location;
import core.models.Plane;
import java.time.LocalDateTime;

/**
 *
 * @author adolf
 */

public interface IFlightData {
    Location getDepartureLocation();
    Location getArrivalLocation();
    LocalDateTime getDepartureDate();
    Plane getPlane();
}