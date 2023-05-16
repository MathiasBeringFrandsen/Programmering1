package application.model;

import java.time.LocalDateTime;

public class FlightTest {

    public static void main(String[] args) {
        Flight flight = new Flight("AY025", "Seoul");
        flight.createPassenger("Arnold", 31);
        flight.createPassenger("Bruce", 59);
        flight.createPassenger("Dolph", 24);
        flight.createPassenger("Linda", 59);
        flight.createPassenger("Jennifer", 65);
        flight.setDepartDate(LocalDateTime.now());
        flight.setArrivalDate(LocalDateTime.now().plusHours(12));

        System.out.println("Gennemsnitlig alder på passagererne: " + flight.averagePassengerAge());
        System.out.println();
        System.out.println("Længden af flyveturen: " + flight.flightDurationInHours());
        System.out.println();
        System.out.println("Tager flyveturen sted henover midnat: " + flight.midnightFlight());

    }

}
