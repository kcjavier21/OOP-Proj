package com.projectoop;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChapterOneQuiz {
	
	@FXML private Label usernameLabel = new Label("Username");
	@FXML private Label userProgressLabel = new Label("0");
	@FXML private Label userTotalScoreLabel = new Label("0");
	
	@FXML private Label checkLabelOne = new Label("O");
	@FXML private Label checkLabelTwo = new Label("O");
	@FXML private Label checkLabelThree = new Label("O");
	@FXML private Label checkLabelFour = new Label("O");
	@FXML private Label checkLabelFive = new Label("O");
	@FXML private Label checkLabelSix = new Label("O");
	@FXML private Label checkLabelSeven = new Label("O");
	@FXML private Label checkLabelEight = new Label("O");
	@FXML private Label checkLabelNine = new Label("O");
	@FXML private Label checkLabelTen = new Label("O");
	
	
	@FXML private TextField answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10;
	
	@FXML private Button Submit;
	@FXML private Button btnLogOut;
	@FXML private Button btnGoBack;
	@FXML private Button btnChapOne;
	@FXML private Button btnChapTwo;
	@FXML private Button btnChapThree;
	@FXML private Button btnChapFour;
	@FXML private Button btnDashboard;
	
	
	Alert a = new Alert(AlertType.NONE); 
	
	private static int attempts = 3;
	private static int score = 3;
	private static int userProgress = 0;
	private static int userTotalScore = 0;
	
	@FXML private Label scoreLabel = new Label("0");
	@FXML private Label attemptLabel = new Label("3");
	
	Stage stage = new Stage();
	
	private static String username = new String("Username");
	
	ChapterOneGUI chapterOneGUI = new ChapterOneGUI();  // ==> GET the Chapter One's GUI
	Dashboard dashboard = new Dashboard();
	
	
	// ============ REFRESH =============
	
	public void onClickRefreshButton() {
		System.out.println("Refresh Activated!");
		DisplayController.loadAttributes();
		
		ChapterOneQuiz.username = DisplayController.getUserNameStr();
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		
		ChapterOneQuiz.userProgress = DisplayController.getUserProgress();
		this.userProgressLabel.setText(Integer.toString(ChapterOneQuiz.userProgress));
		
		ChapterOneQuiz.userTotalScore = DisplayController.getUserTotalScore();
		this.userTotalScoreLabel.setText(Integer.toString(ChapterOneQuiz.userTotalScore));
		
		if (ChapterOneQuiz.attempts <= 0) {
			ChapterOneQuiz.attempts = 0;
			
			this.Submit.setDisable(true);
		}
		
		ChapterOneQuiz.attempts = DisplayController.getQuiz1Attempts();
		this.attemptLabel.setText(Integer.toString(ChapterOneQuiz.attempts));
		
		ChapterOneQuiz.score = DisplayController.getQuiz1Score();
		this.scoreLabel.setText(Integer.toString(ChapterOneQuiz.score));
		
		if (ChapterOneQuiz.score >= 6) {
			this.scoreLabel.setStyle("-fx-text-fill: green");
		} else {
			this.scoreLabel.setStyle("-fx-text-fill: red");
		}
		
		if (ChapterOneQuiz.attempts > 0) {
			this.attemptLabel.setStyle("-fx-text-fill: green");
		} else {
			this.attemptLabel.setStyle("-fx-text-fill: red");
		}
	}
	
	
	// ============= SUBMIT =============
	
	@FXML private void submitAnswers() throws Exception {
		int tempScore = 0;
		System.out.println("ATTEMPTS: " + ChapterOneQuiz.attempts);
		ChapterOneQuiz.attempts -= 1;
		
		// ===== Identifying number of Attempts =====
		if (ChapterOneQuiz.attempts < 0) {
			ChapterOneQuiz.attempts = 0;
			this.Submit.setDisable(true);
		}
		
		else {
			if (answer1.getText().toLowerCase().equals("b")) {
				tempScore = tempScore + 1;
				this.checkLabelOne.setText("O");
				this.checkLabelOne.setStyle("-fx-text-fill: green");
			} else {
				this.checkLabelOne.setText("X");
				this.checkLabelOne.setStyle("-fx-text-fill: red");
			}
			
			if (answer2.getText().toLowerCase().equals("a")) {
				tempScore = tempScore + 1;
				this.checkLabelTwo.setText("O");
				this.checkLabelTwo.setStyle("-fx-text-fill: green");
			} else {
				this.checkLabelTwo.setText("X");
				this.checkLabelTwo.setStyle("-fx-text-fill: red");
			}
			
			if (answer3.getText().toLowerCase().equals("d")) {
				tempScore = tempScore + 1;
				this.checkLabelThree.setText("O");
				this.checkLabelThree.setStyle("-fx-text-fill: green");
			} else {
				this.checkLabelThree.setText("X");
				this.checkLabelThree.setStyle("-fx-text-fill: red");
			}
				
			if (answer4.getText().toLowerCase().equals("c")) {
				tempScore = tempScore + 1;
				this.checkLabelFour.setText("O");
				this.checkLabelFour.setStyle("-fx-text-fill: green");
			} else {
				this.checkLabelFour.setText("X");
				this.checkLabelFour.setStyle("-fx-text-fill: red");
			}
			
			if (answer5.getText().toLowerCase().equals("c")) {
				tempScore = tempScore + 1;
				this.checkLabelFive.setText("O");
				this.checkLabelFive.setStyle("-fx-text-fill: green");
			} else {
				this.checkLabelFive.setText("X");
				this.checkLabelFive.setStyle("-fx-text-fill: red");
			}
			
			if (answer6.getText().toLowerCase().equals("d")) {
				tempScore = tempScore + 1;
				this.checkLabelSix.setText("O");
				this.checkLabelSix.setStyle("-fx-text-fill: green");
			} else {
				this.checkLabelSix.setText("X");
				this.checkLabelSix.setStyle("-fx-text-fill: red");
			}
			
			if (answer7.getText().toLowerCase().equals("a")) {
				tempScore = tempScore + 1;
				this.checkLabelSeven.setText("O");
				this.checkLabelSeven.setStyle("-fx-text-fill: green");
			} else {
				this.checkLabelSeven.setText("X");
				this.checkLabelSeven.setStyle("-fx-text-fill: red");
			}
			
			if (answer8.getText().toLowerCase().equals("b")) {
				tempScore = tempScore + 1;
				this.checkLabelEight.setText("O");
				this.checkLabelEight.setStyle("-fx-text-fill: green");
			} else {
				this.checkLabelEight.setText("X");
				this.checkLabelEight.setStyle("-fx-text-fill: red");
			}
			
			if (answer9.getText().toLowerCase().equals("c")) {
				tempScore = tempScore + 1;
				this.checkLabelNine.setText("O");
				this.checkLabelNine.setStyle("-fx-text-fill: green");
			} else {
				this.checkLabelNine.setText("X");
				this.checkLabelNine.setStyle("-fx-text-fill: red");
			}
			
			if (answer10.getText().toLowerCase().equals("d")) {
				tempScore = tempScore + 1;
				this.checkLabelTen.setText("O");
				this.checkLabelTen.setStyle("-fx-text-fill: green");
			} else {
				this.checkLabelTen.setText("X");
				this.checkLabelTen.setStyle("-fx-text-fill: red");
			}
			
			// ==== Finalizing Progress ======
			System.out.println("ATTEMPTS: " + ChapterOneQuiz.attempts);
			
			if (ChapterOneQuiz.userProgress == 0 && tempScore >= 6) {
				DisplayController.setProgress(25);
				ChapterOneQuiz.userProgress += 25;
			} 
				else if (ChapterOneQuiz.userProgress == 25 && tempScore < 6) {
					DisplayController.setProgress(-25);
					ChapterOneQuiz.userProgress -= 25;
				}
			
			
			// ==== Setting number of Attempts ====
			if (ChapterOneQuiz.attempts <= 0) {
				ChapterOneQuiz.attempts = 0;
				this.Submit.setDisable(true);
				this.attemptLabel.setStyle("-fx-text-fill: red");
			}
			
			ChapterOneQuiz.score = tempScore;
			DisplayController.setQuiz1Score(tempScore);
			ChapterOneQuiz.userTotalScore = DisplayController.getUserTotalScore();
			
			// ==== Pass or fail ====
			if (tempScore >= 6) {
				a.setAlertType(AlertType.INFORMATION); 
				a.setContentText("Congrats! You passed!\n Your Score: " + tempScore); 
				a.show();
				this.scoreLabel.setStyle("-fx-text-fill: green");
			} else {
				a.setAlertType(AlertType.WARNING); 
				a.setContentText("Sorry, you failed :(\n Your Score: " + tempScore); 
				a.show();
				this.scoreLabel.setStyle("-fx-text-fill: red");
			}
		}
		
		// ========= Displaying Important Attributes =====
		this.userProgressLabel.setText(Integer.toString(ChapterOneQuiz.userProgress));
		this.userTotalScoreLabel.setText(Integer.toString(ChapterOneQuiz.userTotalScore));
		this.scoreLabel.setText(Integer.toString(ChapterOneQuiz.score));
		
		// ==== Displaying Number of Attempts =====
		DisplayController.setQuiz1Attempts(ChapterOneQuiz.attempts);
		this.attemptLabel.setText(Integer.toString(ChapterOneQuiz.attempts));
	}
	
	
	
	// ========== NAVIGATE ===========
	
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


	@FXML 
	private void goBack() throws Exception {
		
	    Stage currentStage = (Stage) btnGoBack.getScene().getWindow();
	    currentStage.close();
	    
		try {
	    	chapterOneGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void navigateToDashboard() throws Exception {
		
	    Stage currentStage = (Stage) btnDashboard.getScene().getWindow();
	    currentStage.close();
	    Stage window = new Stage();
	    dashboard.start(window);
		dashboard.switchScene(ChapterOneQuiz.username);
	}
	
	
	public void navigateToChapOne() throws Exception {
		
	    Stage currentStage = (Stage) btnChapOne.getScene().getWindow();
	    currentStage.close();
	    
		try {
	    	chapterOneGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToChapTwo() throws Exception {
		Stage currentStage = (Stage) btnChapTwo.getScene().getWindow();
	    currentStage.close();
	    
		try {
	    	ChapterTwoGUI chapterTwoGUI = new ChapterTwoGUI();
	    	chapterTwoGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToChapThree() throws Exception {
		
		Stage currentStage = (Stage) btnChapThree.getScene().getWindow();
	    currentStage.close();
		
		try {
	    	ChapterThreeGUI chapterThreeGUI = new ChapterThreeGUI();
	    	chapterThreeGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToChapFour() throws Exception {
		
	    Stage currentStage = (Stage) btnChapFour.getScene().getWindow();
	    currentStage.close();
	    
	    try {
	    	Stage stage = new Stage();
	    	ChapterFourGUI chapterFourGUI = new ChapterFourGUI();
	    	chapterFourGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
