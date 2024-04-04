import java.util.LinkedList;

public class Graph {
    private LinkedList<Vertices> vertices = new LinkedList<>();
    private LinkedList<Edge> edges = new LinkedList<>();
    private LinkedList<Vertices> shortestPath = new LinkedList<>();

    public void addNode(Vertices vertices){
        this.vertices.add(vertices);
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }
    public void findShortestPath(Vertices start, Vertices end){
        setShortestPath(start, end, 0);
        craftShortestPath(end, start);
        revealShortestPath(start, end);
        rollback();
    }

    private void setShortestPath(Vertices start, Vertices end, int cost){
        if(start == end){
            return;
        }

        for(Edge edge: edges){
            if(edge.src == start){
                if (cost + edge.weight < edge.dest.cost){
                    edge.dest.cost = cost + edge.weight;
                    edge.dest.prev = start;
                    setShortestPath(edge.dest, end, cost + edge.weight);
                }
            }
        }
    }

    private void craftShortestPath(Vertices end, Vertices start){
        if(end == start){
            return;
        }
        shortestPath.add(end);
        craftShortestPath(end.prev, start);
    }

    private void revealShortestPath(Vertices start, Vertices end){
        String res = start.name;
        for(int i = shortestPath.size() - 1; i > -1; i--){
            res += "->" + shortestPath.get(i).name;
        }

        System.out.println(res);
        System.out.println("distance: " + end.cost + "km");
    }

    private void rollback(){
        for(Vertices n: vertices){
            n.cost = Integer.MAX_VALUE;
            n.prev = null;
        }
        shortestPath.clear();
    }
}
