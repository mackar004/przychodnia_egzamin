/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.egzamin.przychodnia.repository;

import java.util.List;
import m.egzamin.przychodnia.model.Raport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author m
 */
public interface RapRepository extends JpaRepository<Raport, Long>{
//    List<Raport> findByNazwisko(String nazwisko);
}
