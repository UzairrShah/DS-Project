package bst;
public class Node <E> {
	int key;
	E data;
	Node<E> leftChild;
	Node<E> rightChild;
	public Node(int k,E e)
	{
		key=k;
		data=e;
		leftChild=null;
		rightChild=null;
	}
	public void display() {
	 System.out.print(key+":");
	 System.out.println(data);
	 
	}
}
