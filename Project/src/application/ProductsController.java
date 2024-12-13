package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import application.Products;

public class ProductsController implements Initializable{
	
	
	    ObservableList <Products> My_List;
	
	    @FXML
	    private Button AddProductButton;

	    @FXML
	    private TableColumn<Products, Integer> prodid_col;

	    @FXML
	    private TextField PID_txtbx;

	    @FXML
	    private TableColumn<Products, Double> proprice_col;

	    @FXML
	    private TableColumn<Products, String> prodname_col;

	    @FXML
	    private TextField PName_txtbx;

	    @FXML
	    private TextField Price_txtbx;

	    @FXML
	    private TableColumn<Products, Double> madein_col;

	    @FXML
	    private TextField Quantity_txtbx;

	    @FXML
	    private TableView<Products> Product_tbv;

	    @FXML
	    private TextField Search;

	    @FXML
	    private ComboBox<String> SelectionBox;

	    @FXML
	    private Button VehicleClearAllButton;

	    @FXML
	    private Button VehicleDeleteButton;

	    @FXML
	    private AnchorPane VehiclesSelection;

	    @FXML
	    private BorderPane ViewVehicleWindow;

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
	    
	    private Stage stage;
	    private Scene scene;
	    private Parent root;

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		
		prodid_col.setCellValueFactory(new PropertyValueFactory<Products, Integer>("Pid"));
		prodname_col.setCellValueFactory(new PropertyValueFactory<Products, String>("Pname"));
		madein_col.setCellValueFactory(new PropertyValueFactory<Products, Double>("Quantity"));
		proprice_col.setCellValueFactory(new PropertyValueFactory<Products, Double>("Price"));

		try {
			
			//Product_tbv.getItems().clear();
			//Product_tbv.setItems(My_List);
            My_List = MyConnection.getProductsData();
            
			
            Product_tbv.setEditable(true);
            Product_tbv.setItems(My_List);
            SelectionBox.getItems().addAll("ID", "Name");
            SelectionBox.setValue("Name"); // Set default value

            // Create a FilteredList wrapping the original list
            FilteredList<Products> filtereddata = new FilteredList<>(My_List, b -> true);

            // Add listener to the TextField for real-time filtering
            Search.textProperty().addListener((observable, oldValue, newValue) -> {
                filtereddata.setPredicate(product -> {
                    // If the search box is empty, display all products
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Get the selected search criteria
                    String criteria = SelectionBox.getValue();
                    String lower = newValue.toLowerCase();

                    // Filter based on the selected criteria
                    if (criteria.equals("ID")) {
                        // Convert the product ID to string and check if it contains the search text
                        return Integer.toString(product.getPid()).toLowerCase().contains(lower);
                    } else if (criteria.equals("Name")) {
                        // Check if the product name contains the search text
                        return product.getPname().toLowerCase().contains(lower);
                    }
                    return false;
                });
            });

            // Create a SortedList from the FilteredList
            SortedList<Products> my_sorted_list = new SortedList<>(filtereddata);

            // Bind the comparator of the SortedList to the TableView comparator
            my_sorted_list.comparatorProperty().bind(Product_tbv.comparatorProperty());

            // Set the sorted and filtered data to the TableView
            Product_tbv.setItems(my_sorted_list);
       
		     
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
		
	}
	
	
	    @FXML
	    void AddProductButton(ActionEvent event) throws ClassNotFoundException, SQLException {
	    	int id = Integer.parseInt(PID_txtbx.getText());

	        String name = PName_txtbx.getText();

	        double price =  Double.parseDouble(Price_txtbx.getText());

	        double quantity = Double.parseDouble(Quantity_txtbx.getText());
	    	
	    	
	    	System.out.println("fdaf");
	    	Product_tbv.refresh();
	    	
	    	MyConnection.insert_Product(id, name,quantity , price);
	    	My_List = MyConnection.getProductsData();
	    	Product_tbv.setItems(My_List);
	    	
	    	PID_txtbx.clear();
	    	PName_txtbx.clear();
	    	Price_txtbx.clear();
	    	Quantity_txtbx.clear();
	    }
	 
	 
	    @FXML
	    void VehicleClearAllButton(ActionEvent event) {
	    	System.out.println("Clear All Vehicles");
	        showDialog(Product_tbv.getScene().getWindow(), Modality.APPLICATION_MODAL, Product_tbv);
	    }

	    @FXML
	    void VehicleDeleteButton(ActionEvent event) {

	    }
	    
	    
	    private void showDialog(Window owner, Modality modality, TableView<Products> table) {
	        Stage stage = new Stage();
	        stage.initOwner(owner);
	        stage.initModality(modality);

	        Button yesButton = new Button("Confirm");
	        yesButton.setOnAction(e -> {
	            for (Products row : new ArrayList<>(table.getItems())) {
	                MyConnection.deleteVehicleRow(row);
	            }
	            System.out.println("jahfalhgaldj");
	            table.getItems().clear();
	            System.out.println("jahfalhgaldj");
	            table.refresh();
	            stage.close();
	        });

	        Button noButton = new Button("Cancel");
	        noButton.setOnAction(e -> stage.close());

	        HBox root = new HBox(10, yesButton, noButton);
	        root.setAlignment(Pos.CENTER);
	        Scene scene = new Scene(root, 400, 100);
	        stage.setScene(scene);
	        stage.setTitle("Confirm Delete?");
	        stage.show();
	    }
	    @FXML
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
			 else if (event.getSource()==ordersButton) {
		 
		 Parent root = FXMLLoader.load(getClass().getResource("orders.fxml"));
			Scene scene = new Scene(root);
			Stage regStage = new Stage();

			regStage.setScene(scene);
			regStage.show();

			ordersButton.getScene().getWindow().hide();
		 
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
