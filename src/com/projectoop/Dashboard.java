package com.projectoop;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Dashboard extends Application {
	
	@FXML private Label usernameLabel = new Label("Hello");
	@FXML private Label userProgressLabel = new Label("0");
	@FXML private Label userTotalScoreLabel = new Label("0");
	
	@FXML private Button btnLogOut;
	@FXML private ImageView imageview;
	
	private static int userProgress = 0;
	private static int userTotalScore = 0;
	
	public static ChapterOne chapterOne = new ChapterOne();
	
	Parent dashboardLayout;
	private static Scene dashboardScene;
	private static Stage window;
	DisplayController display = new DisplayController();
	ChapterOneGUI chapterOneGUI = new ChapterOneGUI();
	
	
	public Label getUsernameLabel() {
        return this.usernameLabel;
    }
	
	public void initialize(URL url, ResourceBundle rb) {
		Image image = new Image(getClass().getResourceAsStream("src/media/learn.jpg"));
		imageview.setImage(image); 
	}
	
	public void start(Stage primaryStage) throws Exception {
		 this.dashboardLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/dashboard.fxml"));
		 Dashboard.window = primaryStage;
		 Dashboard.window.setTitle("Data Science For Everyone - Dashboard");
		 
		 System.out.println("Welcome " + usernameLabel); 
		 primaryStage.setResizable(false);
	}
	
	public void switchScene(String username) throws Exception {
		DisplayController.setVal(username);
		System.out.println(DisplayController.getUserNameStr());
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		
		System.out.println("YEEEET " + this.usernameLabel);
	    Dashboard.dashboardScene = new Scene(dashboardLayout, 1440, 900);
	    Dashboard.window.setScene(dashboardScene);
	    Dashboard.window.show();
	  }
	
	
	public void buttonIsClicked() {
		//DisplayController displayController = new DisplayController();
		DisplayController.loadAttributes();
		
		System.out.println("Refresh button clicked!");
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		System.out.println("UN Button: " + this.usernameLabel);
		
		Dashboard.userProgress = DisplayController.getUserProgress();
		this.userProgressLabel.setText(Integer.toString(Dashboard.userProgress));
		
		Dashboard.userTotalScore = DisplayController.getUserTotalScore();
		this.userTotalScoreLabel.setText(Integer.toString(Dashboard.userTotalScore));
		
	}
	
	
	
	
	
	// ======= NAVIGATION ========
	
	public void logOut() throws Exception {
		
	    Stage currentStage = (Stage) btnLogOut.getScene().getWindow();
	    currentStage.close();
	    
		try {
	    	Stage stage = new Stage();
	    	LoginPageGUI loginPageGUI = new LoginPageGUI();
	    	loginPageGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void seeProfile() throws Exception {
		
		try {
			Stage stage = new Stage();
			ProfileGUI profileGUI = new ProfileGUI();
			profileGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void navigateToChapOne() throws Exception {
			Dashboard.window.close();
			
		try {
	    	Stage stage = new Stage();
	    	chapterOneGUI.start(stage);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
	}
	
	public void navigateToChapTwo() throws Exception {
		Dashboard.window.close();
		
		try {
	    	Stage stage = new Stage();
	    	ChapterTwoGUI chapterTwoGUI = new ChapterTwoGUI();
	    	chapterTwoGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void navigateToChapThree() throws Exception {
		Dashboard.window.close();
		
		try {
	    	Stage stage = new Stage();
	    	ChapterThreeGUI chapterThreeGUI = new ChapterThreeGUI();
	    	chapterThreeGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToChapFour() throws Exception {
		Dashboard.window.close();
		
		try {
	    	Stage stage = new Stage();
	    	ChapterFourGUI chapterFourGUI = new ChapterFourGUI();
	    	chapterFourGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

