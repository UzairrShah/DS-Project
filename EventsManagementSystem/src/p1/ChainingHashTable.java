package p1;


public class ChainingHashTable<E> {

    public SinglyLinkedList<E>[] hashArray;

	public ChainingHashTable(int size) {
        hashArray = (SinglyLinkedList[]) new Object[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new SinglyLinkedList<>();
        }
    }

    public void insert(int index, E data) {
        hashArray[index].addLast(data);
    }

    public void delete(int index, E data) {
        hashArray[index].remove(data);
    }


	public E find(int index, String eventName) {
	    SinglyLinkedList<E> linkedList = hashArray[index];
	    SinglyNode<E> current = linkedList.getHead();
	
	    while (current != null) {
	        E data = current.getData();
	        if (data instanceof Event && ((Event) data).getTitle().equals(eventName)) {
	            return data;
	        }
	        current = current.getNext();
	    }
	    return null;
	}

 

    public void displayTable() {
        for (int i = 0; i < hashArray.length; i++) {
            System.out.println("LinkedList " + i + ":");
            hashArray[i].display();
        }
    }
    
    // EXTRA
    public SinglyLinkedList<E> getLinkedList(int index) {
        return hashArray[index];
    }
}
