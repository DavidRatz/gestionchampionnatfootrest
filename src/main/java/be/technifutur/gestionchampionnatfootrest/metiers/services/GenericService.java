package be.technifutur.gestionchampionnatfootrest.metiers.services;

import java.util.List;

public interface GenericService<T,U> {
    T getOne(Long id);

    List<T> getAll();

    T insert(U form);
    T update(Long id, U form);

    T delete(Long id);
}
