package be.technifutur.gestionchampionnatfootrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import be.technifutur.gestionchampionnatfootrest.data.repo.RencontreRepository;
import be.technifutur.gestionchampionnatfootrest.models.dtos.ClassementDTO;

@RestController
@RequestMapping("/classement")
public class ClassementController {
    @Autowired
    private RencontreRepository repository;
    
    @GetMapping("/{id}")
    public ClassementDTO getScore(@PathVariable Long id){
        int score = repository.getScoreByClub(id);
        return ClassementDTO.builder()
            .score(score)
            .clubId(id)
            .build();
    }
}
