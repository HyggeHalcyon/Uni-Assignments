/*
    Not really the best way to implement it,
    but I was racing against time, so it'll work
    though the implementation was very specific
    for the use case
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.Vector;

public class Graph {
    private LinkedList<Vertice> vertices, shortestPath;
    private LinkedList<Edge> edges;
    private int totalCost = 0;

    Graph(){
        this.vertices = new LinkedList<>();
        this.edges = new LinkedList<>();
        this.shortestPath = new LinkedList<>();
    }

    public void DjikstraTransit(Vertice start, Vertice[] dest){
        // can't be bothered
        System.out.print(start.name);
        for(Vertice end: dest) {
            crawlFindShortestPath(start, end, 0);
            reverseCrawl(end, start);
            printShortestPathTransit(start, end);
            rollback();

            start = end;
        }

        // would be nice if all of the output is coded in one function,
        // but I cant be bothered
        System.out.println("\ndistance: " + totalCost + "km");
        this.totalCost = 0;
    }

    private void crawlFindShortestPath(Vertice start, Vertice end, int cost){
        if(start == end){
            return;
        }

        for(Edge edge: edges){
            if(edge.src == start){
                if (cost + edge.weight < edge.dest.cost){
                    edge.dest.cost = cost + edge.weight;
                    edge.dest.prev = start;
                    crawlFindShortestPath(edge.dest, end, cost + edge.weight);
                }
            }
        }
    }

    private void reverseCrawl(Vertice end, Vertice start){
        if(end == start){
            return;
        }
        shortestPath.add(end);
        reverseCrawl(end.prev, start);
    }

    // bad way of outputting the result, but I can't be bothered
    private void printShortestPathTransit(Vertice start, Vertice end){
        String res = "";
        for(int i = shortestPath.size() - 1; i > -1; i--){
            res += "->" + shortestPath.get(i).name;
        }

        System.out.print(res);
        this.totalCost += end.cost;
    }

    private void rollback(){
        for(Vertice n: vertices){
            n.cost = Integer.MAX_VALUE;
            n.prev = null;
        }
        shortestPath.clear();
    }

    public void addVertice(Vertice vertice){
        this.vertices.add(vertice);
    }
    public void addVertice(Vertice[] vertices){
        for(Vertice vertice: vertices){
            this.vertices.add(vertice);
        }
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }
    public void addEdge(Edge[] edges){
        for(Edge edge: edges){
            this.edges.add(edge);
        }
    }

    public LinkedList<Edge> cloneEdges() {
        return (LinkedList) this.edges.clone();
    }

}
