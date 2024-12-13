package application;

import java.sql.Date;

public class allInformationForClient {
	 private int cid;
	 private String name;
	 private Date date;
	 private String Pname;
	 private int quantity;
	 private float price;
	 private float total;
	 private float discount;
	 
	public allInformationForClient(int cid, String name, Date date, String pname, int quantity, float price,
			float total, float discount) {
		super();
		this.cid = cid;
		this.name = name;
		this.date = date;
		Pname = pname;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.discount = discount;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPname() {
		return Pname;
	}

	public void setPname(String pname) {
		Pname = pname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
}
