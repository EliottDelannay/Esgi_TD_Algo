public class SommetDijkstra {
    //TODO Rename
    Sommet sommet;
    Boolean visited;
    double distanceFromSource;
    Sommet bestParentFromSource;
    Integer myInf = Integer.MAX_VALUE;

    public SommetDijkstra(Sommet s) {
        this.sommet = s;
        this.visited = false;
        this.distanceFromSource = myInf;
        this.bestParentFromSource = null;
    }

    public Sommet getNode() {
        return sommet;
    }

    public void setNode(Sommet sommet) {
        this.sommet = sommet;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public double getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(double distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public Sommet getBestParentFromSource() {
        return bestParentFromSource;
    }

    public void setBestParentFromSource(Sommet bestParentFromSource) {
        this.bestParentFromSource = bestParentFromSource;
    }

}
