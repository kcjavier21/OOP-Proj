package com.projectoop;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
		System.out.println("Password: " + LoginPage.password);
		
		DBConnection connectNow = new DBConnection();
		Connection connectDB = connectNow.getConnection();
		
		String verifyLogin = "SELECT (1) FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
		
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin);
			
			if (queryResult.next()) {
				this.invalidLoginLabel.setText(" ");
				System.out.println("Congratulations!");
				
				Stage currentStage = (Stage) loginBtn.getScene().getWindow();
			    currentStage.close();
				
				Stage window = new Stage();
				dashboard.start(window);
				dashboard.switchScene(LoginPage.username); // -> Will call the...
					// switchScene method to switch the scene to dash board window.
			} else {
				this.invalidLoginLabel.setText("Invalid username or password!");
				System.out.println("Invalid Login");
			}
			
			System.out.println("Try!");
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
			System.out.println("Exception!");
		}
		
		
		
		
		
		
		
		
		
		/*
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
		}	*/
	}


}
