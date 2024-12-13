package application;

public class departmentEmployees {
	private int Eid;
	private String Name;
	public departmentEmployees(int eid, String name) {
		super();
		Eid = eid;
		Name = name;
	}
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

}
