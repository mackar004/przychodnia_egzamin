/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.egzamin.przychodnia.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import m.egzamin.przychodnia.model.Lekarz;
import m.egzamin.przychodnia.model.Pacjent;
import m.egzamin.przychodnia.model.Wizyta;
import m.egzamin.przychodnia.repository.LekarzRepository;
import m.egzamin.przychodnia.repository.PacjentRepository;
import m.egzamin.przychodnia.repository.WizytaRepository;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class WizytaEdytor extends VerticalLayout {

    private final WizytaRepository wizytaRepo;
    private final LekarzRepository lekarzRepo;
    private final PacjentRepository pacjentRepo;
    private Wizyta wizyta;
    private Lekarz lekarz;
    private Pacjent pacjent;
    private LocalDate data;
    private Integer godzina;
    private Button zapisz = new Button("Zapisz wizyte");
    private List<Integer> listaGodzin = new ArrayList<>(Arrays.asList(8, 9, 10, 11, 12, 13, 14, 15));
    private List<Integer> dostepneGodziny;

    @Autowired
    public WizytaEdytor(WizytaRepository wizytaRepo, LekarzRepository lekarzRepo, PacjentRepository pacjentRepo) {

        this.wizytaRepo = wizytaRepo;
        this.lekarzRepo = lekarzRepo;
        this.pacjentRepo = pacjentRepo;

        ComboBox<Lekarz> lekarzBox = new ComboBox<>("Lekarze");
        lekarzBox.addValueChangeListener(event -> {
            lekarz = (Lekarz) event.getValue();
        });
        lekarzBox.setItems(lekarzRepo.findAll());

        ComboBox<Pacjent> pacjentBox = new ComboBox<>("Pacjenci");
        pacjentBox.addValueChangeListener(event -> {
            pacjent = (Pacjent) event.getValue();
        });
        pacjentBox.setItems(pacjentRepo.findAll());
        ComboBox<Integer> godzinaBox = new ComboBox<>("Godzina");

        DatePicker datePicker = new DatePicker();
        datePicker.addValueChangeListener(
                event -> {
                    LocalDate selectedDate = datePicker.getValue();
                    if (selectedDate != null) {
                        data = selectedDate;
                        dostepneGodziny = listaGodzin;
                        wizytaRepo.findByLekarzAndData(lekarz, data).forEach(wiz -> {
                            dostepneGodziny.removeIf(s -> s.equals(wiz.getGodzina()));
                        });
                        //dostepneGodziny.removeIf(s -> s.equals(10));
                        godzinaBox.setItems(dostepneGodziny);
                    }
                });

        godzinaBox.addValueChangeListener(event -> {
            godzina = godzinaBox.getValue();
        });

        zapisz.addClickListener(e -> {
            wizytaRepo.save(new Wizyta(data, lekarz, pacjent, godzina));
            Notification n = new Notification().show("Wizyta dodana, odswież stronę");
            n.setPosition(Notification.Position.MIDDLE);
        });

        add(lekarzBox, pacjentBox, datePicker, godzinaBox, zapisz);
        setVisible(false);
    }
}
