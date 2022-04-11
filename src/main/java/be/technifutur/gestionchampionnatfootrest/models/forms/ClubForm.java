package be.technifutur.gestionchampionnatfootrest.models.forms;

import java.time.LocalDate;

import org.springframework.validation.annotation.Validated;

import lombok.*;

@Data
@Validated
public class ClubForm {
    private String nom;
    private String pays;
    private String nomPresident;
    private String nomStade;
    private LocalDate dateCreation;
}
