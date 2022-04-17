package be.technifutur.gestionchampionnatfootrest.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import be.technifutur.gestionchampionnatfootrest.models.dtos.ClassementDTO;
import be.technifutur.gestionchampionnatfootrest.models.entities.Classement;
import be.technifutur.gestionchampionnatfootrest.models.entities.Rencontre;

public interface RencontreRepository extends JpaRepository<Rencontre,Long> {
    @Query(value = "CALL get_all_classement();", nativeQuery = true)
    List<ClassementDTO> getScoreByClub(Long clubId);
}
