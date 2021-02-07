package com.projectoop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import java.util.Date;
import java.util.ResourceBundle;


public class Registration {
	
	@FXML private Label registrationMessageLabel;
	@FXML private Label errorLabel;
	
	@FXML private PasswordField setPasswordField;
	@FXML private PasswordField confirmPasswordField;
	@FXML private TextField firstnameTextField;
	@FXML private TextField lastnameTextField;
	@FXML private TextField usernameTextField;
	@FXML private TextField emailTextField;
	
	@FXML private Button registerButton;
	@FXML private Button cancelButton;
	
	public void initialize(URL url, ResourceBundle resourceBundle) {
		
	}
	
	public void registerUser() {
		DBConnection connectNow = new DBConnection();
		Connection connectDB = connectNow.getConnection();
		
		Date date = new Date();
		long now = date.getTime();
		int id = (int) now / 1000;
		System.out.println(id);
		String firstname = firstnameTextField.getText();
		String lastname = lastnameTextField.getText();
		String username = usernameTextField.getText();
		String email = emailTextField.getText();
		String password = setPasswordField.getText();
		
		// === Check if any field is blank ===
		if ( !firstname.equals("") && !lastname.equals("") && !username.equals("") && !email.equals("") && !password.equals("")) {
			
			if (password.length() > 6) {
				
				
				// === Check if passwords match ===
				if(setPasswordField.getText().equals(confirmPasswordField.getText())) {
					
					// === Check if user name or email is existing ===
					String verifyLogin = "SELECT (1) FROM users WHERE username = '" + username + "' OR email = '" + email + "'";
	
					try {
						Statement statement = connectDB.createStatement();
						ResultSet queryResult = statement.executeQuery(verifyLogin);
						
						if (queryResult.next()) {
							errorLabel.setText("Invalid username or email!");
							System.out.println("Username or email is already been used!");
						} else {
							password = encodePassword(password);
							String insertFields = "INSERT INTO users(firstname, lastname, username, password, email, id) VALUES ('";
							String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "','"+ email + "','" + id +"')";
							String insertToRegister = insertFields + insertValues;
							
							try {
								Statement state = connectDB.createStatement();
								state.executeUpdate(insertToRegister);	
							} catch (Exception e) {
								e.printStackTrace();
								e.getCause();
							}
							
							errorLabel.setText("");
							registrationMessageLabel.setText("User has been registered!");
						}
						
					} catch (Exception e) {
						e.printStackTrace();
						e.getCause();
						System.out.println("Exception!");
					}
				
				} else {
					errorLabel.setText("Passwords do not match!");
				}
			} else {
				errorLabel.setText("Password is too short");
			}
		} else {
			errorLabel.setText("Any field cannot be blank!");
		}
	}
	
	public void cancelButtonOnAction(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}
	
	private String encodePassword(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}
}
