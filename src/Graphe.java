import java.util.*;

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
                    liste.get(i).setSommetAdjacent(new Branche(liste.get(j)));
                }
            }
        }
        this.sommets = liste;
    }

    public static boolean parcoursProfondeurModifie(Sommet depart, Sommet dest, List<Sommet> cheminInverse, List<Sommet> sommetsVisites) {
        if (Objects.equals(depart.getNom(), dest.getNom())) {
            cheminInverse.add(depart);
            return true;
        } else if (!sommetsVisites.contains(depart)) {
            sommetsVisites.add(depart);
            for (int i = 0; i < depart.getSommetsAdjacents().size(); i++) {
                if (parcoursProfondeurModifie(depart.getSommetsAdjacents().get(i).getDestination(), dest, cheminInverse, sommetsVisites)) {
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

    public static ArrayList<SommetDijkstra> plusCoursChemin(Graphe matrice, Sommet sommet) {
        ArrayList<SommetDijkstra> sommetDijkstras = new ArrayList<>();
        SommetDijkstra currentNode = new SommetDijkstra(new Sommet(""));
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < matrice.getSommets().size(); i++) {
            SommetDijkstra d = new SommetDijkstra(matrice.getSommet(i));
            if (Objects.equals(sommet.getNom(), d.sommet.getNom())) {
                d.setDistanceTrajet(0);
                currentNode = d;
            }
            map.put(d.sommet.getNom(), i);
            sommetDijkstras.add(d);
        }

        while (currentNode != null) {
            currentNode.visiter = true;

            for (int i = 0; i < currentNode.sommet.sommetsAdjacents.size(); i++) {
                SommetDijkstra branchNode = sommetDijkstras.get(map.get(currentNode.sommet.sommetsAdjacents.get(i).getDestination().getNom()));
                Branche B = currentNode.sommet.sommetsAdjacents.get(i);

                if (branchNode.getDistanceTrajet() > currentNode.distanceTrajet + B.getPoids()) {
                    branchNode.distanceTrajet = currentNode.distanceTrajet + B.getPoids();
                    branchNode.optimalTrajet = currentNode.getSommet();
                    for (int g = 0; g < sommetDijkstras.size(); g++) {
                        if (Objects.equals(branchNode.getSommet().getNom(), sommetDijkstras.get(g).getSommet().getNom())) {
                            sommetDijkstras.set(g, branchNode);
                        }
                    }
                }
            }

            SommetDijkstra init = new SommetDijkstra(new Sommet(""));
            init.setOptimalTrajet(null);
            for (SommetDijkstra sommetDijkstra : sommetDijkstras) {
                if (init.getDistanceTrajet() > sommetDijkstra.getDistanceTrajet() && !sommetDijkstra.visiter) {
                    init = sommetDijkstra;
                }
            }
            if (init.getDistanceTrajet() != init.infinie) {
                currentNode = init;
            } else {
                currentNode = null;
            }

        }
        return sommetDijkstras;
    }

    public static ArrayList<Sommet> distanceLaPlusCourte(ArrayList<SommetDijkstra> list, Sommet cible) {
        ArrayList<Sommet> plusCoursChemin = new ArrayList<>();

        SommetDijkstra currentNode = null;
        for (SommetDijkstra sommetDijkstra : list) {
            if (Objects.equals(sommetDijkstra.getSommet().getNom(), cible.getNom())) {
                currentNode = sommetDijkstra;
                plusCoursChemin.add(currentNode.getSommet());
            }
        }

        while (currentNode.getOptimalTrajet() != null) {
            for (SommetDijkstra sommetDijkstra : list) {
                if (currentNode.getOptimalTrajet() != null && Objects.equals(sommetDijkstra.getSommet().getNom(), currentNode.getOptimalTrajet().getNom())) {
                    currentNode = sommetDijkstra;
                    plusCoursChemin.add(currentNode.getSommet());
                }
            }
        }
        return plusCoursChemin;
    }

}