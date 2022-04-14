package be.technifutur.gestionchampionnatfootrest.metiers.services;

import be.technifutur.gestionchampionnatfootrest.models.dtos.JourneeDTO;

public interface JourneeService {
    JourneeDTO getOneByNumeroAndChampionnat(int numero, Long championnatId);
    JourneeDTO getOneByNumero(int numero);
}
