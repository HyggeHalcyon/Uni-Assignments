public class BinarySearchTree {
    class Node {
        public int value;
        public Node left, right;

        Node(int val){
            this.value = val;
            left = right = null;
        }
    }
    private Node root;
    BinarySearchTree(int value){
        this.root = new Node(value);
    }

    public void print(String message) {
        System.out.println(message);
        printTree(root, 0);
    }

    private void printTree(Node node, int depth) {
        if (node != null) {
            printTree(node.right, depth + 1);

            for (int i = 0; i < depth; i++) {
                System.out.print("\t");
            }
            System.out.println(node.value);

            printTree(node.left, depth + 1);
        }
    }

    public void insert(int value){
        insertNode(root, value);
    }

    private Node insertNode(Node node, int value){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value) node.left = insertNode(node.left, value);
        else if(value > node.value) node.right = insertNode(node.right, value);

        return node;
    }
    public void delete(int value){
        deleteNode(root, value);
    }

    private Node deleteNode(Node node, int value){
        // base case if the deleted node is not found
        if(node == null)
            return node;

        // search for the node, it will execute this branch
        // only if it is not the node to be deleted
        if(node.value > value) {
            node.left = deleteNode(node.left, value);
            return node; // preserve for unchanged node
        }
        else if(node.value < value) {
            node.right = deleteNode(node.right, value);
            return node; // preserve for unchanged node
        }

        // this branch only execute if it's on the
        // node to be deleted
        if(node.left == null)
            return node.right;
        else if(node.right == null)
            return node.left;
        else {
            // honestly, I don't even get it
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.value = minValue(node.right);
            node.right = deleteNode(node.right, node.value);
            return node;
        }
    }

    private int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }
}
