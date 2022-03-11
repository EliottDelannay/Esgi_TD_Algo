public class Branche {
    double poids;
    Sommet destination;

    public Branche(Sommet destination) {
        this.poids = 1;
        this.destination = destination;
    }

    public double getPoids() {
        return poids;
    }

    public Sommet getDestination() {
        return destination;
    }
}
