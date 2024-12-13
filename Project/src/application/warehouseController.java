package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.util.converter.IntegerStringConverter;

public class warehouseController implements Initializable{
	
	Connection con= null;
	
    
    @FXML
    private Button clientButton;

    @FXML
    private Button dashBoardButton;

    @FXML
    private Button departmentsButton;

    @FXML
    private Button employeesButton;

    @FXML
    private Button ordersButton;

    @FXML
    private Button productsButton;
    
    @FXML
    private Button suppliersButton;


    @FXML
    private Button vehiclesButton;
    
    
    
    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane warehousePane;
    
 
    

    @FXML
    private Label numEmp;
    
    @FXML
    private ComboBox<String> searchBox;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<warehouse> warehouseTable;
    
    @FXML
    private TableColumn<warehouse, String> locationCol;

    @FXML
    private TableColumn<warehouse, Integer> numOfEmployeesCol;
    
    @FXML
    private TableColumn<warehouse, Integer> capacityCol;
    
    @FXML
    private TableColumn<warehouse, Integer> widCol;
    

    @FXML
    private TableColumn<warehouseEmployees, Integer> empIDCol;

    @FXML
    private TableColumn<warehouseEmployees, String> empNameCol;

    @FXML
    private TableView<warehouseEmployees> employeeTable;

    @FXML
    private Button warehousesButton;
    @FXML
    private ImageView editImage;

    
    ObservableList<warehouse> listw;
    ObservableList<warehouseEmployees> listw2;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
		searchBox.setItems(FXCollections.observableArrayList("wid",  "name"));
		searchBox.getSelectionModel().select(0);
		
		widCol.setCellValueFactory(new PropertyValueFactory<warehouse, Integer>("wid"));
		
        locationCol.setCellValueFactory(new PropertyValueFactory<warehouse, String>("location"));
        
        
		capacityCol.setCellValueFactory(new PropertyValueFactory<warehouse, Integer>("capacity"));
        //capacityCol.setCellFactory(TextFieldTableCell.<warehouse>forTableColumn());


		numOfEmployeesCol.setCellValueFactory(new PropertyValueFactory<warehouse, Integer>("NumberOfEmployees"));
		numOfEmployeesCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		
		empIDCol.setCellValueFactory(new PropertyValueFactory<warehouseEmployees, Integer>("Eid"));
		empNameCol.setCellValueFactory(new PropertyValueFactory<warehouseEmployees, String>("Name"));
		
		numOfEmployeesCol.setOnEditCommit(
				
				(CellEditEvent<warehouse, Integer> t) -> {
            ((warehouse) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setNumberOfEmployees(t.getNewValue()); //display only
 //updateName( t.getRowValue().getCid(),t.getNewValue());
});

		
		try {
			listw=mySqlConnector.getWarehousesData();
			listw2=mySqlConnector.getWarehousesEmplyeesData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		warehouseTable.setItems(listw);
		employeeTable.setItems(listw2);
		numEmp.setText(String.valueOf(listw2.size()));

        
		
	}
	
	  @FXML
	    void search(KeyEvent event) throws SQLException {
		  String choose = null;
		   
		   choose = searchBox.getValue();
		   listw2= mySqlConnector.getWarehousesEmplyeesData("select distinct e.eid,e.name from  employee e, warehouses h where e.wid !=0 and e."+choose+" like '"+searchTextField.getText()+"%';");
			employeeTable.setItems(listw2);
			numEmp.setText(String.valueOf(listw2.size()));


	    }
	  

	  

	
	 @FXML
	    void switchForm(ActionEvent event) throws IOException {
		 
		 if (event.getSource()==dashBoardButton) {
		 		
	 			Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
	 			Scene scene = new Scene(root);
	 			Stage regStage = new Stage();
	 
	 			regStage.setScene(scene);
	 			regStage.show();
	 
	 			clientButton.getScene().getWindow().hide();
	 			
	 		}
	    	 
	    	 else if (event.getSource()==clientButton) {
	    		 
	    		 Parent root = FXMLLoader.load(getClass().getResource("clientView.fxml"));
	  			Scene scene = new Scene(root);
	  			Stage regStage = new Stage();
	  
	  			regStage.setScene(scene);
	  			regStage.show();
	  
	  			clientButton.getScene().getWindow().hide();
	    		 
	    	 }
		 
	    	 else if (event.getSource()==departmentsButton) {
	     		 
	     		 Parent root = FXMLLoader.load(getClass().getResource("departmentView.fxml"));
	   			Scene scene = new Scene(root);
	   			Stage regStage = new Stage();
	   
	   			regStage.setScene(scene);
	   			regStage.show();
	   
	   			departmentsButton.getScene().getWindow().hide();
	     		 
	     	 }
		 
	    	 else if (event.getSource()==vehiclesButton) {
	     		 
	     		 Parent root = FXMLLoader.load(getClass().getResource("Vehicles.fxml"));
	   			Scene scene = new Scene(root);
	   			Stage regStage = new Stage();
	   
	   			regStage.setScene(scene);
	   			regStage.show();
	   
	   			vehiclesButton.getScene().getWindow().hide();
	     		 
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
	    void getData(ActionEvent event) {
	    	warehouse selectedWarehouse = warehouseTable.getSelectionModel().getSelectedItem();
            if (selectedWarehouse != null) {
            //	warehouseData.setText(String.valueOf(selectedWarehouse.getWid()));
            //	capacityData.setText(String.valueOf(selectedWarehouse.getCapacity()));
            //	locationData.setText(selectedWarehouse.getLocation());
            //	numOfEmpData.setText(String.valueOf(selectedWarehouse.getNumberOfEmployees()));

            }
	    }


}
