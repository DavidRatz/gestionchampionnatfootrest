package be.technifutur.gestionchampionnatfootrest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

//import be.technifutur.gestionchampionnatfootrest.metiers.services.RencontreService;
import be.technifutur.gestionchampionnatfootrest.metiers.services.GenericService;
import be.technifutur.gestionchampionnatfootrest.metiers.services.impl.RencontreServiceImpl;
import be.technifutur.gestionchampionnatfootrest.models.dtos.RencontreDTO;
import be.technifutur.gestionchampionnatfootrest.models.forms.RencontreForm;

@RestController
@RequestMapping("/rencontre")
public class RencontreController {
    
    @Autowired
    private RencontreServiceImpl service;

    @GetMapping("/{id}")
    public RencontreDTO getOne(@PathVariable Long id){
        return service.getOne(id);
    }

    @GetMapping
    public List<RencontreDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/club/{id}")
    @PreAuthorize("permitAll()")
    public List<RencontreDTO> getRencontresOfClub(@PathVariable Long id){
        return service.getRencontresByClub(id);
    }

    @PatchMapping("/update/{id}")
    @PreAuthorize("isAuthenticated()")
    public RencontreDTO update(@PathVariable Long id, @Valid @RequestBody RencontreForm form){
        return service.update(id,form);
    }
}
