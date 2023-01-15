package com.kodilla.travel;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightService {

    private Set flights;
    private static FlightService flightService;

    private FlightService() {
        this.flights= exampleData();
    }

    public static FlightService getInstance() {
        if (flightService == null) {
            flightService = new FlightService();
        }
        return flightService;
    }

    public Set getFlight() {
        return new HashSet<>(flights);
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public void chooseFlight(Flight flight) {
        this.flights.contains(flight);
    }

    private Set exampleData() {
        Set flights = new HashSet<>();
        flights.add(new Flight("Kraków", "Warszawa", "2022-10-19" ,  "14.15"));
        flights.add(new Flight("Wrocław", "Gdańsk", "2022-10-25" ,  "6.45"));
        flights.add(new Flight("Warszawa", "Londyn", "2022-11-05" ,  "10.05"));
        return flights;
    }

    public void save(Flight flight) {
        this.flights.add(flight);
    }

    public void delete(Flight flight) {
        this.flights.remove(flight);
    }

}
