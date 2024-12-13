package application;

public class Delivery{
	
    public int Orderid, Driverid,Carid; 
    public String Orderstatus, OrderDistenation;
    
	public Delivery(int orderid, int driverid, int carid, String orderstatus, String orderDistenation) {
		super();
		Orderid = orderid;
		Driverid = driverid;
		Carid = carid;
		Orderstatus = orderstatus;
		OrderDistenation = orderDistenation;
	}
	public int getOrderid() {
		return Orderid;
	}
	public void setOrderid(int orderid) {
		Orderid = orderid;
	}
	public int getDriverid() {
		return Driverid;
	}
	public void setDriverid(int driverid) {
		Driverid = driverid;
	}
	public int getCarid() {
		return Carid;
	}
	public void setCarid(int carid) {
		Carid = carid;
	}
	public String getOrderstatus() {
		return Orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		Orderstatus = orderstatus;
	}
	public String getOrderDistenation() {
		return OrderDistenation;
	}
	public void setOrderDistenation(String orderDistenation) {
		OrderDistenation = orderDistenation;
	}
    
    
	
	
}

