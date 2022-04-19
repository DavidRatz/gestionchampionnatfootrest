package be.technifutur.gestionchampionnatfootrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

//import be.technifutur.gestionchampionnatfootrest.metiers.services.JourneeService;
import be.technifutur.gestionchampionnatfootrest.metiers.services.GenericService;
import be.technifutur.gestionchampionnatfootrest.metiers.services.impl.JourneeServiceImpl;
import be.technifutur.gestionchampionnatfootrest.models.dtos.JourneeDTO;

@RestController
@RequestMapping("/journee")
public class JourneeController {
    
    @Autowired
    private JourneeServiceImpl service;

    @GetMapping
    public List<JourneeDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{numero}")
    @PreAuthorize("permitAll()")
    public JourneeDTO getOneByNumero(@PathVariable int numero){
        return service.getOneByNumero(numero);
    }

    @GetMapping("/{numero}/championnat/{championnatId}")
    @PreAuthorize("permitAll()")
    public JourneeDTO getOneByNumero(@PathVariable int numero, @PathVariable Long championnatId){
        return service.getOneByNumeroAndChampionnat(numero, championnatId);
    }
}
