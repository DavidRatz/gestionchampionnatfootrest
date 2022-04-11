package be.technifutur.gestionchampionnatfootrest.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "championnat")
public class Championnat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String saison;
    @Column(nullable = false)
    private String nbEquipes;
    @Column(nullable = false)
    private String pays;
    @OneToMany(mappedBy = "championnat", cascade = CascadeType.PERSIST)
    private List<Club> clubs = new ArrayList<>();
}
