package be.technifutur.gestionchampionnatfootrest.models.dtos;

import lombok.Builder;
import lombok.Data;

public interface ClassementDTO {
    Long getId();
    int getButmarque();
    int getButencaisse();
}
