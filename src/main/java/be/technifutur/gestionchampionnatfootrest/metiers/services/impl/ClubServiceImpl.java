package be.technifutur.gestionchampionnatfootrest.metiers.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.technifutur.gestionchampionnatfootrest.data.repo.ClubRepository;
import be.technifutur.gestionchampionnatfootrest.metiers.services.ClubService;
import be.technifutur.gestionchampionnatfootrest.metiers.services.GenericService;
import be.technifutur.gestionchampionnatfootrest.models.dtos.ClubDTO;
import be.technifutur.gestionchampionnatfootrest.models.forms.ClubForm;

@Service
public class ClubServiceImpl implements GenericService<ClubDTO, ClubForm>, ClubService {

    @Autowired
    private ClubRepository repository;

    @Override
    public ClubDTO getOne(Long id) {
        return repository.findById(id)
                .map(ClubDTO::of)
                .orElseThrow();
    }

    @Override
    public List<ClubDTO> getAll() {
        return repository.findAll().stream()
                .map(ClubDTO::of)
                .toList();
    }

    @Override
    public ClubDTO insert(ClubForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ClubDTO update(Long id, ClubForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ClubDTO delete(Long id) {
        ClubDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
    
}
