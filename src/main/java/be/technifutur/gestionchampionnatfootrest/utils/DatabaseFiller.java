package be.technifutur.gestionchampionnatfootrest.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.technifutur.gestionchampionnatfootrest.data.repo.ClubRepository;
import be.technifutur.gestionchampionnatfootrest.models.entities.Club;

@Component
public class DatabaseFiller implements InitializingBean {

    @Autowired
    private ClubRepository clubRepo;

    @Override
    public void afterPropertiesSet() throws Exception {
        Club club = Club.builder()
                .id(1L)
                .nom("Standard de Liège")
                .nomPresident("Bruno Venanzi")
                .nomStade("Maurice Dufrasne")
                .dateCreation(LocalDate.of(1898, Month.JANUARY, 1))
                .pays("Belgique")
                .build();
                
        clubRepo.save(club);
    }
}
