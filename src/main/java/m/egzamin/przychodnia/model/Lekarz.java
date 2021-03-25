/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.egzamin.przychodnia.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author m
 */

@Entity
@Table(name="lekarz")
public class Lekarz {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazwisko;
    private int stawka;
            
    @OneToMany(mappedBy = "lekarz", fetch = FetchType.EAGER)
    private List<Wizyta> wizyta;
    
    private Lekarz(){}
    
    public Lekarz(String nazwisko, int stawka){
        this.nazwisko = nazwisko;
        this.stawka = stawka;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getStawka() {
        return stawka;
    }

    public void setStawka(int stawka) {
        this.stawka = stawka;
    }

    public List<Wizyta> getWizyta() {
        return wizyta;
    }

    public void setWizyta(List<Wizyta> wizyta) {
        this.wizyta = wizyta;
    }
    
    @Override
    public String toString(){
        return this.nazwisko;
    }
    
}
