class Node {
    private final boolean RED = true, BLACK = false;
    final Integer key; // associated data
    final boolean color;
    Node left, right;
    // constructor
    public Node(Integer data, boolean color) {
        this.key = data;
        this.color = color;
        left = right = null;
    }
    public String toString() {
        String c = "red";
        if (color == BLACK) c = "black";
        return "key: " + key + ", " + c;
    }
}// end class Node

public class RBTree {
    private static final boolean RED = true, BLACK = false;
    Node root; // root of the BST

    // constructor
    public RBTree() {
        root = null;
    }

    public static boolean isValidRadBlackTree(RBTree tree) {
        if (tree == null || tree.root == null) {
            // An empty tree or a tree with no root is considered a valid red-black tree.
            return true;
        }

        // Property 1: The root is black.
        if (tree.root.color != BLACK) {
            return false;
        }

        // Check if all red nodes have only black children.
        if (!tree.blackChildren(tree.root)) {
            return false;
        }
        // Check Property 4 (consistent black height for all paths).
        int blackHeight = tree.checkBlackHeight(tree.root);
        return blackHeight != -1;
    }

    // Helper function to check if all paths have the same black height (Property 4).
    private static int checkBlackHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftBlackHeight = checkBlackHeight(node.left);
        int rightBlackHeight = checkBlackHeight(node.right);

        // Check if the black height of subtrees is consistent.
        if (leftBlackHeight == -1 || rightBlackHeight == -1 ||
                leftBlackHeight != rightBlackHeight) {
            return -1;
        }
        int currentBlackHeight = leftBlackHeight;

        if (node.color == BLACK) {
            currentBlackHeight++; // Increment the black height if the node is black.
        }

        return currentBlackHeight;
    }

    private boolean blackChildren(Node node) {
        if (node == null) {
            return true; // Null nodes are considered to have black children
        }

        if (node.color == RED) {
            if ((node.left != null && node.left.color == RED) ||
                    (node.right != null && node.right.color == RED)) {
                return false; // Red node with red child
            }
        }
        // Recursively check left and right subtrees
        return blackChildren(node.left) &&
                blackChildren(node.right);
    }

}
