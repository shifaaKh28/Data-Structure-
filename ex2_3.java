public class Ex2_4 {

    /**
     * Calculates the maximum sum path in the given binary tree.
     *
     * @param binaryTree The binary tree for which to find the maximum sum path.
     * @return A string containing the maximum sum and the corresponding path.
     */
    public static String maxsumpath(BinaryTree binaryTree){
        // Find the maximum sum path starting from the root node
        Result result = maxima(binaryTree.getRoot());
        // Construct and return a string with the result
        return "max sum:" + result.getLen() + "path is:" + result.getPath();
    }

    /**
     * Recursively calculates the maximum sum path starting from the given node.
     *
     * @param node The node from which to calculate the maximum sum path.
     * @return A Result object containing the maximum sum and the corresponding path.
     */
    public static Result maxima(Node node){
        // Base case: If the node is null, return a Result with zero length and "X" as the path
        if (node == null){
            return new Result(0, "X");
        }
        /// Recursively calculate the maximum sum path in the left and right subtrees
        Result p1 = maxima(node.getRight());
        Result p2 = maxima(node.getLeft());

        // Determine the maximum of the two paths
        int maximum = Math.max(p1.getLen(), p2.getLen());

        // Calculate the current sum including the node's data and the maximum path
        int currentsum = node.getData() + maximum;

        // Determine the path based on the maximum length
        String s = p1.getLen() > p2.getLen()? p1.getPath() : p2.getPath();
        // Append the current node's data to the path
        if (!s.isEmpty()){
            s+= "  "+"<---";
        }
        s += node.getData();
        return new Result(currentsum, s);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(new Node(6));
        Node root = bt.getRoot();
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(9);
        root.right.right = new Node(11);
        root.right.left = new Node(7);
        root.right.left.left = new Node(13);
        String path = maxsumpath(bt);
        System.out.println("max sum path = "+" "+path);

        BinaryTree bt2 = new BinaryTree(new Node(10));

    }
}

