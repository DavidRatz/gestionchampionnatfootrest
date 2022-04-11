package be.technifutur.gestionchampionnatfootrest.models.entities;

import java.time.LocalTime;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "rencontre")
public class Rencontre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:MM")
    private LocalTime heure;
    private int scoreDomicile;
    private int scoreVisiteur;
    @ManyToOne
    private Journee journee;
    // @ManyToOne
    // private Club clubDomicile;
    // @ManyToOne
    // private Club clubVisiteur;
}
