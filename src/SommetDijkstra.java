public class SommetDijkstra {
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

    /* Dijkstra first try
    public void calculateShortestPath(Dijkstra Dnode)
    {
        while (Dnode.node != null)
        {
            Dnode.visited = true;
            for ( Branch child : Dnode.node.children ) {
                if (child.destination.distanceFromSource > Dnode.distanceFromSource + Branch.weight)
                {
                    Branch.node.distanceFromSource = Dnode.distanceFromSource + Branch.weight;
                    Branch.node.bestParentFromSource = Dnode;
                }
            }
            Dnode.setDistanceFromSource(Branch.node.distanceFromSource);
            // Branch.node.distanceFromSource with lower value & Branch.node.visited = false
        }
    }*/



    /* Test main Dijkstra
    public static void test()
    {
        Branch CTest = new Branch(2, null);
        Node NTest = new Node(1, null);
        Dijkstra Test = new  Dijkstra(NTest);
        Test.setDistanceFromSource(0);

    }*/

}
