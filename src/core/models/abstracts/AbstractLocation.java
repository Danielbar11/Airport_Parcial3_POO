/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.abstracts;

/**
 *
 * @author adolf
 */
import core.models.interfaces.ILocation;

public abstract class AbstractLocation implements ILocation {
    protected final String airportId;
    
    protected AbstractLocation(String airportId) {
        this.airportId = airportId;
    }
    
    @Override
    public final String getAirportId() {
        return airportId;
    }
}