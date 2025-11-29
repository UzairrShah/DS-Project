package p1;

import java.io.Serializable;

public class TreeNode<E> implements Serializable{

    private static final long serialVersionUID = 1L;
    
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

