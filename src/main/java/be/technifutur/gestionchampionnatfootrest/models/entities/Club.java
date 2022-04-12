package be.technifutur.gestionchampionnatfootrest.models.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nom;
    @Column(nullable = false)
    private String pays;
    @Column(nullable = false)
    private String nomPresident;
    @Column(nullable = false)
    private String nomStade;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreation;
    @ManyToOne
    private Championnat championnat;
    @OneToMany(mappedBy = "clubDomicile", cascade = CascadeType.PERSIST)
    private List<Rencontre> rencontresDomicile = new ArrayList<>();
    @OneToMany(mappedBy = "clubVisiteur", cascade = CascadeType.PERSIST)
    private List<Rencontre> rencontresVisiteur = new ArrayList<>();
}
