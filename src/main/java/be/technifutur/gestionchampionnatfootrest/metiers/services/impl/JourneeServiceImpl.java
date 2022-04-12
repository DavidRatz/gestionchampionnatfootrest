package be.technifutur.gestionchampionnatfootrest.metiers.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.technifutur.gestionchampionnatfootrest.data.repo.JourneeRepository;
import be.technifutur.gestionchampionnatfootrest.metiers.services.GenericService;
import be.technifutur.gestionchampionnatfootrest.models.dtos.JourneeDTO;

@Service
public class JourneeServiceImpl implements GenericService<JourneeDTO> {

    @Autowired
    private JourneeRepository repository;

    @Override
    public JourneeDTO getOne(Long id) {
        return repository.findById(id)
                .map(JourneeDTO::of)
                .orElseThrow();
    }

    @Override
    public List<JourneeDTO> getAll() {
        return repository.findAll().stream()
                .map(JourneeDTO::of)
                .toList();
    }
    
}
