package be.technifutur.gestionchampionnatfootrest.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.technifutur.gestionchampionnatfootrest.data.repo.UtilisateurRepository;
import be.technifutur.gestionchampionnatfootrest.metiers.services.impl.UserDetailsServiceImpl;
import be.technifutur.gestionchampionnatfootrest.models.dtos.UtilisateurDTO;
import be.technifutur.gestionchampionnatfootrest.models.entities.Utilisateur;
import be.technifutur.gestionchampionnatfootrest.models.forms.UtilisateurForm;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    
    @Autowired
    private UserDetailsServiceImpl service;
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/role")
    @PreAuthorize("isAuthenticated()")
    public UtilisateurDTO getRolesByUsername(Authentication auth){
        System.out.println(auth);
        Utilisateur user = (Utilisateur)auth.getPrincipal();
        return UtilisateurDTO.of(user);
    }
}
