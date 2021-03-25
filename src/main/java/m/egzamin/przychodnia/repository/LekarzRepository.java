/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.egzamin.przychodnia.repository;

import java.util.List;
import m.egzamin.przychodnia.model.Lekarz;
import m.egzamin.przychodnia.model.Wizyta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author m
 */
public interface LekarzRepository extends JpaRepository<Lekarz, Long>{
    List<Lekarz> findById(long id);
    List<Lekarz> findByNazwiskoContains(String nazwisko);
    List<Lekarz> findByWizyta(Wizyta wizyta);
}
