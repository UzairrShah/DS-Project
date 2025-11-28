package p1;
import java.util.ArrayList;
import java.io.Serializable;

public class Event implements Serializable {

    // ================== Fields ==================
    private int day;
    private int month;
    private int year;
    private String name;

  
    private TreeNode root;

    // ================== Inner Node Class ==================
    
    private static class TreeNode {
        Attendee data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(Attendee data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    // ================== Constructor ==================
    public Event(int day, int month, int year, String name) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.name = name;
        this.root = null;
    }

    // ================== Getters ==================
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

    // ================== BST: addAttendee ==================
    public void addAttendee(Attendee a) {
        TreeNode newNode = new TreeNode(a);

       
        if (root == null) {
            root = newNode;
            return;
        }

       
        TreeNode current = root;
        TreeNode parent = null;
        int newId = a.getId();

        while (current != null) {
            parent = current;
            int currentId = current.data.getId();

            if (newId < currentId) {
                current = current.leftChild;
            } else if (newId > currentId) {
                current = current.rightChild;
            } else {
                // duplicate id → ignore...
                return;
            }
        }

        // attach to the correct side of parent
        int parentId = parent.data.getId();
        if (newId < parentId) {
            parent.leftChild = newNode;
        } else {
            parent.rightChild = newNode;
        }
    }


    // ================== BST: search ==================

    public boolean search(int k) {
        TreeNode current = root;

        while (current != null) {
            int currentId = current.data.getId();

            if (k == currentId) {
                return true;            // found
            } else if (k < currentId) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }

        return false; // reached null → not found
    }


    // ================== BST: attendeesList (pre-order) ==================
    public ArrayList<Attendee> attendeesList() {
        ArrayList<Attendee> list = new ArrayList<>();
        fillPreOrder(root, list);
        return list;
    }

    private void fillPreOrder(TreeNode node, ArrayList<Attendee> list) {
        if (node == null) return;

        list.add(node.data);                      
        fillPreOrder(node.leftChild, list);      
        fillPreOrder(node.rightChild, list);      
    }

  
    @Override
    public String toString() {
        return "Event{name='" + name + "', date=" + day + "/" + month + "/" + year + "}";
    }
}
