import java.util.*;

public class Graphe {

    //TODO Rename
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

    public void setSommets(List<Sommet> sommets) {
        this.sommets = sommets;
    }

    public static List<SommetDijkstra> calculateShortestPath(Graphe matrice, Sommet sommet) {
        ArrayList<SommetDijkstra> sommetDijkstras = new ArrayList<>();
        SommetDijkstra currentNode = new SommetDijkstra(new Sommet(""));
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < matrice.getSommets().size(); i++) {
            SommetDijkstra d = new SommetDijkstra(matrice.getSommet(i));
            if (Objects.equals(sommet.getNom(), d.sommet.getNom())) {
                d.setDistanceFromSource(0);
                currentNode = d;
            }
            map.put(d.sommet.getNom(), i);
            sommetDijkstras.add(d);
        }
        //TODO make a function
        while (currentNode != null) {
            currentNode.visited = true;

            for (int i = 0; i < currentNode.sommet.sommetsAdjacents.size(); i++) {

                SommetDijkstra branchNode = sommetDijkstras.get(map.get(currentNode.sommet.getNom()));
                Branche B =  currentNode.sommet.sommetsAdjacents.get(i);

                if (branchNode.getDistanceFromSource() > currentNode.distanceFromSource + B.getWeight()) {
                    branchNode.distanceFromSource = currentNode.distanceFromSource + B.getWeight();
                    branchNode.bestParentFromSource = currentNode.getNode();
                    sommetDijkstras.set(i, branchNode);
                }
            }


            //Todo make a function remove hardcoded parts
            SommetDijkstra init = new SommetDijkstra(new Sommet(""));
            init.setBestParentFromSource(null);
            for(SommetDijkstra sommetDijkstra : sommetDijkstras) {
                if(init.getDistanceFromSource() > sommetDijkstra.getDistanceFromSource() && !sommetDijkstra.visited) {
                    init = sommetDijkstra;
                }
            }
            if(init.getDistanceFromSource() != init.myInf) {
                currentNode = init;
            } else {
                currentNode = null;
            }

        }
        return sommetDijkstras;
    }

    public static SommetDijkstra returnLowerDistance(ArrayList<SommetDijkstra> list, Sommet dijkstraNode)
    {
        double lowerPath = 0;
        lowerPath = list.get(0).getDistanceFromSource();

        for (int i =1; i < list.size(); i++)
        {
            if (list.get(i).getVisited() == (false && list.get(i).getDistanceFromSource() < lowerPath))
            {
                lowerPath = list.get(i).getDistanceFromSource();
            }
        }
        SommetDijkstra currentNode = new SommetDijkstra(dijkstraNode);
        currentNode.setDistanceFromSource(lowerPath);

        return currentNode;
    }

}