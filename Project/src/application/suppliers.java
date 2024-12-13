package application;

public class suppliers {
	
	public suppliers(int sid, String name, String address, String phone_number) {
		super();
		Sid = sid;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
	}

	public suppliers(int sid, String phone_number) {
		super();
		Sid = sid;
		this.phone_number = phone_number;
	}

	int Sid;
	String name, address, phone_number;
	
	public suppliers(int sid, String name, String address) {
		super();
		Sid = sid;
		this.name = name;
		this.address = address;
	}

	public int getSid() {
		return Sid;
	}

	public void setSid(int sid) {
		Sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phone_number;
	}

	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "suppliers [Sid=" + Sid + ", name=" + name + ", address=" + address + ", phone_number=" + phone_number
				+ "]";
	}
}
