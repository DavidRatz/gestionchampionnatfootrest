package be.technifutur.gestionchampionnatfootrest.models.dtos;

import lombok.Builder;
import lombok.Data;

public interface ClassementDTO {
    Long getIdClub();
    String getNomClub();
    int getMatchJoue();
    int getVictoire();
    int getNul();
    int getDefaite();
    int getButPour();
    int getButContre();
    int getDiffBut();
    int getPoints();
}
