package com.projectoop;

	import javafx.application.Application;
	//import javafx.event.ActionEvent;
	//import javafx.event.EventHandler;
	/*
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.StackPane;
	import javafx.scene.layout.VBox;*/
	
	import javafx.stage.Stage;
	
	//import javafx.geometry.Insets;

public class Main extends Application {
	
	Stage window;
	 
	public Login login = new Login();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
		public void start(Stage primaryStage) {
			login.start(primaryStage);
		}

}
