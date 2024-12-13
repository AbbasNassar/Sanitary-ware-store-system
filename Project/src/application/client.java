package application;


public class client {
	 
	  private int cid;
	 private String name;
	 private String address;
	 private String payment_method;

	 
	public client(int cid, String name, String address, String payment_method) {
		super();
		this.cid = cid;
		this.name = name;
		this.address = address;
		this.payment_method = payment_method;

	}

	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

}

