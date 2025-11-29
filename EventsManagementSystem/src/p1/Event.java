package p1;

import java.util.ArrayList;

public class Event {

    int day;
    int month;
    int year;
    String title;
    Tree<Attendee> attendees; 

    public Event(int day, int month, int year, String title) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.title = title;
        attendees = new Tree<>();
    }

    public void addAttendee(Attendee a) {
        attendees.insert(a.getId(), a);
    }

    public boolean search(int id) {
    	if (attendees.search(id)!= null) {
    		return true;
    	}
        return false;
    }

    // PREORDER 
    public ArrayList<Attendee> attendeesList() {
        ArrayList<Attendee> list = new ArrayList<>();
        attendees.preorderToList(list);
        return list;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " (" + day + "/" + month + "/" + year + ")";
    }
}
