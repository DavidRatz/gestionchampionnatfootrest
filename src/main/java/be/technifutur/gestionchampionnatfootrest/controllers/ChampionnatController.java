package be.technifutur.gestionchampionnatfootrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import be.technifutur.gestionchampionnatfootrest.metiers.services.impl.ChampionnatServiceImpl;
import be.technifutur.gestionchampionnatfootrest.models.dtos.ChampionnatDTO;

@RestController
@RequestMapping("/championnat")
public class ChampionnatController {
    
    @Autowired
    private ChampionnatServiceImpl service;

    @GetMapping("/{id}")
    public ChampionnatDTO getOne(@PathVariable Long id){
        return service.getOne(id);
    }

    @GetMapping
    public List<ChampionnatDTO> getAll(){
        return service.getAll();
    }
}
