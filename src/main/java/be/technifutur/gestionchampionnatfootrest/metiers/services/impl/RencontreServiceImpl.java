package be.technifutur.gestionchampionnatfootrest.metiers.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.technifutur.gestionchampionnatfootrest.data.repo.RencontreRepository;
import be.technifutur.gestionchampionnatfootrest.metiers.services.GenericService;
import be.technifutur.gestionchampionnatfootrest.metiers.services.RencontreService;
import be.technifutur.gestionchampionnatfootrest.models.dtos.RencontreDTO;

@Service
public class RencontreServiceImpl implements GenericService<RencontreDTO>, RencontreService {

    @Autowired
    private RencontreRepository repository;

    @Override
    public RencontreDTO getOne(Long id) {
        return repository.findById(id)
                .map(RencontreDTO::of)
                .orElseThrow();
    }

    @Override
    public List<RencontreDTO> getAll() {
        return repository.findAll().stream()
                .map(RencontreDTO::of)
                .toList();
    }
    
}
