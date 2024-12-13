package application;

public class Orders{
	
    public int Product_Id; 
    public String Product_Name;
    public double Quantity,TotalPrice,Price;
    
    
	public Orders() {
		super();
	}

	public Orders(int product_Id, String product_Name, double quantity, double totalPrice, double price) {
		super();
		Product_Id = product_Id;
		Product_Name = product_Name;
		this.Quantity = quantity;
		//this.Discount = discount;
		this.TotalPrice = totalPrice;
		this.Price = price;
	}

	public int getProduct_Id() {
		return Product_Id;
	}
	
	public void setProduct_Id(int product_Id) {
		Product_Id = product_Id;
	}
	
	public String getProduct_Name() {
		return Product_Name;
	}
	
	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}
	
	public double getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(double quantity) {
		this.Quantity = quantity;
	}
	
	/*public double getDiscount() {
		return Discount;
	}
	
	public void setDiscount(double discount) {
		this.Discount = discount;
	}*/
	
	public double getTotalPrice() {
		return TotalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.TotalPrice = totalPrice;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		this.Price = price;
	}    
	
	
	
	
}

