package com.kodilla.travel;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route
public class MainView extends VerticalLayout {

    private Grid grid= new Grid<>(Flight.class);
    private FlightForm flightForm= new FlightForm(this);
    private FlightService flightService= FlightService.getInstance();

    public MainView() {
        grid.setColumns("startingPlace", "finalPlace", "flightDate", "flightTime");
        HorizontalLayout mainContent = new HorizontalLayout(grid, flightForm);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(mainContent);
        flightForm.setFlight(null);
        setSizeFull();
        refresh();
    }

    public void refresh() {
        grid.setItems(flightService.getFlight());
    }

}
