package be.technifutur.gestionchampionnatfootrest.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.gestionchampionnatfootrest.models.entities.Rencontre;

public interface RencontreRepository extends JpaRepository<Rencontre,Long> {
    
}
