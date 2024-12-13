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

public class SearchProductController implements Initializable{
	
	
	ObservableList <Products> My_List;
	
    @FXML
    private TableView<Products> Product_tbv;

    @FXML
    private TableColumn<Products, Double> madein_col;

    @FXML
    private TextField name_txtbx;

    @FXML
    private TableColumn<Products, Integer> prodid_col;

    @FXML
    private TableColumn<Products, String> prodname_col;

    @FXML
    private TableColumn<Products, Double> proprice_col;
	
    public Products pro;
	
    private AddOrderController cotro;
    
    private static double Max_Quantity;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
     
    
    public void SetController(AddOrderController cotro) {
    	this.cotro = cotro;
    	
    }
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		
		prodid_col.setCellValueFactory(new PropertyValueFactory<Products, Integer>("Pid"));
		prodname_col.setCellValueFactory(new PropertyValueFactory<Products, String>("Pname"));
		madein_col.setCellValueFactory(new PropertyValueFactory<Products, Double>("Quantity"));
		proprice_col.setCellValueFactory(new PropertyValueFactory<Products, Double>("Price"));

		try {
			
			//Product_tbv.getItems().clear();
			//Product_tbv.setItems(My_List);
            My_List = MyConnection.getProductData();
            
			
            Product_tbv.setEditable(true);
           // Product_tbv.setItems(My_List);
            
            FilteredList <Products> filtereddata = new FilteredList <>(My_List, b->true);
            //System.out.println("hello");
            name_txtbx.textProperty().addListener((observable, oldValue, newValue) -> {
            	
            	filtereddata.setPredicate(product -> {
            		
                    if(newValue == null || newValue.isEmpty()) {
                    	return true;
                    	
                    }           		
            		
                    String lower = newValue.toLowerCase();
                    if(product.getPname().toLowerCase().indexOf(lower) != -1) {
                    	return true;
                    }
                    else return false;
            		
            		
            	});
            	  	
            	
            });
            
            //System.out.println("Hi");
            
            SortedList<Products> my_sorted_list = new SortedList<>(filtereddata);
            
            my_sorted_list.comparatorProperty().bind(Product_tbv.comparatorProperty());
            
            
            
            Product_tbv.setItems(my_sorted_list);
       
		     
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
		
		Products prod =  Product_tbv.getSelectionModel().getSelectedItem();
		int num = Product_tbv.getSelectionModel().getSelectedIndex();
		System.out.println();
        if(num - 1 < -1) {
        	System.out.println("Invalid Row");
        	return;
        }	
		
        pro = prod;
        stage = (Stage) Product_tbv.getScene().getWindow();
        stage.close();

        //return prod;
        
        SetmaxQuantity(prod.Quantity);
        //AddOrderController addcontroller = loader.getController();
        cotro.Setinfo(prod.Pid, prod.Pname,prod.Price,prod.Quantity);
        //addcontroller.Setinfo();
        
        Product_tbv.refresh();
        
        
        
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
	  
	  public void cleartbv () {
		  System.out.println("not ya nuts");
		  Product_tbv.getItems().clear();
		  System.out.println("nuts ya nuts");
	  }
	  
	  public void SetmaxQuantity (double quantity) {
		  
		  this.Max_Quantity = quantity;
		  
	  }
	  
      public static double getmaxQuantity () {
		  
			return Max_Quantity;
		  
	  }
     
	
}
