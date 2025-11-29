package p1;

import java.io.Serializable;

public class Attendee implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	public Attendee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Attendee [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	
}
