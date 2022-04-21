package be.technifutur.gestionchampionnatfootrest.models.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import be.technifutur.gestionchampionnatfootrest.models.entities.Championnat;
import be.technifutur.gestionchampionnatfootrest.models.entities.Club;
import be.technifutur.gestionchampionnatfootrest.models.entities.Rencontre;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClubDTO implements Serializable {
    private final Long id;
    private final String nom;
    private final String pays;
    private final String nomPresident;
    private final String nomStade;
    private final LocalDate dateCreation;
    private ChampionnatDTO championnat;
    private List<RencontreDTO> rencontresDomicile;
    private List<RencontreDTO> rencontresVisiteur;

    public static ClubDTO of(Club entity){
        if( entity == null )
            return null;

        return new ClubDTO(
                entity.getId(),
                 entity.getNom(),
                entity.getPays(),
                entity.getNomPresident(),
                entity.getNomStade(),
                entity.getDateCreation(),
                ChampionnatDTO.of(entity.getChampionnat()),
                entity.getRencontresDomicile() == null ? null : entity.getRencontresDomicile().stream()
                        .map(RencontreDTO::of)
                        .toList(),
                entity.getRencontresVisiteur() == null ? null : entity.getRencontresVisiteur().stream()
                        .map(RencontreDTO::of)
                        .toList()
        );
    }

    @Data
    public static class ChampionnatDTO{
        private final Long id;
        private final String nom;
        private final String saison;
        private final int nbEquipes;
        private final String pays;

        public static ChampionnatDTO of(Championnat championnat) {
            if( championnat == null )
                return null;

            return new ChampionnatDTO(
                championnat.getId(),
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
        private final ClubRencontreDTO clubDomicile;
        private final ClubRencontreDTO clubVisiteur;

        public static RencontreDTO of(Rencontre rencontre) {
            if( rencontre == null )
                return null;

            return new RencontreDTO(
                rencontre.getDate(),
                rencontre.getScoreDomicile(),
                rencontre.getScoreVisiteur(),
                ClubRencontreDTO.of(rencontre.getClubDomicile()),
                ClubRencontreDTO.of(rencontre.getClubVisiteur())
            );
        }
    }

    @Data
    public static class ClubRencontreDTO{
        private final String nom;
        public static ClubRencontreDTO of(Club entity){
            if( entity == null )
                return null;
    
            return new ClubRencontreDTO(
                    entity.getNom()
            );
        }
    }
}
