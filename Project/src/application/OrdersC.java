package application;

import java.time.LocalDate;

public class OrdersC{
	
    public int Order_Id, Client_Id;
    public LocalDate Date;
    public String Pay_Type;
    public double TotalPrice,Discount, Paid_Amount, Remaining;
    
	public OrdersC(int order_Id, int client_Id, LocalDate date, String pay_Type, double totalPrice, double discount,
			double paid_Amount, double remaining) {
		super();
		Order_Id = order_Id;
		Client_Id = client_Id;
		this.Date = date;
		Pay_Type = pay_Type;
		TotalPrice = totalPrice;
		Discount = discount;
		Paid_Amount = paid_Amount;
		Remaining =  remaining;
	}
	
	public double getRemaining() {
		return Remaining;
	}
	
	public void setRemaining(double remaining) {
		Remaining = remaining;
	}
	
	public int getOrder_Id() {
		return Order_Id;
	}
	public void setOrder_Id(int order_Id) {
		Order_Id = order_Id;
	}
	public int getClient_Id() {
		return Client_Id;
	}
	public void setClient_Id(int client_Id) {
		Client_Id = client_Id;
	}
	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		this.Date = date;
	}
	public String getPay_Type() {
		return Pay_Type;
	}
	public void setPay_Type(String pay_Type) {
		Pay_Type = pay_Type;
	}
	public double getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		TotalPrice = totalPrice;
	}
	public double getDiscount() {
		return Discount;
	}
	public void setDiscount(double discount) {
		Discount = discount;
	}
	public double getPaid_Amount() {
		return Paid_Amount;
	}
	public void setPaid_Amount(double paid_Amount) {
		Paid_Amount = paid_Amount;
	}
    	
	
}

