import java.util.ArrayList;
import java.util.List;

public class Sommet{
    private String nom;
    List<Branche> sommetsAdjacents;

    public Sommet(String nom) {
        this.nom = nom;
        this.sommetsAdjacents = new ArrayList<>();
    }

    public Sommet(String nom, List<Branche> sommetsAdjacents) {
        this.nom = nom;
        this.sommetsAdjacents = sommetsAdjacents;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Branche> getSommetsAdjacents() {
        return sommetsAdjacents;
    }

    public void setSommetsAdjacents(List<Branche> sommetsAdjacents) {
        this.sommetsAdjacents = sommetsAdjacents;
    }

    public void setSommetAdjacent(Branche sommetAdjacent) {
        this.sommetsAdjacents.add(sommetAdjacent);
    }
}