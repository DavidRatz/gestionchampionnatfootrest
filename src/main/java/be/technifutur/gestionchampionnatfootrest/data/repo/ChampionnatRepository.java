package be.technifutur.gestionchampionnatfootrest.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.gestionchampionnatfootrest.models.entities.Championnat;

public interface ChampionnatRepository extends JpaRepository<Championnat,Long> {
    Championnat findByPays(String pays);
}
