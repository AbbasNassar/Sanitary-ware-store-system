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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

public class ShowOrderController implements Initializable{
	
	 @FXML
	    private TableColumn<OrdersC, Integer> Cid_col;

	    @FXML
	    private TableColumn<OrdersC, LocalDate> Date_col;

	    @FXML
	    private TableColumn<OrdersC, Double> Discount_col;

	    @FXML
	    private TableView<OrdersC> Order_tbv;

	    @FXML
	    private TableColumn<OrdersC, Double> Paid_col;

	    @FXML
	    private TableColumn<OrdersC, String> PayType_col;

	    @FXML
	    private TableColumn<OrdersC, Double> Totproce_col;

	    @FXML
	    private TableColumn<OrdersC, Integer> id_col;
	    
	    @FXML
	    private TableColumn<OrdersC, Double> Remaining_col;
	    
	    @FXML
	    private TextField search_txtbx;
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
		
		Cid_col.setCellValueFactory(new PropertyValueFactory<OrdersC, Integer>("Client_Id"));
		Date_col.setCellValueFactory(new PropertyValueFactory<OrdersC, LocalDate>("Date"));
		Discount_col.setCellValueFactory(new PropertyValueFactory<OrdersC, Double>("Discount"));
		Paid_col.setCellValueFactory(new PropertyValueFactory<OrdersC, Double>("Paid_Amount"));
		PayType_col.setCellValueFactory(new PropertyValueFactory<OrdersC, String>("Pay_Type"));
		Totproce_col.setCellValueFactory(new PropertyValueFactory<OrdersC, Double>("TotalPrice"));
		id_col.setCellValueFactory(new PropertyValueFactory<OrdersC, Integer>("Order_Id"));
		Remaining_col.setCellValueFactory(new PropertyValueFactory<OrdersC, Double>("Remaining"));
		
try {
			
			//Product_tbv.getItems().clear();
			//Product_tbv.setItems(My_List);
			ObservableList <OrdersC> My_List;
            My_List = MyConnection.getOrdersCData();
            
            
            System.out.println("mylist");
            System.out.println(My_List);
            
			
            Order_tbv.setEditable(true);
           // Product_tbv.setItems(My_List);
            
            FilteredList <OrdersC> filtereddata = new FilteredList <>(My_List, b->true);
            search_txtbx.textProperty().addListener((observable, oldValue, newValue) -> {
            	
            	filtereddata.setPredicate(customer -> {
            		
                    if(newValue == null || newValue.isEmpty()) {
                    	return true;
                    	
                    }           		
            		
                    String lower = newValue.toLowerCase();
                    if(String.valueOf(customer.getOrder_Id()).equals(newValue)) {
                    	return true;
                    }
                    else return false;
            		
            		
            	});
            	  	
            	
            });
            
            SortedList<OrdersC> my_sorted_list = new SortedList<>(filtereddata);
            
            my_sorted_list.comparatorProperty().bind(Order_tbv.comparatorProperty());
            
            Order_tbv.setItems(my_sorted_list);
       
		     
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
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
        //controller.SetController(this);


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
