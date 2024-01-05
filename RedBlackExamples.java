public class EX3_3 {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    public static void main(String[] args) {
       /*
                  15B
                /    \
               /      \
              10R       20R
          output:true
        */
        RBTree tree = new RBTree();
        tree.root = new Node(15, BLACK);
        tree.root.left = new Node(10, RED);
        tree.root.right = new Node(20, RED);
        System.out.println("is RB tree? " + RBTree.isValidRadBlackTree(tree));

           /*
                  15B
                /    \
               /      \
              10R       20R
             /  \      /  \
            /    \    /    \
           5B     11B 18B    25B
                             \
                              \
                              30B
          output:false
        */
        RBTree tree2 = new RBTree();
        tree2.root = new Node(15, BLACK);
        tree2.root.left = new Node(10, RED);
        tree2.root.left.left = new Node(5, BLACK);
        tree2.root.left.right = new Node(11,BLACK);

        tree2.root.right = new Node(20, RED);
        tree2.root.right.left = new Node(18, BLACK);
        tree2.root.right.right = new Node(25, BLACK);
        tree2.root.right.right.right = new Node(30, BLACK);

        System.out.println("is RB tree? " + RBTree.isValidRadBlackTree(tree2));

/*
                  15B
                /    \
               /      \
              10R       20R
             /  \      /  \
            /    \    /    \
           5R     11R 18B    25B

          output:false
        */
        RBTree tree3 = new RBTree();
        tree3.root = new Node(15, BLACK);
        tree3.root.left = new Node(10, RED);
        tree3.root.left.left = new Node(5, RED);
        tree3.root.left.right = new Node(11,RED);

        tree3.root.right = new Node(20, RED);
        tree3.root.right.left = new Node(18, BLACK);
        tree3.root.right.right = new Node(25, BLACK);


        System.out.println("is RB tree? " + RBTree.isValidRadBlackTree(tree3));

          /*
                    8B
                /        \
               /          \
              1R          12R
             /  \          /  \
            /    \        /    \
           2B     6B      10B    14B
          / \    / \      / \    /  \
         /   \  /   \    /   \  /    \
       1R   3R  5R  7R  9R  11R 13R   15R


          output:true
        */
        RBTree tree4 = new RBTree();
        tree4.root = new Node(8, BLACK);
        tree4.root.left = new Node(1, RED);
        tree4.root.left.left = new Node(2, BLACK);
        tree4.root.left.right = new Node(6,BLACK);
        tree4.root.left.left.left = new Node(1, RED);
        tree4.root.left.left.right = new Node(3,RED);
        tree4.root.left.right.left = new Node(5,RED);
        tree4.root.left.right.right = new Node(7,RED);

        tree4.root.right = new Node(12, RED);
        tree4.root.right.left = new Node(10, BLACK);
        tree4.root.right.right = new Node(14, BLACK);

        tree4.root.right.left.left = new Node(9, RED);
        tree4.root.right.left.right = new Node(11, RED);
        tree4.root.right.right.left = new Node(13, RED);
        tree4.root.right.right.right = new Node(15, RED);

        System.out.println("is RB tree? " + RBTree.isValidRadBlackTree(tree4));

    }
}
