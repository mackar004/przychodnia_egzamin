/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.egzamin.przychodnia.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 *
 * @author m
 */
class NavigationBar extends HorizontalLayout {

    NavigationBar() {
        Button btnPacjenci = new Button("Pacjenci", new Icon(VaadinIcon.MALE));
        btnPacjenci.setHeight("70px");
        btnPacjenci.addClickListener(e -> {
            btnPacjenci.getUI().ifPresent(ui -> ui.navigate("pacjenci"));
        });

        Button btnLekarze = new Button("Lekarze", new Icon(VaadinIcon.USERS));
        btnLekarze.setHeight("70px");
        btnLekarze.addClickListener(e -> {
            btnLekarze.getUI().ifPresent(ui -> ui.navigate("lekarze"));
        });
        
        Button btnWizyty = new Button("Wizyty");
        btnWizyty.setHeight("70px");
        btnWizyty.addClickListener(e -> {
            btnWizyty.getUI().ifPresent(ui -> ui.navigate("wizyty"));
        });
        
        add(btnPacjenci, btnLekarze, btnWizyty);
    }
}
