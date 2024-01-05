class TreapNode {
    int key;
    int priority;
    TreapNode left;
    TreapNode right;

    public TreapNode(int key, int priority) {
        this.key = key;
        this.priority = priority;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + priority + ")";
    }
}
public class Treap {
    private TreapNode root;  // Root of the Treap

    // Constructor to create an empty Treap
    public Treap() {
        this.root = null;
    }

    // Insert a new node with a given key and priority into the Treap
    public TreapNode insert(int key, int priority) {
        root = insertRec(root, key, priority);
        return root; // You can return the inserted node if needed
    }

    // Recursive method to insert a node while maintaining the Treap properties
    private TreapNode insertRec(TreapNode root, int key, int priority) {
        // Standard BST insertion
        if (root == null) {
            return new TreapNode(key, priority);
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key, priority);
            // Perform rotations if necessary to maintain max heap property
            if (root.left.priority > root.priority) {
                root = rotateRight(root);
            }
        } else if (key > root.key) {
            root.right = insertRec(root.right, key, priority);
            // Perform rotations if necessary to maintain max heap property
            if (root.right.priority > root.priority) {
                root = rotateLeft(root);
            }
        }

        return root;
    }
    /**
     * Helper method to perform a right rotation
     * Performs a right rotation in a Treap.
     *
     * @param y The node to be rotated.
     * @return The new root node after the rotation.
     */

    private TreapNode rotateRight(TreapNode y) {
        // Store the left child of y as x
        TreapNode x = y.left;

        // Store the right child of x as t
        TreapNode t = x.right;

     // Perform the right rotation
        x.right = y;
        y.left = t;

        // Return the new root node (x)
        return x;
    }
    /**
     * Helper method to perform a left rotation
     * Performs a left rotation on the given TreapNode.
     *
     * @param x The TreapNode to be rotated left.
     * @return The new root of the subtree after the rotation.

     */
    private static TreapNode rotateLeft(TreapNode x) {
        // Store the right child of x as y
        TreapNode y = x.right;

        // Store the left child of y as t
        TreapNode t = y.left;

        // Perform rotation
        y.left = x;
        x.right = t;

        // Return the new root node (y)
        return y;
    }

    // Search for a key in the Treap
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive method to search for a key
    private boolean searchRec(TreapNode root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.key) {
            return true;
        }

        if (key < root.key) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    // Preorder traverse
    public void preorderTraversePlus() {
        preorderTraversePlusRec(root);
    }

    // Recursive method for preorder traversal,,preOrder: root-->left-->right
    private void preorderTraversePlusRec(TreapNode root) {
        if (root != null) {
            System.out.print(root + " ");
            preorderTraversePlusRec(root.left);
            preorderTraversePlusRec(root.right);
        }
    }
        public static void main(String[] args) {
            // Create a new Treap
            Treap treap = new Treap();
             treap.root=new TreapNode(50,15);
             treap.root.left=new TreapNode(30,5);
            treap.root.right=new TreapNode(70,10);

            treap.root.left.left=new TreapNode(20,2);
            treap.root.left.right=new TreapNode(40,4);

            treap.insert(45,20);

            // Insert nodes into the Treap with keys and priorities

            // Example of searching for a key
            int keyToSearch = 40;
            boolean found = treap.search(keyToSearch);
            System.out.println("Key " + keyToSearch + " found: " + found);

            // Perform a preorder traversal and print the nodes
            System.out.println("Preorder traversal:");
            treap.preorderTraversePlus();
        }

             }




