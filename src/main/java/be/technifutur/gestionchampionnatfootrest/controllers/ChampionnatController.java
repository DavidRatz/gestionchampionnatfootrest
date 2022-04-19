package be.technifutur.gestionchampionnatfootrest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import be.technifutur.gestionchampionnatfootrest.metiers.services.impl.ChampionnatServiceImpl;
import be.technifutur.gestionchampionnatfootrest.models.dtos.ChampionnatDTO;
import be.technifutur.gestionchampionnatfootrest.models.forms.ChampionnatForm;

@RestController
@RequestMapping("/championnat")
public class ChampionnatController {
    
    @Autowired
    private ChampionnatServiceImpl service;

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ChampionnatDTO getOne(@PathVariable Long id){
        return service.getOne(id);
    }

    @GetMapping
    @PreAuthorize("permitAll()")
    public List<ChampionnatDTO> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    @PreAuthorize("isAuthenticated()")
    public ChampionnatDTO insertChampionnat(@Valid @RequestBody ChampionnatForm form,Authentication auth){
        System.out.println(auth);
        return service.insert(form);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ChampionnatDTO updateChampionnat(@PathVariable Long id,@Valid @RequestBody ChampionnatForm form){
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ChampionnatDTO deleteChampionnat(@PathVariable Long id){
        return service.delete(id);
    }
}
