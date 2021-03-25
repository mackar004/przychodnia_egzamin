/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.egzamin.przychodnia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author m
 */
@Entity
@Table(name = "raport")
public class Raport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazwisko;
    private Integer iloscWizyt;
    private Integer przychod;
    private float srWizyty;
    private float srPrzychod;
    
    public Raport(String nazwisko, Integer iloscWizyt, Integer przychod, Integer iloscDni){
        this.nazwisko = nazwisko;
        this.iloscWizyt = iloscWizyt;
        this.przychod = przychod;
        this.srWizyty = this.iloscWizyt/iloscDni;
        this.srPrzychod = this.przychod/iloscDni;
//        System.out.println(srWizyty);
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Integer getIloscWizyt() {
        return iloscWizyt;
    }

    public void setIloscWizyt(Integer iloscWizyt) {
        this.iloscWizyt = iloscWizyt;
    }

    public Integer getPrzychod() {
        return przychod;
    }

    public void setPrzychod(Integer przychod) {
        this.przychod = przychod;
    }

    public float getSrWizyty() {
        return srWizyty;
    }

    public float getSrPrzychod() {
        return srPrzychod;
    }
   
}