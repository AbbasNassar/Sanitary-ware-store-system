package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import application.Products;

public class DashBoardController implements Initializable{
	    ObservableList <Products> My_List;
	    ObservableList <Products> Temp_List= FXCollections.observableArrayList();
	    
	    ObservableList <Delivery> My_Delivery_List;
	    ObservableList <Delivery> Temp_Delivery_List= FXCollections.observableArrayList();
	    
	    ObservableList <OrdersC> My_Unpaid_List;
	    ObservableList <OrdersC> Temp_Unpaid_List= FXCollections.observableArrayList();
	    
	    ObservableList <OrdersC> Temp_Today_List= FXCollections.observableArrayList();
	    
	    @FXML
        private TableView<Products> Outstock_tbv;
	    
	    @FXML
	    private Button exitButton;
	    
	    @FXML
	    private TableColumn<Products, Integer> Prodid_col;

	    @FXML
	    private TableColumn<Products, String> Prodname_col;
	    
	    
	    @FXML
	    private TableView<OrdersC> Sales_tbv;
	    @FXML
	    private TableColumn<OrdersC, Double> TodaysOrdertot_col;

	    @FXML
	    private TableColumn<OrdersC, Integer> Todaysorderid_col;

	    @FXML
	    private TableColumn<OrdersC, Integer> customerid_col;
	
	    
	    @FXML
	    private TableView<Delivery> delivery_tbv;
	    
	    @FXML
	    private TableColumn<Delivery, Integer> Carid_col;
	  
	    @FXML
	    private TableColumn<Delivery, String> Destination_col;
	    
	    @FXML
	    private TableColumn<Delivery, Integer> deliveryid_col;
	    
	    
	  
	    @FXML
	    private TableView<OrdersC> unpaid_tbv;
	    
	    @FXML
	    private TableColumn<OrdersC, Double> Remaining_col;

	    @FXML
	    private TableColumn<OrdersC, Integer> unpaidid_col;

	    @FXML
	    private TableColumn<OrdersC, Double> unpaidprice_col;
	    

	    @FXML
	    private BorderPane Bpane;

	    @FXML
	    private Button Dashbtn;

	    @FXML
	    private Button Depbtn;

	    @FXML
	    private Button Empbtn;

	    @FXML
	    private Button Orderbtn;

	    @FXML
	    private ComboBox<String> PMonthcbx;

	    @FXML
	    private ComboBox<String> PYearcbx;

	    @FXML
	    private Button Productbtn;

	    @FXML
	    private LineChart<String, Number> Purchaselinechart;

	    @FXML
	    private ComboBox<String> SMonthcbx;

	    @FXML
	    private ComboBox<String> SYearcbx;

	    @FXML
	    private LineChart<String, Number> Saleslinechart;

	    @FXML
	    private StackPane Stack_pane;

	    @FXML
	    private Button Supplierbtn;

	    @FXML
	    private Button Vehiclesbtn;

	    @FXML
	    private Button Warehousebtn;

	    @FXML
	    private AnchorPane inside_Anch_left;

	    @FXML
	    private AnchorPane outside_anch_left;

	    @FXML
	    private AnchorPane top_anch;

	    @FXML
	    private CategoryAxis SalesXAxis;
	    
	    @FXML
	    private CategoryAxis PurchaseXAxis;
	    
	    @FXML
	    private Label Nocarslbl;

	    @FXML
	    private Label Nocustomerslbl;

	    @FXML
	    private Label Nodeliverylbl;

	    @FXML
	    private Label Noempslbl;

	    @FXML
	    private Label Noincomelbl;

	    @FXML
	    private Label Nosupplierslbl;
	    
	    @FXML
	    private Button employeesButton;
	    
	
	    @FXML
	    private Button clientButton;
	    
	    @FXML
	    private Button warehousesButton;
	    
	    @FXML
	    private Button departmentsButton;

	    @FXML
	    private Button ordersButton;
	    
	    @FXML
	    private Button productsButton;
	    
	    @FXML
	    private Button suppliersButton;
	    
	    @FXML
	    private Button vehiclesButton;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){	
		
		Prodid_col.setCellValueFactory(new PropertyValueFactory<Products, Integer>("Pid"));
		Prodname_col.setCellValueFactory(new PropertyValueFactory<Products, String>("Pname"));
	    
	    Carid_col.setCellValueFactory(new PropertyValueFactory<Delivery, Integer>("Carid"));
	    deliveryid_col.setCellValueFactory(new PropertyValueFactory<Delivery, Integer>("Orderid"));
	    Destination_col.setCellValueFactory(new PropertyValueFactory<Delivery, String>("OrderDistenation"));
	    
	    Remaining_col.setCellValueFactory(new PropertyValueFactory<OrdersC, Double>("Remaining"));
	    unpaidprice_col.setCellValueFactory(new PropertyValueFactory<OrdersC, Double>("TotalPrice"));
	    unpaidid_col.setCellValueFactory(new PropertyValueFactory<OrdersC, Integer>("Order_Id"));

	    
	    TodaysOrdertot_col.setCellValueFactory(new PropertyValueFactory<OrdersC, Double>("TotalPrice"));
	    Todaysorderid_col.setCellValueFactory(new PropertyValueFactory<OrdersC, Integer>("Order_Id"));;
	    customerid_col.setCellValueFactory(new PropertyValueFactory<OrdersC, Integer>("Client_Id"));;
	    
	    
		
		try {
			
			My_List = MyConnection.getProductData();
			My_Delivery_List = MyConnection.getDeliveryOrderData();
			My_Unpaid_List = MyConnection.getOrdersCData();
			Outstock_tbv.setEditable(true);
			delivery_tbv.setEditable(true);
			unpaid_tbv.setEditable(true);
			Sales_tbv.setEditable(false);			
			
			for(Products prod : My_List) {
				    
				  if (prod.Quantity == 0) {
					  
					  Temp_List.add(prod);
					    
				  }				
			}
			
			
			
			for(Delivery del : My_Delivery_List) {
			    
				  if (del.Orderstatus == "In-delivery") {
					  
					  Temp_Delivery_List.add(del);
					    
				  }				
			}
			
			
			for(OrdersC Unpaid : My_Unpaid_List) {
			    
				  if (Unpaid.Remaining != 0.0) {
					  
					  Temp_Unpaid_List.add(Unpaid);
					  
				  }
				  if (Unpaid.Date.equals(LocalDate.now())) {
					  
					  Temp_Today_List.add(Unpaid);
					  
				  }
			}
			
			
			Outstock_tbv.setItems(Temp_List);
			delivery_tbv.setItems(My_Delivery_List);
			unpaid_tbv.setItems(Temp_Unpaid_List);
			Sales_tbv.setItems(Temp_Today_List);
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		
		
		
		
		SMonthcbx.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
        for (int year = 2000; year <= LocalDate.now().getYear(); year++) {
            SYearcbx.getItems().add(String.valueOf(year));
        }	
		
		
		 PMonthcbx.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
	        for (int year = 2000; year <= LocalDate.now().getYear(); year++) {
	            PYearcbx.getItems().add(String.valueOf(year));
	        }
	        
	        try {
				Nocarslbl.setText(String.valueOf(MyConnection.getnumcars()));
				Nocustomerslbl.setText(String.valueOf(MyConnection.getnumcustomers()));
				Nodeliverylbl.setText(String.valueOf(MyConnection.getnumdelivery()));
				Noempslbl.setText(String.valueOf(MyConnection.getnumemps()));
				Nosupplierslbl.setText(String.valueOf(MyConnection.getnumsuppliers()));
				String income = "$"+String.valueOf(MyConnection.gettodayincome());
				Noincomelbl.setText(income);
				
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
	}
	
	
	
	
    @FXML
    void UpdatePchart(ActionEvent event) throws ClassNotFoundException, SQLException {
    	
    	String selectedMonth = PMonthcbx.getValue();
        String selectedYear = PYearcbx.getValue();
        if (selectedMonth != null && selectedYear != null) {
            List<XYChart.Data<String, Number>> purchaseData = MyConnection.getDataFromDatabase("purchaseOrder", selectedYear, selectedMonth);
            updateLineChart(Purchaselinechart,PurchaseXAxis ,purchaseData);
        }

    }

    @FXML
    void UpdateSchart(ActionEvent event) throws ClassNotFoundException, SQLException {
    	System.out.println("here to update");
       	String selectedMonth = SMonthcbx.getValue();
        String selectedYear = SYearcbx.getValue();
        if (selectedMonth != null && selectedYear != null) {
        	
            List<XYChart.Data<String, Number>> salesData = MyConnection.getDataFromDatabase("salesOrder", selectedYear, selectedMonth);
            updateLineChart(Saleslinechart,SalesXAxis ,salesData);
            
        }
    }
    
    
    private void updateLineChart(LineChart<String, Number> lineChart,CategoryAxis xAxis ,List<XYChart.Data<String, Number>> data) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().addAll(data);
        lineChart.getData().clear();
        lineChart.getData().add(series);
        
        List<String> categories = new ArrayList<>();
        for (XYChart.Data<String, Number> d : data) {
            categories.add(d.getXValue());
        }
        xAxis.setCategories(FXCollections.observableArrayList(categories));
    }
    @FXML
    void addClient(MouseEvent event) {
		System.out.println("hello");
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
		 else {
			 ;
		 }


	}
	
		
}
