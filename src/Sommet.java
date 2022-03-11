import java.util.ArrayList;
import java.util.List;

public class Sommet {
    private final String nom;
    List<Branche> sommetsAdjacents;

    public Sommet(String nom) {
        this.nom = nom;
        this.sommetsAdjacents = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Branche> getSommetsAdjacents() {
        return sommetsAdjacents;
    }

    public void setSommetAdjacent(Branche sommetAdjacent) {
        this.sommetsAdjacents.add(sommetAdjacent);
    }
}