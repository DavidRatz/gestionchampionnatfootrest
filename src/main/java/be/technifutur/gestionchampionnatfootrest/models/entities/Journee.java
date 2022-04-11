package be.technifutur.gestionchampionnatfootrest.models.entities;

import java.sql.Date;
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
@Table(name = "journee")
public class Journee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;
    @ManyToOne
    private Championnat championnat;
    @OneToMany(mappedBy = "journee", cascade = CascadeType.PERSIST)
    private List<Rencontre> rencontres = new ArrayList<>();
}
