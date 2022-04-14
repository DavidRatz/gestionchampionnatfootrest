package be.technifutur.gestionchampionnatfootrest.models.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import be.technifutur.gestionchampionnatfootrest.models.entities.Championnat;
import be.technifutur.gestionchampionnatfootrest.models.entities.Journee;
import be.technifutur.gestionchampionnatfootrest.models.entities.Rencontre;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JourneeDTO implements Serializable {
    private final Long id;
    private final int numero;
    private final LocalDate dateDebut;
    private final LocalDate dateFin;
    private final ChampionnatDTO championnat;
    private final List<RencontreDTO> rencontres;
    
    public static JourneeDTO of(Journee journee){
        if( journee == null )
            return null;

        return new JourneeDTO(
            journee.getId(),
            journee.getNumero(),
            journee.getDateDebut(),
            journee.getDateFin(),
            ChampionnatDTO.of(journee.getChampionnat()),
            journee.getRencontres() == null ? null : journee.getRencontres().stream()
                        .map(RencontreDTO::of)
                        .toList()
        );
    }

    @Data
    public static class ChampionnatDTO{
        private final String nom;
        private final String saison;
        private final int nbEquipes;
        private final String pays;

        public static ChampionnatDTO of(Championnat championnat) {
            if( championnat == null )
                return null;

            return new ChampionnatDTO(
            championnat.getNom(),
            championnat.getSaison(),
            championnat.getNbEquipes(),
            championnat.getPays()
            );
        }
    }

    @Data
    public static class RencontreDTO{
        private final LocalDateTime date;
        private final int scoreDomicile;
        private final int scoreVisiteur;
        
        public static RencontreDTO of(Rencontre rencontre) {
            if( rencontre == null )
                return null;

            return new RencontreDTO(
                rencontre.getDate(),
                rencontre.getScoreDomicile(),
                rencontre.getScoreVisiteur()
            );
        }
    }
}
