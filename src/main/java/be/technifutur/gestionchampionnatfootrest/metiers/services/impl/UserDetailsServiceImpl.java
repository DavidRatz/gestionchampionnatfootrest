package be.technifutur.gestionchampionnatfootrest.metiers.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import be.technifutur.gestionchampionnatfootrest.data.repo.UtilisateurRepository;
import be.technifutur.gestionchampionnatfootrest.models.dtos.UtilisateurDTO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtilisateurRepository uRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return uRepo.findByUsername(username).orElseThrow();
    }

    public UtilisateurDTO getUserByUsernameAndPassword(String username, String password) {
        return uRepo.findByUsernameAndPassword(username, password)
                    .map(UtilisateurDTO::of)
                    .orElseThrow();
    }

    public UtilisateurDTO getRolesByUsername(String username) {
        return null;
    }
    
}
