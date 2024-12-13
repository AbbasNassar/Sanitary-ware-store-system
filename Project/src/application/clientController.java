package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class clientController implements Initializable{
	Connection con = null;

    
    @FXML
    private Button AddButton;
    
    @FXML
    private AnchorPane addClientPane;
    

    @FXML
    private TextField clientIDData;

    @FXML
    private TextField clientNameData;
    
    @FXML
    private TextField clientPaymentData;
    
    @FXML
    private TextField clientAddressData;
    
    @FXML
    private TextField clientPhoneData;
    
    @FXML
    private Button dashBoardButton;
    
    @FXML
    private TableView<clientPhone> clientPhoneTable;
    
    @FXML
    private TableColumn<clientPhone, Integer> cid2Col;
    
    @FXML
    private TableColumn<clientPhone, String> phoneCol;
    
    
    
 @FXML
    private Button clientsButton;
 
 @FXML
 private Button warehousesButton;
 
 
 @FXML
 private Button departmentsButton;
 

 @FXML
 private Button suppliersButton;

 @FXML
 private Button vehiclesButton;
 

 @FXML
 private Button ordersButton;

 @FXML
 private Button productsButton;
 
 @FXML
 private Button employeesButton;
 
 @FXML
 private Button exitButton;



 
 

 @FXML
 private AnchorPane clientPane1;

    @FXML
    private TableView<client> clientTable;
    
    @FXML
    private TableColumn<client, String> addressCol;

    @FXML
    private TableColumn<client, Integer> cidCol;
    
    @FXML
    private TableColumn<client, String> nameCol;

    @FXML
    private TableColumn<client, String> paymentCol;

    
    @FXML
    private TextField searchField;
   
    @FXML
    private ComboBox<String> searchBox;
    
    @FXML
    private TableView<allInformationForClient> client3Table;
    
    @FXML
    private TableColumn<allInformationForClient, Integer> cid3Col;
    
    @FXML
    private TableColumn<allInformationForClient, Float> price3Col;

    @FXML
    private TableColumn<allInformationForClient, String> product3Col;

    @FXML
    private TableColumn<allInformationForClient, Integer> quantity3Col;
    
    @FXML
    private TableColumn<allInformationForClient, Float> total3Col;
    
    @FXML
    private TableColumn<allInformationForClient, Float> discount3Col;

    @FXML
    private TableColumn<allInformationForClient, String> name3Col;
    

    @FXML
    private TableColumn<allInformationForClient, Date> date3Col;
    
    @FXML
    private TextField clientIDData1;
    

    @FXML
    private TextField clientPhoneData1;
	
	
	ObservableList<client> listc;
	ObservableList<clientPhone> listc2;
	ObservableList<allInformationForClient> listc3;

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		searchBox.setItems(FXCollections.observableArrayList("cid", "name", "address","payment_method"));
		searchBox.getSelectionModel().select(1);
		
		cidCol.setCellValueFactory(new PropertyValueFactory<client, Integer>("cid"));
		
        nameCol.setCellValueFactory(new PropertyValueFactory<client, String>("name"));
        
        nameCol.setCellFactory(TextFieldTableCell.<client>forTableColumn());

        

        addressCol.setCellValueFactory(new PropertyValueFactory<client, String>("address"));
        addressCol.setCellFactory(TextFieldTableCell.<client>forTableColumn());


        paymentCol.setCellValueFactory(new PropertyValueFactory<client, String>("payment_method"));
        paymentCol.setCellFactory(TextFieldTableCell.<client>forTableColumn());
        
        cid2Col.setCellValueFactory(new PropertyValueFactory<clientPhone, Integer>("cid"));
        
        phoneCol.setCellValueFactory(new PropertyValueFactory<clientPhone, String>("PhoneNumber"));
        phoneCol.setCellFactory(TextFieldTableCell.<clientPhone>forTableColumn());

        
        nameCol.setOnEditCommit(
        		(CellEditEvent<client, String> t) -> {
                       ((client) t.getTableView().getItems().get(
        	                        t.getTablePosition().getRow())
        	                        ).setName(t.getNewValue()); //display only
                 updateName( t.getRowValue().getCid(),t.getNewValue());
        		});

        addressCol.setOnEditCommit(
         		(CellEditEvent<client, String> t) -> {
                        ((client) t.getTableView().getItems().get(
         	                        t.getTablePosition().getRow())
         	                        ).setAddress(t.getNewValue()); //display only
                  updateAddress( t.getRowValue().getCid(),t.getNewValue());
         		});
        
  phoneCol.setOnEditCommit(        
        		
        		(CellEditEvent<clientPhone, String> t) -> {
        			String oldValue = t.getOldValue();
                       ((clientPhone) t.getTableView().getItems().get(
        	                        t.getTablePosition().getRow())
        	                        ).setPhoneNumber(t.getNewValue());
                 updatePhone( oldValue,t.getNewValue());
        		});
        
        paymentCol.setOnEditCommit(        
        		(CellEditEvent<client, String> t) -> {
                       ((client) t.getTableView().getItems().get(
        	                        t.getTablePosition().getRow())
        	                        ).setPayment_method(t.getNewValue());
                 updatePayment_method( t.getRowValue().getCid(),t.getNewValue());
        		});
        
        
      
        
        cid3Col.setCellValueFactory(new PropertyValueFactory<allInformationForClient, Integer>("cid"));
        name3Col.setCellValueFactory(new PropertyValueFactory<allInformationForClient, String>("name"));
        date3Col.setCellValueFactory(new PropertyValueFactory<allInformationForClient, Date>("date"));
        product3Col.setCellValueFactory(new PropertyValueFactory<allInformationForClient, String>("Pname"));
        quantity3Col.setCellValueFactory(new PropertyValueFactory<allInformationForClient, Integer>("quantity"));
        price3Col.setCellValueFactory(new PropertyValueFactory<allInformationForClient, Float>("price"));
        total3Col.setCellValueFactory(new PropertyValueFactory<allInformationForClient, Float>("total"));
        discount3Col.setCellValueFactory(new PropertyValueFactory<allInformationForClient, Float>("discount"));


        
		try {
			
			listc = mySqlConnector.getclientData();
			listc2 = mySqlConnector.getclientPhone();
			listc3 = mySqlConnector.getAllInfo();


		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		clientTable.setItems(listc);
		clientPhoneTable.setItems(listc2);
		client3Table.setItems(listc3);
		
	}
	


		
	  @FXML
	    void search(KeyEvent  event) throws ClassNotFoundException, SQLException {
		   String choose = null;
		   
		   choose = searchBox.getValue();
		   listc = mySqlConnector.getclientData("select * from client where "+ choose + " like'"+searchField.getText()+"%';");
		   listc2 = mySqlConnector.getclientPhone("select c.cid, p.PhoneNumber from client c,clientPhone p where c.cid = p.cid and c."+ choose + " like'"+searchField.getText()+"%';");

		   listc3 = mySqlConnector.getAllInfo("select c.cid as cid,c.name,s.date,p.Pname,o.quantity,p.price,s.totalPrice,o.discount\r\n"
					+ "from client c,salesorder s ,orderlines o, products p\r\n"
					+ "where c.cid = s.cid and s.soid = o.soid and o.Pid = p.Pid and c."+choose+" like '"+searchField.getText()+"%';");

		   clientTable.setItems(listc);
		   clientPhoneTable.setItems(listc2);

			client3Table.setItems(listc3);

		   
	    }

    @FXML
    void switchForm(ActionEvent event) throws IOException {
    	
    	 if (event.getSource()==dashBoardButton) {
 		
 			Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
 			Scene scene = new Scene(root);
 			Stage regStage = new Stage();
 
 			regStage.setScene(scene);
 			regStage.show();
 
 			dashBoardButton.getScene().getWindow().hide();
 			
 		}
    	 
    	 else if (event.getSource()==warehousesButton) {
    		 
    		 Parent root = FXMLLoader.load(getClass().getResource("warehouseView.fxml"));
  			Scene scene = new Scene(root);
  			Stage regStage = new Stage();
  
  			regStage.setScene(scene);
  			regStage.show();
  
  			warehousesButton.getScene().getWindow().hide();
    		 
    	 }
    	 
    	 else if (event.getSource()==departmentsButton) {
     		 
     		 Parent root = FXMLLoader.load(getClass().getResource("departmentView.fxml"));
   			Scene scene = new Scene(root);
   			Stage regStage = new Stage();
   
   			regStage.setScene(scene);
   			regStage.show();
   
   			departmentsButton.getScene().getWindow().hide();
     		 
     	 }
 else if (event.getSource()==employeesButton) {
     		 
     		 Parent root = FXMLLoader.load(getClass().getResource("Employees.fxml"));
   			Scene scene = new Scene(root);
   			Stage regStage = new Stage();
   
   			regStage.setScene(scene);
   			regStage.show();
   
   			employeesButton.getScene().getWindow().hide();
     		 
     	 }
    	 
    	 
    	 
     	 else if (event.getSource()==ordersButton) {
     		 
     		 Parent root = FXMLLoader.load(getClass().getResource("orders.fxml"));
   			Scene scene = new Scene(root);
   			Stage regStage = new Stage();
   
   			regStage.setScene(scene);
   			regStage.show();
   
   			ordersButton.getScene().getWindow().hide();
     		 
     	 }
    	 
     	 else if (event.getSource()==productsButton) {
     		 
     		 Parent root = FXMLLoader.load(getClass().getResource("Products.fxml"));
   			Scene scene = new Scene(root);
   			Stage regStage = new Stage();
   
   			regStage.setScene(scene);
   			regStage.show();
   
   			productsButton.getScene().getWindow().hide();
     		 
     	 }
     	 else if (event.getSource()==suppliersButton) {
     		 
     		 Parent root = FXMLLoader.load(getClass().getResource("Suppliers.fxml"));
   			Scene scene = new Scene(root);
   			Stage regStage = new Stage();
   
   			regStage.setScene(scene);
   			regStage.show();
   
   			suppliersButton.getScene().getWindow().hide();
     		 
     	 }
    	 
     	else if (event.getSource()==vehiclesButton) {
    		 
    		 Parent root = FXMLLoader.load(getClass().getResource("Vehicles.fxml"));
  			Scene scene = new Scene(root);
  			Stage regStage = new Stage();
  
  			regStage.setScene(scene);
  			regStage.show();
  
  			vehiclesButton.getScene().getWindow().hide();
    		 
    	 }
     	else if (event.getSource()==exitButton) {
    		 
    		 Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
  			Scene scene = new Scene(root);
  			Stage regStage = new Stage();
  
  			regStage.setScene(scene);
  			regStage.show();
  			exitButton.getScene().getWindow().hide();
    		 
    	 }



    }
    @FXML
    void addClient(MouseEvent event) throws ClassNotFoundException, SQLException {
    	if (clientIDData.getText().isEmpty() || clientNameData.getText().isEmpty() || clientAddressData.getText().isEmpty() || clientPhoneData.getText().isEmpty() ) {
       		
    		JOptionPane.showMessageDialog(null, "fill all field");
    		return;
    	}
    	int cid = Integer.parseInt(clientIDData.getText());
    	String name = clientNameData.getText();
    	String Address = clientAddressData.getText();
    	String payment = clientPaymentData.getText();
    	String Phone = clientPhoneData.getText();
    	
    	con = mySqlConnector.connectDB();
		
		String SQL = "INSERT INTO client (cid, name, address,payment_method) VALUES ("
				+ cid +",'"+ name +"','"+Address+"','"+payment+"');";
		
		 mySqlConnector.ExecuteStatement(con,SQL);
		 
		 SQL = "INSERT INTO clientPhone (cid,PhoneNumber) VALUES ("
				 +cid+", '"+Phone+ "');";
		 mySqlConnector.ExecuteStatement(con,SQL);

		System.out.println("Connection established");
		con.close();
		
		listc = mySqlConnector.getclientData();
		clientTable.setItems(listc);  
		
		listc2 = mySqlConnector.getclientPhone();
		clientPhoneTable.setItems(listc2);   
		
		clientIDData.clear();
		clientNameData.clear();
		clientAddressData.clear();
		clientPaymentData.clear();
		clientPhoneData.clear();
		}
    
    @FXML
    void AddPhone(MouseEvent event) throws ClassNotFoundException, SQLException {
    	
 	if (clientIDData1.getText().isEmpty() ||  clientPhoneData1.getText().isEmpty() ) {
       		
    		JOptionPane.showMessageDialog(null, "fill all field");
    		return;
    	}
    	int cid = Integer.parseInt(clientIDData1.getText());
    	String Phone = clientPhoneData1.getText();
    	
    	con = mySqlConnector.connectDB();
		
				 
		String SQL = "INSERT INTO clientPhone (cid,PhoneNumber) VALUES ("
				 +cid+", '"+Phone+ "');";
		 mySqlConnector.ExecuteStatement(con,SQL);

		System.out.println("Connection established");
		con.close();
		
		listc2 = mySqlConnector.getclientPhone();
		clientPhoneTable.setItems(listc2);
		
		clientPhoneData1.clear();
		clientIDData1.clear();

    }
    
    @FXML
    void deleteClient(MouseEvent event) {
    	 ObservableList<client> selectedRows = clientTable.getSelectionModel().getSelectedItems();
     	ArrayList<client> rows = new ArrayList<>(selectedRows);
     	rows.forEach(row -> {
     		clientTable.getItems().remove(row); 
     		deleteclientRow(row); 
     		clientTable.refresh();
     		clientPhoneTable.refresh();
     	 });
     		ObservableList<clientPhone> selectedRows2 = clientPhoneTable.getSelectionModel().getSelectedItems();
         	ArrayList<clientPhone> rows2 = new ArrayList<>(selectedRows2);
         	rows2.forEach(row2 -> {
         		clientPhoneTable.getItems().remove(row2); 
         		deletePhoneRow(row2); 
         		clientPhoneTable.refresh();
         	 });
   
    }
 
    @FXML
    void refresh(MouseEvent event) throws ClassNotFoundException, SQLException {
    	
    	listc = mySqlConnector.getclientData();
		clientTable.setItems(listc);  
		
		listc2 = mySqlConnector.getclientPhone();
		clientPhoneTable.setItems(listc2); 
		
		listc3 = mySqlConnector.getAllInfo();
		client3Table.setItems(listc3); 
    }
    
    
	public void updateName(int cid, String name) {
		
		try {
			System.out.println("update  client set name = '"+name + "' where cid = "+cid);
			con = mySqlConnector.connectDB();
			mySqlConnector.ExecuteStatement(con,"update  client set name = '"+name + "' where cid = "+cid+";");
			con.close();
			System.out.println("Connection closed.");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	

	
	public void updateAddress(int cid, String address) {
		
		try {
			System.out.println("update  client set address = '"+address + "' where cid = "+cid);
			con = mySqlConnector.connectDB();
			mySqlConnector.ExecuteStatement(con,"update  client set address = '"+address + "' where cid = "+cid+";");
			con.close();
			System.out.println("Connection closed");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	
	public void updatePayment_method(int cid, String payment) {
		
		try {
			System.out.println("update  client set payment_method = '"+payment + "' where cid = "+cid);
			con = mySqlConnector.connectDB();
			mySqlConnector.ExecuteStatement(con,"update  client set  payment_method= '"+payment + "' where cid = "+cid+";");
			con.close();
			System.out.println("Connection closed");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	public void updatePhone(String phoneID, String Phone) {
		
		try {
			System.out.println("update  clientPhone set phoneNumber = '"+Phone + "' where phoneNumber = '"+phoneID+"'");
			con = mySqlConnector.connectDB();
			mySqlConnector.ExecuteStatement(con,"update  clientPhone set  phoneNumber= '"+Phone + "' where PhoneNumber = '"+phoneID+"';");
			con.close();
			System.out.println("Connection closed");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}

	private void deleteclientRow(client row) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("delete from  client where cid="+row.getCid() + ";");
			con = mySqlConnector.connectDB();
			mySqlConnector.ExecuteStatement(con,"delete from  client where cid="+row.getCid() + ";");
			
			con.close();
			System.out.println("Connection closed");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	private void deletePhoneRow(clientPhone row) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("delete from clientPhone where phoneNumber="+row.getPhoneNumber()+ ";");
		 con = mySqlConnector.connectDB();
		mySqlConnector.ExecuteStatement(con, "delete from  clientPhone where phoneNumber="+"'"+row.getPhoneNumber()+"'" + ";");
			
			con.close();
			System.out.println("Connection closed");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}


}
