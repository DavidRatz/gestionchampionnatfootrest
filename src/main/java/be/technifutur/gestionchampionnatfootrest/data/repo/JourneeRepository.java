package be.technifutur.gestionchampionnatfootrest.data.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import be.technifutur.gestionchampionnatfootrest.models.entities.Journee;

public interface JourneeRepository extends JpaRepository<Journee,Long> {
    Optional<Journee> findByNumero(int numero);
    @Query(value = "select * from journee j where j.numero = ?1 and j.championnat_id = ?2", nativeQuery = true)
    Optional<Journee> findByNumeroAndChampionnat(int numero, int championnat);
}
