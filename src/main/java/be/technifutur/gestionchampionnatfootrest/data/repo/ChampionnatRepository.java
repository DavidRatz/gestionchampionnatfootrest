package be.technifutur.gestionchampionnatfootrest.data.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.gestionchampionnatfootrest.models.entities.Championnat;

public interface ChampionnatRepository extends JpaRepository<Championnat,Long> {
    Optional<Championnat> findByPays(String pays);
}
