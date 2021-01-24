package com.projectoop;
	
	
	import javafx.application.Application;
	//import javafx.event.ActionEvent;
	//import javafx.event.EventHandler;
	
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.StackPane;
	import javafx.scene.layout.VBox;
	import javafx.scene.control.Label;
	
	import javafx.stage.Stage;
	
	import javafx.geometry.Insets;
	
	
 public class Login extends Application {
	
	 public Dashboard dashboard = new Dashboard(); // -> Import Dashboard.java
	 DisplayController display = new DisplayController();
	 
	 public Stage window;
	 Button button;
	 Scene loginScene, dashboardScene;
	 StackPane dashboardLayout;

	 
	 @Override
	 public void start(Stage primaryStage) throws Exception {
		 this.window = primaryStage;
		 this.window.setTitle("Data Science For Everyone - Log in");
		
		// Form - insertion of the user name
		TextField username = new TextField();
		Label LoginLabel = new Label("Please Login");
		button = new Button("Login");
		button.setOnAction(e -> {
			try {
				isValid(username, username.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}); //-> Will call the...
			// isValid function to check if user name is valid
		
		
		// Setting the layout of the Login window
		VBox loginLayout = new VBox(10);
		loginLayout.setPadding(new Insets(20, 20, 20, 20));
		loginLayout.getChildren().addAll(LoginLabel, username, button);
		
		// Setting and Displaying the scene base on the layout of Login window
		loginScene = new Scene(loginLayout, 300, 400);
	    this.window.setScene(loginScene);
	    this.window.setTitle("Data Science For Everyone");
	    this.window.show();
	    
	    //dashboard.start(primaryStage); // -> Calling the start method of Dashboard.java
	}

	// === USERNAME VALIDATION ===
	public void isValid(TextField input, String message) throws Exception {
		dashboard.start(this.window);
		String username = new String(input.getText());
		String name = new String("Ken");
		System.out.println("Username: " + username);
		System.out.println("Name: " + name);
		
		if (username.equals(name)) {
			System.out.println("Welcome, " + username);
			
			dashboard.switchScene(username); // -> Will call the...
				// switchScene method to switch the scene to dash board window.
		} else {
			System.out.println("Invalid username, " + username);
		}	
	}

}

















