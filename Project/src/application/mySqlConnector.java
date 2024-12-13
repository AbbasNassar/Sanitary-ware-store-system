package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class mySqlConnector {

	private static String dbURL;
	private static String dbUsername = "root";
	private static String dbPassword = "123123";
	private static String URL = "127.0.0.1";
	private static String port = "3306";
	private static String dbName = "AlItqan";
	private static Connection con;
	
	
	public static Connection connectDB() throws ClassNotFoundException, SQLException {
		
		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection (dbURL, p);
		return con;

	}
	
	public static void ExecuteStatement(Connection con,String SQL) throws SQLException {

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();
		
			 
		}
		catch(Exception s) {
			s.printStackTrace();
			System.out.println("SQL statement is not executed!");
			  
		}
	}
	

	public static ObservableList<client> getclientData() throws SQLException{
		String SQL = "select cid,`name`,address, payment_method from `client` order by cid";

		Connection conn;
		 try {
			conn = connectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 System.out.println("connection establish");
		 
		 ObservableList<client> list =FXCollections.observableArrayList();
		 
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(SQL);
		 
		 while ( rs.next() ) {
				list.add(new client(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
						));
			}
			
		 st.close();
		 con.close();
		 
		 System.out.println("connection close "+list.size());
		 
		return list;

	}
	
	public static ObservableList<client> getclientData(String SQL) throws SQLException{

		Connection conn;
		 try {
			conn = connectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 System.out.println("connection establish");
		 
		 ObservableList<client> list =FXCollections.observableArrayList();
		 
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(SQL);
		 
		 while ( rs.next() ) {
				list.add(new client(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
						));
			}
			
		 st.close();
		 con.close();
		 
		 System.out.println("connection close "+list.size());
		 
		return list;

	}
	
	public static ObservableList<allInformationForClient> getAllInfo() throws SQLException{
		String SQL = "select c.cid,c.name,s.date,p.Pname,o.quantity,p.price,s.totalPrice,o.discount\r\n"
				+ "from client c,salesorder s ,orderlines o, products p\r\n"
				+ "where c.cid = s.cid and s.soid = o.soid and o.Pid = p.Pid;";

		Connection conn;
		 try {
			conn = connectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 System.out.println("connection establish");
		 
		 ObservableList<allInformationForClient> list =FXCollections.observableArrayList();
		 
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(SQL);
		 
		 while ( rs.next() ) {
				list.add(new allInformationForClient(
						rs.getInt(1),
						rs.getString(2),
						rs.getDate(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getFloat(6),
						rs.getFloat(7),
						rs.getFloat(8)
						));
			}
			
		 st.close();
		 con.close();
		 
		 System.out.println("connection close "+list.size());
		 
		return list;

	}
	
	public static ObservableList<allInformationForClient> getAllInfo(String SQL) throws SQLException{
		

		Connection conn;
		 try {
			conn = connectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 System.out.println("connection establish");
		 
		 ObservableList<allInformationForClient> list =FXCollections.observableArrayList();
		 
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(SQL);
		 
		 while ( rs.next() ) {
				list.add(new allInformationForClient(
						rs.getInt(1),
						rs.getString(2),
						rs.getDate(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getFloat(6),
						rs.getFloat(7),
						rs.getFloat(8)
						));
			}
			
		 st.close();
		 con.close();
		 
		 System.out.println("connection close "+list.size());
		 
		return list;

	}
	
	
	public static ObservableList<clientPhone> getclientPhone() throws SQLException{
		String SQL = "select cid, phoneNumber from clientPhone order by cid";

		Connection conn;
		 try {
			conn = connectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 System.out.println("connection establish");
		 
		 ObservableList<clientPhone> list =FXCollections.observableArrayList();
		 
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(SQL);
		 
		 while ( rs.next() ) {
				list.add(new clientPhone(
						rs.getInt(1),
						rs.getString(2)
						));
			}
			
		 st.close();
		 con.close();
		 
		 System.out.println("connection close "+list.size());
		 
		return list;

	}
	
	public static ObservableList<clientPhone> getclientPhone(String SQL) throws SQLException{

		Connection conn;
		 try {
			conn = connectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 System.out.println("connection establish");
		 
		 ObservableList<clientPhone> list =FXCollections.observableArrayList();
		 
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(SQL);
		 
		 while ( rs.next() ) {
				list.add(new clientPhone(
						rs.getInt(1),
						rs.getString(2)
						));
			}
			
		 st.close();
		 con.close();
		 
		 System.out.println("connection close "+list.size());
		 
		return list;

	}
	
	public static ObservableList<warehouse> getWarehousesData() throws SQLException{
		String SQL = "select wid,capacity,location, numberOfEmployees from `warehouses` order by wid";

		Connection conn;
		 try {
			conn = connectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 System.out.println("connection establish");
		 
		 ObservableList<warehouse> list =FXCollections.observableArrayList();
		 
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(SQL);
		 
		 while ( rs.next() ) {
				list.add(new warehouse(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getInt(4)
						));
			}
			
		 st.close();
		 con.close();
		 
		 System.out.println("connection close "+list.size());
		 
		return list;

	}
	
	public static ObservableList<warehouseEmployees> getWarehousesEmplyeesData() throws SQLException{
		String SQL = "select  eid,name from  employee  where Wid !=0 order by wid";

		Connection conn;
		 try {
			conn = connectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 System.out.println("connection establish");
		 
		 ObservableList<warehouseEmployees> list =FXCollections.observableArrayList();
		 
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(SQL);
		 
		 while ( rs.next() ) {
				list.add(new warehouseEmployees(
						rs.getInt(1),
						rs.getString(2)
						));
			}
			
		 st.close();
		 con.close();
		 
		 System.out.println("connection close "+list.size());
		 
		return list;

	}
	
	public static ObservableList<warehouseEmployees> getWarehousesEmplyeesData(String SQL) throws SQLException{

		Connection conn;
		 try {
			conn = connectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 System.out.println("connection establish");
		 
		 ObservableList<warehouseEmployees> list =FXCollections.observableArrayList();
		 
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(SQL);
		 
		 while ( rs.next() ) {
				list.add(new warehouseEmployees(
						rs.getInt(1),
						rs.getString(2)
						));
			}
			
		 st.close();
		 con.close();
		 
		 System.out.println("connection close "+list.size());
		 
		return list;

	}
	
	public static ObservableList<departments> getDataDepartments() throws ClassNotFoundException, SQLException{
		
		ObservableList<departments> list=FXCollections.observableArrayList();
		
		connectDB();
		System.out.println("Connection established");
		
		String SQL = "select * from department order by Did";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		
		
		while(rs.next()) 
			list.add(new departments(Integer.parseInt(rs.getString("Did")),rs.getString("name"),Integer.parseInt(rs.getString("numberOfEmployees")), Integer.parseInt(rs.getString("Eid"))));
		
		rs.close();
		stmt.close();
		
		
		con.close();
		System.out.println("Connection closed " + list.size());
		
		return list;
	}


	public static ObservableList<departmentEmployees> getDepartmentsEmplyeesData() throws SQLException{
		String SQL = "select  eid,name from  employee  where did !=0 order by did";

		Connection conn;
		 try {
			conn = connectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 System.out.println("connection establish");
		 
		 ObservableList<departmentEmployees> list =FXCollections.observableArrayList();
		 
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(SQL);
		 
		 while ( rs.next() ) {
				list.add(new departmentEmployees(
						rs.getInt(1),
						rs.getString(2)
						));
			}
			
		 st.close();
		 con.close();
		 
		 System.out.println("connection close "+list.size());
		 
		return list;

	}
	
	public static ObservableList<departmentEmployees> getDepartmentsEmplyeesData(String SQL) throws SQLException{

		Connection conn;
		 try {
			conn = connectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 System.out.println("connection establish");
		 
		 ObservableList<departmentEmployees> list =FXCollections.observableArrayList();
		 
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(SQL);
		 
		 while ( rs.next() ) {
				list.add(new departmentEmployees(
						rs.getInt(1),
						rs.getString(2)
						));
			}
			
		 st.close();
		 con.close();
		 
		 System.out.println("connection close "+list.size());
		 
		return list;

	}


	
	
}
