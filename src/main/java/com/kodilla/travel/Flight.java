package com.kodilla.travel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Flight {

    private String startingPlace;
    private String finalPlace;
    private String flightDate;
    private String flightTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        return finalPlace.equals(flight.finalPlace) &&
                flightDate.equals(flight.flightDate) &&
                flightTime.equals(flight.flightTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalPlace, flightDate, flightTime);
    }
}
