package p1;

public class TreeNode<E> {
    int key;
    E data;
    TreeNode<E> leftChild;
    TreeNode<E> rightChild;

    public TreeNode(int k, E d) {
        key = k;
        data = d;
        leftChild = null;
        rightChild = null;
    }

    public void display() {
        System.out.println(key + ": " + data);
    }
}

