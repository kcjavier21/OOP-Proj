package com.projectoop;

	import javafx.application.Application;
	//import javafx.event.ActionEvent;
	//import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
	import javafx.scene.control.Button;
	//import javafx.scene.control.TextField;
	import javafx.scene.control.Label;
	import javafx.scene.layout.StackPane;
	import javafx.scene.layout.VBox;

	import javafx.stage.Stage;

	//import javafx.geometry.Insets;


	public class Sample extends Application{
			
			Stage window;
			Button button;
			Scene scene, scene1, scene2;
		
			public static void main(String[] args) {
				launch(args);
			}
			
			// === LAMBDA EXPRESSIONS ===
			/* 
			@Override
			public void start(Stage primaryStage) {
				primaryStage.setTitle("Title of the Window");
				button = new Button();
				button.setText("Hey baby!");
				
				//This class will handle the button events
				button.setOnAction(e -> System.out.println("Hello!"));
				
				StackPane layout =new StackPane();
				layout.getChildren().add(button);
				Scene scene = new Scene(layout, 300, 250);
				primaryStage.setScene(scene);
				primaryStage.show();
				
			}*/
			
			// === Adding Text Fields ===
			/*
			public void start(Stage primaryStage) {
				window = primaryStage;
				window.setTitle("thenewboston");
				
				// Form
				TextField nameInput = new TextField();
				
				button = new Button("Click Me!");
				button.setOnAction(e -> isInt(nameInput, nameInput.getText()) );
				
				//Layout
				VBox layout = new VBox(10);
				layout.setPadding(new Insets(20, 20, 20, 20));
				layout.getChildren().addAll(nameInput, button);
				
				scene = new Scene(layout, 300, 250);
				window.setScene(scene);
				window.show();
				}
			
			private boolean isInt(TextField input, String message) {
				try {
					int age = Integer.parseInt(input.getText());
					System.out.println("User is: " + age);
					return true;
				} catch (NumberFormatException e) {
					System.out.println("Error: " + message + "is not a number");
					return false;
				}
			}
			*/
			
			// === Switching Scenes ====

			public void start(Stage primaryStage) throws Exception {
				window = primaryStage;
				
				// Label 1 and Button 1 - To be inserted in Layout 1
				Label label1 = new Label("Welcome to the first scene!");
				Button button1 = new Button("Go to Scene 2");
				button1.setOnAction(e -> window.setScene(scene2));
				
				// Layout 1 - children are laid out with vertical column
				VBox layout1 = new VBox(20);
				layout1.setPadding(new Insets(20, 20, 20, 20));
				layout1.getChildren().addAll(label1, button1);
				scene1 = new Scene(layout1, 200, 200);
				
				
				//Button 2 - To be inserted in Layout 2
				Button button2 = new Button("Go back to Scene 1");
				button2.setOnAction(e -> window.setScene(scene1));
				
				//Layout 2
				StackPane layout2 = new StackPane();
				layout2.getChildren().add(button2);
				scene2 = new Scene(layout2, 600, 300);
				
				//Setting and showing the scene
				window.setScene(scene1);
				window.setTitle("Title Here");
				window.show();
			}
			
			
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
