package be.technifutur.gestionchampionnatfootrest.data.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.gestionchampionnatfootrest.models.dtos.UtilisateurDTO;
import be.technifutur.gestionchampionnatfootrest.models.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByUsername(String username);
    Optional<Utilisateur> findByUsernameAndPassword(String username, String password);
}
