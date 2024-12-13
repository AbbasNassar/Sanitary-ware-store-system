package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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

public class EmployeesController implements Initializable{
	
	ObservableList<employees> employeesList;
	ObservableList<employeesPhones> employeesPhoneList;
	ObservableList<Integer> managerIds;
	@FXML
    private Button AddEmployeeButton;
	
	@FXML
    private Button exitButton;
	
    @FXML
    private TextField EmployeeManagerData1;

    @FXML
    private Button AddPhoneNumberButton;

    @FXML
    private TextField EmployeeAddressData;

    @FXML
    private TextField EmployeeDid;

    @FXML
    private TextField EmployeeIdData;

    @FXML
    private TextField EmployeeJobType;

    @FXML
    private TextField EmployeeManagerData;

    @FXML
    private TextField EmployeeNameData;

    @FXML
    private TextField EmployeePhoneNumberData;

    @FXML
    private TextField EmployeeSalary;

    @FXML
    private TextField EmployeeSearch;

    @FXML
    private TextField EmployeeWid;

    @FXML
    private AnchorPane EmployeeWindow;
    
    @FXML
    private TextField EmployeePass;

    @FXML
    private Button departmentsButton;

    @FXML
    private Button suppliersButton;

    @FXML
    private Button vehiclesButton;
    
    @FXML
    private Button clientButton;

    @FXML
    private Button dashBoardButton;
    
    @FXML
    private Button ordersButton;

    @FXML
    private Button productButton;

    @FXML
    private Button warehousesButton;

    @FXML
    private Button EmployeeClearAllButton;

    @FXML
    private Button EmployeeDeleteButton;
    
    @FXML
    private TextField EmployeeIdData1;

    @FXML
    private ComboBox<String> attributeSelection;
    
    @FXML
    private TableView<employees> employeeTable;
    
    @FXML
    private TableView<employeesPhones> EmployeesPhoneNumberTable;
    
    @FXML
    private TableColumn<employeesPhones, Integer> EidCol;

    @FXML
    private TableColumn<employees, Integer> EidColMain;

    @FXML
    private TableColumn<employees, String> employeeAddressCol;

    @FXML
    private TableColumn<employees, Integer> employeeDidCol;

    @FXML
    private TableColumn<employees, String> employeeJobTypeCol;

    @FXML
    private TableColumn<employees, String> employeeNameCol;

    @FXML
    private TableColumn<employees, String> employeePassCol;

    @FXML
    private TableColumn<employeesPhones, String> employeePhoneNumberCol;

    @FXML
    private TableColumn<employees, Integer> employeeSalaryCol;

    @FXML
    private TableColumn<employees, Integer> employeeWidCol;
    @FXML
    private Button GoToEmployeesButton;
    
    
    
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
    	 
    	 
     	 else if (event.getSource()==vehiclesButton) {
     		 
     		 Parent root = FXMLLoader.load(getClass().getResource("Vehicles.fxml"));
   			Scene scene = new Scene(root);
   			Stage regStage = new Stage();
   
   			regStage.setScene(scene);
   			regStage.show();
   
   			vehiclesButton.getScene().getWindow().hide();
     		 
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
    	 
     	 else if (event.getSource()==productButton) {
     		 
     		 Parent root = FXMLLoader.load(getClass().getResource("Products.fxml"));
   			Scene scene = new Scene(root);
   			Stage regStage = new Stage();
   
   			regStage.setScene(scene);
   			regStage.show();
   
   			productButton.getScene().getWindow().hide();
     		 
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
    void AddEmployeeButton(ActionEvent event) {
    	if (!checkForEmptyData()) {
    		if (verifyData()) {
    			int managerId = Integer.parseInt(EmployeeManagerData.getText().toString().trim());
            	int Eid = Integer.parseInt(EmployeeIdData.getText().toString().trim());
            	String	name = EmployeeNameData.getText().toString().trim();
            	String	address = EmployeeAddressData.getText().toString().trim();
            	int salary = Integer.parseInt(EmployeeSalary.getText().toString().trim());
            	String jobType = EmployeeJobType.getText().toString().trim();
            	int Did = Integer.parseInt(EmployeeDid.getText().toString().trim());
            	int Wid = Integer.parseInt(EmployeeWid.getText().toString().trim());
            	String pass = EmployeePass.getText().toString().trim();
            	
            	int EidProplem = 0;
              	 for (employees emp : employeesList) {
          			 if (emp.getEid() == Eid) {
          				 EidProplem = 1;
          				 break;
          			 }
          			 
          		 }
              	 if (EidProplem == 0) {
              		int flag = 0;
       	    		employees emp = new employees(Eid, name, address, salary, jobType, Did, Wid, pass);
       	    		
       	    		
       	    		for (int i = 0; i < managerIds.size(); i++) {
       	    		    int id = managerIds.get(i);
       	    		    if (id == managerId)
       	    		    	flag = 1;
       	    		}
       	    		if (flag == 1) {
       	    			try {
       	    				mySqlConnect.insertEmployeeData(emp);
           	    	        employeeTable.getItems().add(emp);
           	    	     employeeTable.refresh();
       	    			}catch (SQLException e) {
       						e.printStackTrace();
       					}
       	    			catch (ClassNotFoundException e) {
       						e.printStackTrace();
       					}
       	    			dataAddedSuccesfully(employeeTable.getScene().getWindow(),Modality.APPLICATION_MODAL);
       	    			EmployeeManagerData.setText("");
       	    			EmployeeIdData.setText("");
       	    			EmployeeNameData.setText("");
       	    			EmployeeAddressData.setText("");
       	    			EmployeeSalary.setText("");
       	    			EmployeeJobType.setText("");
       	    			EmployeeDid.setText("");
       	    			EmployeeWid.setText("");
       	    			EmployeePass.setText("");
       	    		}
       	    		else {
       	    			showManagerIdNotFound(employeeTable.getScene().getWindow(),Modality.APPLICATION_MODAL);
       	    		} 
              	 }
              	 else {
              		 JOptionPane.showMessageDialog(null, "Inserted employee id is already in table.");;
              	 }
               	 
       	}
    	}
    	else
    	missingData(employeeTable.getScene().getWindow(),Modality.APPLICATION_MODAL);
    }

    @FXML
    void AddPhoneNumberButton(ActionEvent event) {
    	if (!checkForEmptyData1()) {
    		if (verifyData1()) {
    			int managerId = Integer.parseInt(EmployeeManagerData1.getText().toString().trim());
            	int Eid = Integer.parseInt(EmployeeIdData1.getText().toString().trim());
            	String	phoneNumber = EmployeePhoneNumberData.getText().toString().trim();
            	
            	int phoneNumberMatch = 0;
            	for (employeesPhones i : employeesPhoneList) {
          			 if (i.getPhoneNumber().equals(phoneNumber)) {
          				 phoneNumberMatch = 1;
          				 break;
          			 }
          			 
          		 }
              	 if (phoneNumberMatch == 0) {
              		int flag = 0;
       	    		employeesPhones emp = new employeesPhones(Eid, phoneNumber);
       	    		
       	    		
       	    		for (int i = 0; i < managerIds.size(); i++) {
       	    		    int id = managerIds.get(i);
       	    		    if (id == managerId)
       	    		    	flag = 1;
       	    		}
       	    		if (flag == 1) {
       	    			try {
       	    				mySqlConnect.insertEmployeePhoneData(emp);
       	    				EmployeesPhoneNumberTable.getItems().add(emp);
       	    				EmployeesPhoneNumberTable.refresh();
       	    			}catch (SQLException e) {
       						e.printStackTrace();
       					}
       	    			catch (ClassNotFoundException e) {
       						e.printStackTrace();
       					}
       	    			dataAddedSuccesfully1(EmployeesPhoneNumberTable.getScene().getWindow(),Modality.APPLICATION_MODAL);
       	    			EmployeeManagerData1.setText("");
       	    			EmployeeIdData1.setText("");
       	    			EmployeePhoneNumberData.setText("");
       	    		}
       	    		else {
       	    			showManagerIdNotFound(employeeTable.getScene().getWindow(),Modality.APPLICATION_MODAL);
       	    		} 
              	 }
              	 else {
              		 JOptionPane.showMessageDialog(null, "Inserted employee phone number is already in table.");;
              	 } 
       	}
    	}
    	else
    	missingData(employeeTable.getScene().getWindow(),Modality.APPLICATION_MODAL);
    }

    @FXML
    void EmployeeClearAllButton(ActionEvent event) {
    	showDialog(employeeTable.getScene().getWindow(), Modality.APPLICATION_MODAL, employeeTable, EmployeesPhoneNumberTable);
    }

    @FXML
    void EmployeeDeleteButton(ActionEvent event) {
    	 ObservableList<employees> selectedEmployeeRows = employeeTable.getSelectionModel().getSelectedItems();
    	 ObservableList<employeesPhones> selectedEmployeePhoneRows = EmployeesPhoneNumberTable.getSelectionModel().getSelectedItems();
    	 if (selectedEmployeePhoneRows.isEmpty() && !selectedEmployeeRows.isEmpty()) {
    		 ArrayList<employees> rows = new ArrayList<>(selectedEmployeeRows);
             rows.forEach(row -> {
                 employeeTable.getItems().remove(row);
                 ObservableList<employeesPhones> employeeList = EmployeesPhoneNumberTable.getItems();
                 Iterator<employeesPhones> iterator = employeeList.iterator();
                 while (iterator.hasNext()) {
                     employeesPhones employee = iterator.next();
                     if (row.getEid()==employee.getEid()) {
                         iterator.remove();
                     }
                 }
                 mySqlConnect.deleteEmployeeRow(row);
                 employeeTable.refresh();
                 EmployeesPhoneNumberTable.refresh();
             });
    	 }
    	 else if(!selectedEmployeePhoneRows.isEmpty() && selectedEmployeeRows.isEmpty()) {
    		 ArrayList<employeesPhones> rows = new ArrayList<>(selectedEmployeePhoneRows);
             rows.forEach(row -> {
                 EmployeesPhoneNumberTable.getItems().remove(row);
                 mySqlConnect.deleteEmployeePhonesNumberRow(row);
                 employeeTable.refresh();
                 EmployeesPhoneNumberTable.refresh();
             });
    	 }
    }
    
   
    @FXML
    void Search(KeyEvent event) throws ClassNotFoundException, SQLException {
    	String select = attributeSelection.getValue();
    	if (select.equals("Eid")) {
    		employeesList = mySqlConnect.getDataEmployees("select * from employee where Eid like '"+EmployeeSearch.getText()+"%' order by Eid");
        	employeeTable.setItems(employeesList);	
    	}
    	else if (select.equals("Eid")){
    		employeesList = mySqlConnect.getDataEmployees("select * from employee where name like '"+EmployeeSearch.getText()+"%' order by Eid");
        	employeeTable.setItems(employeesList);
    	}
    	else if(select.equals("phoneNumber")){
    		employeesPhoneList = mySqlConnect.getPhoneDataEmployees("select * from employeePhone where phoneNumber like '"+EmployeeSearch.getText()+"%' order by Eid");
    		EmployeesPhoneNumberTable.setItems(employeesPhoneList);
    	}
    	else if(select.equals("Wid")) {
    		employeesList = mySqlConnect.getDataEmployees("select * from employee where Wid like '"+EmployeeSearch.getText()+"%' order by Eid");
        	employeeTable.setItems(employeesList);
    	}
    	else {
    		employeesList = mySqlConnect.getDataEmployees("select * from employee where Did like '"+EmployeeSearch.getText()+"%' order by Eid");
        	employeeTable.setItems(employeesList);
    	}
    }

	@Override
    public void initialize(URL url, ResourceBundle rb) {
		attributeSelection.setItems(FXCollections.observableArrayList("Eid",  "name", "phoneNumber", "Wid", "Did"));
    	attributeSelection.getSelectionModel().select(0);
		//JOptionPane.showConfirmDialog(null, "FUCK");
		try {
			try {
				employeesList = FXCollections.observableArrayList(mySqlConnect.getDataEmployees());
				employeesPhoneList = FXCollections.observableArrayList(mySqlConnect.getPhoneDataEmployees());
			}catch(ClassNotFoundException e) {
				System.out.println("Class not found");
			}
			catch(SQLException e1) {
				System.out.println("query didn't excute");
			}
		
		managerIds = FXCollections.observableArrayList(mySqlConnect.getManagerIds());
		employeeTable.setEditable(true);
		employeeTable.setItems(employeesList);
        EmployeesPhoneNumberTable.setEditable(true);
        EmployeesPhoneNumberTable.setItems(employeesPhoneList);

        EidColMain.setCellValueFactory(new PropertyValueFactory<>("Eid"));
        employeeNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        employeeAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        employeeSalaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        employeeJobTypeCol.setCellValueFactory(new PropertyValueFactory<>("jobType"));
        employeePassCol.setCellValueFactory(new PropertyValueFactory<>("pass"));
        employeeDidCol.setCellValueFactory(new PropertyValueFactory<>("Did"));
        employeeWidCol.setCellValueFactory(new PropertyValueFactory<>("Wid"));
        
        EidCol.setCellValueFactory(new PropertyValueFactory<>("Eid"));
        employeePhoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        employeeNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        employeeNameCol.setOnEditCommit((CellEditEvent<employees, String> t) -> {
            t.getRowValue().setName(t.getNewValue());
            mySqlConnect.updateEmployeeName(t.getRowValue().getEid(), t.getNewValue());
        });

        employeeAddressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        employeeAddressCol.setOnEditCommit((CellEditEvent<employees, String> t) -> {
            t.getRowValue().setAddress(t.getNewValue());
            mySqlConnect.updateEmployeeAddress(t.getRowValue().getEid(), t.getNewValue());
        });
        
        employeePassCol.setCellFactory(TextFieldTableCell.forTableColumn());
        employeePassCol.setOnEditCommit((CellEditEvent<employees, String> t) -> {
            t.getRowValue().setPass(t.getNewValue());
            mySqlConnect.updateEmployeePass(t.getRowValue().getEid(), t.getNewValue());
        });
        
        employeeJobTypeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        employeeJobTypeCol.setOnEditCommit((CellEditEvent<employees, String> t) -> {
            t.getRowValue().setJobType(t.getNewValue());
            mySqlConnect.updateEmployeeJobType(t.getRowValue().getEid(), t.getNewValue());
        });

        employeePhoneNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
        employeePhoneNumberCol.setOnEditCommit((CellEditEvent<employeesPhones, String> t) -> {
            t.getRowValue().setPhoneNumber(t.getNewValue());
            mySqlConnect.updateEmployeePhoneNumber(t.getRowValue().getEid(), t.getNewValue());
        });
        employeeSalaryCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        employeeSalaryCol.setOnEditCommit((CellEditEvent<employees, Integer> t) -> {
            t.getRowValue().setSalary(t.getNewValue());
            mySqlConnect.updateEmployeeSalary(t.getRowValue().getEid(), t.getNewValue());
        });
        employeeDidCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        employeeDidCol.setOnEditCommit((CellEditEvent<employees, Integer> t) -> {
            t.getRowValue().setDid(t.getNewValue());
            mySqlConnect.updateEmployeeDid(t.getRowValue().getEid(), t.getNewValue());
        });
        employeeWidCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        employeeWidCol.setOnEditCommit((CellEditEvent<employees, Integer> t) -> {
            t.getRowValue().setWid(t.getNewValue());
            mySqlConnect.updateEmployeeWid(t.getRowValue().getEid(), t.getNewValue());
        });
        // One row is selected at max
   	 	employeeTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
            	EmployeesPhoneNumberTable.getSelectionModel().clearSelection();
            }
        });

   	 	EmployeesPhoneNumberTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
            	employeeTable.getSelectionModel().clearSelection();
            }
        });
		
    } catch (Exception e) {
        e.printStackTrace();
    }
	}
	private void showDialog(Window owner, Modality modality, TableView<employees> table, TableView<employeesPhones> table1) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Button yesButton = new Button("Confirm");
        yesButton.setOnAction(e -> {
            for (employees row : new ArrayList<>(table.getItems())) {
                mySqlConnect.deleteEmployeeRow(row);
            }
            for (employeesPhones row : new ArrayList<>(table1.getItems())) {
                mySqlConnect.deleteEmployeePhonesNumberRow(row);
            }
            table.getItems().clear();
            table.refresh();
            table1.getItems().clear();
            table1.refresh();
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

        Label label = new Label("Employee added successfully");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 220, 50);
        stage.setScene(scene);
        stage.setTitle("Success!");
        stage.show();
    }
    private void dataAddedSuccesfully1(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Employee phone number added successfully");
      
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
    private void phoneNumberRepeated(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("This employee phone number is already in the data base");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void employeeNameNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Employee name must be string");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 220, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void employeeAddressNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Employee address must be string");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void employeePhoneNumberNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Employee phone number must be in this formate 111-1111");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 350, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private boolean isNumeric(String str) { 
    	  try {  
    	    Integer.parseInt(str);  
    	    return true;
    	  } catch(NumberFormatException e){  
    	    return false;  
    	  }  
    	}
    private boolean checkPhoneNumberForm(String str) { 
  	  try {  
  	    if(str.charAt(3) == '-')  
  	    return true;
  	    else
  	    	return false;
  	  }
  	  catch(Exception e) {
  		  return false;
  	  }
  	}
    private boolean verifyData() {
    	int notValidData = 0;
    	if (isNumeric(EmployeeManagerData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		managerNotValid(employeeTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}
    	if (isNumeric(EmployeeIdData.getText().toString().trim()))
    		 ;
    	else {
    		notValidData++;
    		employeeIdNotValid(employeeTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}
    	if (!isNumeric(EmployeeNameData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		employeeNameNotValid(employeeTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}	
    	if (!isNumeric(EmployeeAddressData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		employeeAddressNotValid(employeeTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}
    	if (!isNumeric(EmployeePhoneNumberData.getText().toString().trim())&& checkPhoneNumberForm(EmployeePhoneNumberData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		employeePhoneNumberNotValid(employeeTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}	
    	if (notValidData == 0)
    		return true;
    	else
    		return false;
    }
    private boolean checkForEmptyData() {
    	int notValidData = 0;
    	if (EmployeeManagerData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (EmployeeIdData.getText().toString().trim().length() == 0 )
    		notValidData++;
    	if (EmployeeNameData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (EmployeeAddressData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (EmployeePass.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (EmployeeSalary.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (EmployeeJobType.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (EmployeeDid.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (EmployeeWid.getText().toString().trim().length() == 0)
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
    private boolean verifyData1() {
    	int notValidData = 0;
    	if (isNumeric(EmployeeManagerData1.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		managerNotValid(EmployeesPhoneNumberTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}
    	if (isNumeric(EmployeeIdData1.getText().toString().trim()))
    		 ;
    	else {
    		notValidData++;
    		employeeIdNotValid(EmployeesPhoneNumberTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}
    	if (!isNumeric(EmployeePhoneNumberData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		employeeNameNotValid(EmployeesPhoneNumberTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}	
    	if (notValidData == 0)
    		return true;
    	else
    		return false;
    }
    private boolean checkForEmptyData1() {
    	int notValidData = 0;
    	if (EmployeeManagerData1.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (EmployeeIdData1.getText().toString().trim().length() == 0 )
    		notValidData++;
    	if (EmployeePhoneNumberData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (notValidData > 0)
    		return true;
    		else
    			return false;
    	    }

}


