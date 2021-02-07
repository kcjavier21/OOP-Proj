package com.projectoop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistrationGUI extends Application {
	
	Parent registrationPageLayout;
	private static Stage window;
	private static Scene registrationPageScene;
	
	public void start(Stage primaryStage) throws Exception {
		this.registrationPageLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/registrationPage.fxml"));
		RegistrationGUI.window = primaryStage;
		RegistrationGUI.window.setTitle("Data Science For Everyone - Register");
		RegistrationGUI.registrationPageScene = new Scene(registrationPageLayout, 400, 640);
	    RegistrationGUI.window.setScene(registrationPageScene);
	    RegistrationGUI.window.show();
		
		System.out.println("Registration Page");
		
		primaryStage.setResizable(false);
	}
}