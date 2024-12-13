package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import application.Products;

public class SearchCustomerController implements Initializable{
	
	
	
	
	 @FXML
	    private TableView<Customers> Customer_tbv;

	    @FXML
	    private TableColumn<Customers, Integer> custid_col;

	    @FXML
	    private TableColumn<Customers, String> custname_col;

	    @FXML
	    private TextField search_txtbx;

	
    private AddOrderController cotro;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
     
    
    public void SetController(AddOrderController cotro) {
    	this.cotro = cotro;
    	
    }
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		
		custid_col.setCellValueFactory(new PropertyValueFactory<Customers, Integer>("Id"));
		custname_col.setCellValueFactory(new PropertyValueFactory<Customers, String>("Name"));
		

		try {
			
			//Product_tbv.getItems().clear();
			//Product_tbv.setItems(My_List);
			ObservableList <Customers> My_List;
            My_List = MyConnection.getCustomerData();
            
            
            System.out.println("mylist");
            System.out.println(My_List);
            
			
            Customer_tbv.setEditable(true);
           // Product_tbv.setItems(My_List);
            
            FilteredList <Customers> filtereddata = new FilteredList <>(My_List, b->true);
            search_txtbx.textProperty().addListener((observable, oldValue, newValue) -> {
            	
            	filtereddata.setPredicate(customer -> {
            		
                    if(newValue == null || newValue.isEmpty()) {
                    	return true;
                    	
                    }           		
            		
                    String lower = newValue.toLowerCase();
                    if(customer.getName().toLowerCase().indexOf(lower) != -1 || String.valueOf(customer.getId()).equals(newValue)) {
                    	return true;
                    }
                    else return false;
            		
            		
            	});
            	  	
            	
            });
            
            SortedList<Customers> my_sorted_list = new SortedList<>(filtereddata);
            
            my_sorted_list.comparatorProperty().bind(Customer_tbv.comparatorProperty());
            
            Customer_tbv.setItems(my_sorted_list);
       
		     
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
		
	}
	
	
	public void selection(MouseEvent event) throws IOException {
			
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddOrder.fxml"));
		Parent root = loader.load();
		
		Customers cust =  Customer_tbv.getSelectionModel().getSelectedItem();
		int num = Customer_tbv.getSelectionModel().getSelectedIndex();
		System.out.println();
        if(num - 1 < -1) {
        	System.out.println("here to return");
        	return;
        }	
		
        //pro = cust;
        stage = (Stage) Customer_tbv.getScene().getWindow();
        stage.close();

        //return prod;
        
        
        //AddOrderController addcontroller = loader.getController();
        cotro.Setinfo(cust.Id, cust.Name);
        //addcontroller.Setinfo();
        
        Customer_tbv.refresh();
        
        
        
      /*  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        */
        /*stage = (Stage) Product_tbv.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();*/
        
		
	}
	
	  public void setPrimaryStage(Stage primaryStage) {
	        this.stage = primaryStage;
	    }
	  

	
}
