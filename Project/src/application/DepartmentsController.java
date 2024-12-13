package application;

import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.converter.IntegerStringConverter;

public class DepartmentsController implements Initializable{
	
		ObservableList<departments> departmentList;
		ObservableList<Integer> managerIds;
		ObservableList<Integer> employeeIds;
	 	@FXML
	    private BorderPane AddNewDepartmentWindow;
	 	
	 	@FXML
	    private Button exitButton;

	    @FXML
	    private Button AddVehicleButton;

	    @FXML
	    private Button BackFromAddNewVehicle;

	    @FXML
	    private Button DeparmentDeleteButton;

	    @FXML
	    private Button DepartmentClearAllButton;
	    
	    
	    @FXML
	    private Button clientButton;

	    @FXML
	    private Button dashBoardButton;
	    
	    @FXML
	    private Button employeesButton;

	    @FXML
	    private Button ordersButton;

	    @FXML
	    private Button productsButton;

	    @FXML
	    private Button warehousesButton;



	    @FXML
	    private AnchorPane DepartmentSelection;

	    @FXML
	    private Button DepartmentViewBackButton;

	    @FXML
	    private Button GoToAddNewDepartmentButton;

	    @FXML
	    private Button DepartmentsButton;

	    @FXML
	    private Button SuppliersButton;

	    @FXML
	    private Button VehiclesButton;

	   

	    @FXML
	    private TextField VehicleCapacityData;

	    @FXML
	    private TextField VehicleIdData;

	    @FXML
	    private TextField VehicleManagerData;

	    @FXML
	    private TextField VehicleModelData;

	    @FXML
	    private TextField VehicleYearOfProductionData;
	    
	    @FXML
	    private TextField searchTextField;

	    @FXML
	    private BorderPane ViewDepartmentWindow;

	    @FXML
	    private TableView<departments> deparmentsTable;

	    @FXML
	    private TableColumn<departments, Integer> DidCol;

	    @FXML
	    private TableColumn<departments, String> nameCol;

	    @FXML
	    private TableColumn<departments, Integer> numberOfEmployeesCol;
	    
	    @FXML
	    private TableColumn<departments, Integer> EidCol;
	    
	    @FXML
	    private TableColumn<departmentEmployees, Integer> departmentEmpIDCol;

	    @FXML
	    private TableColumn<departmentEmployees, String> departmentEmpNameCol;

	    @FXML
	    private TableView<departmentEmployees> departmentEmployeesTable;
	    
	    @FXML
	    private ComboBox<String> searchBox;
	    
	    @FXML
	    private Label numEmp;
	    
	    ObservableList<departmentEmployees> listD;
	    


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
	     	 
	     	 else if (event.getSource()==warehousesButton) {
	     		 
	     		 Parent root = FXMLLoader.load(getClass().getResource("warehouseView.fxml"));
	   			Scene scene = new Scene(root);
	   			Stage regStage = new Stage();
	   
	   			regStage.setScene(scene);
	   			regStage.show();
	   
	   			warehousesButton.getScene().getWindow().hide();
	     		 
	     	 }
	    	 
	     	 else if (event.getSource()==clientButton) {
	     		 
	     		 Parent root = FXMLLoader.load(getClass().getResource("clientView.fxml"));
	   			Scene scene = new Scene(root);
	   			Stage regStage = new Stage();
	   
	   			regStage.setScene(scene);
	   			regStage.show();
	   
	   			warehousesButton.getScene().getWindow().hide();
	     		 
	     	 }
	    	 
	    	 
	     	 else if (event.getSource()==VehiclesButton) {
	     		 
	     		 Parent root = FXMLLoader.load(getClass().getResource("Vehicles.fxml"));
	   			Scene scene = new Scene(root);
	   			Stage regStage = new Stage();
	   
	   			regStage.setScene(scene);
	   			regStage.show();
	   
	   			VehiclesButton.getScene().getWindow().hide();
	     		 
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
	     	 else if (event.getSource()==SuppliersButton) {
	     		 
	     		 Parent root = FXMLLoader.load(getClass().getResource("Suppliers.fxml"));
	   			Scene scene = new Scene(root);
	   			Stage regStage = new Stage();
	   
	   			regStage.setScene(scene);
	   			regStage.show();
	   
	   			SuppliersButton.getScene().getWindow().hide();
	     		 
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

	
	  
	public void initialize(URL url, ResourceBundle rb) {
		
		searchBox.setItems(FXCollections.observableArrayList("Did",  "name"));
		searchBox.getSelectionModel().select(0);
		 try {
	        	ViewDepartmentWindow.setVisible(true);
	            departmentList = FXCollections.observableArrayList(mySqlConnect.getDataDepartments());
	            managerIds = FXCollections.observableArrayList(mySqlConnect.getManagerIds());
	            employeeIds = FXCollections.observableArrayList(mySqlConnect.getEmployeeIds());
	         

	            deparmentsTable.setEditable(true);
	            deparmentsTable.setItems(departmentList);

	            DidCol.setCellValueFactory(new PropertyValueFactory<>("Did"));
	            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
	            numberOfEmployeesCol.setCellValueFactory(new PropertyValueFactory<>("numberOfEmployees"));
	            EidCol.setCellValueFactory(new PropertyValueFactory<>("Eid"));

	            nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
	            nameCol.setOnEditCommit((CellEditEvent<departments, String> t) -> {
	                t.getRowValue().setName(t.getNewValue());
	                mySqlConnect.updateDepartmentName(t.getRowValue().getDid(), t.getNewValue());
	            });

	            numberOfEmployeesCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
	            numberOfEmployeesCol.setOnEditCommit((CellEditEvent<departments, Integer> t) -> {
	                t.getRowValue().setNumberOfEmployees(t.getNewValue());
	                mySqlConnect.updateDepartmentNOE(t.getRowValue().getDid(), t.getNewValue());
	            });

	            EidCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
	            EidCol.setOnEditCommit((CellEditEvent<departments, Integer> t) -> {
	                t.getRowValue().setEid(t.getNewValue());
	                mySqlConnect.updateDepartmentEid(t.getRowValue().getDid(), t.getNewValue());
	            });
	            
	            
	            departmentEmpIDCol.setCellValueFactory(new PropertyValueFactory<departmentEmployees, Integer>("eid"));
	            departmentEmpNameCol.setCellValueFactory(new PropertyValueFactory<departmentEmployees, String>("name"));


	            listD =  FXCollections.observableArrayList(mySqlConnector.getDepartmentsEmplyeesData());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 
         departmentEmployeesTable.setItems(listD);
         numEmp.setText(String.valueOf(listD.size()));


	}
	
	@FXML
    void search(KeyEvent event) throws SQLException {
		String choose = null;
		   
		   choose = searchBox.getValue();
		   listD= mySqlConnector.getDepartmentsEmplyeesData("select distinct e.eid,e.name from  employee e, warehouses h where e.did !=0 and e."+choose+" like '"+searchTextField.getText()+"%';");
	         departmentEmployeesTable.setItems(listD);
	         numEmp.setText(String.valueOf(listD.size()));

    }
	
	
	 
}