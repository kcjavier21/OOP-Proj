package com.projectoop;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class Dashboard extends Application {
	
	@FXML private Label usernameLabel = new Label("Hello");
	

	Parent dashboardLayout;
	Scene dashboardScene;
	private Stage window;
	DisplayController display = new DisplayController();
	
/*	public static void main(String[] args) {
		launch(args);
	}*/
	
	public Label getUsernameLabel() {
        return this.usernameLabel;
    }
	
	public void start(Stage primaryStage) throws Exception {
		 
		 this.dashboardLayout = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
		 this.window = primaryStage;
		 this.window.setTitle("Data Science For Everyone - Dashboard");
		 System.out.println("Welcome " + usernameLabel);
	}
	
	public void switchScene(String username) {
		DisplayController.setVal(username);
		System.out.println(DisplayController.getUserNameStr());
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		System.out.println("YEEEET " + this.usernameLabel);
	    dashboardScene = new Scene(dashboardLayout, 1080, 720);
	    this.window.setScene(dashboardScene);
	    this.window.show();
	  }
	
	public void buttonIsClicked() {
		System.out.println("Nice!");
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		System.out.println("UN Button: " + this.usernameLabel);
	}
	
}
