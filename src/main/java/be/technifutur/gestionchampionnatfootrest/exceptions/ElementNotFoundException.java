package be.technifutur.gestionchampionnatfootrest.exceptions;

public class ElementNotFoundException extends RuntimeException {

    private final Object id;
    private final Class<?> clazz;

    public ElementNotFoundException(Object id, Class<?> clazz) {
        super("l'élément d'id {" + id + "} n'a pas pu être trouvé");
        this.id = id;
        this.clazz = clazz;
    }

    public Object getId() {
        return id;
    }

    public Class<?> getClazz() {
        return clazz;
    }
}
