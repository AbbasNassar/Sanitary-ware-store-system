package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.NumberStringConverter;

public class AddOrderController implements Initializable{
	
    @FXML
    private Button Addbtn;
    
    @FXML
    private Button searchbtn;
	
    @FXML
    private Button DashButton;

    @FXML
    private Button DepartmentButton;

    @FXML
    private Button EmpButton;

    @FXML
    private Button OrdersButton;

    @FXML
    private Button ProductButton;

    @FXML
    private Button SupplierButton;

    @FXML
    private Button VehicleButton;

    @FXML
    private Button WarehouseButton;
    
    @FXML
    private Button Backbtn;
    
    @FXML
    private Button Savebtn;
    
    @FXML
    private Button customersearchbtn;
    
    @FXML
    private Label Driverlbl;
    
    @FXML
    private Label carlbl;
    
    @FXML
    private Label destlbl;
    
    @FXML
    private Label empidlbl;
    
    @FXML
    private Label Paylbl;
    
    @FXML
    private TableView<Orders> orderstable;

    @FXML
    private TableColumn<Orders, Double> discount_col;

    @FXML
    private TableColumn<Orders, Double> price_col;

    @FXML
    private TableColumn<Orders, Integer> productid_col;

    @FXML
    private TableColumn<Orders, String> productname_col;

    @FXML
    private TableColumn<Orders, Double> quantity_col;

    @FXML
    private TableColumn<Orders, Double> totprice_col;
    
    @FXML
    private TextField Discount_txtbx;
    
    @FXML
    private TextField PID_txtbx;

    @FXML
    private TextField PName_txtbx;

    @FXML
    private TextField Price_txtbx;

    @FXML
    private TextField Quantity_txtbx;
    
    @FXML
    private TextField custidtxtbx;
    
    @FXML
    private TextField custnametxtbx;
    
    @FXML
    private TextField totalpricetxtbx;
    
    @FXML
    private TextField Caridtxtbx;

    @FXML
    private TextField Destitxtbx;
    
    @FXML
    private TextField Emploidtxtbx;
    
    @FXML
    private TextField driveridtxtbx;
    
    @FXML
    private TextField Paymenttxtbx;
    
    @FXML
    private CheckBox Cashcheck;

    @FXML
    private CheckBox Chequescheck;
    
    @FXML
    private CheckBox Deliverycheck;

    @FXML
    private CheckBox Inplacecheck;
    
    @FXML
    private DatePicker Datefield;
    
    @FXML
    private TextField ordernotext;
    
    @FXML
    private Button clientButton;

    @FXML
    private Button dashBoardButton;

    @FXML
    private Button departmentsButton;

    @FXML
    private Button employeesButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button ordersButton;

    @FXML
    private Button productsButton;

    @FXML
    private Button suppliersButton;

    @FXML
    private Button vehiclesButton;

    @FXML
    private Button warehousesButton;
    
    
    
   /// public AddOrderController controllerr; 
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Stage primaryStage;
    
    private double originalPrice; 
    double totprice;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		totprice = 0;
		
		orderstable.setEditable(true);
		
		Price_txtbx.setEditable(true);
		Price_txtbx.setDisable(false);
		Price_txtbx.setVisible(true);
		ordernotext.setEditable(false);
		carlbl.setVisible(false);
    	Caridtxtbx.setVisible(false);
    	Driverlbl.setVisible(false);
    	driveridtxtbx.setVisible(false);
    	destlbl.setVisible(false);
    	Destitxtbx.setVisible(false);
    	empidlbl.setVisible(false);
    	Emploidtxtbx.setVisible(false);
    	Paylbl.setVisible(false);
    	Paymenttxtbx.setVisible(false);
		
		
		Cashcheck.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                Chequescheck.setSelected(false); // Uncheck Chequescheck if Cashcheck is checked
            }
        });

        Chequescheck.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                Cashcheck.setSelected(false); // Uncheck Cashcheck if Chequescheck is checked
            }
        });

        // Add listeners to the second group of checkboxes
        Deliverycheck.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                Inplacecheck.setSelected(false); // Uncheck Inplacecheck if Deliverycheck is checked
            }
        });

        Inplacecheck.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                Deliverycheck.setSelected(false); // Uncheck Deliverycheck if Inplacecheck is checked
            }
        });
                
		
		try {
			
			int orderno = MyConnection.getnumorders() + 1 ;
			System.out.println("fhdhd");
			ordernotext.setText(String.valueOf(orderno));
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		productid_col.setCellValueFactory(new PropertyValueFactory<Orders, Integer>("Product_Id"));
		productname_col.setCellValueFactory(new PropertyValueFactory<Orders, String>("Product_Name"));
		price_col.setCellValueFactory(new PropertyValueFactory<Orders, Double>("Price"));
		quantity_col.setCellValueFactory(new PropertyValueFactory<Orders, Double>("Quantity"));
		totprice_col.setCellValueFactory(new PropertyValueFactory<Orders, Double>("TotalPrice"));
		
			
		 Datefield.setValue(LocalDate.now());

	        // Add a listener to handle date changes
	        Datefield.valueProperty().addListener((observable, oldValue, newValue) -> {
	            System.out.println("Selected date: " + newValue);
	            // Handle the new date value here
	        });
		
		
		totalpricetxtbx.setOnAction(event -> {
			  try {
			    double newPrice = Double.parseDouble(totalpricetxtbx.getText());
			    updateDiscount(newPrice);
			    //originalPrice = newPrice; // Update original price (if needed)
			  } catch (NumberFormatException e) {
			    // Handle invalid input in price
			  }
			});
        
		
		Quantity_txtbx.setOnAction(event -> {
			  try {
			    double max_quantity = SearchProductController.getmaxQuantity();
			    
			    if (Double.parseDouble(Quantity_txtbx.getText()) > max_quantity) {
			    	Quantity_txtbx.setText(String.valueOf(max_quantity));
			    	
			    }
			    /*else {
			    	
			    	Quantity_txtbx.setText(String.valueOf(max_quantity));
			    	
			    	
			    }*/
			    
			    
			    //originalPrice = newPrice; // Update original price (if needed)
			  } catch (NumberFormatException e) {
			    // Handle invalid input in price
			  }
			});
		

        Discount_txtbx.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                double discount = Double.parseDouble(newValue);
                if (discount >= 0 && discount <= 100) {
                    updatePrice(originalPrice, discount);
                } else {
                    // Handle discount out of range
                    Discount_txtbx.setText(oldValue); // Reset to previous value
                }
            } catch (NumberFormatException e) {
                // Handle invalid input in discount
            }
        });

        System.out.println("not here, i am tired");
		
	/*	try {
			
	       // stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        


		
        /*ObservableList<Orders> data = FXCollections.observableArrayList();
        for(int i=0;i<10;i++)
          data.add(new Orders());  // Add an empty row */

        //orderstable.setItems(data);
        /*orderstable.setEditable(true);
		discount_col.setCellValueFactory(new PropertyValueFactory<Orders, Double>("Discount"));
		price_col.setCellValueFactory(new PropertyValueFactory<Orders, Double>("Price"));
		productid_col.setCellValueFactory(new PropertyValueFactory<Orders, Integer>("Product_Id"));
		productname_col.setCellValueFactory(new PropertyValueFactory<Orders, String>("Product_Name"));
		quantity_col.setCellValueFactory(new PropertyValueFactory<Orders, Double>("Quantity"));
		totprice_col.setCellValueFactory(new PropertyValueFactory<Orders, Double>("TotalPrice"));
		*/
		
		
		//try {
		     
		//}
		/*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/		
	
		
	}
	
	
    @FXML
    void Add_Table(MouseEvent event) {
        
        int id = Integer.parseInt(PID_txtbx.getText());

        String name = PName_txtbx.getText();

        double price =  Double.parseDouble(Price_txtbx.getText());

        double quantity = Double.parseDouble(Quantity_txtbx.getText());
        
        double total_price = price * quantity;
        
        totprice += total_price; 
        
        originalPrice = totprice;
    	
        totalpricetxtbx.setText(String.valueOf(totprice));
        
    	Orders my_line = new Orders(id, name, quantity, total_price, price);
    	
    	orderstable.getItems().add(my_line);
    	orderstable.refresh();
    	
    	PID_txtbx.clear();
    	PName_txtbx.clear();
    	Price_txtbx.clear();
    	Quantity_txtbx.clear();
    	
    		
    }

    @FXML
    void Pop_Products(MouseEvent event) throws IOException {
    	
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchProduct.fxml"));
      
        //loader.setController(controller);
        Parent popUpRoot;
        try {
            popUpRoot = loader.load();
            
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        stage = new Stage();
        stage.setScene(new Scene(popUpRoot));
        stage.show();
    	
        SearchProductController controller = loader.getController(); // Pass reference
        controller.SetController(this);
        //controller.cleartbv(); 
    	
    	
    	
    	/*FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchProduct.fxml"));
        root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/
   
        
        /*stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();*/
        
        //stage.show();

    }
    
    
    @FXML
    void Pop_Customers(MouseEvent event) {
        
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchCustomer.fxml"));
         
         //loader.setController(controller);
         Parent popUpRoot;
         try {
             popUpRoot = loader.load();
             
         } catch (Exception e) {
             e.printStackTrace();
             return;
         }

         stage = new Stage();
         stage.setScene(new Scene(popUpRoot));
         stage.show();
     	
         SearchCustomerController controller = loader.getController(); // Pass reference
         controller.SetController(this);
         
    	
    	
    }

    @FXML
    void Switch_Back(MouseEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("orders.fxml"));
        root = loader.load();
        
        
       /* SearchProductController scene2Controller = loader.getController();
        scene2Controller.setSharedData(sharedData);*/
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,1549,792);
        stage.setScene(scene);
        stage.show();

    }
    
    
    @FXML
    void Save(MouseEvent event) throws ClassNotFoundException, SQLException {
    	
    	ObservableList<Orders> items = orderstable.getItems();
        int rowCount = items.size();
        int carId = 0;
        int employeeId = 0;
        int customerId = 0;
        int driverid = 0;
        int orderid = 0;
        double paymentAmount = 0;
        double discount = 0;
        double totalPrice = 0;
        String destination = null;
        LocalDate orderDate = null;
        if(!Caridtxtbx.getText().toString().trim().isEmpty()) {
            carId = Integer.parseInt(Caridtxtbx.getText());
        }
        
        if(!Destitxtbx.toString().trim().isEmpty())
            destination = Destitxtbx.getText();
        
        if(!Emploidtxtbx.getText().toString().trim().isEmpty())
           employeeId = Integer.parseInt(Emploidtxtbx.getText());
        
        if(!Paymenttxtbx.getText().toString().trim().isEmpty())
            paymentAmount = Double.parseDouble(Paymenttxtbx.getText());
        
        if(!Datefield.getValue().toString().trim().isEmpty())
           orderDate = Datefield.getValue();
        
        if(!custidtxtbx.getText().toString().trim().isEmpty())
           customerId = Integer.parseInt(custidtxtbx.getText());
        
        if(!Discount_txtbx.getText().toString().trim().isEmpty())
           discount = Double.parseDouble(Discount_txtbx.getText());
        
        if(!totalpricetxtbx.getText().toString().trim().isEmpty())
           totalPrice = Double.parseDouble(totalpricetxtbx.getText());
        
        String orderType = Cashcheck.isSelected() ? "Cash" : "Cheques";
        
        if(!driveridtxtbx.getText().toString().trim().isEmpty())
           driverid = Integer.parseInt(driveridtxtbx.getText());
 
        if(!ordernotext.getText().toString().trim().isEmpty())
           orderid = Integer.parseInt(ordernotext.getText());
        try {
        MyConnection.connectDB();
        MyConnection.setAutoCommit(false); 
        
        MyConnection.insert_order(orderid, orderDate, discount, totalPrice, customerId, orderType, paymentAmount);
        
        System.out.println("number of rows is: " + rowCount );
        for(int i=0;i<rowCount; i++) {
        	Orders order = items.get(i);
        	MyConnection.insert_orderline(i+1, order.getTotalPrice(), order.getQuantity(), order.getProduct_Id(), orderid);
        	System.out.println("i haven't been here");
        }
        
        if(Deliverycheck.isSelected()) {
        	String my_string = "In-delivery";
            MyConnection.insert_deliveryorder(orderid, driverid, carId, my_string, destination);
            }
        else {
            MyConnection.insert_placeorder(orderid, employeeId);
        }
        MyConnection.setAutoCommit(false);
        MyConnection.commitTransaction(); // Commit the transaction
        
    } catch (SQLException | ClassNotFoundException e) {
    	System.out.println("Error: " + e.getMessage());
    	MyConnection.setAutoCommit(false);
        MyConnection.rollbackTransaction(); // Rollback in case of an error
        throw e;
    } finally {
        MyConnection.setAutoCommit(true); // Restore auto-commit
    }
        
        
        Discount_txtbx.clear();
        
        PID_txtbx.clear();

        PName_txtbx.clear();

        Price_txtbx.clear();

        Quantity_txtbx.clear();
        
        custidtxtbx.clear();
        
        custnametxtbx.clear();
        
        totalpricetxtbx.clear();
        
        Caridtxtbx.clear();
        Caridtxtbx.setVisible(false);

        Destitxtbx.clear();
        Destitxtbx.setVisible(false);
        
        
        Emploidtxtbx.clear();
        Emploidtxtbx.setVisible(false);
        
        driveridtxtbx.clear();
        driveridtxtbx.setVisible(false);
        
        
        Paymenttxtbx.clear();
        Paymenttxtbx.setVisible(false);
        
        Cashcheck.setSelected(false);

        Chequescheck.setSelected(false);
        
        Deliverycheck.setSelected(false);

        Inplacecheck.setSelected(false);
        
        Driverlbl.setVisible(false);
        
        carlbl.setVisible(false);
        
        destlbl.setVisible(false);
        
        empidlbl.setVisible(false);
        
        Paylbl.setVisible(false);
        
        orderstable.getItems().clear();
        
        int onum = MyConnection.getnumorders()+1;
        ordernotext.setText(String.valueOf(onum));
       
        
        
        
        
        
        
    }

    @FXML
    void Switch_DashBoard(MouseEvent event) {

    }

    @FXML
    void Switch_Departments(MouseEvent event) {

    }

    @FXML
    void Switch_Employees(MouseEvent event) {

    }

    @FXML
    void Switch_Orders(MouseEvent event) {

    }

    @FXML
    void Switch_Products(MouseEvent event) {

    }

    @FXML
    void Switch_Suppliers(MouseEvent event) {

    }

    @FXML
    void Switch_Warehouses(MouseEvent event) {

    }
    
    
    void Setinfo(int id, String name, double price, double Quantity){
            //System.out.println("here yasta");
            
    		PID_txtbx.setText(String.valueOf(id));
    		//System.out.println(PID_txtbx.getText()); 
        	PName_txtbx.setText(name);
        	//System.out.println(PName_txtbx.getText());
        	Price_txtbx.setText(String.valueOf(price));
        	
        	Quantity_txtbx.setText(String.valueOf(price));
        	//System.out.println(Price_txtbx.getText());
        	
    	/*System.out.println("Hello here");
    	PID_txtbx.setText(String.valueOf(id));
    	PName_txtbx.setText(name);
    	Price_txtbx.setText(String.valueOf(price));
*/    	
    }
    
    
    void Setinfo(int id, String name){
        //System.out.println("hereeeeee yasta");  
        
        custidtxtbx.setText(String.valueOf(id));
        custnametxtbx.setText(name);
    	
	/*System.out.println("Hello here");
	PID_txtbx.setText(String.valueOf(id));
	PName_txtbx.setText(name);
	Price_txtbx.setText(String.valueOf(price));
*/    	
}
    
    
    public void setPrimaryStage(Stage primaryStage) {
        this.stage = primaryStage;
    }
    
    
    private void updateDiscount(double newPrice) {
        double discount = (originalPrice - newPrice) / originalPrice * 100;
        Discount_txtbx.setText(String.format("%.2f", discount)); // Format to 2 decimal places
    }

    private void updatePrice(double price, double discount) {
        double discountedPrice = price * (1 - discount / 100);
        totalpricetxtbx.setText(String.format("%.2f", discountedPrice));
    }

	
    void SetOriginalPrice(double original){
    	this.originalPrice = original;
    	
    }
    
    double getOriginalPrice(){
    	return originalPrice;
    	
    }
    
    
    public String getpaymenttypeSelectedOption() {
        if (Cashcheck.isSelected()) {
            return "Cash";
        } else if (Chequescheck.isSelected()) {
            return "Cheques";
        } else {
            return "None";
        }
    }

    // Method to check which checkbox is selected in the second group
    public String getordertypeSelectedOption() {
        if (Deliverycheck.isSelected()) {
            return "Delivery";
        } else if (Inplacecheck.isSelected()) {
            return "Inplace";
        } else {
            return "None";
        }
    }
    
    
    @FXML
    void Deliverybx(ActionEvent event) {
    	carlbl.setVisible(true);
    	Caridtxtbx.setVisible(true);
    	Driverlbl.setVisible(true);
    	driveridtxtbx.setVisible(true);
    	destlbl.setVisible(true);
    	Destitxtbx.setVisible(true);
    	empidlbl.setVisible(false);
    	Emploidtxtbx.setVisible(false);
    }

    @FXML
    void Inplacebx(ActionEvent event) {
    	
    	carlbl.setVisible(false);
    	Caridtxtbx.setVisible(false);
    	Driverlbl.setVisible(false);
    	driveridtxtbx.setVisible(false);
    	destlbl.setVisible(false);
    	Destitxtbx.setVisible(false);
    	empidlbl.setVisible(true);
    	Emploidtxtbx.setVisible(true);

    }

    @FXML
    void Paymentcheck(ActionEvent event) {
         Paylbl.setVisible(true);
         Paymenttxtbx.setVisible(true);
    }
    public void switchForm(ActionEvent event) throws IOException {
		
		
		 if (event.getSource()==clientButton) {
			
			Parent root = FXMLLoader.load(getClass().getResource("clientView.fxml"));
			Scene scene = new Scene(root);
			Stage regStage = new Stage();

			regStage.setScene(scene);
			regStage.show();

			clientButton.getScene().getWindow().hide();
			
		}
		 
		 else if (event.getSource()==warehousesButton) {
 		 
 		 Parent root = FXMLLoader.load(getClass().getResource("WarehouseView.fxml"));
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
		 else if (event.getSource()==dashBoardButton) {
  		 
  		 Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
			Scene scene = new Scene(root);
			Stage regStage = new Stage();

			regStage.setScene(scene);
			regStage.show();

			dashBoardButton.getScene().getWindow().hide();
  		 
  	 }
		 else if (event.getSource()==productsButton) {
	 
	 Parent root = FXMLLoader.load(getClass().getResource("orders.fxml"));
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
		 else {
			 ;
		 }


	}
	
	
}
