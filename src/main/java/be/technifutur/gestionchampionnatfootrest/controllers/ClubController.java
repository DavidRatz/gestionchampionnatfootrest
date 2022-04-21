package be.technifutur.gestionchampionnatfootrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import be.technifutur.gestionchampionnatfootrest.metiers.services.ClubService;
import be.technifutur.gestionchampionnatfootrest.metiers.services.GenericService;
import be.technifutur.gestionchampionnatfootrest.metiers.services.impl.ClubServiceImpl;
import be.technifutur.gestionchampionnatfootrest.models.dtos.ClubDTO;

@RestController
@RequestMapping("/club")
public class ClubController {
    
    @Autowired
    private ClubServiceImpl service;

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<ClubDTO> getOne(@PathVariable Long id){
        return  ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping
    @PreAuthorize("permitAll()")
    public List<ClubDTO> getAll(){
        return service.getAll();
    }
}
