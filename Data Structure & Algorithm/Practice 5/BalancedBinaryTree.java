public class BalancedBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree;

        tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("balanced? " + tree.isBalanced(tree.root));

        tree.root.left.right.left = new Node(6);
        System.out.println("balanced? " + tree.isBalanced(tree.root));
    }
}
