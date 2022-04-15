package be.technifutur.gestionchampionnatfootrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import be.technifutur.gestionchampionnatfootrest.data.repo.RencontreRepository;
import be.technifutur.gestionchampionnatfootrest.models.dtos.ClassementDTO;
import be.technifutur.gestionchampionnatfootrest.models.entities.Classement;

@RestController
@RequestMapping("/classement")
public class ClassementController {
    @Autowired
    private RencontreRepository repository;
    
    @GetMapping("/{id}")
    public List<ClassementDTO> getScore(@PathVariable Long id){
        List<ClassementDTO> classement = repository.getScoreByClub(id);
        System.out.println(classement);
        return classement;
        // return ClassementDTO.builder()
        //     .score(score)
        //     .clubId(id)
        //     .build();
    }
}
