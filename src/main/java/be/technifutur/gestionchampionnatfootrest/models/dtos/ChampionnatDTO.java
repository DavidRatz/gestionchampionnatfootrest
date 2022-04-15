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
public class ChampionnatDTO implements Serializable {
    private final Long id;
    private final String nom;
    private final String saison;
    private final int nbEquipes;
    private final String pays;
    private final List<ClubDTO> clubs;
    private final List<JourneeDTO> journees;

    public static ChampionnatDTO of(Championnat championnat) {
            if( championnat == null )
                return null;

            return new ChampionnatDTO(
            championnat.getId(),
            championnat.getNom(),
            championnat.getSaison(),
            championnat.getNbEquipes(),
            championnat.getPays(),
            championnat.getClubs() == null ? null : championnat.getClubs().stream()
                    .map(ClubDTO::of)
                    .toList(),
            championnat.getJournees() == null ? null : championnat.getJournees().stream()
                    .map(JourneeDTO::of)
                    .toList()
        );
    }

    @Data
    public static class ClubDTO{
        private final Long id;
        private final String nom;
        private final String pays;
        private final String nomPresident;
        private final String nomStade;
        private final LocalDate dateCreation;

        public static ClubDTO of(Club entity){
            if( entity == null )
                return null;
    
            return new ClubDTO(
                    entity.getId(),
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
        private final List<RencontreDTO> rencontres;

        public static JourneeDTO of(Journee journee){
            if( journee == null )
                return null;
    
            return new JourneeDTO(
                journee.getNumero(),
                journee.getDateDebut(),
                journee.getDateFin(),
                journee.getRencontres() == null ? null : journee.getRencontres().stream()
                            .map(RencontreDTO::of)
                            .toList()
            );
        }

    }

    @Data
    public static class RencontreDTO {
        private final LocalDateTime date;
        private final int scoreDomicile;
        private final int scoreVisiteur;
        private final ClubDTO clubDomicile;
        private final ClubDTO clubVisiteur;
    
        public static RencontreDTO of(Rencontre rencontre ) {
            if( rencontre == null )
                return null;
    
            return new RencontreDTO(
                rencontre.getDate(),
                rencontre.getScoreDomicile(),
                rencontre.getScoreVisiteur(),
                ClubDTO.of(rencontre.getClubDomicile()),
                ClubDTO.of(rencontre.getClubVisiteur())
            );
        }
    }
}
