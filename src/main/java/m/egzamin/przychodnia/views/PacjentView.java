/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.egzamin.przychodnia.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import m.egzamin.przychodnia.model.Pacjent;
import m.egzamin.przychodnia.model.Wizyta;
import m.egzamin.przychodnia.repository.PacjentRepository;
import m.egzamin.przychodnia.repository.WizytaRepository;
import org.springframework.util.StringUtils;

/**
 *
 * @author m
 */
@Route(value = "pacjenci")
public class PacjentView extends VerticalLayout {

    private final PacjentRepository pacjentRepo;
    private final WizytaRepository wizytaRepo;
    private Pacjent pacjent;
    final Grid pacjentGrid;
    final Grid wizytaGrid;
    final TextField pacjentFiltr;

    final NavigationBar menu;

    public PacjentView(PacjentRepository pacjentRepo, WizytaRepository wizytaRepo) {
        this.pacjentRepo = pacjentRepo;
        this.wizytaRepo = wizytaRepo;

        this.pacjentGrid = new Grid<>(Pacjent.class);
        this.wizytaGrid = new Grid<>(Wizyta.class);
        wizytaGrid.setVisible(true);
        
        this.menu = new NavigationBar();
        this.pacjentFiltr = new TextField();
        pacjentFiltr.setPlaceholder("Szukaj pacjenta");
        pacjentFiltr.setValueChangeMode(ValueChangeMode.EAGER);
        pacjentFiltr.addValueChangeListener(e -> listPacjent(e.getValue()));
        
        wizytaGrid.setColumns("id", "data", "lekarz");

        pacjentGrid.setColumns("id", "nazwisko", "pesel");
        pacjentGrid.getColumnByKey("id").setWidth("50px").setFlexGrow(0).setSortProperty("id");
        pacjentGrid.asSingleSelect().addValueChangeListener(e -> {
            pacjent = (Pacjent) e.getValue();
            listWizyta(pacjent);
        });

        
        add(menu, pacjentFiltr, pacjentGrid, wizytaGrid);
        
        listPacjent(pacjentFiltr.getValue());
    }

    private void listPacjent(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            pacjentGrid.setItems(pacjentRepo.findAll());
        } else {
            pacjentGrid.setItems(pacjentRepo.findByNazwiskoContains(filterText));
        }
    }
    
    private void listWizyta(Pacjent pacjent){
        wizytaGrid.setItems(wizytaRepo.findByPacjent(pacjent));
    }
}