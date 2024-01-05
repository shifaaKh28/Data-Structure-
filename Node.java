public class Node {
    public int data;
    public Node left, right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", left=" + left + ", right=" + right + '}';
    }

    public Integer getData() {return data;}

    public Node getLeft() {return left;}
    public Node getRight() {return right;}
}
