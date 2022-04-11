package be.technifutur.gestionchampionnatfootrest.models.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import be.technifutur.gestionchampionnatfootrest.models.entities.Championnat;
import be.technifutur.gestionchampionnatfootrest.models.entities.Club;
import be.technifutur.gestionchampionnatfootrest.models.entities.Rencontre;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClubDTO implements Serializable {
    private Long id;
    private String nom;
    private String pays;
    private String nomPresident;
    private String nomStade;
    private LocalDate dateCreation;
    //private ChampionnatDTO championnat;
    //private List<RencontreDTO> rencontresDomicile;
    //private List<RencontreDTO> rencontresVisiteur;

    public static ClubDTO of(Club entity){
        if( entity == null )
            return null;

        return new ClubDTO(
                entity.getId(),
                entity.getNom(),
                entity.getNomPresident(),
                entity.getNomStade(),
                entity.getPays(),
                entity.getDateCreation()//,
                // ChampionnatDTO.of(entity.getChampionnat()),
                // entity.getRencontresDomicile() == null ? null : entity.getRencontresDomicile().stream()
                //         .map(RencontreDTO::of)
                //         .toList(),
                // entity.getRencontresVisiteur() == null ? null : entity.getRencontresVisiteur().stream()
                //         .map(RencontreDTO::of)
                //         .toList()
        );
    }

    // @Data
    // public static class ChampionnatDTO{
    //     public static ChampionnatDTO of(Championnat championnat) {
    //         return null;
    //     }
    // }

    // @Data
    // public static class RencontreDTO{
    //     public static RencontreDTO of(Rencontre rencontre) {
    //         return null;
    //     }
    // }
}
