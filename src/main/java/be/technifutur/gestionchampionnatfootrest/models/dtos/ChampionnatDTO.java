package be.technifutur.gestionchampionnatfootrest.models.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import be.technifutur.gestionchampionnatfootrest.models.entities.Championnat;
import be.technifutur.gestionchampionnatfootrest.models.entities.Club;
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
                        .toList()
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
}
