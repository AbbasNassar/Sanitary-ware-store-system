package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;


public class MyConnection {
	static ArrayList<Orders> data = new ArrayList <>();
	static ArrayList<Products> Product_data = new ArrayList <>();
	static ArrayList<Customers> Customers_data = new ArrayList <>();
	static ArrayList<OrdersC> OrdersC_data = new ArrayList <>();
	static ArrayList<Delivery> Delivery_data = new ArrayList <>();
	
	
	private static String dbURL;
	private static String dbUsername = "root";
	private static String dbPassword = "123123";
	private static String URL = "127.0.0.1";
	private static String port = "3306";
	private static String dbName = "Alitqan";
	private static Connection con;
	
    static PreparedStatement pstmt1 = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;

   
	
static void connectDB() throws ClassNotFoundException, SQLException {
	

		
		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("hesre");
	
		con = DriverManager.getConnection (dbURL, p);

	}


public static ObservableList<Orders> getOrderData() throws SQLException, ClassNotFoundException {
	
	 //ArrayList<Employees> data //= new ArrayList <>();	
     ObservableList<Orders> dataList;
	
	String SQL;
			
	connectDB();
	System.out.println("Connection established");

	SQL = "select * from  order by Eid";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);


	while ( rs.next() ) {
		
		int id = Integer.parseInt(rs.getString(1));
		String name = rs.getString(2);
		String Addr = rs.getString(3);
		double sal = Double.parseDouble(rs.getString(4));
		String job =  rs.getString(5);
		
		String MSQL = "select * from Phone_number where Peid = "+id;
		
		
		Statement stmtt = con.createStatement();
		ResultSet rss = stmtt.executeQuery(MSQL);
         		
		while ( rss.next() ) {
		  	
		  String phonee = rss.getString(2);	
	      data.add(new Orders());		
			
		}
		
	}	
	
	rs.close();
	stmt.close();
     

	dataList = FXCollections.observableArrayList(data);
	

	
	
	con.close();
	System.out.println("Connection closed " + data.size());
	
	return dataList;
}


public static ObservableList<Delivery> getDeliveryOrderData() throws SQLException, ClassNotFoundException {
	
	 //ArrayList<Employees> data //= new ArrayList <>();	
    ObservableList<Delivery> dataList;
    OrdersC_data.clear();
	
	String SQL;
			
	connectDB();
	System.out.println("Connection established");

	SQL = "select * from  deliveryOrder";
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);
	

	while ( rs.next() ) {
		 //System.out.println("nonon");
		
		
		 int id = rs.getInt(1); // Use getInt for integer fields
		 int did = rs.getInt(2); // Convert SQL date to LocalDate
		 int Cid = rs.getInt(3); // Use getDouble for double fields
		 String Type = rs.getString(4); // Use getString for string fields
		 String Dist = rs.getString(5); // Use getDouble for double fields
         
		 
		 // (int orderid, int driverid, int carid, String orderstatus, String orderDistenation)
		 Delivery_data.add(new Delivery(id, did, Cid, Type, Dist));		
	     //System.out.println("lkjfaof");		

	}	
	
	rs.close();
	stmt.close();
  

	dataList = FXCollections.observableArrayList(Delivery_data);
	
	con.close();
	System.out.println("Connection closed " + data.size());
	
	return dataList;
}





public static ObservableList<Products> getProductData() throws SQLException, ClassNotFoundException {
	
	Product_data.clear();
    ObservableList<Products> dataList;
	
	String SQL;
			
	connectDB();
	System.out.println("Connection established");

	SQL = "select * from  products";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);


	while ( rs.next() ) {
		
		int id = Integer.parseInt(rs.getString(1));
		String name = rs.getString(2);
		double price = Double.parseDouble(rs.getString(3));
		double Quantity =  rs.getDouble(4);

		Product_data.add(new Products(id,name,Quantity,price));		
			
	}	
	
	rs.close();
	stmt.close();
    

	dataList = FXCollections.observableArrayList(Product_data);
	
 for (Products employee : dataList) {
       System.out.println("Employee ID: " + employee.Pid);
       System.out.println("Employee Name: " + employee.Pname);
       System.out.println("Employee Address: " + employee.Quantity);
       System.out.println("Employee Job Type: " + employee.Price);
       
       System.out.println();
   }
	
	
	
	con.close();
	System.out.println("Connection closed " + data.size());
	
	return dataList;
}


public static ObservableList<Customers> getCustomerData() throws SQLException, ClassNotFoundException {
	
	
	
	 //ArrayList<Employees> data //= new ArrayList <>();	
   ObservableList<Customers> dataList;
   Customers_data.clear();
	
	String SQL;
			
	connectDB();
	System.out.println("Connection established");

	SQL = "select cid, name from  Client";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);


	while ( rs.next() ) {
		
		int id = Integer.parseInt(rs.getString(1));
		String name = rs.getString(2);

		Customers_data.add(new Customers(id,name));		
			

	}	
	
	rs.close();
	stmt.close();
   

	dataList = FXCollections.observableArrayList(Customers_data);
	
for (Customers cust : dataList) {
      System.out.println("Employee ID: " + cust.Id);
      System.out.println("Employee Name: " + cust.Name);      
      System.out.println();
  }
	
	
	
	con.close();
	System.out.println("Connection closed " + data.size());
	
	return dataList;
}

public static ObservableList<OrdersC> getOrdersCData() throws SQLException, ClassNotFoundException {
	
	
	
	 //ArrayList<Employees> data //= new ArrayList <>();	
    ObservableList<OrdersC> dataList;
    OrdersC_data.clear();
	
	String SQL;
			
	connectDB();
	System.out.println("Connection established");

	SQL = "select * from  salesOrder";
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);
	

	while ( rs.next() ) {
		 //System.out.println("nonon");
		
		
		 int id = rs.getInt(1); // Use getInt for integer fields
		 LocalDate date = rs.getDate(2).toLocalDate(); // Convert SQL date to LocalDate
		 double discount = rs.getDouble(3); // Use getDouble for double fields
		 double Tot = rs.getDouble(4); // Use getDouble for double fields
		 int Cid = rs.getInt(5); // Use getInt for integer fields
		 String Type = rs.getString(6); // Use getString for string fields
		 double amount = rs.getDouble(7); // Use getDouble for double fields
		 double remaining = Tot - amount;

		 OrdersC_data.add(new OrdersC(id, Cid, date, Type, Tot, discount, amount,remaining));		
	     //System.out.println("lkjfaof");		

	}	
	
	rs.close();
	stmt.close();
  

	dataList = FXCollections.observableArrayList(OrdersC_data);
	
	con.close();
	System.out.println("Connection closed " + data.size());
	
	return dataList;
}





public static void ExecuteStatement(String SQL) throws SQLException {

	try {
		
		System.out.println("trying man");
		Statement stmt = con.createStatement();
		System.out.println("fup man");
		stmt.executeUpdate(SQL);
		System.out.println("outsider");
		stmt.close();
	
		 
	}
	catch(SQLException s) {
		s.printStackTrace();
		System.out.println("SQL statement is not executed!");
		  
	}
	
	
}

public static int getnumorders() throws SQLException, ClassNotFoundException {
	
	
	
	String SQL = "Select Count(*) from salesOrder";
	connectDB();
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);
	int id = 0;
	
	while ( rs.next() ) {
		
		id = Integer.parseInt(rs.getString(1));	
			
	}
	con.close();
	return id;
	
}

public static int getnumcustomers() throws SQLException, ClassNotFoundException {
	
	
	
	String SQL = "Select Count(*) from client";
	connectDB();
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);
	int id = 0;
	
	while ( rs.next() ) {
		
		id = Integer.parseInt(rs.getString(1));	
			
	}
	con.close();
	return id;
	
}

public static int getnumcars() throws SQLException, ClassNotFoundException {
	
	
	
	String SQL = "Select Count(*) from vehicles";
	connectDB();
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);
	int id = 0;
	
	while ( rs.next() ) {
		
		id = Integer.parseInt(rs.getString(1));	
			
	}
	con.close();
	return id;
	
}

public static int getnumsuppliers() throws SQLException, ClassNotFoundException {
	
	
	
	String SQL = "Select Count(*) from suppliers";
	connectDB();
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);
	int id = 0;
	
	while ( rs.next() ) {
		
		id = Integer.parseInt(rs.getString(1));	
			
	}
	con.close();
	return id;
	
}

public static int getnumemps() throws SQLException, ClassNotFoundException {
	
	
	
	String SQL = "Select Count(*) from employee";
	connectDB();
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);
	int id = 0;
	
	while ( rs.next() ) {
		
		id = Integer.parseInt(rs.getString(1));	
			
	}
	con.close();
	return id;
	
}


public static int getnumdelivery() throws SQLException, ClassNotFoundException {
	
	
	
	String SQL = "SELECT COUNT(*) FROM deliveryOrder WHERE Orderstatus = 'In-delivery'";
	connectDB();
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);
	int id = 0;
	
	while ( rs.next() ) {
		
		id = Integer.parseInt(rs.getString(1));	
			
	}
	con.close();
	return id;
	
}

public static double gettodayincome() throws SQLException, ClassNotFoundException {
	
	
	
	LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String todayString = today.format(formatter);
    String SQL = "SELECT SUM(paidamount) FROM salesOrder WHERE date = ?";
	connectDB();
	
	double income = 0;
	
	try (PreparedStatement pstmt = con.prepareStatement(SQL)) {
        pstmt.setString(1, todayString);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            income =  rs.getDouble(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (con != null) {
            con.close();
        }
    }
    return income;
	
}







public static void insert_order (int id, LocalDate date, double discount, double totprice, int Customerid, String Paymenttype, double Paidamount) throws SQLException, ClassNotFoundException {

	  connectDB();
	  
	  
	  String sql = "INSERT INTO salesOrder (SOid, date, discount, totalPrice, Cid, Paytype, paidamount) VALUES (?, ?, ?, ?, ?, ?, ?)";

	  
      try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
          pstmt.setInt(1, id);
          pstmt.setDate(2, Date.valueOf(date));
          pstmt.setDouble(3, discount);
          pstmt.setDouble(4, totprice);
          pstmt.setInt(5, Customerid);
          pstmt.setString(6, Paymenttype);
          pstmt.setDouble(7, Paidamount);
          pstmt.executeUpdate();
      }
	  
}

public static void insert_orderline (int id, double price, double quantity, int productid, int Orderid) throws SQLException, ClassNotFoundException{
	
	
	  String sql = "INSERT INTO orderLines (OLid, price, quantity, Pid, Sales_Order_Id) VALUES (?, ?, ?, ?, ?)";
      
      try (PreparedStatement pstmt = con.prepareStatement(sql)) {
          pstmt.setInt(1, id);
          pstmt.setDouble(2, price);
          pstmt.setDouble(3, quantity);
          pstmt.setInt(4, productid);
          pstmt.setInt(5, Orderid);
          pstmt.executeUpdate();
      }
	
	
}

public static void insert_deliveryorder (int id, int driveid, int Carid, String Orderstatus, String OrderDistenation) throws SQLException, ClassNotFoundException{
		
    connectDB();
    String insertSQL = "INSERT INTO deliveryOrder (Orderid, Driverid, Carid, Orderstatus,OrderDistenation ) VALUES (?, ?, ?, ?,?)";
    try {
        con.setAutoCommit(false); // Disable auto-commit
        try (PreparedStatement insertStmt = con.prepareStatement(insertSQL)) {
            insertStmt.setInt(1, id);
            insertStmt.setInt(2, driveid);
            insertStmt.setInt(3, Carid);
            insertStmt.setString(4, Orderstatus);
            insertStmt.setString(5, OrderDistenation);
            insertStmt.executeUpdate();
            con.commit(); // Commit the transaction
        } catch (SQLException e) {
            con.rollback(); // Rollback in case of an error
            throw e;
        }
    } finally {
        con.setAutoCommit(true); // Restore auto-commit
    }
}

public static void insert_placeorder (int id, int Empid) throws SQLException, ClassNotFoundException{
	
  
	  connectDB();
      String checkOrderIdSQL = "SELECT 1 FROM salesOrder WHERE SOid = ?";

      try (PreparedStatement checkStmt = con.prepareStatement(checkOrderIdSQL)) {
          checkStmt.setInt(1, id);
          try (ResultSet rs = checkStmt.executeQuery()) {
              if (rs.next()) {
                  String insertSQL = "INSERT INTO inplaceorder (Orderid, Empid) VALUES (?, ?)";
                  try (PreparedStatement insertStmt = con.prepareStatement(insertSQL)) {
                      insertStmt.setInt(1, id);
                      insertStmt.setInt(2, Empid);
                      insertStmt.executeUpdate();
                  }
              } else {
                  System.out.println("Orderid " + id + " does not exist in salesOrder table.");
              }
          }
      }
	  
}

public static void commitTransaction() throws SQLException {
    System.out.println("Starting commitTransaction()");
    if (con != null && !con.isClosed()) {
        try {
            System.out.println("Attempting to commit transaction...");
            con.commit();
            System.out.println("Transaction committed successfully.");
        } catch (SQLException e) {
            System.out.println("Error during commit: " + e.getMessage());
            throw e;
        }
    } else {
        System.out.println("Connection is null or closed.");
    }
}

public static void rollbackTransaction() throws SQLException {
    System.out.println("Starting rollbackTransaction()");
    if (con != null && !con.isClosed()) {
        try {
            System.out.println("Attempting to rollback transaction...");
            con.rollback();
            System.out.println("Transaction rolled back successfully.");
        } catch (SQLException e) {
            System.out.println("Error during rollback: " + e.getMessage());
            throw e;
        }
    } else {
        System.out.println("Connection is null or closed.");
    }
}

public static void setAutoCommit(boolean autoCommit) throws SQLException {
    if (con != null && !con.isClosed()) {
        con.setAutoCommit(autoCommit);
    }
}



public static List<XYChart.Data<String, Number>> getDataFromDatabase(String tableName, String year, String month) throws ClassNotFoundException, SQLException {
	connectDB();
    List<XYChart.Data<String, Number>> data = new ArrayList<>();
    
    int daysInMonth = YearMonth.of(Integer.parseInt(year), Integer.parseInt(month)).lengthOfMonth();
    for (int day = 1; day <= daysInMonth; day++) {
        data.add(new XYChart.Data<>(String.format("%02d", day), 0));
    }
    
    String sql = "SELECT DAY(date), SUM(totalPrice) FROM " + tableName + " WHERE YEAR(date) = ? AND MONTH(date) = ? GROUP BY DAY(date)";
   
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setString(1, year);
        pstmt.setString(2, month);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int day = rs.getInt(1);
            double totalPrice = rs.getDouble(2);
            data.set(day - 1, new XYChart.Data<>(String.format("%02d", day), totalPrice));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return data;
}


public static void deleteVehicleRow(Products row) {
    // TODO Auto-generated method stub

    try {
        connectDB();
        ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
        ExecuteStatement("delete from  products where Pid="+row.getPid() + ";");
        ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
        con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
}
public static void insert_Product(int id, String name,double price,double quantity ) throws SQLException, ClassNotFoundException{


    connectDB();
    String SQL = "INSERT INTO products (pid, pname, price, quantity) VALUES ("+id+",'"+name+"',"+price+","+quantity+");";

        mySqlConnector.ExecuteStatement(con,SQL);
           con.close();


    }
public static ObservableList<Products> getProductsData() throws SQLException{
    String SQL = "select  pid,pname,quantity,price from  products  where  pid";

     try {
        connectDB();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 
     System.out.println("connection establish");

     ObservableList<Products> list =FXCollections.observableArrayList();

     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(SQL);

     while ( rs.next() ) {
            list.add(new Products(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getDouble(4)
                    ));
        }

     st.close();
     con.close();

     System.out.println("connection close "+list.size());

    return list;

}


}
