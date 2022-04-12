package be.technifutur.gestionchampionnatfootrest.metiers.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.technifutur.gestionchampionnatfootrest.data.repo.ChampionnatRepository;
import be.technifutur.gestionchampionnatfootrest.metiers.services.GenericService;
import be.technifutur.gestionchampionnatfootrest.models.dtos.ChampionnatDTO;

@Service
public class ChampionnatServiceImpl implements GenericService<ChampionnatDTO> {

    @Autowired
    private ChampionnatRepository repository;

    @Override
    public ChampionnatDTO getOne(Long id) {
        return repository.findById(id)
                .map(ChampionnatDTO::of)
                .orElseThrow();
    }

    @Override
    public List<ChampionnatDTO> getAll() {
        return repository.findAll().stream()
                .map(ChampionnatDTO::of)
                .toList();
    }
    
}
