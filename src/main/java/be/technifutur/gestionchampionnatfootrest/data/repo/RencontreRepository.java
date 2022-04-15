package be.technifutur.gestionchampionnatfootrest.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import be.technifutur.gestionchampionnatfootrest.models.dtos.ClassementDTO;
import be.technifutur.gestionchampionnatfootrest.models.entities.Classement;
import be.technifutur.gestionchampionnatfootrest.models.entities.Rencontre;

public interface RencontreRepository extends JpaRepository<Rencontre,Long> {
    @Query(value = "select d.id,  SUM(d.butmarque), SUM(d.butencaisse) from (SELECT club_domicile_id as 'id', r.score_domicile as 'butmarque',r.score_visiteur as 'butencaisse', r.date FROM rencontre r WHERE club_domicile_id = ?1 union all SELECT club_visiteur_id as 'id', r.score_visiteur as 'butmarque', r.score_domicile as 'butencaisse', r.date FROM rencontre r WHERE club_visiteur_id = ?1) d where d.date < Now()", nativeQuery = true)
    List<ClassementDTO> getScoreByClub(Long clubId);
}
