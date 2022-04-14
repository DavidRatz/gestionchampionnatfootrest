package be.technifutur.gestionchampionnatfootrest.metiers.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.technifutur.gestionchampionnatfootrest.data.repo.JourneeRepository;
import be.technifutur.gestionchampionnatfootrest.metiers.services.GenericService;
import be.technifutur.gestionchampionnatfootrest.metiers.services.JourneeService;
import be.technifutur.gestionchampionnatfootrest.models.dtos.JourneeDTO;
import be.technifutur.gestionchampionnatfootrest.models.forms.JourneeForm;

@Service
public class JourneeServiceImpl implements GenericService<JourneeDTO,JourneeForm>, JourneeService {

    @Autowired
    private JourneeRepository repository;

    @Override
    public JourneeDTO getOneByNumeroAndChampionnat(int numero, int championnatId) {
        return repository.findByNumeroAndChampionnat(numero,championnatId)
                .map(JourneeDTO::of)
                .orElseThrow();
    }

    @Override
    public List<JourneeDTO> getAll() {
        return repository.findAll().stream()
                .map(JourneeDTO::of)
                .toList();
    }

    @Override
    public JourneeDTO getOne(Long id) {
        return repository.findById(id)
        .map(JourneeDTO::of)
        .orElseThrow();
    }

    @Override
    public JourneeDTO getOneByNumero(int numero) {
        return repository.findByNumero(numero)
        .map(JourneeDTO::of)
        .orElseThrow();
    }

    @Override
    public JourneeDTO insert(JourneeForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JourneeDTO update(Long id, JourneeForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JourneeDTO delete(Long id) {
        JourneeDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
    
}
