import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Graphe graphe = new Graphe();
        //matrice d'adjacence (matrice carré) entre plusieurs sommets
        Integer[][] matrice = {
                {0,1,0},
                {1,0,1},
                {0,1,0}
        };
        String[] noms = {"Lyon", "Bayonne", "Paris"};

        graphe.setGraphe(noms, matrice);

        // Affiche le nombre de sommets adjacents au sommet X
        System.out.println(graphe.getSommet(0).getSommetsAdjacents().size());
        System.out.println(graphe.getSommet(1).getSommetsAdjacents().size());
        System.out.println(graphe.getSommet(2).getSommetsAdjacents().size());

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

        // Affiche "Ecrire un nombre: "
        System.out.println("Ecrire un nombre: ");

        //Lit l'entier écrit par l'utilisateur et l'affecte
        // à  la variable nombre du programme
        int nombre = scanner.nextInt();
        // Affiche le nombre saisit par l'utilisateur
        System.out.println(nombre);


        List<SommetDijkstra> list = Graphe.calculateShortestPath(graphe,graphe.getSommet(0) );
        for (SommetDijkstra d: list) {
            System.out.println(d.sommet.getNom());
        }

    }

}
