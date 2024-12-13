package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterController  implements Initializable{
	
	private Connection con =null; 

	 @FXML
	    private GridPane regGridPane;
	 
	@FXML
    private Label RegSelect;

    @FXML
    private Label RegisterLabel;

    @FXML
    private Label regAddres;

    @FXML
    private TextField regAddressbx;

    @FXML
    private Label regConforimpass;

    @FXML
    private TextField regDepartmentbx;

    @FXML
    private Label regID;

    @FXML
    private TextField regIDbx;

    @FXML
    private Label regJob;

    @FXML
    private TextField regJobbx;

    @FXML
    private Label regName;

    @FXML
    private TextField regNamebx;

    @FXML
    private Label regSalary;

    @FXML
    private TextField regSalarybx;

    @FXML
    private PasswordField regconforimbx;

    @FXML
    private Label regdepartment;

    @FXML
    private Button registerButton;

    @FXML
    private Label regpassword;

    @FXML
    private PasswordField regpasswordbx;

    @FXML
    private Label regwarehouse;

    @FXML
    private TextField regwarehousebx;
    

    @FXML
    private VBox jobLocationbx;

    @FXML
    private ToggleGroup option1;

    @FXML
    private RadioButton radioDepartment;

    @FXML
    private RadioButton radioWarehose;
    
    @FXML
    private Button rest;
    
    @FXML
    private Button closeButton;
    

    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
    	regwarehouse.setVisible(false);
    	regwarehousebx.setVisible(false);
    	regdepartment.setVisible(false);
    	regDepartmentbx.setVisible(false);
    	
    	//regGridPane.getChildren().removeAll(regwarehouse,regwarehousebx,regdepartment,regDepartmentbx);
    }
    
    @FXML
    void selectDepartment(ActionEvent event) {
    	
    	regdepartment.setVisible(true);
    	regDepartmentbx.setVisible(true);
    	
    	regwarehouse.setVisible(false);
    	regwarehousebx.setVisible(false);
    }

    @FXML
    void selectWareHouse(ActionEvent event) {
    	regdepartment.setVisible(false);
    	regDepartmentbx.setVisible(false);
    	
    	regwarehouse.setVisible(true);
    	regwarehousebx.setVisible(true);
    }
    
    @FXML
    void Register(ActionEvent event) {
    	
    	if (regNamebx.getText().isEmpty() || regIDbx.getText().isEmpty() || regAddressbx.getText().isEmpty() || regJobbx.getText().isEmpty() ||(regwarehousebx.getText().isEmpty() && regDepartmentbx.getText().isEmpty())||regpasswordbx.getText().isEmpty() ||regconforimbx.getText().isEmpty()) {
   		
    		JOptionPane.showMessageDialog(null, "fill all field");
    		

    	}
    	
    	else {
    		
    	String Name = regNamebx.getText();
    	int id = Integer.parseInt(regIDbx.getText());
    	
    	String idString= Integer.toString(id);
    	if(idString.length()>7 || idString.length()<7) {
    		JOptionPane.showMessageDialog(null, "enter 7 digit ID");
    		return;}
    	
    	String address =regAddressbx.getText();
    	String job =regJobbx.getText();
    	double salary = Double.parseDouble(regSalarybx.getText());
    	int warehose=0;
    	int department=0;
    	if (regDepartmentbx.getText().isEmpty()) {
   		 warehose = Integer.parseInt(regwarehousebx.getText());
    	}
    	else {
   		 department = Integer.parseInt(regDepartmentbx.getText());

    	}
    	
    	String password = regpasswordbx.getText();
    	String conforim =regconforimbx.getText();
    	
    	if (password.equals(conforim)) {
		String SQL;
		int accept =JOptionPane.showConfirmDialog(null, "accept your information");
		if(accept==1) {
			return;
		}
		else if(accept==2) {
			restAll(null);
			return;
		}

    	try {
			con = mySqlConnector.connectDB();
			SQL = "set FOREIGN_KEY_CHECKS=0;";
			 mySqlConnector.ExecuteStatement(con,SQL);
			
			SQL = "INSERT INTO employee (Eid, name, address, salary, jobType, Did, Wid,pass) VALUES ("
					+ id +",'"+ Name +"','"+address+"','"+salary+"','"+job+"',"+department+","+ warehose+",'"+conforim+"')";
			
			 mySqlConnector.ExecuteStatement(con,SQL);
			 
				if (radioDepartment.isSelected()) 
					 mySqlConnector.ExecuteStatement(con,"update department set numberOfemployees = numberOfemployees + 1 where did = "+department+";");

			    	
			    	else 
			       mySqlConnector.ExecuteStatement(con,"update warehouses set numberOfemployees = numberOfemployees + 1 where wid = "+warehose+";");


			SQL = "set FOREIGN_KEY_CHECKS=1;";

			 mySqlConnector.ExecuteStatement(con,SQL);
			System.out.println("Connection established");
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	restAll(null);
		
		
    	}
    	
    	else {
    		JOptionPane.showMessageDialog(null, "check passward again");

    	}
    	}
    }
    
    @FXML
    void restAll(ActionEvent event) {
    	
    	
    	regNamebx.clear();
    	regIDbx.clear();
    	regAddressbx.clear();
    	regJobbx.clear();
    	regSalarybx.clear();
    	regwarehousebx.clear();
    	regDepartmentbx.clear();
    	regpasswordbx.clear();
    	regconforimbx.clear();

    }
    
    @FXML
    void Close(ActionEvent event) throws IOException {
    	
    	Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene scene = new Scene(root);
		Stage regStage = new Stage();
	
		regStage.setScene(scene);
		regStage.show();
		
		closeButton.getScene().getWindow().hide();

    }

}
