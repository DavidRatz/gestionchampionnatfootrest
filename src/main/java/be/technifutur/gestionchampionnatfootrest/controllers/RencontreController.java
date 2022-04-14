package be.technifutur.gestionchampionnatfootrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import be.technifutur.gestionchampionnatfootrest.metiers.services.RencontreService;
import be.technifutur.gestionchampionnatfootrest.metiers.services.GenericService;
import be.technifutur.gestionchampionnatfootrest.metiers.services.impl.RencontreServiceImpl;
import be.technifutur.gestionchampionnatfootrest.models.dtos.RencontreDTO;

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
}
