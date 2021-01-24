package com.projectoop;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Dashboard extends Application {
	
	@FXML private Label usernameLabel = new Label("Hello");
	
	public static ChapterOne chapterOne = new ChapterOne();
	
	Parent dashboardLayout;
	private static Scene dashboardScene;
	private static Stage window;
	DisplayController display = new DisplayController();
	
	
	public Label getUsernameLabel() {
        return this.usernameLabel;
    }
	
	public void start(Stage primaryStage) throws Exception {
		 this.dashboardLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/dashboard.fxml"));
		 Dashboard.window = primaryStage;
		 Dashboard.window.setTitle("Data Science For Everyone - Dashboard");
		 
		 System.out.println("Welcome " + usernameLabel); 
	}
	
	public void switchScene(String username) throws Exception {
		DisplayController.setVal(username);
		System.out.println(DisplayController.getUserNameStr());
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		
		System.out.println("YEEEET " + this.usernameLabel);
	    Dashboard.dashboardScene = new Scene(dashboardLayout, 1080, 720);
	    Dashboard.window.setScene(dashboardScene);
	    Dashboard.window.show();
	  }
	
	public void buttonIsClicked() {
		System.out.println("Refresh button clicked!");
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		System.out.println("UN Button: " + this.usernameLabel);
	}
	
	public void navigateChapOne() throws Exception {
			Dashboard.window.close();
		try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/projectoop/fxml-files/chapterOne.fxml"));
	    	Parent root = (Parent) loader.load();
	    	Stage stage = new Stage();
	    	stage.setScene(new Scene(root));
	    	stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}

	}
}

