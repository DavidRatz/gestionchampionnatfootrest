package be.technifutur.gestionchampionnatfootrest.metiers.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.technifutur.gestionchampionnatfootrest.data.repo.RencontreRepository;
import be.technifutur.gestionchampionnatfootrest.metiers.services.GenericService;
import be.technifutur.gestionchampionnatfootrest.metiers.services.RencontreService;
import be.technifutur.gestionchampionnatfootrest.models.dtos.RencontreDTO;
import be.technifutur.gestionchampionnatfootrest.models.entities.Rencontre;
import be.technifutur.gestionchampionnatfootrest.models.forms.RencontreForm;

@Service
public class RencontreServiceImpl implements GenericService<RencontreDTO, RencontreForm>, RencontreService {

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

    @Override
    public RencontreDTO insert(RencontreForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RencontreDTO update(Long id, RencontreForm form) {
        Rencontre entity = repository.findById(id)
                .orElseThrow();
        entity.setScoreDomicile(form.getScoreDomicile());
        entity.setScoreVisiteur(form.getScoreVisiteur());

        return RencontreDTO.of(repository.save(entity));
    }

    @Override
    public RencontreDTO delete(Long id) {
        RencontreDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
    
}
