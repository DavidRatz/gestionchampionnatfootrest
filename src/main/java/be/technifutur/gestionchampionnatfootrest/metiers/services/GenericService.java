package be.technifutur.gestionchampionnatfootrest.metiers.services;

import java.util.List;

public interface GenericService<T> {
    T getOne(Long id);

    List<T> getAll();
}
