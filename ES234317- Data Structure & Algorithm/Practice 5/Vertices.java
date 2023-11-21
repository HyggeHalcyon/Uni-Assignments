public class Vertices {
    String name;
    int cost;
    Vertices prev;
    Vertices(String name){
        this.name = name;
        this.cost = Integer.MAX_VALUE;
        this.prev = null;
    }
}
