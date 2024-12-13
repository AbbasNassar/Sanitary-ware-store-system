package application;


public class clientPhone {
	private int cid;
	private String phoneNumber;

	public clientPhone(int cid, String phoneNumber) {
		super();
		this.cid = cid;
		this.phoneNumber = phoneNumber;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}
