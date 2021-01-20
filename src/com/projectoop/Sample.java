package com.projectoop;

	import javafx.application.Application;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;

	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.StackPane;
	import javafx.scene.layout.VBox;

	import javafx.stage.Stage;

	import javafx.geometry.Insets;


	public class Sample extends Application{
			
			Stage window;
			Button button;
			Scene scene;
		
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
	}

