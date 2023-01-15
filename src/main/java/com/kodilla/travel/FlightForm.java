package com.kodilla.travel;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;


@Route
public class FlightForm extends FormLayout {

    private TextField startingPlace = new TextField("startingPlace");
    private TextField finalPlace = new TextField("finalPlace");
    private TextField flightDate = new TextField("flightDate");
    private TextField flightTime = new TextField("flightTime");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Button weather = new Button("Check the weather");
    private Button choseFlight = new Button("Chose Flight");
    private Binder<Flight> binder = new Binder<Flight>(Flight.class);
    private FlightService service = FlightService.getInstance();
    private MainView mainView;


    public FlightForm(MainView mainView) {
        HorizontalLayout buttons = new HorizontalLayout(save, delete, weather, choseFlight);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(startingPlace, finalPlace, flightDate, flightTime, buttons);
        binder.bindInstanceFields(this);
        this.mainView = mainView;
        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());
    }

    private void save() {
        Flight flight = binder.getBean();
        service.save(flight);
        mainView.refresh();
        setFlight(null);
    }

    private void delete() {
        Flight flight = binder.getBean();
        service.delete(flight);
        mainView.refresh();
        setFlight(null);
    }

    public void setFlight(Flight flight) {

        binder.setBean(flight);
        if(flight == null) {
            setVisible(false);
        } else {
            setVisible(true);
            finalPlace.focus();
        }
    }
}
