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
@Table(name="pacjent")
public class Pacjent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazwisko;
    private String pesel;
    
    @OneToMany(mappedBy = "pacjent", fetch = FetchType.EAGER)
    private List<Wizyta> wizyta;
    
    private Pacjent(){}
    
    public Pacjent(String nazwisko, String pesel){
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }
    
    public Pacjent(String nazwisko, String pesel, List<Wizyta> wizyta){
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.wizyta = wizyta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
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
        //return String.format("Nazwisko %s; Pesel: %d", nazwisko,pesel);
    }
    
}
