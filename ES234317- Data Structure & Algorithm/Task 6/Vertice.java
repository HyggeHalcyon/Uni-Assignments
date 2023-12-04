public class Vertice {
    String name;
    int cost;
    Vertice prev;
    Vertice(String name){
        this.name = name;
        this.cost = Integer.MAX_VALUE;
        this.prev = null;
    }
}
