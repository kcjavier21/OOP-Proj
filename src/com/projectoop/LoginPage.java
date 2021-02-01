package com.projectoop;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;


public class LoginPage {
	
	@FXML private TextField usernameTextField;
	@FXML private PasswordField passwordField;
	
	@FXML private Button loginBtn;
	
	@FXML private Label invalidLoginLabel = new Label("");
	
	private static String username = new String("Username");
	private static String password = new String("Password");
	
	Dashboard dashboard = new Dashboard();
	
	
	public void onClickLogin() throws Exception {
		
		LoginPage.username = usernameTextField.getText();
		System.out.println("Username: " + LoginPage.username);
		
		LoginPage.password = passwordField.getText();
		System.out.println("Username: " + LoginPage.password);
		
		if ((LoginPage.username.equals("Ken")) && (LoginPage.password.equals("password"))) {
			System.out.println("Welcome, " + username);
			this.invalidLoginLabel.setText(" ");
			
			Stage currentStage = (Stage) loginBtn.getScene().getWindow();
		    currentStage.close();
			
			Stage window = new Stage();
			dashboard.start(window);
			dashboard.switchScene(LoginPage.username); // -> Will call the...
				// switchScene method to switch the scene to dash board window.
		} else {
			System.out.println("Invalid username or password : " + username);
			this.invalidLoginLabel.setText("Invalid username or password!");
		}	
	}


}
