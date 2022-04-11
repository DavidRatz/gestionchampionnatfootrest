package be.technifutur.gestionchampionnatfootrest.metiers.services;

import java.util.List;

import be.technifutur.gestionchampionnatfootrest.models.dtos.ClubDTO;


public interface ClubService {

    ClubDTO getOne(Long id);

    List<ClubDTO> getAll();
    
}
