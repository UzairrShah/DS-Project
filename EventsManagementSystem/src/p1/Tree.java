package p1;

import java.io.Serializable;
import java.util.ArrayList;


public class Tree<E> implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private TreeNode<E> root;

    public Tree() {
        root = null;
    }

    public E search(int k)
    {
   	 TreeNode<E> current=root;
   	 while(current.key!=k)
   	 {
   		 if (k<current.key)
   			 current=current.leftChild;
   		 else
   			 current=current.rightChild;
   		 if(current==null)
   			 return null;
   	 }
   	 return current.data;
    }

    
    public void insert(int k, E e) {
        TreeNode<E> newNode = new TreeNode<>(k, e);

        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode<E> current = root;
        TreeNode<E> parent;

        while (true) {
            parent = current;

            if (k < current.key) {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = newNode;
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    return;
                }
            }
        }
    }

    public boolean delete(int k)
    {
   	 TreeNode<E> current = root;
   	 TreeNode<E> parent = root;
   	 boolean isLeftChild = true;
   	 while(current.key!= k) 
   	 {
   		 parent = current;
   		 if(k < current.key) 
   		 {
   			 isLeftChild = true;
   			 current = current.leftChild;
   		 }
   		 else 
   		 {
   			 isLeftChild = false;
   			 current = current.rightChild;
   		 }
   		 if(current == null) 
   			 return false; 
   	 }
   	 if(current.leftChild==null &&current.rightChild==null)
   	 {
   	 if(current == root) 
   	 	root = null; 
   	 else 
   	 	if(isLeftChild)
   	 		parent.leftChild = null; 
   	 	else 
   	 		parent.rightChild = null;
   	 }
   	 else 
   		  if(current.rightChild==null)
   		     if(current == root)
   			 root = current.leftChild;
   		      else 
   			  if(isLeftChild) 
   				parent.leftChild = current.leftChild;
   		          else // right child of parent
   		               parent.rightChild = current.leftChild;
   		  else if(current.leftChild==null)
   		      if(current == root)
   		        root = current.rightChild;
   		      else 
   		          if(isLeftChild) // left child of parent
   		              parent.leftChild = current.rightChild;
   		          else // right child of parent
   		              parent.rightChild = current.rightChild;
   		  else 
   		  {
   			  
   			  TreeNode<E> successor = getSuccessor(current);
   			   if(current == root)
   				  root = successor;
   			  else if(isLeftChild)
   				  parent.leftChild = successor;
   			  else
   				  parent.rightChild = successor;
   			  successor.leftChild = current.leftChild;
   		  } 
   	 return true;

    }
    
    private TreeNode<E> getSuccessor(TreeNode<E> delNode)
    {
   	 TreeNode<E> successorParent = delNode;
   	 TreeNode<E> successor = delNode;
   	 TreeNode<E> current = delNode.rightChild; // go to right child
   	 while(current != null) // until no more
   	 { // left children,
   		 successorParent = successor;
   		 successor = current;
   		 current = current.leftChild; // go to left child
   	 }
   	 // if successor not
   	 if(successor != delNode.rightChild) // right child,
   	 { // make connections
   		 successorParent.leftChild = successor.rightChild;
   		 successor.rightChild = delNode.rightChild;
   	 }
   	 return successor;
    }
    
    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1: preorder(root); break;
            case 2: inorder(root); break;
            case 3: postorder(root); break;
           }
       }

     public void preorder(TreeNode<E> n) {
         if (n == null) 
        	 return;
         n.display();
         preorder(n.leftChild);
         preorder(n.rightChild);
     }

     public void inorder(TreeNode<E> n) {
         if (n == null) return;
         inorder(n.leftChild);
         n.display();
         inorder(n.rightChild);
     }

     public void postorder(TreeNode<E> n) {
         if (n == null)
        	 return;
         postorder(n.leftChild);
         postorder(n.rightChild);
         n.display();
     }

     // NEW METHODS
     public void preorderToList(ArrayList<E> list) {
         rPreorderToList(root, list);
     }

     private void rPreorderToList(TreeNode<E> n, ArrayList<E> list) {
         if (n == null) 
        	 return;
         list.add(n.data);
         rPreorderToList(n.leftChild, list);
         rPreorderToList(n.rightChild, list);
     }

     public void inorderToList(ArrayList<E> list) {
          rInorderToList(root, list);
     }

     private void rInorderToList(TreeNode<E> n, ArrayList<E> list) {
         if (n == null) 
        	 return;
         rInorderToList(n.leftChild, list);
         list.add(n.data);
         rInorderToList(n.rightChild, list);
     }

     public void postorderToList(ArrayList<E> list) {
         rPostorderToList(root, list);
     }

     private void rPostorderToList(TreeNode<E> n, ArrayList<E> list) {
         if (n == null) return;
         rPostorderToList(n.leftChild, list);
         rPostorderToList(n.rightChild, list);
         list.add(n.data);
     }



}
