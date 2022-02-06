import java.util.ArrayList;
import java.util.List;

public class Sommet{
    private String nom;
    List<Sommet> sommetsAdjacents;

    public Sommet(String nom) {
        this.nom = nom;
        this.sommetsAdjacents = new ArrayList<>();
    }

    public Sommet(String nom, List<Sommet> sommetsAdjacents) {
        this.nom = nom;
        this.sommetsAdjacents = sommetsAdjacents;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Sommet> getSommetsAdjacents() {
        return sommetsAdjacents;
    }

    public void setSommetsAdjacents(List<Sommet> sommetsAdjacents) {
        this.sommetsAdjacents = sommetsAdjacents;
    }

    public void setSommetAdjacent(Sommet sommetAdjacent) {
        this.sommetsAdjacents.add(sommetAdjacent);
    }
}

