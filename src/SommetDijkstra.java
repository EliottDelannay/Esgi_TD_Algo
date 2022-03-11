public class SommetDijkstra {
    Sommet sommet;
    Boolean visiter;
    double distanceTrajet;
    Sommet optimalTrajet;
    Integer infinie = Integer.MAX_VALUE;

    public SommetDijkstra(Sommet s) {
        this.sommet = s;
        this.visiter = false;
        this.distanceTrajet = infinie;
        this.optimalTrajet = null;
    }

    public Sommet getSommet() {
        return sommet;
    }

    public double getDistanceTrajet() {
        return distanceTrajet;
    }

    public void setDistanceTrajet(double distanceTrajet) {
        this.distanceTrajet = distanceTrajet;
    }

    public Sommet getOptimalTrajet() {
        return optimalTrajet;
    }

    public void setOptimalTrajet(Sommet optimalTrajet) {
        this.optimalTrajet = optimalTrajet;
    }

}
