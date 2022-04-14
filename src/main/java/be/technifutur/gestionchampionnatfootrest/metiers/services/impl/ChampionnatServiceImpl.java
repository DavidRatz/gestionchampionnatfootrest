package be.technifutur.gestionchampionnatfootrest.metiers.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.technifutur.gestionchampionnatfootrest.data.repo.ChampionnatRepository;
import be.technifutur.gestionchampionnatfootrest.metiers.services.GenericService;
import be.technifutur.gestionchampionnatfootrest.models.dtos.ChampionnatDTO;
import be.technifutur.gestionchampionnatfootrest.models.forms.ChampionnatForm;

@Service
public class ChampionnatServiceImpl implements GenericService<ChampionnatDTO,ChampionnatForm> {

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

    @Override
    public ChampionnatDTO insert(ChampionnatForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ChampionnatDTO update(Long id, ChampionnatForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ChampionnatDTO delete(Long id) {
        ChampionnatDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
    
}
