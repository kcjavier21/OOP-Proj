package com.projectoop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProfileGUI extends Application {
	
	Parent profilePageLayout;
	private static Stage window;
	private static Scene profilePageScene;
	
	
	public void start(Stage primaryStage) throws Exception {
		this.profilePageLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/profilePage.fxml"));
		ProfileGUI.window = primaryStage;
		ProfileGUI.window.setTitle("Data Science For Everyone - Your Profile");
		ProfileGUI.profilePageScene = new Scene(profilePageLayout, 720, 670);
	    ProfileGUI.window.setScene(profilePageScene);
	    ProfileGUI.window.show();
		
		System.out.println("Login Page");
		
		primaryStage.setResizable(false);
	}

}