/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.egzamin.przychodnia.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import m.egzamin.przychodnia.model.Pacjent;
import m.egzamin.przychodnia.model.Wizyta;
import m.egzamin.przychodnia.repository.WizytaRepository;

/**
 *
 * @author m
 */
@Route(value = "wizyty")
public class WizytaView extends VerticalLayout {

    final NavigationBar menu;

    private final WizytaRepository wizytaRepo;
    final Grid wizytaGrid;
    Button nowaWizyta = new Button("Nowa wizyta");
    private final WizytaEdytor edytor;

    public WizytaView(WizytaRepository wizytaRepo, WizytaEdytor edytor) {

        this.menu = new NavigationBar();
        this.wizytaRepo = wizytaRepo;
        this.wizytaGrid = new Grid<>(Wizyta.class);
        wizytaGrid.setColumns("id", "data", "godzina", "lekarz", "pacjent");
        this.edytor = edytor;
        
        nowaWizyta.addClickListener(e -> edytor.setVisible(true));

        listWizyta();

        add(menu, nowaWizyta, edytor, wizytaGrid);
    }

    private void listWizyta() {
        wizytaGrid.setItems(wizytaRepo.findAll());
    }
}
