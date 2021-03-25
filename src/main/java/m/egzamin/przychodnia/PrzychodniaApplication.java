package m.egzamin.przychodnia;

import m.egzamin.przychodnia.model.Lekarz;
import m.egzamin.przychodnia.model.Pacjent;
import m.egzamin.przychodnia.model.Wizyta;
import m.egzamin.przychodnia.repository.LekarzRepository;
import m.egzamin.przychodnia.repository.PacjentRepository;
import m.egzamin.przychodnia.repository.RapRepository;
import m.egzamin.przychodnia.repository.WizytaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrzychodniaApplication {

    @Autowired
    LekarzRepository lekarzRepository;

    @Autowired
    WizytaRepository wizytaRepository;

    @Autowired
    PacjentRepository pacjentRepository;
    
    @Autowired
    RapRepository raportRepository;

    public static void main(String[] args) {
        SpringApplication.run(PrzychodniaApplication.class, args);
    }

//    @Bean-+
//            Pacjent jb = new Pacjent("Bauer", "895645821");
//            Pacjent co = new Pacjent("O'Brian", "905865823");
//
//            repository.save(jb);
//            repository.save(co);
//
//            Lekarz p = new Lekarz("Palmer", 1200);
//            lekRepo.save(p);
//            
//            Lekarz p2 = new Lekarz("Nowak", 600);
//            lekRepo.save(p2);
//
////            Wizyta wiz = new Wizyta(p, jb);
////            repo.save(wiz);
////
////            Wizyta wiz2 = new Wizyta(p2, co);
////            repo.save(wiz2);
//
//        });
//    }
}
