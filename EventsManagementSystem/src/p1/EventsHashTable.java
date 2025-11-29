package p1;

import java.time.LocalDate;
import java.util.ArrayList;

public class EventsHashTable {

    private ChainingHashTable<Event> cht;

    public EventsHashTable() {
        cht = new ChainingHashTable<>(367);
    }
    
    private int indexOf(int day, int month, int year) {
        return LocalDate.of(year, month, day).getDayOfYear();
    }

    

    public void addEvent(int day, int month, int year, String title) {
        int index = indexOf(day, month, year);
        Event e = new Event(day, month, year, title);
        cht.insert(index, e);
    }
    
    
    
	public void addAttendee(String eventName, int id, String name) {
	    Attendee attendee = new Attendee(id, name);
	    boolean found = false;
	
	    for (int i = 1; i < 367; i++) { 
	        SinglyLinkedList<Event> linkedList = cht.getLinkedList(i);
	        SinglyNode<Event> current = linkedList.getHead();
	
	        while (current != null) {
	            Event event = current.getData();
	            if (event.getTitle().equals(eventName)) {
	                event.addAttendee(attendee);
	                found = true;
	                break;
	            }
	            current = current.getNext();
	        }
	      if (found)
	    	  break;
	    }
	    if (!found) 
	        System.out.println("Error: Event with name '" + eventName + "' not found.");
	}



	public void removeEvent(String eventName) {
	    boolean found = false;
	
	    for (int i = 1; i < 367; i++) { 
	        SinglyLinkedList<Event> linkedList = cht.getLinkedList(i);
	        SinglyNode<Event> current = linkedList.getHead();
	
	        while (current != null) {
	            Event event = current.getData();
	            if (event.getTitle().equals(eventName)) {
	                linkedList.remove(event); 
	                found = true;
	                break;
	            }
	            current = current.getNext();
	        }
	        if (found) 
	        	break;
	    }
	    if (!found) 
	        System.out.println("Error: Event with name '" + eventName + "' not found.");
	    
	}

	

	public ArrayList<String> attendeesList(int day, int month, int year) {
	    ArrayList<String> names = new ArrayList<>();
	    int index = indexOf(day, month, year);
	
	    SinglyLinkedList<Event> linkedList = cht.getLinkedList(index);
	    SinglyNode<Event> current = linkedList.getHead();
	
	    while (current != null) {
	        Event event = current.getData();
	        ArrayList<Attendee> attendees = event.attendeesList();
	        for (Attendee a : attendees) {
	            names.add(a.getName());
	        }
	        current = current.getNext();
	    }
	    return names;
	}

	
	
	public ArrayList<String> attendeeEvents(int id) {
	    ArrayList<String> eventNames = new ArrayList<>();
	
	    
	    for (int i = 1; i < 367 ; i++) { 
	        SinglyLinkedList<Event> linkedList = cht.getLinkedList(i);
	        SinglyNode<Event> current = linkedList.getHead();
	
	        while (current != null) {
	            Event event = current.getData();
	            if (event.search(id)) { 
	                eventNames.add(event.getTitle());
	            }
	            current = current.getNext();
	        }
	    }
	    return eventNames;
	}



}
