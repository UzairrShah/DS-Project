package p1;

import java.io.Serializable;

public class SinglyLinkedList<E> implements Serializable{

    private static final long serialVersionUID = 1L;
    private SinglyNode<E> head = null;
    private SinglyNode<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return head.getData();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getData();
    }

    public void addFirst(E e) {
        head = new SinglyNode<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    public void addLast(E e) {
        SinglyNode<E> newest = new SinglyNode<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;

        E answer = head.getData();
        head = head.getNext();
        size--;

        if (size == 0)
            tail = null;

        return answer;
    }
    
	public E removeLast(){
		if(isEmpty()) return null;
		E answer=tail.getData();
		if (head==tail)
			head=tail=null;
		else
		{
		    SinglyNode<E> tmp=head;
		    while (tmp.getNext()!=tail)
		    	tmp=tmp.getNext();
		 tmp.setNext(null);
		 tail=tmp;
		}
		size--;
		return answer;
	}
	// EXTRA METHOD
    public boolean remove(E e) {
        if (isEmpty()) return false;

        
        if (head.getData().equals(e)) {
            removeFirst();
            return true;
        }

        SinglyNode<E> prev = head;
        SinglyNode<E> curr = head.getNext();

        while (curr != null) {
            if (curr.getData().equals(e)) {
                prev.setNext(curr.getNext());
                if (curr == tail)
                    tail = prev;
                size--;
                return true;
            }
            prev = curr;
            curr = curr.getNext();
        }
        return false;
    }

    public void display() {
        SinglyNode<E> tmp = head;
        while (tmp != null) {
            System.out.println(tmp.getData());
            tmp = tmp.getNext();
        }
    }
    // NEEDED SINCE HEAD IS PRIVATE 
    public SinglyNode<E> getHead() {
    return head;
    }


}
