package application.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * A flight with an airline between airports.
 */
public class Flight {
    private String flightNumber;
    private String destination;
    private LocalDateTime departDate;
    private LocalDateTime arrivalDate;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    /**
     * Constructor that creates a flight for an airline.
     *
     * @param flightNumber the number of the flight
     * @param destination  the destination of the flight
     */
    public Flight(String flightNumber, String destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    /**
     * Gets the destination.
     *
     * @return the destination or null if not set
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Gets the flight number.
     *
     * @return the flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Gets the LocalDateTime when the flight will depart
     *
     * @return departure date, can be null
     */
    public LocalDateTime getDepartDate() {
        return departDate;
    }

    /**
     * Sets the LocalDateTime when the flight will depart.
     * Precondition: cannot be later than the land time.
     *
     * @param departDate
     */
    public void setDepartDate(LocalDateTime departDate) {
        this.departDate = departDate;
    }

    /**
     * Gets the LocalDateTime for when the flight will land.
     *
     * @return arrival date, can be null
     */
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the LocalDateTime for when the flight will land.
     * Precondition: cannot be before the depart time.
     *
     * @param landDate arrival date
     */
    public void setArrivalDate(LocalDateTime landDate) {
        arrivalDate = landDate;
    }

    /**
     * Creates a passenger with name and age
     * Precondition: name is not empty or null and age >= 0.
     *
     * @param name name of the passenger
     * @param age  the age of the passenger
     * @return the newly created passenger object
     */
    public Passenger createPassenger(String name, int age) {
        Passenger p = new Passenger(name, age);
        passengers.add(p);
        return p;
    }

    /**
     * Removes the passenger.
     * Precondition: the passenger must exists on this flight.
     *
     * @param passenger
     */
    public void removePassenger(Passenger passenger) {
        for (int i = 0; i < passengers.size(); i++) {
            if (passenger == passengers.get(i)) {
                passengers.remove(i);
            }
        }
    }

    /**
     * Gets the current list of passengers on this flight
     *
     * @return list of passengers
     */
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * The duration of the flight measured in hours
     * Precondition: the depart and arrival dates must have been set
     *
     * @return how many hours
     */
    public double flightDurationInHours() {
        double hours = ChronoUnit.HOURS.between(departDate, arrivalDate);
        return hours;
    }

    /**
     * Returns true if the flight happens during midnight of the day of departure.
     * Precondition: depart and arrival dates must have been set
     *
     * @return true if midnight is included in the flight period, otherwise false.
     */
    public boolean midnightFlight() {
        boolean isMidnightFlight = !(departDate.getDayOfMonth() == arrivalDate.getDayOfMonth());
        return isMidnightFlight;
    }

    /**
     * Gets the average age of all the passengers
     * Precondition: there must exist passengers on this flight
     * @return average age of passengers
     */
    public int averagePassengerAge(){
        int averageAge = 0;
        for (int i = 0; i < passengers.size(); i++){
            averageAge = averageAge + passengers.get(i).getAge();
        }
        return averageAge / passengers.size();
    }

}
