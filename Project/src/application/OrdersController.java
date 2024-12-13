package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class OrdersController implements Initializable{
	

    @FXML
    private Button Addsalesbtn;

    @FXML
    private Button ShowSalesordersbtn;
    
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
		
		
		//try {
		     
		//}
		/*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/		
	
		
	}
	
	
    @FXML
    void Show_Salesorder(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowOrder.fxml"));
        root = loader.load();
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void Switch_Addorder(MouseEvent event) throws IOException {
    	
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddOrder.fxml"));
        root = loader.load();
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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
