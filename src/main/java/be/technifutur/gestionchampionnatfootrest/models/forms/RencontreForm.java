package be.technifutur.gestionchampionnatfootrest.models.forms;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import lombok.*;

@Data
public class RencontreForm {
    @Min(value= 0, message = "Score plus grand que 0")
    private int scoreDomicile;
    @Min(0)
    private int scoreVisiteur;
}
