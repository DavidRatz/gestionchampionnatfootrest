package be.technifutur.gestionchampionnatfootrest.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassementDTO {
    private Long clubId;
    private int score;
}
