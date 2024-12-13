package application;

public class Products{
	
    public int Pid; 
    public String Pname;
    public double Price, Quantity;
    
    
	public Products(int product_Id, String product_Name, double Quantity, double price) {
		super();
		Pid = product_Id;
		Pname = product_Name;
		this.Quantity = Quantity;
		this.Price = price;
	}


	public int getPid() {
		return Pid;
	}


	public void setPid(int pid) {
		Pid = pid;
	}


	public String getPname() {
		return Pname;
	}


	public void setPname(String pname) {
		Pname = pname;
	}


	public double getQuantity() {
		return Quantity;
	}


	public void setQuantity(double Quantity) {
		this.Quantity = Quantity;
	}


	public double getPrice() {
		return Price;
	}


	public void setPrice(double price) {
		this.Price = price;
	}



	
	
	
	
}

