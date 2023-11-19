import java.util.LinkedList;
import java.util.List;

public class DirectedGraph {
    private List<Vertex> vertices;
    private List<Edge> edges;

    DirectedGraph(){
        this.vertices = new LinkedList<Vertex>();
        this.edges = new LinkedList<Edge>();
    }

    class Vertex{
        String name;
        Vertex(String name){
            this.name = name;
        }
    }

    class Edge{
        Vertex src, dest;
        int weight;
        Edge(Vertex src, Vertex dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public Vertex addVertex(String name){
        Vertex vertex = new Vertex(name);

        if(this.vertices.contains(vertex)){
            System.out.println("Duplicate Vertex Detected");
            return null;
        }

        this.vertices.add(vertex);
        return vertex;
    }

    public void addEdge(String srcN, String destN, int weight){
        Vertex src = null;
        Vertex dest = null;
        for(Vertex v: this.vertices){
            if(src != null && dest != null) break;
            if(v.name == srcN) src = v;
            else if(v.name == destN) dest = v;
        }

        if(src == null && dest == null){
            System.out.println("Vertex doesn't exist");
            return;
        }

        this.edges.add(new Edge(src, dest, weight));
    }

    public void print(String message){
        System.out.println(message);
        for (Edge edge: edges){
            Vertex src = edge.src;
            Vertex dest = edge.dest;
            System.out.printf("%s  %d  %s\n",
                    " ".repeat(src.name.length()),
                    edge.weight,
                    " ".repeat(dest.name.length()));
            System.out.printf("%s ---> %s\n", src.name, dest.name);
        }
    }

}