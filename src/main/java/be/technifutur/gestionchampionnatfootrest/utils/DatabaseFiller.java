package be.technifutur.gestionchampionnatfootrest.utils;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import be.technifutur.gestionchampionnatfootrest.data.repo.ChampionnatRepository;
import be.technifutur.gestionchampionnatfootrest.data.repo.ClubRepository;
import be.technifutur.gestionchampionnatfootrest.data.repo.JourneeRepository;
import be.technifutur.gestionchampionnatfootrest.data.repo.RencontreRepository;
import be.technifutur.gestionchampionnatfootrest.data.repo.UtilisateurRepository;
import be.technifutur.gestionchampionnatfootrest.models.entities.Championnat;
import be.technifutur.gestionchampionnatfootrest.models.entities.Club;
import be.technifutur.gestionchampionnatfootrest.models.entities.Journee;
import be.technifutur.gestionchampionnatfootrest.models.entities.Rencontre;
import be.technifutur.gestionchampionnatfootrest.models.entities.Utilisateur;

@Component
public class DatabaseFiller implements InitializingBean {

    @Autowired
    private ClubRepository clubRepo;
    @Autowired
    private ChampionnatRepository championnatRepo;
    @Autowired
    private JourneeRepository journeeRepo;
    @Autowired
    private RencontreRepository rencontreRepo;
    @Autowired
    private UtilisateurRepository uRepo;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void afterPropertiesSet() throws Exception {
        rencontreRepo.deleteAll();
        journeeRepo.deleteAll();
        clubRepo.deleteAll();
        championnatRepo.deleteAll();
        uRepo.deleteAll();
        
        Championnat championnat = Championnat.builder()
                        // .id(1L)
                        .nom("Jupiler pro league")
                        .nbEquipes(18)
                        .saison("2021-2022")
                        .pays("Belgique")
                        .build();
        championnatRepo.save(championnat);

        Club club = Club.builder()
                .id(1L)
                .nom("Standard de Liège")
                .nomPresident("Bruno Venanzi")
                .nomStade("Maurice Dufrasne")
                .dateCreation(LocalDate.of(1898, Month.JANUARY, 1))
                .pays("Belgique")
                .championnat(championnat)
                .build();
                
        clubRepo.save(club);

        club = Club.builder()
                .id(2L)
                .nom("RSC Anderlecht")
                .nomPresident("Wouter Vandenhaute")
                .nomStade("Lotto park")
                .dateCreation(LocalDate.of(1908, Month.MAY, 27))
                .pays("Belgique")
                .championnat(championnat)
                .build();
                
        clubRepo.save(club);

        club = Club.builder()
                .id(3L)
                .nom("Club Brugge KV")
                .nomPresident("Bart Verhaeghe")
                .nomStade("Jan-Breydel Stadium")
                .dateCreation(LocalDate.of(1891, Month.NOVEMBER, 1))
                .pays("Belgique")
                .championnat(championnat)
                .build();
                
        clubRepo.save(club);

        club = Club.builder()
                .id(4L)
                .nom("RSC Charleroi")
                .nomPresident("Fabien Debecq")
                .nomStade("Stade du pays de Charleroi")
                .dateCreation(LocalDate.of(1904, Month.JANUARY, 1))
                .pays("Belgique")
                .championnat(championnat)
                .build();
                
        clubRepo.save(club);

        club = Club.builder()
                .id(5L)
                .nom("Union Saint-Gilloise")
                .nomPresident("Alex Muzio")
                .nomStade("Stade Joseph Marien")
                .dateCreation(LocalDate.of(1897, Month.NOVEMBER, 1))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);

        club = Club.builder()
                .id(6L)
                .nom("Royal Antwerp")
                .nomPresident("Paul Gheysens")
                .nomStade("Bosuilstadion")
                .dateCreation(LocalDate.of(1880, Month.JANUARY, 1))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);

        club = Club.builder()
                .id(7L)
                .nom("KAA Gent")
                .nomPresident("Ivan De Witte")
                .nomStade("Ghelamco Arena")
                .dateCreation(LocalDate.of(1900, Month.OCTOBER, 31))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);

        club = Club.builder()
                .id(8L)
                .nom("Mechelen")
                .nomPresident("Dieter Pienninckx")
                .nomStade("Stade AFAS")
                .dateCreation(LocalDate.of(1904, Month.JANUARY, 1))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);

        club = Club.builder()
                .id(9L)
                .nom("KRC Genk")
                .nomPresident("Peter Croonen")
                .nomStade("Luminus Arena")
                .dateCreation(LocalDate.of(1923, Month.JANUARY, 1))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);

        club = Club.builder()
                .id(10L)
                .nom("Saint Trond VV")
                .nomPresident("David Meekers")
                .nomStade("Stayen")
                .dateCreation(LocalDate.of(1924, Month.FEBRUARY, 23))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);

        club = Club.builder()
                .id(11L)
                .nom("Cercle Bruges")
                .nomPresident("Vincent Goemare")
                .nomStade("Jan-Breydel Stadium")
                .dateCreation(LocalDate.of(1899, Month.APRIL, 9))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);

        club = Club.builder()
                .id(12L)
                .nom("OH Louvain")
                .nomPresident("Chris Vandebroeck")
                .nomStade("King Power at Den Dreef Stadion")
                .dateCreation(LocalDate.of(1957, Month.JANUARY, 1))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);

        club = Club.builder()
                .id(13L)
                .nom("KV Ostende")
                .nomPresident("Gauthier Ganaye")
                .nomStade("Versluys Arena")
                .dateCreation(LocalDate.of(1905, Month.OCTOBER, 1))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);


        club = Club.builder()
                .id(14L)
                .nom("KV Courtrai")
                .nomPresident("Ronny Verhelst")
                .nomStade("Stade des Éperons d'or")
                .dateCreation(LocalDate.of(1901, Month.MARCH, 14))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);

        club = Club.builder()
                .id(15L)
                .nom("KAS Eupen")
                .nomPresident("Tariq Abdulaziz Al Naama")
                .nomStade("Stade du Kehrweg")
                .dateCreation(LocalDate.of(1945, Month.JULY, 9))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);

        club = Club.builder()
                .id(16L)
                .nom("Zulte Waregem")
                .nomPresident("Carl Ballière")
                .nomStade("Stade Arc-en-ciel")
                .dateCreation(LocalDate.of(1935, Month.SEPTEMBER, 25))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);

        club = Club.builder()
                .id(17L)
                .nom("RFC Seraing")
                .nomPresident("Bernard Serin")
                .nomStade("Stade du Pairay")
                .dateCreation(LocalDate.of(1922, Month.JANUARY, 1))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);

        club = Club.builder()
                .id(18L)
                .nom("Beerschot VA")
                .nomPresident("Abdullah bin Musaid Al Saud")
                .nomStade("Stade olympique d'Anvers")
                .dateCreation(LocalDate.of(1921, Month.JANUARY, 1))
                .pays("Belgique")
                .championnat(championnat)
                .build();

        clubRepo.save(club);

        Utilisateur user = new Utilisateur();
        user.setUsername("admin");
        user.setPassword(encoder.encode("pass"));
        user.setRoles(List.of("ROLE_ADMIN"));

        uRepo.save(user);

        user = new Utilisateur();
        user.setUsername("user");
        user.setPassword(encoder.encode("pass"));
        user.setRoles(List.of("ROLE_USER"));

        uRepo.save(user);

       creationCalendrier();
    }

    private void creationCalendrier(){
       

        int nbClub = (int)clubRepo.count(); //4
        int nbJournee = (nbClub-1)*2; //6
        int nbRencontreByJournee = nbClub/2; //2
        int nbRencontre = nbJournee*nbRencontreByJournee; //12
        int moitieRencontre = (nbJournee / 2);
        List<Journee> lJournees = journeeRepo.findAll();
        
        Journee journee2Insert = null;
        Rencontre rencontre = null;

        int i =0;

        for (int iJournee = 0; iJournee < nbJournee; iJournee++) {
            LocalDate dateDebut = LocalDate.now().minusWeeks(2).with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).plusDays(i);
            LocalDate dateFin = LocalDate.now().minusWeeks(2).with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).plusDays(i+2);
            journee2Insert = Journee.builder()
                .numero(iJournee+1)
                .dateDebut(dateDebut)
                .dateFin(dateFin)
                .championnat(championnatRepo.findByPays("Belgique").get())
                .build();
            journeeRepo.save(journee2Insert);
            i+=7;

            
            for (int iRencontreByJournee = 0; iRencontreByJournee < nbRencontreByJournee; iRencontreByJournee++) {
                int days = Math.toIntExact(ChronoUnit.DAYS.between(dateDebut, dateFin));
                Long idClubDomicile = Long.valueOf((iJournee + iRencontreByJournee) % (nbClub-1));
                Long idClubVisiteur = null;
                if(iRencontreByJournee == 0)
                    idClubVisiteur = Long.valueOf((nbClub-1));
                else
                    idClubVisiteur = Long.valueOf(((nbClub-1) - iRencontreByJournee + iJournee) % (nbClub-1));
                rencontre = Rencontre.builder()
                    .date(LocalDateTime.of(dateDebut, LocalTime.of(20, 00)).plusDays(ThreadLocalRandom.current().nextInt(days+1)))
                    .journee(journeeRepo.findByNumero(iJournee+1).get())
                    .build();
                if (iJournee < moitieRencontre) {
                    rencontre.setClubDomicile(clubRepo.findById(idClubDomicile+1).get());
                    rencontre.setClubVisiteur(clubRepo.findById(idClubVisiteur+1).get());
                } else {
                    rencontre.setClubDomicile(clubRepo.findById(idClubVisiteur+1).get());
                    rencontre.setClubVisiteur(clubRepo.findById(idClubDomicile+1).get());
                }
                rencontreRepo.save(rencontre);
            }
        }

    }
}
