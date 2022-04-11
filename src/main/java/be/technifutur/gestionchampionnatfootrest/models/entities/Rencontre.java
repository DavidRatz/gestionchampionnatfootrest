package be.technifutur.gestionchampionnatfootrest.models.entities;

import java.sql.Time;

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
    private Time heure;
    private int scoreDomicile;
    private int scoreVisiteur;
    @ManyToOne
    private Journee journee;
    @ManyToOne
    private Club clubDomicile;
    @ManyToOne
    private Club clubVisiteur;
}
