package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class mySqlConnect {
	
	private static String dbURL;
	private static String dbUsername = "root";
	private static String dbPassword = "123123";
	private static String URL = "127.0.0.1";
	private static String port = "3306";
	private static String dbName = "AlItqan";
	private static Connection con;
	
	Connection conn = null;
	private static void connectDB() throws ClassNotFoundException, SQLException {

		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection (dbURL, p);

		}
	
	public static ObservableList<vehicles> getDatavehicles() throws ClassNotFoundException, SQLException{
		
		ObservableList<vehicles> list;
		
		connectDB();
		System.out.println("Connection established");
		
		String SQL = "select * from vehicles order by Vid";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		list = FXCollections.observableArrayList();
		
		while(rs.next()) 
			list.add(new vehicles(Integer.parseInt(rs.getString("Vid")),rs.getString("model"),Integer.parseInt(rs.getString("yearOfProduction")),Integer.parseInt(rs.getString("capacity")),Integer.parseInt(rs.getString("numberOfOrders")),rs.getString("licensePlateNumber"),rs.getString("licenseExpiryDate"),Integer.parseInt(rs.getString("Eid"))));
		
		rs.close();
		stmt.close();
		
		con.close();
		System.out.println("Connection closed " + list.size());
		
		return list;
	}
public static ObservableList<vehicles> getDatavehicles(String SQL) throws ClassNotFoundException, SQLException{
		
		ObservableList<vehicles> list;
		
		connectDB();
		System.out.println("Connection established");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		list = FXCollections.observableArrayList();
		
		
		while(rs.next()) 
			list.add(new vehicles(Integer.parseInt(rs.getString("Vid")),rs.getString("model"),Integer.parseInt(rs.getString("yearOfProduction")),Integer.parseInt(rs.getString("capacity")),Integer.parseInt(rs.getString("numberOfOrders")),rs.getString("licensePlateNumber"),rs.getString("licenseExpiryDate"),Integer.parseInt(rs.getString("Eid"))));
		
		rs.close();
		stmt.close();
		
		
		con.close();
		System.out.println("Connection closed " + list.size());
		
		return list;
	}
	 public static ObservableList<Integer> getManagerIds() throws ClassNotFoundException, SQLException {
	        ObservableList<Integer> managerIds = FXCollections.observableArrayList();

	        connectDB();
	        System.out.println("Connection established");

	        String SQL = "SELECT Eid FROM employee WHERE jobType = 'Manager'";
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(SQL);

	        while (rs.next()) {
	            managerIds.add(rs.getInt("Eid"));
	        }

	        rs.close();
	        stmt.close();
	        con.close();
	        System.out.println("Connection closed.");

	        return managerIds;
	    }
	 public static ObservableList<Integer> getEmployeeIds() throws ClassNotFoundException, SQLException {
	        ObservableList<Integer> EmployeeIds = FXCollections.observableArrayList();

	        connectDB();
	        System.out.println("Connection established");

	        String SQL = "SELECT Eid FROM employee WHERE jobType = 'Driver'";
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(SQL);

	        while (rs.next()) {
	        	EmployeeIds.add(rs.getInt("Eid"));
	        }

	        rs.close();
	        stmt.close();
	        con.close();
	        System.out.println("Connection closed.");

	        return EmployeeIds;
	    }
	public static void  ExecuteStatement(String SQL) throws SQLException {

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();
		
			 
		}
		catch(SQLException s) {
			s.printStackTrace();
			System.out.println("SQL statement is not executed!");
			  
		}
		
	}
	
	public static void  insertVehiclesData(vehicles rc) throws SQLException{
		
		
				System.out.println("Insert into vehicles (Vid, model, yearOfProduction, capacity, licensePlateNumber, licenseExpiryDate, Eid) values("+
							rc.getVid()+",'"
							+rc.getModel()+"',"
							+ rc.getYearOfProduction() +","
							+ rc.getCapacity()+", '"
							+ rc.getLicensePlateNumber()+"', '"	
							+ rc.getLicenseExpiryDate()+"',"
							+ rc.getEid()+
						    ")");
				try {
					connectDB();
				}catch(Exception e) {
					
				}
					ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
					ExecuteStatement("Insert into vehicles (Vid, model, yearOfProduction, capacity, licensePlateNumber, licenseExpiryDate, Eid) values("+
							rc.getVid()+",'"
							+rc.getModel()+"',"
							+ rc.getYearOfProduction() +","
							+ rc.getCapacity()+", '"
							+ rc.getLicensePlateNumber()+"', '"	
							+ rc.getLicenseExpiryDate()+"',"
							+ rc.getEid()+
						    ")");
					ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
					con.close();
					try {
						connectDB();
					}catch(Exception e) {
						
					}
					ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
					ExecuteStatement("Insert into drive (Vid, Eid) values("+
							rc.getVid()+","
							+ rc.getEid()+
						    ")");
					ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
					con.close();
				
				
				
		}
	
	public static void  updateVehicleModel(int Vid, String model) {
		
		try {
			System.out.println("update  vehicles set model = '"+model + "' where Vid = "+Vid);
			connectDB();
			ExecuteStatement("update  vehicles set model = '"+model + "' where Vid = "+Vid+";");
			con.close();
			System.out.println("Connection closed.");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	public static void  updateVehicleYOF(int Vid, int yearOfProduction) {
		
		try {
			System.out.println("update  vehicles set yearOfProduction = "+yearOfProduction + " where Vid = "+Vid);
			connectDB();
			ExecuteStatement("update  vehicles set yearOfProduction = "+yearOfProduction + " where Vid = "+Vid+";");
			con.close();
			System.out.println("Connection closed.");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
public static void  updateVehicleNOO(int Vid, int numberOfOrders) {
		
		try {
			System.out.println("update  vehicles set numberOfOrders = "+numberOfOrders + " where Vid = "+Vid);
			connectDB();
			ExecuteStatement("update  vehicles set numberOfOrders = "+numberOfOrders + " where Vid = "+Vid+";");
			con.close();
			System.out.println("Connection closed.");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	public static void  updateVehicleCapacity(int Vid, int capacity) {
		
		try {
			System.out.println("update  vehicles set capacity = "+capacity + " where Vid = "+Vid);
			connectDB();
			ExecuteStatement("update  vehicles set capacity = "+capacity + " where Vid = "+Vid+";");
			con.close();
			System.out.println("Connection closed.");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	public static void  updateVehicleLPN(int Vid, String licensePlateNumber) {
		
		try {
			System.out.println("update  vehicles set licensePlateNumber = '"+licensePlateNumber + "' where Vid = "+Vid);
			connectDB();
			ExecuteStatement("update  vehicles set licensePlateNumber = '"+licensePlateNumber + "' where Vid = "+Vid+";");
			con.close();
			System.out.println("Connection closed.");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	public static void updateVehicleLED(int Vid, String licenseExpiryDate) {
		
		try {
			System.out.println("update  vehicles set licenseExpiryDate = '"+licenseExpiryDate + "' where Vid = "+Vid);
			connectDB();
			ExecuteStatement("update  vehicles set licenseExpiryDate = '"+licenseExpiryDate + "' where Vid = "+Vid+";");
			con.close();
			System.out.println("Connection closed.");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	/* Update Eid? */
public static void  updateVehicleEid(int Vid, int Eid) {
		
		try {
			System.out.println("update  vehicles set Eid = "+Eid + " where Vid = "+Vid);
			connectDB();
			ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
			ExecuteStatement("update  vehicles set Eid = "+Eid + " where Vid = "+Vid+";");
			ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
			con.close();
			System.out.println("Connection closed.");
			connectDB();
			ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
			ExecuteStatement("update  drive set Eid = "+Eid + " where Vid = "+Vid+";");
			ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
			con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	public static void deleteVehicleRow(vehicles row) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("delete from  vehicles where Vid="+row.getVid() + ";");
			connectDB();
			ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
			ExecuteStatement("delete from  vehicles where Vid="+row.getVid() + ";");
			ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
			con.close();
			System.out.println("Connection closed");
			connectDB();
			ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
			ExecuteStatement("delete from  drive where Vid="+row.getVid() + ";");
			ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
			con.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
    /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
    /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
    /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
    /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
    /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
	// Suppliers methods
public static ObservableList<suppliers> getDataSuppliers() throws ClassNotFoundException, SQLException{
		
		ObservableList<suppliers> list;
		
		connectDB();
		System.out.println("Connection established");
		
		String SQL = "select * from suppliers order by Sid";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		list = FXCollections.observableArrayList();
		
		while(rs.next()) 
			list.add(new suppliers(Integer.parseInt(rs.getString("Sid")),rs.getString("name"),rs.getString("address")));
		
		rs.close();
		stmt.close();
		
		con.close();
		System.out.println("Connection closed " + list.size());
		
		return list;
	}
public static ObservableList<suppliers> getDataSuppliers(String SQL) throws ClassNotFoundException, SQLException{
	
	ObservableList<suppliers> list;
	
	connectDB();
	System.out.println("Connection established");
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);

	list = FXCollections.observableArrayList();
	
	while(rs.next()) 
		list.add(new suppliers(Integer.parseInt(rs.getString("Sid")),rs.getString("name"),rs.getString("address")));
	
	rs.close();
	stmt.close();
	
	con.close();
	System.out.println("Connection closed " + list.size());
	
	return list;
}
public static ObservableList<suppliers> getPhoneDataSuppliers() throws ClassNotFoundException, SQLException{
	
	ObservableList<suppliers> list;
	
	connectDB();
	System.out.println("Connection established");
	
	String SQL = "select * from Suppliersphone order by Sid";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);
	list = FXCollections.observableArrayList();
	
	while(rs.next()) 
		list.add(new suppliers(Integer.parseInt(rs.getString("Sid")),rs.getString("phoneNumber")));
	
	rs.close();
	stmt.close();
	
	con.close();
	System.out.println("Connection closed " + list.size());
	 
	        System.out.println("For-each loop:");
	        for (suppliers item : list) 
	            System.out.println(item);
	
	return list;
}
public static ObservableList<suppliers> getPhoneDataSuppliers(String SQL) throws ClassNotFoundException, SQLException{
	
	ObservableList<suppliers> list;
	
	connectDB();
	System.out.println("Connection established");
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);
	list = FXCollections.observableArrayList();
	
	while(rs.next()) 
		list.add(new suppliers(Integer.parseInt(rs.getString("Sid")),rs.getString("phoneNumber")));
	
	rs.close();
	stmt.close();
	
	con.close();
	System.out.println("Connection closed " + list.size());
	
	return list;
}
public static void  insertSupplierData(suppliers rc, int flag) throws SQLException, ClassNotFoundException{
	
	if (flag == 0) {
		System.out.println("Insert into suppliers (Sid, name, address) values("+
				rc.getSid()+",'"
				+rc.getName()+"','"
				+ rc.getAddress() +
			    "')");
	try {
		connectDB();
	}catch(Exception e) {
		
	}
		ExecuteStatement("Insert into suppliers (Sid, name, address) values("+
				rc.getSid()+",'"
				+rc.getName()+"','"
				+ rc.getAddress()
				+
			    "')");
		con.close();
		try {
			connectDB();
		}catch(Exception e) {
			
		}
		ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
		ExecuteStatement("Insert into Suppliersphone (Sid, phoneNumber) values("+
				rc.getSid()+",'"
				+ rc.getPhoneNumber()+
			    "')");
		ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
		con.close();
	}
	else if(flag == 1) {
		try {
			connectDB();
		}catch(Exception e) {
			
		}
		ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
		ExecuteStatement("Insert into Suppliersphone (Sid, phoneNumber) values("+
				rc.getSid()+",'"
				+ rc.getPhoneNumber()+
			    "')");
		ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
		con.close();
	}
}

public static void  updateSupplierName(int Sid, String name) {

try {
System.out.println("update  suppliers set name = '"+name + "' where Sid = "+Sid);
connectDB();
ExecuteStatement("update  suppliers set name = '"+name + "' where Sid = "+Sid+";");
con.close();
System.out.println("Connection closed.");

} catch (SQLException e) {
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
}

public static void  updateSupplierAddress(int Sid, String address) {

try {
System.out.println("update  suppliers set address = "+address + " where Sid = "+Sid);
connectDB();
ExecuteStatement("update  suppliers set address = "+address + " where Sid = "+Sid+";");
con.close();
System.out.println("Connection closed.");

} catch (SQLException e) {
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
}

public static void  updateSupplierPhoneNumber(int Sid, String phoneNumber) {

try {
System.out.println("update  Suppliersphone set phoneNumber = "+phoneNumber + " where Sid = "+Sid);
connectDB();
ExecuteStatement("update  Suppliersphone set phoneNumber = "+phoneNumber + " where Sid = "+Sid+";");
con.close();
System.out.println("Connection closed.");

} catch (SQLException e) {
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
}
public static void deleteSupplierRow(suppliers row) {
	// TODO Auto-generated method stub
	
	try {
		System.out.println("delete from  suppliers where Sid="+row.getSid() + ";");
		connectDB();
		ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
		ExecuteStatement("delete from  suppliers where Sid="+row.getSid() + ";");
		ExecuteStatement("delete from  Suppliersphone where Sid="+row.getSid() + ";");
		ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
		con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
}
public static void deleteSupplierPhonesNumberRow(suppliers row) {
	// TODO Auto-generated method stub
	
	try {
		connectDB();
		ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
		ExecuteStatement("delete from  Suppliersphone where Sid='"+row.getPhoneNumber() + "';");
		ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
		con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
}
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
// Departments methods

public static ObservableList<departments> getDataDepartments() throws ClassNotFoundException, SQLException{
	
	ObservableList<departments> list;
	
	connectDB();
	System.out.println("Connection established");
	
	String SQL = "select * from department order by Did";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);
	list = FXCollections.observableArrayList();
	
	
	while(rs.next()) 
		list.add(new departments(Integer.parseInt(rs.getString("Did")),rs.getString("name"),Integer.parseInt(rs.getString("numberOfEmployees")), Integer.parseInt(rs.getString("Eid"))));
	
	rs.close();
	stmt.close();
	
	
	con.close();
	System.out.println("Connection closed " + list.size());
	
	return list;
}
public static void  updateDepartmentName(int Did, String name) {
	
	try {
		System.out.println("update  department set name = '"+name + "' where Did = "+Did);
		connectDB();
		ExecuteStatement("update  department set name = '"+name + "' where Did = "+Did+";");
		con.close();
		System.out.println("Connection closed.");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
}

public static void  updateDepartmentNOE(int Did, int numberOfEmployees) {
	
	try {
		System.out.println("update  department set numberOfEmployees = "+numberOfEmployees + " where Did = "+Did);
		connectDB();
		ExecuteStatement("update  department set numberOfEmployees = "+numberOfEmployees + " where Did = "+Did+";");
		con.close();
		System.out.println("Connection closed.");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
}
public static void  updateDepartmentEid(int Did, int Eid) {
	
	try {
		System.out.println("update  department set Eid = "+Eid + " where Did = "+Did);
		connectDB();
		ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
		ExecuteStatement("update  department set Eid = "+Eid + " where Did = "+Did+";");
		ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
		con.close();
		System.out.println("Connection closed.");
		connectDB();
		ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
		ExecuteStatement("update  workFor set Eid = "+Eid + " where Did = "+Did+";");
		ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
}

public static void deleteDepartmentRow(departments row) {
	// TODO Auto-generated method stub
	
	try {
		System.out.println("delete from  department where Did="+row.getDid() + ";");
		connectDB();
		ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
		ExecuteStatement("delete from  department where Did="+row.getDid() + ";");
		ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
		con.close();
		System.out.println("Connection closed");
		connectDB();
		ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
		ExecuteStatement("delete from  workFor where Did="+row.getDid() + ";");
		ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
		con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
}

/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
// Employees methods
public static ObservableList<employees> getDataEmployees() throws ClassNotFoundException, SQLException{
	
	ObservableList<employees> list;
	connectDB();
	System.out.println("Connection established");
	String SQL = "select * from employee order by Eid";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);
	list = FXCollections.observableArrayList();
	while(rs.next()) 
		list.add(new employees(Integer.parseInt(rs.getString("Eid")),rs.getString("name"),rs.getString("address"),Integer.parseInt(rs.getString("salary")),rs.getString("jobType"), Integer.parseInt(rs.getString("Did")),Integer.parseInt(rs.getString("Wid")), rs.getString("pass")));
	
	
	con.close();
	System.out.println("Connection closed " + list.size());
	
	return list;
}
public static ObservableList<employees> getDataEmployees(String SQL) throws ClassNotFoundException, SQLException{
	
	ObservableList<employees> list;
	connectDB();
	System.out.println("Connection established");
	//String SQL = "select * from employee order by Eid";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(SQL);
	list = FXCollections.observableArrayList();
	while(rs.next()) 
		list.add(new employees(Integer.parseInt(rs.getString("Eid")),rs.getString("name"),rs.getString("address"),Integer.parseInt(rs.getString("salary")),rs.getString("jobType"), Integer.parseInt(rs.getString("Did")),Integer.parseInt(rs.getString("Wid")), rs.getString("pass")));
	
	
	con.close();
	System.out.println("Connection closed " + list.size());
	
	return list;
}
public static ObservableList<employeesPhones> getPhoneDataEmployees() throws ClassNotFoundException, SQLException{

ObservableList<employeesPhones> list;

connectDB();
System.out.println("Connection established");
String SQL = "select * from Employeephone order by Eid";
Statement stmt = con.createStatement();
ResultSet rs= stmt.executeQuery(SQL);
list = FXCollections.observableArrayList();
while(rs.next()) 
	list.add(new employeesPhones(Integer.parseInt(rs.getString("Eid")), rs.getString("phoneNumber")));

con.close();
System.out.println("Connection closed " + list.size());

return list;
}
public static ObservableList<employeesPhones> getPhoneDataEmployees(String SQL) throws ClassNotFoundException, SQLException{

ObservableList<employeesPhones> list;

connectDB();
System.out.println("Connection established");
Statement stmt = con.createStatement();
ResultSet rs= stmt.executeQuery(SQL);
list = FXCollections.observableArrayList();
while(rs.next()) 
	list.add(new employeesPhones(Integer.parseInt(rs.getString("Eid")), rs.getString("phoneNumber")));

con.close();
System.out.println("Connection closed " + list.size());

return list;
}
public static void  insertEmployeeData(employees rc) throws SQLException, ClassNotFoundException{

	System.out.println("Insert into employee (Eid, name, address, salary, jobType, Did, Wid, pass) values("+
			rc.getEid()+",'"
			+rc.getName()+"','"
			+ rc.getAddress() + "', "
		    + rc.getSalary()+ ",'" 
			+ rc.getJobType()+"',"
			+ rc. getDid()+ ", "
			+ rc.getWid()+",'"
			+ rc.getPass()+"')");
	try {
	connectDB();
}catch(Exception e) {
	
}
	ExecuteStatement("Insert into employee (Eid, name, address, salary, jobType, Did, Wid, pass) values("+
			rc.getEid()+",'"
			+rc.getName()+"','"
			+ rc.getAddress() + "', "
		    + rc.getSalary()+ ",'" 
			+ rc.getJobType()+"',"
			+ rc. getDid()+ ", "
			+ rc.getWid()+",'"
			+ rc.getPass()+"')");
	con.close();
	System.out.println("Connection closed");
	
	con.close();
}
public static void  insertEmployeePhoneData(employeesPhones rc) throws SQLException, ClassNotFoundException{

	System.out.println("Insert into EmployeePhone (Eid, phoneNumber) values("+
			rc.getEid()+",'"
			+rc.getPhoneNumber()+"')");
	try {
	connectDB();
}catch(Exception e) {
	
}
	ExecuteStatement("Insert into EmployeePhone (Eid, phoneNumber) values("+
			rc.getEid()+",'"
			+rc.getPhoneNumber()+"')");
	con.close();
	System.out.println("Connection closed");
	
	con.close();
}

public static void  updateEmployeeName(int Eid, String name) {

try {
System.out.println("update  employee set name = '"+name + "' where Eid = "+Eid);
connectDB();
ExecuteStatement("update  employee set name = '"+name + "' where Eid = "+Eid+";");
con.close();
System.out.println("Connection closed.");

} catch (SQLException e) {
e.printStackTrace();
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
}

public static void  updateEmployeeAddress(int Eid, String address) {

try {
System.out.println("update  employee set address = '"+address + "' where Eid = "+Eid);
connectDB();
ExecuteStatement("update  employee set address = '"+address + "' where Eid = "+Eid+";");
con.close();
System.out.println("Connection closed.");

} catch (SQLException e) {
e.printStackTrace();
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
}

public static void  updateEmployeeSalary(int Eid, int salary) {

try {
System.out.println("update  employee set salary = "+salary + " where Eid = "+Eid);
connectDB();
ExecuteStatement("update  employee set salary = "+salary + " where Eid = "+Eid+";");
con.close();
System.out.println("Connection closed.");

} catch (SQLException e) {
e.printStackTrace();
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
}
public static void  updateEmployeeJobType(int Eid, String jobType) {

try {
System.out.println("update  employee set jobType = '"+jobType + "' where Eid = "+Eid);
connectDB();
ExecuteStatement("update  employee set jobType = '"+jobType + "' where Eid = "+Eid+";");
con.close();
System.out.println("Connection closed.");

} catch (SQLException e) {
e.printStackTrace();
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
}
public static void  updateEmployeePass(int Eid, String pass) {

try {
connectDB();
ExecuteStatement("update  employee set pass = '"+pass + "' where Eid = "+Eid+";");
con.close();

} catch (SQLException e) {
e.printStackTrace();
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
}
public static void  updateEmployeeDid(int Eid, int Did) {

try {
connectDB();
ExecuteStatement("update  employee set Did = "+Did + " where Eid = "+Eid+";");
con.close();

} catch (SQLException e) {
e.printStackTrace();
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
}
public static void  updateEmployeeWid(int Eid, int Wid) {

try {
connectDB();
ExecuteStatement("update  employee set Wid = "+Wid + " where Eid = "+Eid+";");
con.close();

} catch (SQLException e) {
e.printStackTrace();
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
}
public static void  updateEmployeePhoneNumber(int Eid, String phoneNumber) {

try {
connectDB();
ExecuteStatement("update  EmployeePhone set phoneNumber = '"+phoneNumber + "' where Eid = "+Eid+";");
con.close();

} catch (SQLException e) {
e.printStackTrace();
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
}
public static void deleteEmployeeRow(employees row) {
// TODO Auto-generated method stub

try {
	connectDB();
	ExecuteStatement("set FOREIGN_KEY_CHECKS=0;");
	ExecuteStatement("delete from  employee where Eid="+row.getEid() + ";");
	ExecuteStatement("set FOREIGN_KEY_CHECKS=1;");
	con.close();
	
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
public static void deleteEmployeePhonesNumberRow(employeesPhones row) {
// TODO Auto-generated method stub

try {
	connectDB();
	ExecuteStatement("delete from  EmployeePhone where Eid="+row.getEid() + ";");
	con.close();
	
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
}


















