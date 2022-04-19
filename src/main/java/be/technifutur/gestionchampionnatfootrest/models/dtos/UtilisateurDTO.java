package be.technifutur.gestionchampionnatfootrest.models.dtos;
import java.io.Serializable;
import java.util.List;

import be.technifutur.gestionchampionnatfootrest.models.entities.Utilisateur;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UtilisateurDTO implements Serializable {
    private final String username;
    private final String password;
    private final List<String> roles;

    public static UtilisateurDTO of(Utilisateur user){
        if( user == null )
            return null;
        return new UtilisateurDTO(
            user.getUsername(),
            user.getPassword(),
            user.getRoles()
        );
    }
    
}
