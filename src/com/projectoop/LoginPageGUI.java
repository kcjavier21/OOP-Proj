package com.projectoop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginPageGUI extends Application {
	
	Parent loginPageLayout;
	private static Stage window;
	private static Scene loginPageScene;
	
	
	public void start(Stage primaryStage) throws Exception {
		this.loginPageLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/loginPage.fxml"));
		LoginPageGUI.window = primaryStage;
		LoginPageGUI.window.setTitle("Data Science For Everyone - Login");
		LoginPageGUI.loginPageScene = new Scene(loginPageLayout, 300, 500);
	    LoginPageGUI.window.setScene(loginPageScene);
	    LoginPageGUI.window.show();
		
		System.out.println("Login Page");
		
		primaryStage.setResizable(false);
	}

}