package be.technifutur.gestionchampionnatfootrest.models.dtos;

import lombok.Builder;
import lombok.Data;

public interface ClassementDTO {
    Long getId();
    int getMatchJoue();
    int getVictoire();
    int getNul();
    int getDefaite();
    String getBut();
    int getPoints();
}
