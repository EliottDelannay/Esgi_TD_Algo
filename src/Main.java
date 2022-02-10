import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Graphe graphe = new Graphe();

        Integer[][] matrice = {
                {0,1,0},
                {1,0,1},
                {0,1,0}
        };
        String[] noms = {"Lyon", "Bayonne", "Paris"};

        graphe.setGraphe(noms, matrice);

        List<Sommet> cheminInverse = new ArrayList<>();
        System.out.println("Un chemin existe? " + Graphe.parcoursProfondeurModifie(graphe.getSommet(0), graphe.getSommet(2), cheminInverse, new ArrayList<>()));

        System.out.println("Chemin inverse:");
        String sChemin = "";
        for(Sommet s: cheminInverse) {
            sChemin += s.getNom() + " <- ";
        }
        sChemin = sChemin.substring(0 , sChemin.length() - 3);
        System.out.println(sChemin);

        Scanner scanner = new Scanner(System.in);

        List<SommetDijkstra> list = Graphe.calculateShortestPath(graphe,graphe.getSommet(0) );

    }

}
