package com.projectoop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Profile {
	@FXML private Text userFullNameLabel = new Text("Firstname Lastname");
	@FXML private Label usernameLabel = new Label("Username");
	@FXML private Label userProgressLabel = new Label("0");
	@FXML private Label userTotalScoreLabel = new Label("0");
	@FXML private Label userIDLabel = new Label("0");
	
	@FXML private Label quiz1ScoreLabel = new Label("0");
	@FXML private Label quiz2ScoreLabel = new Label("0");
	@FXML private Label quiz3ScoreLabel = new Label("0");
	@FXML private Label quiz4ScoreLabel = new Label("0");
	
	@FXML private Button exitBtn;
	
	private static int quiz1Score = 0;
	private static int quiz2Score = 0;
	private static int quiz3Score = 0;
	private static int quiz4Score = 0;
	
	private static int userProgress = 0;
	private static int userTotalScore = 0;
	private static int userID = 0;

	Stage stage = new Stage();
	
	private static String userFullName = new String("FullName");
	private static String username = new String("Username");
	
	
	ProfileGUI profileGUI = new ProfileGUI();  // ==> GET the Profile's GUI
	Dashboard dashboard = new Dashboard();
	
	
	// ============ REFRESH =============
	
	public void onClickRefreshButton() {
		System.out.println("Refresh Activated!");
		DisplayController.loadAttributes();
		
		Profile.userFullName = DisplayController.getUserFullName().toUpperCase();
		this.userFullNameLabel.setText(DisplayController.getUserFullName().toUpperCase());
		
		Profile.username = DisplayController.getUserNameStr();
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		
		Profile.userID = DisplayController.getUserID();
		this.userIDLabel.setText(Integer.toString(Profile.userID));
		
		Profile.userProgress = DisplayController.getUserProgress();
		this.userProgressLabel.setText(Integer.toString(Profile.userProgress));
		
		Profile.userTotalScore = DisplayController.getUserTotalScore();
		this.userTotalScoreLabel.setText(Integer.toString(Profile.userTotalScore));
		
		Profile.quiz1Score = DisplayController.getQuiz1Score();
		this.quiz1ScoreLabel.setText(Integer.toString(Profile.quiz1Score));
		
		Profile.quiz2Score = DisplayController.getQuiz2Score();
		this.quiz2ScoreLabel.setText(Integer.toString(Profile.quiz2Score));
		
		Profile.quiz3Score = DisplayController.getQuiz3Score();
		this.quiz3ScoreLabel.setText(Integer.toString(Profile.quiz3Score));
		
		Profile.quiz4Score = DisplayController.getQuiz4Score();
		this.quiz4ScoreLabel.setText(Integer.toString(Profile.quiz4Score));
	}
	
	@FXML
	public void exit() {
		 Stage currentStage = (Stage) exitBtn.getScene().getWindow();
		 currentStage.close();
	}
}
