package be.technifutur.gestionchampionnatfootrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import be.technifutur.gestionchampionnatfootrest.metiers.services.ClubService;
import be.technifutur.gestionchampionnatfootrest.models.dtos.ClubDTO;

@RestController
@RequestMapping("/club")
public class ClubController {
    
    @Autowired
    private ClubService service;

    @GetMapping("/{id}")
    public ClubDTO getOne(@PathVariable Long id){
        return service.getOne(id);
    }

    @GetMapping
    public List<ClubDTO> getAll(){
        return service.getAll();
    }
}
