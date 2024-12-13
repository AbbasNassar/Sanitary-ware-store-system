package application;

public class warehouse {

	private int wid;
	private int capacity;
	private String location;
	private int numberOfEmployees;
	
	public warehouse(int wid, int capacity, String location, int numberOfEmployees) {
		super();
		this.wid = wid;
		this.capacity = capacity;
		this.location = location;
		this.numberOfEmployees = numberOfEmployees;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	
}
