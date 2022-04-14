package be.technifutur.gestionchampionnatfootrest.models.forms;

import javax.validation.constraints.*;

import lombok.Data;

@Data
public class ChampionnatForm {
    @NotNull
    @Size(min = 2, max = 255)
    private String nom;
    @NotNull
    @Size(min = 9, max = 9)
    @Pattern(regexp = "[0-9]{4}-[0-9]{4}")
    private String saison;
    @Min(0)
    private int nbEquipes;
    @NotNull
    private String pays;
}
