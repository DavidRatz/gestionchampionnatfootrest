package be.technifutur.gestionchampionnatfootrest.models.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import be.technifutur.gestionchampionnatfootrest.models.entities.Championnat;
import be.technifutur.gestionchampionnatfootrest.models.entities.Club;
import be.technifutur.gestionchampionnatfootrest.models.entities.Journee;
import be.technifutur.gestionchampionnatfootrest.models.entities.Rencontre;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RencontreDTO implements Serializable {
    private final Long id;
    private final LocalDateTime date;
    private final int scoreDomicile;
    private final int scoreVisiteur;
    private final JourneeDTO journee;
    private final ClubDTO clubDomicile;
    private final ClubDTO clubVisiteur;

    public static RencontreDTO of(Rencontre rencontre ) {
        if( rencontre == null )
            return null;

        return new RencontreDTO(
            rencontre.getId(),
            rencontre.getDate(),
            rencontre.getScoreDomicile(),
            rencontre.getScoreVisiteur(),
            JourneeDTO.of(rencontre.getJournee()),
            ClubDTO.of(rencontre.getClubDomicile()),
            ClubDTO.of(rencontre.getClubVisiteur())
        );
    }

    @Data
    public static class ClubDTO{
        private final String nom;
        private final String pays;
        private final String nomPresident;
        private final String nomStade;
        private final LocalDate dateCreation;

        public static ClubDTO of(Club entity){
            if( entity == null )
                return null;
    
            return new ClubDTO(
                    entity.getNom(),
                    entity.getPays(),
                    entity.getNomPresident(),
                    entity.getNomStade(),
                    entity.getDateCreation()
            );
        }
    }

    @Data
    public static class JourneeDTO{
        private final int numero;
        private final LocalDate dateDebut;
        private final LocalDate dateFin;

        public static JourneeDTO of(Journee journee){
            if( journee == null )
                return null;
    
            return new JourneeDTO(
                journee.getNumero(),
                journee.getDateDebut(),
                journee.getDateFin()
            );
        }
    }
}
