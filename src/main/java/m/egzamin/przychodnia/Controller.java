/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.egzamin.przychodnia;

import java.time.Month;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import javax.transaction.Transactional;
import m.egzamin.przychodnia.model.Lekarz;
import m.egzamin.przychodnia.model.Pacjent;
import m.egzamin.przychodnia.model.Raport;
import m.egzamin.przychodnia.model.Wizyta;
import m.egzamin.przychodnia.repository.LekarzRepository;
import m.egzamin.przychodnia.repository.PacjentRepository;
import m.egzamin.przychodnia.repository.WizytaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import m.egzamin.przychodnia.repository.RapRepository;

/**
 *
 * @author m
 */
@Transactional
@org.springframework.stereotype.Controller    // This means that this class is a Controller
@RequestMapping(path = "/rest")
@RestController
public class Controller {

    @Autowired
    PacjentRepository pacjentRepo;

    @Autowired
    WizytaRepository wizytaRepo;

    @Autowired
    LekarzRepository lekarzRepo;

    @Autowired
    RapRepository rapRepo;

    @GetMapping(path = "/pacjent/nowy")
    public @ResponseBody
    String addNewPacjent(@RequestParam String nazwisko, @RequestParam String pesel) {
        if (pacjentRepo.findByNazwiskoAndPeselIgnoreCase(nazwisko, pesel) != null) {
            Pacjent p = new Pacjent(nazwisko, pesel);
            pacjentRepo.save(p);
            return "pacjent" + nazwisko + " " + pesel + " dodany";
        } else {
            return "pacjent" + nazwisko + " " + pesel + " już istnieje!";
        }
    }

    @GetMapping(path = "/raport")
    public @ResponseBody
    Raport raport(@RequestParam String nazwisko, @RequestParam Month miesiac) {
        List<Wizyta> lista = wizytaRepo.findByLekarzNazwisko(nazwisko);

        Integer suma = wizytaRepo.findAll().stream()
                .filter(w -> w.getData().getMonth().equals(miesiac))
                .filter(w -> w.getLekarz().getNazwisko().equalsIgnoreCase(nazwisko))
                .mapToInt(w -> w.getLekarz().getStawka()).sum();

        return new Raport(nazwisko, lista.size(), suma, miesiac.length(false));

//        return nazwisko + "<br> Ilość pacjentów miesiącu: " + lista.size()
//                + "<br> Przychód z wizyt: " + suma + "<br>Średnia ilość pacjentów na dzień: "
//                + lista.size() / (float) miesiac.length(false) + "<br>Średni przychód na dzień: "
//                + suma / (lista.size());
    }

    @GetMapping(path = "/raport2")
    public @ResponseBody
    Iterable<Raport> makeRap(@RequestParam Month miesiac) {
        
        List<Wizyta> lista = wizytaRepo.findAll();
        List<Lekarz> listaLek = lekarzRepo.findAll();
        
        listaLek.forEach(lek-> { 
                Integer suma = wizytaRepo.findAll().stream()
                .filter(w -> w.getData().getMonth().equals(miesiac))
                //.filter(w -> w.getLekarz().getNazwisko().equalsIgnoreCase(nazwisko))
                .mapToInt(w -> w.getLekarz().getStawka())
                .sum();
                rapRepo.save(new Raport(lek.getNazwisko(), lista.size(), suma, miesiac.length(false)));
        });
        //raportRepo.add();
        return rapRepo.findAll();
    }


//    Raport raport2(@RequestParam String nazwisko, @RequestParam Month miesiac) {
//
//        List<Wizyta> lista = wizytaRepo.findByLekarzNazwisko(nazwisko);
//
//        Integer suma = wizytaRepo.findAll().stream()
//                .filter(w -> w.getData().getMonth().equals(miesiac))
//                .filter(w -> w.getLekarz().getNazwisko().equalsIgnoreCase(nazwisko))
//                .mapToInt(w -> w.getLekarz().getStawka())
//                .sum();
//
//        return new Raport(nazwisko, lista.size(), suma, miesiac.length(false));
//
////        return nazwisko + "<br> Ilość pacjentów miesiącu: " + lista.size()
////                + "<br> Przychód z wizyt: " + suma + "<br>Średnia ilość pacjentów na dzień: "
////                + lista.size() / (float) miesiac.length(false) + "<br>Średni przychód na dzień: "
////                + suma / (lista.size());
//    }

//    @GetMapping(path = "/raport2")
//    public @ResponseBody
//    Raport raport2(@RequestParam String nazwisko, @RequestParam Month miesiac) {
//        List<Wizyta> lista = wizytaRepo.findByLekarzNazwisko(nazwisko);
//
//        Integer suma = wizytaRepo.findAll().stream()
//                .filter(w -> w.getData().getMonth().equals(miesiac))
//                .filter(w -> w.getLekarz().getNazwisko().equalsIgnoreCase(nazwisko))
//                .mapToInt(w -> w.getLekarz().getStawka()).sum();
//
//        return new Raport(nazwisko, lista.size(), suma);
//    }

}
