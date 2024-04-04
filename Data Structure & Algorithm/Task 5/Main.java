public class Main {
    static public void main(String[] args){
        /*
                            60
                         /      \
                        30      70
                       /  \    /  \
                      10  40  65  90
         */
        BinarySearchTree tree = new BinarySearchTree(60);
        tree.insert(30);
        tree.insert(70);
        tree.insert(10);
        tree.insert(40);
        tree.insert(65);
        tree.insert(90);
        tree.print("Initial State:");

        tree.delete(90);
        tree.delete(30);
        tree.print("After Deletion:");

        /*
                    A → B ← ↰
                    ↑   ↓   ↑
                    D ← C → E
                            ↓
                            F
         */
        DirectedGraph graph = new DirectedGraph();
        graph.addVertex( "Aaaa mooou");
        graph.addVertex("Baka janaino?");
        graph.addVertex("Chiisana koi to");
        graph.addVertex("Dasakunai");
        graph.addVertex("Ecchiiii!!");
        graph.addVertex("Fukachhii");
        graph.addEdge("Aaaa mooou", "Baka janaino?", 23);
        graph.addEdge("Baka janaino?", "Chiisana koi to", 51);
        graph.addEdge("Chiisana koi to", "Dasakunai", 18);
        graph.addEdge("Dasakunai", "Ecchiiii!!", 64);
        graph.addEdge("Chiisana koi to", "Ecchiiii!!", 58);
        graph.addEdge("Ecchiiii!!", "Fukachhii", 13);
        graph.addEdge("Ecchiiii!!", "Baka janaino?", 74 );
        graph.print("Directed Graph:");
    }
}