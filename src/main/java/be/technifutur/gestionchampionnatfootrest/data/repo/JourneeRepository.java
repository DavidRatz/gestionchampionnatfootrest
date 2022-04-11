package be.technifutur.gestionchampionnatfootrest.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.gestionchampionnatfootrest.models.entities.Journee;

public interface JourneeRepository extends JpaRepository<Journee,Long> {
    
}
