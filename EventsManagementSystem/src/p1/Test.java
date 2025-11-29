package p1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    private static final String OUTPUT_FILE = "events_data.ser";

    public static void main(String[] args) {

        EventsHashTable table = null;

        File f = new File(OUTPUT_FILE);

        if (f.exists()) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
                table = (EventsHashTable) in.readObject();
                in.close();
            } catch (Exception e) {
                table = new EventsHashTable();
            }
        } else {
            table = new EventsHashTable();
        }

        Scanner input = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("1- Add a new event");
            System.out.println("2- Register attendee in an event");
            System.out.println("3- Display attendees list in a specific day");
            System.out.println("4- Display attendee's events");
            System.out.println("5- Remove an event");
            System.out.println("6- Exit");
            System.out.println("enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("enter event title: ");
                    String title = input.nextLine();

                    System.out.print("enter day: ");
                    int d = input.nextInt();
                    System.out.print("enter month: ");
                    int m = input.nextInt();
                    System.out.print("enter year: ");
                    int y = input.nextInt();

                    table.addEvent(d, m, y, title);
                    break;

                case 2:
                    System.out.print("enter event title: ");
                    String eName = input.nextLine();

                    System.out.print("enter attendee ID: ");
                    int aId = input.nextInt();
                    input.nextLine();

                    System.out.print("enter attendee name: ");
                    String aName = input.nextLine();

                    table.addAttendee(eName, aId, aName);
                    break;

                case 3:
                    System.out.print("enter day: ");
                    int day = input.nextInt();
                    System.out.print("enter month: ");
                    int month = input.nextInt();
                    System.out.print("enter year: ");
                    int year = input.nextInt();

                    ArrayList<String> attList = table.attendeesList(day, month, year);

                    if (attList.isEmpty()) {
                        System.out.println("no attendees found on this date");
                    } else {
                        System.out.println("attendees registered on " + day + "/" + month + "/" + year + ":");
                        for (String n : attList) {
                            System.out.println("- " + n);
                        }
                    }
                    break;

                case 4:
                    System.out.print("enter attendee ID: ");
                    int attId = input.nextInt();

                    ArrayList<String> events = table.attendeeEvents(attId);

                    if (events.isEmpty()) {
                        System.out.println("this attendee is not registered in any event");
                    } else {
                        System.out.println("events for attendee ID " + attId + ":");
                        for (String ev : events) {
                            System.out.println("- " + ev);
                        }
                    }
                    break;

                case 5:
                    System.out.print("enter title to remove: ");
                    String removeTitle = input.nextLine();

                    table.removeEvent(removeTitle);
                    break;

                case 6:
                    try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(OUTPUT_FILE));
                        out.writeObject(table);
                        out.close();
                    } catch (Exception e) {
                        System.out.println("error saving data: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("invalid choice");
            }

        } while (choice != 6);

        input.close();
    }
}
