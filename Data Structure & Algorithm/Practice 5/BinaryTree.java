public class BinaryTree {
    Node root;

    int calculateHeight(Node current){
        if(current == null) return 0;

        return 1 + Math.max(calculateHeight(current.left), calculateHeight(current.right));
    }

    boolean isBalanced(Node current){
        if (current == null) return true;

        int leftHeight = calculateHeight(current.left);
        int rightHeight = calculateHeight(current.right);

        if (Math.abs(leftHeight - rightHeight) > 1
                || !isBalanced(current.left)
                || !isBalanced(current.right))
            return false;

        return true;
    }
}
