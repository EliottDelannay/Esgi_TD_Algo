import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Graphe graphe = new Graphe();
        Integer[][] matrice = {
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0}
        };
        String[] noms = {"Lyon", "Bayonne", "Paris", "Marseille", "Toulouse", "Nice", "Nantes", "Lille", "Toulon",
                "Grenoble", "Dijon", "Villeurbanne", "Amiens", "Limoges", "Annecy", "Caen"};

        graphe.setGraphe(noms, matrice);

        //Todo ? représentation des villes et des liaison dans la doc ?
        System.out.println("Liste des villes : " + Arrays.toString(noms));

        Scanner scanner = new Scanner(System.in);
        //TODO Saisir le nom d'une ville et pas un nombre
        System.out.println("Saisir le nombre de la 1ère ville : ");
        int nombreV1 = scanner.nextInt();
        System.out.println("Saisir le nombre de la 2ème Ville: ");
        int nombreV2 = scanner.nextInt();

        List<Sommet> cheminInverse = new ArrayList<>();

        long start1 = System.currentTimeMillis();
        System.out.println("Un chemin existe? " + Graphe.parcoursProfondeurModifie(graphe.getSommet(nombreV1),
                graphe.getSommet(nombreV2), cheminInverse, new ArrayList<>()));
        long end1 = System.currentTimeMillis();
        System.out.println("Chemin inverse:");

        StringBuilder sChemin = new StringBuilder();
        for (Sommet s : cheminInverse) {
            sChemin.append(s.getNom()).append(" <- ");
        }
        sChemin = new StringBuilder(sChemin.substring(0, sChemin.length() - 3));

        System.out.println(sChemin);
        System.out.println("Temps passé pour le parcours en profondeur : "+ (end1-start1));

        long start2 = System.currentTimeMillis();
        List<SommetDijkstra> list = Graphe.plusCoursChemin(graphe, graphe.getSommet(0));
        long end2 = System.currentTimeMillis();

        System.out.println("Temps passé pour Dijkstra : "+ (end2-start2));
       /* for (SommetDijkstra d: list) {
            System.out.println(d.sommet.getNom());
        }*/

        //TODO Afficher le trajet + le temps de calcul des 2 algo

    }

}
