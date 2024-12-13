package application;

import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
import static javafx.stage.Modality.NONE;

public class VehiclesController implements Initializable {

    ObservableList<vehicles> vehiclesList;
    ObservableList<Integer> managerIds;
    ObservableList<Integer> employeeIds;
    
    @FXML
    private TextField Search;
    
    @FXML
    private Button exitButton;
    
    @FXML
    private TableColumn<vehicles, Integer> numberOfOrdersCol;
    
    @FXML
    private TextField VehicleNumberOfOrders;
    
    @FXML
    private TableView<vehicles> vehiclesTable;

    @FXML
    private TableColumn<vehicles, Integer> VidCol;

    @FXML
    private TableColumn<vehicles, Integer> capacityCol;

    @FXML
    private TableColumn<vehicles, String> licensePlateNumberCol;

    @FXML
    private TableColumn<vehicles, String> licenseExpiryDateCol;

    @FXML
    private TableColumn<vehicles, String> modelCol;

    @FXML
    private TableColumn<vehicles, Integer> yearOfProductionCol;

    @FXML
    private TableColumn<vehicles, Integer> EidCol;
    
    @FXML
    private BorderPane ViewVehicleWindow;

    @FXML
    private BorderPane AddNewVehicleWindow;

    @FXML
    private Button AddVehicleButton;

    @FXML
    private Button BackFromAddNewVehicle;

    @FXML
    private TextField EidTextView;

    @FXML
    private TextField EmployeeIdForTheVehicleData;

    @FXML
    private Button GoToAddNewVehicleButton;

   

    @FXML
    private Button GoToViewVehicleTable;

    @FXML
    private TextField VehicleCapacityData;

    @FXML
    private Button VehicleClearAllButton;

    @FXML
    private Button VehicleDeleteButton;

    @FXML
    private TextField VehicleIdData;

    @FXML
    private TextField VehicleLicenseExpiryDateData;

    @FXML
    private TextField VehicleLicensePlateNumberData;

    @FXML
    private TextField VehicleManagerData;

    @FXML
    private TextField VehicleModelData;

    @FXML
    private GridPane VehicleRegister;

    @FXML
    private Button VehicleViewBackButton;

    @FXML
    private TextField VehicleYearOfProductionData;

    @FXML
    private AnchorPane VehiclesSelection;

    @FXML
    private TextField VidTextView;

    @FXML
    private TextField capacityTextView;

    @FXML
    private TextField licenseExpiryDateTextView;

    @FXML
    private TextField licensePlateNumberTextView;

    @FXML
    private TextField modelTextView;

    @FXML
    private TextField yearOfProductionTextView;

    

    @FXML
    private Button employeesButton;
    @FXML
    private Button departmentsButton;

    @FXML
    private Button suppliersButton;

    @FXML
    private Button vehiclesButton;
    
    @FXML
    private Button clientsButton;

    @FXML
    private Button dashBoardButton;
    @FXML
    private Button ordersButton;

    @FXML
    private Button productsButton;

    @FXML
    private Button warehousesButton;

    
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
    	 
     	 else if (event.getSource()==clientsButton) {
     		 
     		 Parent root = FXMLLoader.load(getClass().getResource("clientView.fxml"));
   			Scene scene = new Scene(root);
   			Stage regStage = new Stage();
   
   			regStage.setScene(scene);
   			regStage.show();
   
   			clientsButton.getScene().getWindow().hide();
     		 
     	 }
    	 
    	 
     	 else if (event.getSource()==employeesButton) {
     		 
     		 Parent root = FXMLLoader.load(getClass().getResource("Employees.fxml"));
   			Scene scene = new Scene(root);
   			Stage regStage = new Stage();
   
   			regStage.setScene(scene);
   			regStage.show();
   
   			employeesButton.getScene().getWindow().hide();
     		 
     	 }
    	 
    	 
     	 else if (event.getSource()==departmentsButton) {
     		 
     		 Parent root = FXMLLoader.load(getClass().getResource("departmentView.fxml"));
   			Scene scene = new Scene(root);
   			Stage regStage = new Stage();
   
   			regStage.setScene(scene);
   			regStage.show();
   
   			departmentsButton.getScene().getWindow().hide();
     		 
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
    void GoToAddNewVehicleButton(ActionEvent event) {
    	VehicleRegister.setVisible(true);
    }
    
    @FXML
    private ComboBox<String> SelectionBox;
    
    @FXML
    void AddVehicleButton(ActionEvent event) {
    	
    	if (!checkForEmptyData()) {
    		if (verifyData()) {
    			int managerId = Integer.parseInt(VehicleManagerData.getText().toString().trim());
            	int Vid = Integer.parseInt(VehicleIdData.getText().toString().trim());
            	String	model = VehicleModelData.getText().toString().trim();
            	int	yearOfProduction = Integer.parseInt(VehicleYearOfProductionData.getText().toString().trim());
            	int capacity = Integer.parseInt(VehicleCapacityData.getText().toString().trim());
            	String licensePlateNumber = VehicleLicensePlateNumberData.getText().toString().trim();
            	String licenseExpiryDate = VehicleLicenseExpiryDateData.getText().toString().trim();
            	int	Eid = Integer.parseInt(EmployeeIdForTheVehicleData.getText().toString().trim());
            	int numberOfOrders = Integer.parseInt(VehicleNumberOfOrders.getText().toString().trim());
            	
            		int vidProplem = 0, eidMatch = 0;
               	 for (vehicles vehicle : vehiclesList) {
           			 if (vehicle.Vid == Vid) {
           				 vehicleIdRepeated(vehiclesTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
           				 vidProplem = 1;
           				 break;
           			 }
           			 
           		 }
               	 for (Integer i : employeeIds) {
           			 if (i == Eid) {
           				 eidMatch = 1;
           				 break;
           			 }
           			 
           		 }
               	 if (eidMatch == 0)
               		 employeeIdNotFound(vehiclesTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
               	 if (vidProplem == 0 && eidMatch ==  1) {
               		 
               	    		int flag = 0;
               	    		vehicles emp = new vehicles(Vid,model, yearOfProduction, capacity, numberOfOrders,licensePlateNumber, licenseExpiryDate,Eid);
               	    		
               	    		for (int i = 0; i < managerIds.size(); i++) {
               	    		    int id = managerIds.get(i);
               	    		    if (id == managerId)
               	    		    	flag = 1;
               	    		}
               	    		if (flag == 1) {
               	    			try {
               	    				mySqlConnect.insertVehiclesData(emp);
                   	    	        vehiclesTable.getItems().add(emp);
                   	    			vehiclesTable.refresh();
               	    			}catch (SQLException e) {
               						e.printStackTrace();
               					}
               	    			dataAddedSuccesfully(vehiclesTable.getScene().getWindow(),Modality.APPLICATION_MODAL);
               	    			VehicleIdData.setText("");
               	    			VehicleModelData.setText("");
               	    			VehicleYearOfProductionData.setText("");
               	    			VehicleCapacityData.setText("");
               	    			VehicleLicensePlateNumberData.setText("");
               	    			VehicleLicenseExpiryDateData.setText("");
               	    			EmployeeIdForTheVehicleData.setText("");
               	    			VehicleManagerData.setText("");
               	    			VehicleNumberOfOrders.setText("");
               	    		}
               	    		else {
               	    			showManagerIdNotFound(vehiclesTable.getScene().getWindow(),Modality.APPLICATION_MODAL);
               	    		}
               	    	
               	 }
    		}
    			
       	}
        	
    	else
    	missingData(vehiclesTable.getScene().getWindow(),Modality.APPLICATION_MODAL);
    }
    
    @FXML
    void BackFromAddNewVehicle(ActionEvent event) {
    	VehicleRegister.setVisible(false);
    }

    @FXML
    void GoToViewVehicleTable(ActionEvent event) {
    	ViewVehicleWindow.setVisible(true);
    }

    @FXML
    void VehicleDeleteButton(ActionEvent event) {
        ObservableList<vehicles> selectedRows = vehiclesTable.getSelectionModel().getSelectedItems();
        ArrayList<vehicles> rows = new ArrayList<>(selectedRows);
        rows.forEach(row -> {
            vehiclesTable.getItems().remove(row);
            mySqlConnect.deleteVehicleRow(row);
            vehiclesTable.refresh();
        });
    }

    @FXML
    void VehicleClearAllButton(ActionEvent event) {
        System.out.println("Clear All Vehicles");
        showDialog(vehiclesTable.getScene().getWindow(), Modality.APPLICATION_MODAL, vehiclesTable);
    }
    @FXML
    void VehicleViewBackButton(ActionEvent event) {
    	ViewVehicleWindow.setVisible(false);
    }
    
   
    @FXML
    void Search(KeyEvent event) throws ClassNotFoundException, SQLException {
    	String select = SelectionBox.getValue();
    	if (select.equals("Vid")) {
    		vehiclesList = mySqlConnect.getDatavehicles("select * from vehicles where Vid like '"+Search.getText()+"%' order by Vid");
        	vehiclesTable.setItems(vehiclesList);	
    	}
    	else if(select.equals("capacity")) {
    		vehiclesList = mySqlConnect.getDatavehicles("select * from vehicles where capacity like '"+Search.getText()+"%' order by Vid");
    		vehiclesTable.setItems(vehiclesList);
    	}
    	else if (select.equals("Eid")){
    		vehiclesList = mySqlConnect.getDatavehicles("select * from vehicles where Eid like '"+Search.getText()+"%' order by Vid");
    		vehiclesTable.setItems(vehiclesList);
    	}
    	else {
    		vehiclesList = mySqlConnect.getDatavehicles("select * from vehicles where licensePlateNumber like '"+Search.getText()+"%' order by Vid");
    		vehiclesTable.setItems(vehiclesList);
    	}
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
        	SelectionBox.setItems(FXCollections.observableArrayList("Vid",  "capacity", "PlateNumber","Eid"));
        	SelectionBox.getSelectionModel().select(0);
        	ViewVehicleWindow.setVisible(true);
            vehiclesList = FXCollections.observableArrayList(mySqlConnect.getDatavehicles());
            managerIds = FXCollections.observableArrayList(mySqlConnect.getManagerIds());
            employeeIds = FXCollections.observableArrayList(mySqlConnect.getEmployeeIds());
         

            vehiclesTable.setEditable(true);
            vehiclesTable.setItems(vehiclesList);

            VidCol.setCellValueFactory(new PropertyValueFactory<>("Vid"));
            modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
            yearOfProductionCol.setCellValueFactory(new PropertyValueFactory<>("yearOfProduction"));
            capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
            licensePlateNumberCol.setCellValueFactory(new PropertyValueFactory<>("licensePlateNumber"));
            licenseExpiryDateCol.setCellValueFactory(new PropertyValueFactory<>("licenseExpiryDate"));
            EidCol.setCellValueFactory(new PropertyValueFactory<>("Eid"));
            numberOfOrdersCol.setCellValueFactory(new PropertyValueFactory<>("numberOfOrders"));

            modelCol.setCellFactory(TextFieldTableCell.forTableColumn());
            modelCol.setOnEditCommit((CellEditEvent<vehicles, String> t) -> {
                t.getRowValue().setModel(t.getNewValue());
                mySqlConnect.updateVehicleModel(t.getRowValue().getVid(), t.getNewValue());
            });

            yearOfProductionCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            yearOfProductionCol.setOnEditCommit((CellEditEvent<vehicles, Integer> t) -> {
                t.getRowValue().setYearOfProduction(t.getNewValue());
                mySqlConnect.updateVehicleYOF(t.getRowValue().getVid(), t.getNewValue());
            });
            
            numberOfOrdersCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            numberOfOrdersCol.setOnEditCommit((CellEditEvent<vehicles, Integer> t) -> {
                vehicles vehicle = t.getRowValue();
                int newNumberOfOrders = t.getNewValue();
                int capacity = vehicle.getCapacity();
                
                if (newNumberOfOrders < capacity) {
                    vehicle.setNumberOfOrders(newNumberOfOrders);
                    mySqlConnect.updateVehicleNOO(vehicle.getVid(), newNumberOfOrders);
                } else {
                    // Show an error message
                    numOfOrdersProp();

                    // Revert to the old value
                    t.getTableView().refresh();
                }
            });
            
            

            capacityCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            capacityCol.setOnEditCommit((CellEditEvent<vehicles, Integer> t) -> {
                vehicles vehicle = t.getRowValue();
                int newCapacity = t.getNewValue();

                // Optionally, you can also validate that number of orders is less than capacity
                // after updating the capacity. If not, show a warning.
                if (vehicle.getNumberOfOrders() > newCapacity) {
                   capacityProp();
                // Revert to the old value
                   t.getTableView().refresh();
                }
                else {vehicle.setCapacity(newCapacity);
                mySqlConnect.updateVehicleCapacity(vehicle.getVid(), newCapacity);
                }
            });

            licensePlateNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
            licensePlateNumberCol.setOnEditCommit((CellEditEvent<vehicles, String> t) -> {
                t.getRowValue().setLicensePlateNumber(t.getNewValue());
                mySqlConnect.updateVehicleLPN(t.getRowValue().getVid(), t.getNewValue());
            });

            licenseExpiryDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            licenseExpiryDateCol.setOnEditCommit((CellEditEvent<vehicles, String> t) -> {
                t.getRowValue().setLicenseExpiryDate(t.getNewValue());
                mySqlConnect.updateVehicleLED(t.getRowValue().getVid(), t.getNewValue());
            });

            EidCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            EidCol.setOnEditCommit((CellEditEvent<vehicles, Integer> t) -> {
                t.getRowValue().setEid(t.getNewValue());
                mySqlConnect.updateVehicleYOF(t.getRowValue().getVid(), t.getNewValue());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showDialog(Window owner, Modality modality, TableView<vehicles> table) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Button yesButton = new Button("Confirm");
        yesButton.setOnAction(e -> {
            for (vehicles row : new ArrayList<>(table.getItems())) {
                mySqlConnect.deleteVehicleRow(row);
            }
            table.getItems().clear();
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
    private void showManagerIdNotFound(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Manager ID is not found");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 200, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void dataAddedSuccesfully(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Vehicle added successfully");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 220, 50);
        stage.setScene(scene);
        stage.setTitle("Success!");
        stage.show();
    }
    private void managerNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Manager ID must be integer");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 220, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void vehicleIdNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Vehicle ID must be integer");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 220, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void vehicleIdRepeated(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("This vehicle ID is already in the data base");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void vehicleModelNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Vehicle model must be string");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 220, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void vehicleYOFNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Vehicle year of production must be string");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void vehicleCapacityNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Vehicle capacity must be integer");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 220, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void vehicleLEDNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Vehicle license expiry date must be in this formate YYYY-MM-DD");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void employeeIdNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Employee ID must be integer");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 220, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void employeeIdNotFound(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("This driver ID is not found in the data base");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 350, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void vehicleNOONotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Vehicle number of orders must be integer");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 350, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void numOfOrdersProp() {
    	JOptionPane.showMessageDialog(null, "Number Of Orders must be less than capacity");
    }
    private void capacityProp() {
    	JOptionPane.showMessageDialog(null, "Capacity must be more than number Of Orders");
    }
    private boolean isNumeric(String str) { 
    	  try {  
    	    Integer.parseInt(str);  
    	    return true;
    	  } catch(NumberFormatException e){  
    	    return false;  
    	  }  
    	}
    private boolean isDate(String str) { 
    	try {  
    		if (str.charAt(4) == '-' && str.charAt(7) == '-')  
    			return true;
    		else
    			  return false;
    	  } catch(Exception e){  
    	    return false;  
    	  }  
  	}
    private boolean verifyData() {
    	int notValidData = 0;
    	if (isNumeric(VehicleManagerData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		managerNotValid(vehiclesTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}
    	if (isNumeric(VehicleIdData.getText().toString().trim()))
    		 ;
    	else {
    		notValidData++;
    		vehicleIdNotValid(vehiclesTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}
    	if (!isNumeric(VehicleModelData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		vehicleModelNotValid(vehiclesTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}	
    	if (isNumeric(VehicleYearOfProductionData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		vehicleYOFNotValid(vehiclesTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}
    	if (isNumeric(VehicleCapacityData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		vehicleCapacityNotValid(vehiclesTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}	
    	if (isDate(VehicleLicenseExpiryDateData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		vehicleLEDNotValid(vehiclesTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}	
    	if (isNumeric(EmployeeIdForTheVehicleData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		employeeIdNotValid(vehiclesTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}
    	if (isNumeric(VehicleNumberOfOrders.getText().toString().trim()))
    		if (Integer.parseInt(VehicleCapacityData.getText().toString().trim())<Integer.parseInt(VehicleNumberOfOrders.getText().toString().trim())) {
    			notValidData++;
    			numOfOrdersProp();
    		}
    	else {
    		notValidData++;
    		vehicleNOONotValid(vehiclesTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}
    	if (notValidData == 0)
    		return true;
    	else
    		return false;
    }
    private boolean checkForEmptyData() {
    	int notValidData = 0;
    	if (VehicleManagerData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (VehicleIdData.getText().toString().trim().length() == 0 )
    		notValidData++;
    	if (VehicleModelData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (VehicleYearOfProductionData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (VehicleCapacityData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (VehicleLicensePlateNumberData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (VehicleLicenseExpiryDateData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (EmployeeIdForTheVehicleData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (VehicleNumberOfOrders.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (notValidData > 0)
    		return true;
    		else
    			return false;
    	    }
    private void missingData(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Must fill all data");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 200, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    	
}

