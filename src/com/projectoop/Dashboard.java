package com.projectoop;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Dashboard {
	
	StackPane dashboardLayout;
	Scene dashboardScene;
	private Stage window;
	
	public void start(Stage primaryStage) {
		 this.window = primaryStage;
		 this.window.setTitle("Data Science For Everyone - Dashboard");
	}
	
	public void switchScene(String username) {
		// Label to be inserted in Dashboard Layout
		Label dashboardWelcome = new Label("Welcome, " + username + "!");
	    
		// Setting the Layout of Dashboard
		this.dashboardLayout = new StackPane();
	    this.dashboardLayout.getChildren().add(dashboardWelcome);

	    // Setting and Displaying the scene based on the layout of Dashboard
	    dashboardScene = new Scene(dashboardLayout, 400, 240);
	    this.window.setScene(dashboardScene);
	    this.window.setTitle("Data Science For Everyone");
	    this.window.show();
	  }
}
