package com.projectoop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Dashboard extends Application {
	
	Parent dashboardLayout;
	Scene dashboardScene;
	private Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		 this.dashboardLayout = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
		 this.window = primaryStage;
		 this.window.setTitle("Data Science For Everyone - Dashboard");
	}
	
	public void switchScene() {
	    dashboardScene = new Scene(dashboardLayout, 1080, 720);
	    this.window.setScene(dashboardScene);
	    this.window.show();
	  }
	
	public void buttonIsClicked() {
		System.out.println("Nice!");
	}
}
