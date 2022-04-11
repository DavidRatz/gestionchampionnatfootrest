package be.technifutur.gestionchampionnatfootrest.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.gestionchampionnatfootrest.models.entities.Club;

public interface ClubRepository extends JpaRepository<Club,Long> {
    
}
