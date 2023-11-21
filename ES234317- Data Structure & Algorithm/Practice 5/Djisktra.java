/*
    Not really the best way to implement it,
    but I was racing against time, so it'll work
    though the implementation was very specific
    for the use case
 */

public class Djisktra {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Vertices surabaya = new Vertices("Surabaya");
        Vertices sidoarjo = new Vertices("Sidoarjo");
        Vertices malang = new Vertices("Malang");
        Vertices blitar = new Vertices("Blitar");
        Vertices tulungagung = new Vertices("Tulungagung");
        Vertices trenggalek = new Vertices("Trenggalek");
        Vertices ponorogo = new Vertices("Ponorogo");
        Vertices madiun = new Vertices("Madiun");
        Vertices kediri = new Vertices("Kediri");
        Vertices mojokerto = new Vertices("Mojokerto");
        Vertices nganjuk = new Vertices("Nganjuk");
        Vertices ngawi = new Vertices("Ngawi");
        Vertices bojonegoro = new Vertices("Bojonegoro");
        Vertices lamongan = new Vertices("Lamongan");
        Vertices gresik = new Vertices("Gresik");

        graph.addNode(surabaya);
        graph.addNode(sidoarjo);
        graph.addNode(malang);
        graph.addNode(blitar);
        graph.addNode(tulungagung);
        graph.addNode(trenggalek);
        graph.addNode(ponorogo);
        graph.addNode(madiun);
        graph.addNode(kediri);
        graph.addNode(mojokerto);
        graph.addNode(nganjuk);
        graph.addNode(nganjuk);
        graph.addNode(ngawi);
        graph.addNode(bojonegoro);
        graph.addNode(lamongan);
        graph.addNode(gresik);

        graph.addEdge(new Edge(surabaya, sidoarjo, 20));
        graph.addEdge(new Edge(sidoarjo, malang, 60));
        graph.addEdge(new Edge(malang, blitar, 55));
        graph.addEdge(new Edge(blitar, tulungagung, 30));
        graph.addEdge(new Edge(surabaya, mojokerto, 40));
        graph.addEdge(new Edge(mojokerto, kediri, 60));
        graph.addEdge(new Edge(mojokerto, nganjuk, 65));
        graph.addEdge(new Edge(kediri, tulungagung, 35));
        graph.addEdge(new Edge(nganjuk, kediri, 30));
        graph.addEdge(new Edge(nganjuk, madiun, 40));
        graph.addEdge(new Edge(madiun, nganjuk, 40));
        graph.addEdge(new Edge(madiun, ponorogo, 32));
        graph.addEdge(new Edge(ponorogo, trenggalek, 36));
        graph.addEdge(new Edge(trenggalek, tulungagung, 20));
        graph.addEdge(new Edge(surabaya, gresik, 20));
        graph.addEdge(new Edge(gresik, lamongan, 25));
        graph.addEdge(new Edge(lamongan, bojonegoro, 60));
        graph.addEdge(new Edge(bojonegoro, ngawi, 60));
        graph.addEdge(new Edge(ngawi, madiun, 30));

        graph.findShortestPath(surabaya, tulungagung);
        graph.findShortestPath(surabaya, madiun);
    }
}