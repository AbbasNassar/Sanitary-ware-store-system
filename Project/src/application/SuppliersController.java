package application;

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

public class SuppliersController implements Initializable{
	ObservableList<suppliers> suppliersList;
	ObservableList<suppliers> suppliersPhoneList;
	ObservableList<Integer> managerIds;
    
    @FXML
    private TextField Search;

    @FXML
    private Button exitButton;
    
    @FXML
    private ComboBox<String> SelectionBox;
	
    @FXML
    private BorderPane AddNewSupplierWindow;

    @FXML
    private Button AddSupplierButton;

    @FXML
    private Button BackFromAddNewSupplier;

    @FXML
    private Button GoToAddNewSupplierButton;
    
    @FXML
    private Button GoToViewSuppliersTable;
    
    @FXML
    private GridPane SupplierRegister;

    @FXML
    private AnchorPane SupplierSelection;

    @FXML
    private Button SuppliersClearAllButton;

    @FXML
    private Button SuppliersDeleteButton;

    @FXML
    private Button SuppliersViewBackButton;
    
    @FXML
    private TextField SupplierAddressData;

    @FXML
    private TextField SupplierIdData;

    @FXML
    private TextField SupplierManagerData;

    @FXML
    private TextField SupplierNameData;

    @FXML
    private TextField SupplierPhoneNumberData;
    
    @FXML
    private BorderPane ViewSupplierWindow;
    
    @FXML
    private TableView<suppliers> suppliersTable;

    @FXML
    private TableColumn<suppliers, Integer> SidColMain;
    
    @FXML
    private TableColumn<suppliers, String> supplierAddressCol;

    @FXML
    private TableColumn<suppliers, String> supplierNameCol;
    

    @FXML
    private TableView<suppliers> SupplierPhoneNumberTable;
    
    @FXML
    private TableColumn<suppliers, Integer> SidCol;
    
    @FXML
    private TableColumn<suppliers, String> supplierPhoneNumberCol;

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
  
  			clientsButton.getScene().getWindow().hide();
  			
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
    	 
     	 else if (event.getSource()==productsButton) {
     		 
     		 Parent root = FXMLLoader.load(getClass().getResource("Products.fxml"));
   			Scene scene = new Scene(root);
   			Stage regStage = new Stage();
   
   			regStage.setScene(scene);
   			regStage.show();
   
   			productsButton.getScene().getWindow().hide();
     		 
     	 }
     	 else if (event.getSource()==employeesButton) {
     		 
     		 Parent root = FXMLLoader.load(getClass().getResource("Employees.fxml"));
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
    void AddSupplierButton(ActionEvent event) {
    	if (!checkForEmptyData()) {
    		if (verifyData()) {
    			int managerId = Integer.parseInt(SupplierManagerData.getText().toString().trim());
            	int Sid = Integer.parseInt(SupplierIdData.getText().toString().trim());
            	String	name = SupplierNameData.getText().toString().trim();
            	String	address = SupplierAddressData.getText().toString().trim();
            	String phoneNumber = SupplierPhoneNumberData.getText().toString().trim();
            	
            		int SidProplem = 0, phoneNumberMatch = 0;
               	 for (suppliers supplier : suppliersList) {
           			 if (supplier.Sid == Sid) {
           				 SidProplem = 1;
           				 break;
           			 }
           			 
           		 }
               	 for (suppliers i : suppliersPhoneList) {
           			 if (i.phone_number.equals(phoneNumber)) {
           				 phoneNumberMatch = 1;
           				 break;
           			 }
           			 
           		 }
               	 if (phoneNumberMatch == 1)
               		phoneNumberRepeated(suppliersTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
               	 if (SidProplem == 0 && phoneNumberMatch ==  0) {
               		 
               	    		int flag = 0;
               	    		suppliers supp = new suppliers(Sid, name, address, phoneNumber);
               	    		
               	    		
               	    		for (int i = 0; i < managerIds.size(); i++) {
               	    		    int id = managerIds.get(i);
               	    		    if (id == managerId)
               	    		    	flag = 1;
               	    		}
               	    		if (flag == 1) {
               	    			try {
               	    				mySqlConnect.insertSupplierData(supp, SidProplem);
                   	    	        suppliersTable.getItems().add(supp);
                   	    	     SupplierPhoneNumberTable.getItems().add(supp);
                   	    	     suppliersTable.refresh();
               	    			}catch (SQLException e) {
               						e.printStackTrace();
               					}
               	    			catch (ClassNotFoundException e) {
               						e.printStackTrace();
               					}
               	    			dataAddedSuccesfully(suppliersTable.getScene().getWindow(),Modality.APPLICATION_MODAL);
               	    			SupplierManagerData.setText("");
               	    			SupplierIdData.setText("");
               	    			SupplierNameData.setText("");
               	    			SupplierAddressData.setText("");
               	    			SupplierPhoneNumberData.setText("");
               	    		}
               	    		else {
               	    			showManagerIdNotFound(suppliersTable.getScene().getWindow(),Modality.APPLICATION_MODAL);
               	    		}
               	 }
               	 else if(SidProplem == 1) {
               		int flag = 0;
       	    		suppliers supp = new suppliers(Sid, name, address, phoneNumber);
       	    		
       	    		
       	    		for (int i = 0; i < managerIds.size(); i++) {
       	    		    int id = managerIds.get(i);
       	    		    if (id == managerId)
       	    		    	flag = 1;
       	    		}
       	    		if (flag == 1) {
       	    			try {
       	    				mySqlConnect.insertSupplierData(supp, SidProplem);
       	    				SupplierPhoneNumberTable.getItems().add(supp);
           	    	     suppliersTable.refresh();
           	    	  SupplierPhoneNumberTable.refresh();
       	    			}catch (SQLException e) {
       						e.printStackTrace();
       					}
       	    			catch (ClassNotFoundException e) {
       						e.printStackTrace();
       					}
       	    			dataAddedSuccesfully(suppliersTable.getScene().getWindow(),Modality.APPLICATION_MODAL);
       	    			SupplierManagerData.setText("");
       	    			SupplierIdData.setText("");
       	    			SupplierNameData.setText("");
       	    			SupplierAddressData.setText("");
       	    			SupplierPhoneNumberData.setText("");
               	 }
    		}
    		}	
       	}
    	else
    	missingData(suppliersTable.getScene().getWindow(),Modality.APPLICATION_MODAL);
    }

    @FXML
    void BackFromAddNewSupplier(ActionEvent event) {
    	SupplierRegister.setVisible(false);
    }

    @FXML
    void GoToAddNewSupplierButton(ActionEvent event) {
    	ViewSupplierWindow.setVisible(false);
    	SupplierRegister.setVisible(true);
    }

    @FXML
    void GoToViewSupplierTable(ActionEvent event) {
    	ViewSupplierWindow.setVisible(true);
    	SupplierRegister.setVisible(false);
    }

    @FXML
    void SuppliersClearAllButton(ActionEvent event) {
        showDialog(suppliersTable.getScene().getWindow(), Modality.APPLICATION_MODAL, suppliersTable, SupplierPhoneNumberTable);
        
    }

    @FXML
    void SuppliersDeleteButton(ActionEvent event) {
    	 ObservableList<suppliers> selectedSuppliersRows = suppliersTable.getSelectionModel().getSelectedItems();
    	 ObservableList<suppliers> selectedSuppliersPhoneRows = SupplierPhoneNumberTable.getSelectionModel().getSelectedItems();
    	 if (selectedSuppliersPhoneRows.isEmpty() && !selectedSuppliersRows.isEmpty()) {
    		 ArrayList<suppliers> rows = new ArrayList<>(selectedSuppliersRows);
             rows.forEach(row -> {
                 suppliersTable.getItems().remove(row);
                 ObservableList<suppliers> suppliersList = SupplierPhoneNumberTable.getItems();
                 Iterator<suppliers> iterator = suppliersList.iterator();
                 while (iterator.hasNext()) {
                     suppliers supplier = iterator.next();
                     if (row.Sid==supplier.Sid) {
                         iterator.remove();
                     }
                 }
                 mySqlConnect.deleteSupplierRow(row);
                 suppliersTable.refresh();
                 SupplierPhoneNumberTable.refresh();
             });
    	 }
    	 else if(!selectedSuppliersPhoneRows.isEmpty() && selectedSuppliersRows.isEmpty()) {
    		 ArrayList<suppliers> rows = new ArrayList<>(selectedSuppliersPhoneRows);
             rows.forEach(row -> {
                 SupplierPhoneNumberTable.getItems().remove(row);
                 mySqlConnect.deleteSupplierRow(row);
                 suppliersTable.refresh();
                 SupplierPhoneNumberTable.refresh();
             });
    	 }
    }

    @FXML
    void SuppliersViewBackButton(ActionEvent event) {
    	ViewSupplierWindow.setVisible(false);
    }
   
    @FXML
    void Search(KeyEvent event) throws ClassNotFoundException, SQLException {
    	String select = SelectionBox.getValue();
    	if (select.equals("Sid")) {
    		suppliersList = mySqlConnect.getDataSuppliers("select * from suppliers where Sid like '"+Search.getText()+"%' order by Sid");
    		suppliersTable.setItems(suppliersList);	
    	}
    	else if (select.equals("name")){
    		suppliersList = mySqlConnect.getDataSuppliers("select * from suppliers where name like '"+Search.getText()+"%' order by Sid");
    		suppliersTable.setItems(suppliersList);
    	}
    	else {
    		suppliersPhoneList = mySqlConnect.getPhoneDataSuppliers("select * from Suppliersphone where phoneNumber like '"+Search.getText()+"%' order by Sid");
    		SupplierPhoneNumberTable.setItems(suppliersPhoneList);
    	}
    }

	@Override
    public void initialize(URL url, ResourceBundle rb){
		SelectionBox.setItems(FXCollections.observableArrayList("Sid",  "name", "phoneNumber"));
		SelectionBox.getSelectionModel().select(0);
		try {
			ViewSupplierWindow.setVisible(true);
			try {
				suppliersList = FXCollections.observableArrayList(mySqlConnect.getDataSuppliers());
				suppliersPhoneList = FXCollections.observableArrayList(mySqlConnect.getPhoneDataSuppliers());
			}catch(ClassNotFoundException e) {
				System.out.println("Class not found");
			}
			catch(SQLException e1) {
				System.out.println("query didn't excute");
			}
		
		managerIds = FXCollections.observableArrayList(mySqlConnect.getManagerIds());
        suppliersTable.setEditable(true);
        suppliersTable.setItems(suppliersList);
        SupplierPhoneNumberTable.setEditable(true);
        SupplierPhoneNumberTable.setItems(suppliersPhoneList);

        SidColMain.setCellValueFactory(new PropertyValueFactory<>("Sid"));
        supplierNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        supplierAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        
        SidCol.setCellValueFactory(new PropertyValueFactory<>("Sid"));
        supplierPhoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        supplierNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        supplierNameCol.setOnEditCommit((CellEditEvent<suppliers, String> t) -> {
            t.getRowValue().setName(t.getNewValue());
            mySqlConnect.updateSupplierName(t.getRowValue().getSid(), t.getNewValue());
        });

        supplierAddressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        supplierAddressCol.setOnEditCommit((CellEditEvent<suppliers, String> t) -> {
            t.getRowValue().setName(t.getNewValue());
            mySqlConnect.updateSupplierAddress(t.getRowValue().getSid(), t.getNewValue());
        });

        supplierPhoneNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
        supplierPhoneNumberCol.setOnEditCommit((CellEditEvent<suppliers, String> t) -> {
            t.getRowValue().setPhoneNumber(t.getNewValue());
            mySqlConnect.updateSupplierPhoneNumber(t.getRowValue().getSid(), t.getNewValue());
        });
        // One row is selected at max
   	 suppliersTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
           	 SupplierPhoneNumberTable.getSelectionModel().clearSelection();
            }
        });

   	 SupplierPhoneNumberTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
           	 suppliersTable.getSelectionModel().clearSelection();
            }
        });
		
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
	private void showDialog(Window owner, Modality modality, TableView<suppliers> table, TableView<suppliers> table1) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Button yesButton = new Button("Confirm");
        yesButton.setOnAction(e -> {
            for (suppliers row : new ArrayList<>(table.getItems())) {
                mySqlConnect.deleteSupplierRow(row);
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

        Label label = new Label("Supplier added successfully");
      
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
    private void supplierIdNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("supplier ID must be integer");
      
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

        Label label = new Label("This supplier phone number is already in the data base");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void supplierNameNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Supplier name must be string");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 220, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void supplierAddressNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Supplier address must be string");
      
        HBox root = new HBox(10, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 50);
        stage.setScene(scene);
        stage.setTitle("Error");
        stage.show();
    }
    private void supplierPhoneNumberNotValid(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label("Supplier phone number must be in this formate 111-1111");
      
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
    	if (isNumeric(SupplierManagerData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		managerNotValid(suppliersTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}
    	if (isNumeric(SupplierIdData.getText().toString().trim()))
    		 ;
    	else {
    		notValidData++;
    		supplierIdNotValid(suppliersTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}
    	if (!isNumeric(SupplierNameData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		supplierNameNotValid(suppliersTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}	
    	if (!isNumeric(SupplierAddressData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		supplierAddressNotValid(suppliersTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}
    	if (!isNumeric(SupplierPhoneNumberData.getText().toString().trim())&& checkPhoneNumberForm(SupplierPhoneNumberData.getText().toString().trim()))
    		;
    	else {
    		notValidData++;
    		supplierPhoneNumberNotValid(suppliersTable.getScene().getWindow(), Modality.APPLICATION_MODAL);
    	}	
    	if (notValidData == 0)
    		return true;
    	else
    		return false;
    }
    private boolean checkForEmptyData() {
    	int notValidData = 0;
    	if (SupplierManagerData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (SupplierIdData.getText().toString().trim().length() == 0 )
    		notValidData++;
    	if (SupplierNameData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (SupplierAddressData.getText().toString().trim().length() == 0)
    		notValidData++;
    	if (SupplierPhoneNumberData.getText().toString().trim().length() == 0)
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
