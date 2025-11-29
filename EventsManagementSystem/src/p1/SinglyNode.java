package p1;

public class SinglyNode<E> {
    private E data;
    private SinglyNode<E> next;

    public SinglyNode(E d, SinglyNode<E> n) {
        data = d;
        next = n;
    }

    public E getData() {
        return data;
    }

    public SinglyNode<E> getNext() {
        return next;
    }

    public void setNext(SinglyNode<E> n) {
        next = n;
    }
}
