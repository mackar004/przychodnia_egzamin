/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.egzamin.przychodnia.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import m.egzamin.przychodnia.model.Lekarz;
import m.egzamin.przychodnia.model.Pacjent;
import m.egzamin.przychodnia.model.Wizyta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author m
 */
public interface WizytaRepository extends JpaRepository<Wizyta, Long>{
    List<Wizyta> findById(long id);
    List<Wizyta> findByData(LocalDate data);
    List<Wizyta> findByData(Month miesiac);
    List<Wizyta> findByLekarzNazwisko(String nazwisko);
    List<Wizyta> findByDataAndLekarzNazwisko(Month miesiac, String nazwisko);
    List<Wizyta> findByPacjent(Pacjent pacjent);
    List<Wizyta> findByLekarzAndData(Lekarz lekarz, LocalDate data);
}
