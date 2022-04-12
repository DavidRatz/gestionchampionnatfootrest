package be.technifutur.gestionchampionnatfootrest.models.entities;

import java.time.LocalDateTime;

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
    @DateTimeFormat(pattern = "dd/MM/YYYY HH:MM")
    private LocalDateTime date;
    @Column(nullable = true)
    private int scoreDomicile;
    @Column(nullable = true)
    private int scoreVisiteur;
    @ManyToOne
    private Journee journee;
    @ManyToOne
    private Club clubDomicile;
    @ManyToOne
    private Club clubVisiteur;
}
