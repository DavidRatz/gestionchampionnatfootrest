package be.technifutur.gestionchampionnatfootrest.metiers.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.technifutur.gestionchampionnatfootrest.data.repo.*;
import be.technifutur.gestionchampionnatfootrest.metiers.services.GenericService;
import be.technifutur.gestionchampionnatfootrest.models.dtos.ChampionnatDTO;
import be.technifutur.gestionchampionnatfootrest.models.entities.*;
import be.technifutur.gestionchampionnatfootrest.models.forms.ChampionnatForm;

@Service
public class ChampionnatServiceImpl implements GenericService<ChampionnatDTO,ChampionnatForm> {

    @Autowired
    private ChampionnatRepository repository;
    @Autowired
    private JourneeRepository journeeRepo;
    @Autowired
    private ClubRepository clubRepo;

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
        Championnat championnat = Championnat.builder()
                .nom(form.getNom())
                .saison(form.getSaison())
                .nbEquipes(form.getNbEquipes())
                .pays(form.getPays())
                .build();
        return ChampionnatDTO.of(repository.save(championnat));
    }

    @Override
    public ChampionnatDTO update(Long id, ChampionnatForm form) {
        Championnat championnat2Update = repository.findById(id)
                        .orElseThrow();
        championnat2Update.setNom(form.getNom());
        championnat2Update.setSaison(form.getSaison());
        championnat2Update.setNbEquipes(form.getNbEquipes());
        championnat2Update.setPays(form.getPays());
        return ChampionnatDTO.of(repository.save(championnat2Update));
    }

    @Override
    public ChampionnatDTO delete(Long id) {
        Championnat championnat = repository.findById(id).orElseThrow();
        for(Journee journee : championnat.getJournees()){
            journee.setChampionnat(null);
            journeeRepo.save(journee);
        }
        for(Club club : championnat.getClubs()){
            club.setChampionnat(null);
            clubRepo.save(club);
        }
        ChampionnatDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
    
}
