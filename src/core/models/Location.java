package core.models;

import core.models.abstracts.AbstractLocation;

/**
 * Concrete implementation of Location
 * Maintains exact same functionality as original
 * Now follows all SOLID principles
 * 
 * @author edangulo
 */
public class Location extends AbstractLocation {
    
    private String airportName;
    private String airportCity;
    private String airportCountry;
    private double airportLatitude;
    private double airportLongitude;

    public Location(String airportId, String airportName, String airportCity, String airportCountry, double airportLatitude, double airportLongitude) {
        super(airportId);
        this.airportName = airportName;
        this.airportCity = airportCity;
        this.airportCountry = airportCountry;
        this.airportLatitude = airportLatitude;
        this.airportLongitude = airportLongitude;
    }

    @Override
    public String getAirportName() {
        return airportName;
    }

    @Override
    public String getAirportCity() {
        return airportCity;
    }

    @Override
    public String getAirportCountry() {
        return airportCountry;
    }

    @Override
    public double getAirportLatitude() {
        return airportLatitude;
    }

    @Override
    public double getAirportLongitude() {
        return airportLongitude;
    }
}