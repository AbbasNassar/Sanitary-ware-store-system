package application;

public class vehicles {

	int Vid;
	String model;
	int yearOfProduction;
	int capacity;
	String licensePlateNumber;
	String licenseExpiryDate;
	int Eid;
	int numberOfOrders;
	
	public vehicles(int vid, String model, int yearOfProduction, int capacity, int numberOfOrders,String licensePlateNumber,String licenseExpiryDate, int eid) {
		super();
		this.Vid = vid;
		this.model = model;
		this.yearOfProduction = yearOfProduction;
		this.capacity = capacity;
		this.licensePlateNumber = licensePlateNumber;
		this.licenseExpiryDate = licenseExpiryDate;
		this.Eid = eid;
		this.numberOfOrders = numberOfOrders;
	}


	public int getNumberOfOrders() {
		return numberOfOrders;
	}


	public void setNumberOfOrders(int numberOfOrders) {
		this.numberOfOrders = numberOfOrders;
	}


	public int getVid() {
		return Vid;
	}

	public void setVid(int vid) {
		Vid = vid;
	}

	public int getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public int getEid() {
		return Eid;
	}

	public void setEid(int eid) {
		Eid = eid;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public String getLicenseExpiryDate() {
		return licenseExpiryDate;
	}

	public void setLicenseExpiryDate(String licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "vehicles [Vid=" + Vid + ", model=" + model + ", yearOfProduction=" + yearOfProduction + ", capacity="
				+ capacity + ", licensePlateNumber=" + licensePlateNumber + ", licenseExpiryDate=" + licenseExpiryDate
				+ ", Eid=" + Eid + "]";
	}
	

}
