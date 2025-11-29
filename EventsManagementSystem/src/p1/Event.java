package p1;
import java.util.ArrayList;
import java.io.Serializable;

public class Event implements Serializable {

    // ================== Fields ==================
    private int day;
    private int month;
    private int year;
    private String name;
    private Tree attendees;
  
    
    public Event(int day, int month, int year, String name) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public void addAttendee(Attendee a) {
        attendees.insert(a.getId(), a);
  
    }

    public boolean search(int k) {
        if (attendees.search(k)== null)
            return false;
        return true;
        
    }


    public ArrayList<Attendee> attendeesList () {
        return attendees.preOrderList();
        
    }

    @Override
    public String toString() {
        return "Event{name='" + name + "', date=" + day + "/" + month + "/" + year + "}";
    }
}
