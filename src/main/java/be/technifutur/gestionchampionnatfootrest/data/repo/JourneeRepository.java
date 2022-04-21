package be.technifutur.gestionchampionnatfootrest.data.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import be.technifutur.gestionchampionnatfootrest.models.entities.Journee;

public interface JourneeRepository extends JpaRepository<Journee,Long> {
    Optional<Journee> findByNumero(int numero);
    @Query(value = "select * from journee j join rencontre r on r.journee_id = j.id join club c on c.id = r.club_domicile_id join championnat ch on ch.id = j.championnat_id where j.numero = ?1 and j.championnat_id = ?2 order by r.date asc", nativeQuery = true)
    Optional<Journee> findByNumeroAndChampionnat(int numero, Long championnat);
}
