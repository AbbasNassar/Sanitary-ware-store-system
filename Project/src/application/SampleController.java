package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SampleController implements Initializable {

	private Connection con = null;

	@FXML
	private Label Hellolable;
	

	@FXML
	private AnchorPane anchor1;

	@FXML
	private AnchorPane anchor2;

	@FXML
	private Label createacclable;

	@FXML
	private Label detalislable;

	@FXML
	private VBox sginLabel;

	@FXML
	private Label fillLabel;

	@FXML
	private Label forgetlable;

	@FXML
	private AnchorPane main_anch;

	@FXML
	private Button signin;

	@FXML
	private Button signinbtn;

	@FXML
	private Label signinlable;

	@FXML
	private Button signup;

	@FXML
	private Button signupbtn;

	@FXML
	private Label startjournylable;

	@FXML
	private TextField textbxpass1;

	@FXML
	private TextField textbxpass2;

	@FXML
	private TextField textbxuname;

	@FXML
	private TextField textbxEmpid;

	@FXML
	private Label welcomelable;

	@FXML
	private Label fillLabel1;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.7));
		slide.setNode(anchor1);

		slide.setToX(416);
		slide.play();

		anchor2.setTranslateX(-291);

		textbxuname.setVisible(false);
		textbxpass1.setVisible(false);
		createacclable.setVisible(false);

		signinbtn.setVisible(false);
		signup.setVisible(false);
		welcomelable.setVisible(false);
		fillLabel1.setVisible(false);
		fillLabel.setVisible(false);

		Hellolable.setVisible(true);
		startjournylable.setVisible(true);
		detalislable.setVisible(true);
		signupbtn.setVisible(true);
		signin.setVisible(true);
		forgetlable.setVisible(true);
		signinlable.setVisible(true);
		textbxpass2.setVisible(true);
		textbxEmpid.setVisible(true);



	}

	@FXML
	void signinbtn(MouseEvent event) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.7));
		slide.setNode(anchor1);

		slide.setToX(416);
		slide.play();

		anchor2.setTranslateX(-291);

		textbxuname.setVisible(false);
		textbxpass1.setVisible(false);
		createacclable.setVisible(false);

		signinbtn.setVisible(false);
		signup.setVisible(false);
		welcomelable.setVisible(false);
		fillLabel1.setVisible(false);
		fillLabel.setVisible(false);

		Hellolable.setVisible(true);
		startjournylable.setVisible(true);
		detalislable.setVisible(true);
		signupbtn.setVisible(true);
		signin.setVisible(true);
		forgetlable.setVisible(true);
		signinlable.setVisible(true);
		textbxpass2.setVisible(true);
		textbxEmpid.setVisible(true);

		textbxEmpid.clear();
		textbxpass2.clear();
		// System.out.println(EmId);

		slide.setOnFinished((e -> {

		}));

	}

	@FXML
	void signupbtn(MouseEvent event) {
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.7));
		slide.setNode(anchor1);

		slide.setToX(0);
		slide.play();

		anchor2.setTranslateX(0);

		Hellolable.setVisible(false);
		startjournylable.setVisible(false);
		detalislable.setVisible(false);
		textbxpass2.setVisible(false);
		signupbtn.setVisible(false);
		signin.setVisible(false);
		forgetlable.setVisible(true);
		signinlable.setVisible(false);
		textbxEmpid.setVisible(false);
		fillLabel1.setVisible(false);
		fillLabel.setVisible(false);

		createacclable.setVisible(true);

		signinbtn.setVisible(true);
		signup.setVisible(true);
		welcomelable.setVisible(true);
		textbxpass1.setVisible(true);
		textbxuname.setVisible(true);

		textbxuname.clear();
		textbxpass1.clear();

		slide.setOnFinished((e -> {

		}));

	}

	@FXML
	void signup(ActionEvent event) throws IOException {
		fillLabel1.setVisible(false);
		if (textbxuname.getText().isEmpty() || textbxpass1.getText().isEmpty()) {
			fillLabel.setVisible(true);
			JOptionPane.showMessageDialog(null, "Entere your ID and password");

		} else {
			fillLabel.setVisible(false);
			int MaId = Integer.parseInt(textbxuname.getText());
			String pass2 = textbxpass1.getText();

			String SQL;
			try {
				con = new mySqlConnector().connectDB();
				// connectDB();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Connection established");

			SQL = "select distinct d.Eid,pass from employee e,department d where e.Eid =d.Eid";
			Statement stmt = null;
			try {
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(SQL);
				String passward;
				int Mid;
				int flage = 0;
				while (rs.next()) {
					Mid = Integer.parseInt(rs.getString(1));
					passward = (rs.getString(2));
					if (passward.equals(pass2) && Mid == MaId) {
						flage = 1;
						fillLabel1.setVisible(false);
						break;
					}

				}

				con.close();

				if (flage == 1) {

					Parent root = FXMLLoader.load(getClass().getResource("RegisterFxml.fxml"));
					Scene scene = new Scene(root);
					Stage regStage = new Stage();

					regStage.setScene(scene);
					regStage.show();

					signup.getScene().getWindow().hide();

				}

				if (flage == 0) {

					fillLabel1.setVisible(true);
					JOptionPane.showMessageDialog(null, "invalide username or password");
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@FXML
	void signin(ActionEvent event) throws IOException {

		fillLabel1.setVisible(false);

		if (textbxpass2.getText().isEmpty() || textbxEmpid.getText().isEmpty()) {
			fillLabel.setVisible(true);
			JOptionPane.showMessageDialog(null, "Entere your ID and password");
		

		}

		else {
			fillLabel.setVisible(false);

			int EmId = Integer.parseInt(textbxEmpid.getText());

			String pass = textbxpass2.getText();
			String SQL;

			try {
				con = new mySqlConnector().connectDB();
				// connectDB();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Connection established");

			SQL = "select Eid,pass from employee";
			Statement stmt = null;
			try {
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(SQL);
				String passward;
				int Eid;
				int flage = 0;
				while (rs.next()) {
					Eid = Integer.parseInt(rs.getString(1));
					passward = (rs.getString(2));

					if (passward.equals(pass) && Eid == EmId) {
						System.out.println("hello");
						fillLabel1.setVisible(false);
						flage = 1;
						break;

					}
				}
				con.close();
				
				if (flage == 1) {
					Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
					Scene scene = new Scene(root);
					Stage regStage = new Stage();

					regStage.setScene(scene);
					regStage.show();

					signup.getScene().getWindow().hide();					
				}

				if (flage == 0) {
					fillLabel1.setVisible(true);
					JOptionPane.showMessageDialog(null, "invalide username or password");

				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
