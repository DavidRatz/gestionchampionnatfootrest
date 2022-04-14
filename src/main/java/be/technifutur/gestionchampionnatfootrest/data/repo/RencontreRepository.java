package be.technifutur.gestionchampionnatfootrest.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import be.technifutur.gestionchampionnatfootrest.models.entities.Rencontre;

public interface RencontreRepository extends JpaRepository<Rencontre,Long> {
    @Query(value = "select sum(d.score) as 'scoreClub' from (SELECT score_domicile as 'score', date FROM `rencontre` WHERE club_domicile_id = ?1 union all SELECT score_visiteur as 'score', date FROM rencontre WHERE club_visiteur_id = ?1) d where d.date < Now();", nativeQuery = true)
    Integer getScoreByClub(Long clubId);
}
