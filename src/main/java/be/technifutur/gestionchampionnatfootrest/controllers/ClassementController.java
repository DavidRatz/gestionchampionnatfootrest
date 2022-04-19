package be.technifutur.gestionchampionnatfootrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import be.technifutur.gestionchampionnatfootrest.data.repo.RencontreRepository;
import be.technifutur.gestionchampionnatfootrest.models.dtos.ClassementDTO;
import be.technifutur.gestionchampionnatfootrest.models.entities.Classement;

@RestController
@RequestMapping("/classement")
public class ClassementController {
    @Autowired
    private RencontreRepository repository;
    
    @GetMapping("/{idChampionnat}")
    @PreAuthorize("permitAll()")
    public List<ClassementDTO> getScore(@PathVariable Long idChampionnat){
        List<ClassementDTO> classement = repository.getClassementByChampionnat(idChampionnat);
        System.out.println(classement);
        return classement;
        // return ClassementDTO.builder()
        //     .score(score)
        //     .clubId(id)
        //     .build();
    }
}
