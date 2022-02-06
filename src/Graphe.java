import java.util.ArrayList;
import java.util.List;

public class Graphe {
    private List<Sommet> sommets;

    public Graphe() {
        this.sommets = new ArrayList<>();
    }

    public void setGraphe(String[] noms, Integer[][] matrice) {
        List<Sommet> liste = new ArrayList<>();
        for (int i = 0; i < matrice.length; i++) {
            liste.add(new Sommet(noms[i]));
        }

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] == 1) {
                    liste.get(i).setSommetAdjacent(liste.get(j));
                }
            }
        }
        this.sommets = liste;
    }

    public static boolean parcoursProfondeurModifie(Sommet depart, Sommet dest, List<Sommet> cheminInverse, List<Sommet> sommetsVisites) {
        if (depart.getNom() == dest.getNom()) {
            cheminInverse.add(depart);
            return true;
        } else if (!sommetsVisites.contains(depart)) {
            sommetsVisites.add(depart);
            for (int i = 0; i < depart.getSommetsAdjacents().size(); i++) {
                if (parcoursProfondeurModifie(depart.getSommetsAdjacents().get(i), dest, cheminInverse, sommetsVisites) == true) {
                    cheminInverse.add(depart);
                    return true;
                }
            }
        }
        return false;
    }


    public List<Sommet> getSommets() {
        return sommets;
    }

    public Sommet getSommet(int i) {
        return sommets.get(i);
    }

    public void setSommets(List<Sommet> sommets) {
        this.sommets = sommets;
    }

}