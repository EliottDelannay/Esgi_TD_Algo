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
        System.out.println("Liste des villes : " + Arrays.toString(noms));
        System.out.print(System.lineSeparator());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir le nombre de la 1ère ville : ");
        int nombreV1 = scanner.nextInt();
        System.out.println("Saisir le nombre de la 2ème Ville : ");
        int nombreV2 = scanner.nextInt();
        System.out.print(System.lineSeparator());

        List<Sommet> cheminInverse = new ArrayList<>();

        long start1 = System.currentTimeMillis();
        System.out.println("Un chemin existe? " + Graphe.parcoursProfondeurModifie(graphe.getSommet(nombreV1),
                graphe.getSommet(nombreV2), cheminInverse, new ArrayList<>()));
        long end1 = System.currentTimeMillis();
        System.out.println("Chemin inverse:");

        int Duree = 0;
        StringBuilder sChemin = new StringBuilder();
        for (Sommet s : cheminInverse) {
            sChemin.append(s.getNom()).append(" <- ");
            Duree += 1;
        }
        sChemin = new StringBuilder(sChemin.substring(0, sChemin.length() - 3));

        System.out.println(sChemin);
        System.out.println("Durée du parcours : " + Duree + " min");
        System.out.println("Temps passé pour le parcours en profondeur : " + (end1 - start1) + "s");
        System.out.print(System.lineSeparator());

        System.out.println("Dijkstra : ");
        long start2 = System.currentTimeMillis();
        ArrayList<SommetDijkstra> list = Graphe.plusCoursChemin(graphe, graphe.getSommet(nombreV1));
        ArrayList<Sommet> dijkstra = Graphe.distanceLaPlusCourte(list, graphe.getSommet(nombreV2));
        long end2 = System.currentTimeMillis();


        int DDuree = 0;
        StringBuilder sDChemin = new StringBuilder();
        for (Sommet d : dijkstra) {
            sDChemin.append(d.getNom()).append(" <- ");
            DDuree += 1;
        }
        sDChemin = new StringBuilder(sDChemin.substring(0, sDChemin.length() - 3));
        System.out.println(sDChemin);
        System.out.println("Durée du parcours : " + DDuree + " min");
        System.out.println("Temps passé pour Dijkstra : " + (end2 - start2) + "s");

    }

}
