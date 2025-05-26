package core.models;


/**
 * Single Responsibility Principle Applied:
 * Flight class now only handles flight identity and basic data
 * No passenger management, calculations, or scheduling logic
 * 
 * @author edangulo
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import core.models.interfaces.IFlight;
import core.models.services.*;

/**
 * Flight class following SOLID principles
 * Maintains exact same functionality as original
 * 
 * @author edangulo
 */
public class Flight implements IFlight {
    
    // Core flight data - unchanged
    private final String id;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private Location departureLocation;
    private Location scaleLocation;
    private Location arrivalLocation;
    private LocalDateTime departureDate;
    private int hoursDurationArrival;
    private int minutesDurationArrival;
    private int hoursDurationScale;
    private int minutesDurationScale;
    
    // Service dependencies (injected via factory)
    private final IFlightCalculator calculator;
    private final IFlightScheduler scheduler;
    private final IPassengerManager passengerManager;

    // Direct flight constructor - exact same signature
    public Flight(String id, Plane plane, Location departureLocation, Location arrivalLocation, 
                  LocalDateTime departureDate, int hoursDurationArrival, int minutesDurationArrival) {
        this.id = id;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.hoursDurationArrival = hoursDurationArrival;
        this.minutesDurationArrival = minutesDurationArrival;
        
        // Use factory for service creation (DIP)
        FlightServiceFactory factory = new FlightServiceFactory();
        this.calculator = factory.createCalculator();
        this.scheduler = factory.createScheduler();
        this.passengerManager = factory.createPassengerManager(this.passengers);
        
        this.plane.addFlight(this);
    }

    // Connecting flight constructor - exact same signature
    public Flight(String id, Plane plane, Location departureLocation, Location scaleLocation, 
                  Location arrivalLocation, LocalDateTime departureDate, int hoursDurationArrival, 
                  int minutesDurationArrival, int hoursDurationScale, int minutesDurationScale) {
        this.id = id;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.departureLocation = departureLocation;
        this.scaleLocation = scaleLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.hoursDurationArrival = hoursDurationArrival;
        this.minutesDurationArrival = minutesDurationArrival;
        this.hoursDurationScale = hoursDurationScale;
        this.minutesDurationScale = minutesDurationScale;
        
        // Use factory for service creation (DIP)
        FlightServiceFactory factory = new FlightServiceFactory();
        this.calculator = factory.createCalculator();
        this.scheduler = factory.createScheduler();
        this.passengerManager = factory.createPassengerManager(this.passengers);
        
        this.plane.addFlight(this);
    }
    
    // Business methods - exact same interface, delegated to services
    
    @Override
    public void addPassenger(Passenger passenger) {
        passengerManager.addPassenger(passenger);
    }
    
    @Override
    public LocalDateTime calculateArrivalDate() {
        return calculator.calculateArrivalTime(
            departureDate, hoursDurationScale, hoursDurationArrival, 
            minutesDurationScale, minutesDurationArrival
        );
    }
    
    @Override
    public void delay(int hours, int minutes) {
        this.departureDate = scheduler.delayDeparture(this.departureDate, hours, minutes);
    }
    
    @Override
    public int getNumPassengers() {
        return passengerManager.getPassengerCount();
    }
    
    // All getters remain exactly the same
    @Override
    public String getId() {
        return id;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public Location getScaleLocation() {
        return scaleLocation;
    }

    public Location getArrivalLocation() {
        return arrivalLocation;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public int getHoursDurationArrival() {
        return hoursDurationArrival;
    }

    public int getMinutesDurationArrival() {
        return minutesDurationArrival;
    }

    public int getHoursDurationScale() {
        return hoursDurationScale;
    }

    public int getMinutesDurationScale() {
        return minutesDurationScale;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }
    
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
}