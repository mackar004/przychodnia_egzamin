/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.egzamin.przychodnia.model;

import java.time.LocalDate;
import java.time.Month;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wizyta")
public class Wizyta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //@Temporal(TemporalType.TIMESTAMP) //dla typu Date
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "lekarz_id")
    private Lekarz lekarz;

    @ManyToOne
    @JoinColumn(name = "pacjent_id")
    private Pacjent pacjent;
    
    private Integer godzina;
    
    //private Month miesiac;
    
    private Wizyta(){}

    public Wizyta(LocalDate data, Lekarz lekarz, Pacjent pacjent, int godzina) {
        this.data = data;
        this.lekarz = lekarz;
        this.pacjent = pacjent;
        this.godzina = godzina;
        //miesiac = data.getMonth();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public Integer getGodzina() {
        return godzina;
    }

    public void setGodzina(Integer godzina) {
        this.godzina = godzina;
    }

    @Override
    public String toString(){
        return String.format(data.toString());
    }

}
