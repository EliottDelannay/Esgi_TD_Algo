public class Branche {
    //TODO Rename
    double weight;
    Sommet destination;

    public Branche(Sommet destination) {
        this.weight = 1;
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Sommet getDestination() {
        return destination;
    }

    public void setDestination(Sommet destination) {
        this.destination = destination;
    }
}
