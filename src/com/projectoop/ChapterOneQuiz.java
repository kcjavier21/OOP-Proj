package com.projectoop;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChapterOneQuiz {
	
	@FXML private Label usernameLabel = new Label("Username");
	@FXML private Label userProgressLabel = new Label("0");
	@FXML private Label userTotalScoreLabel = new Label("0");
	
	@FXML private TextField answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10;
	
	@FXML private Button Submit;
	@FXML private Button btnLogOut;
	@FXML private Button btnGoBack;
	@FXML private Button btnChapOne;
	@FXML private Button btnChapTwo;
	@FXML private Button btnChapThree;
	@FXML private Button btnDashboard;
	
	private static int attempts = 3;
	private static int score = 3;
	private static int userProgress = 0;
	private static int userTotalScore = 0;
	
	@FXML private Label scoreLabel = new Label("0");
	@FXML private Label attemptLabel = new Label("3");
	
	private static String username = new String("Username");
	
	ChapterOneGUI chapterOneGUI = new ChapterOneGUI();  // ==> GET the Chapter One's GUI
	Dashboard dashboard = new Dashboard();
	
	
	// ============ REFRESH =============
	
	public void onClickRefreshButton() {
		System.out.println("Refresh button clicked!");
		ChapterOneQuiz.username = DisplayController.getUserNameStr();
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		System.out.println("UN Button: " + this.usernameLabel);
		
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
				if (answer1.getText().toLowerCase().equals("b")) 
					tempScore = tempScore + 1;
				
				if (answer2.getText().toLowerCase().equals("a")) 
					tempScore = tempScore + 1;
				
				if (answer3.getText().toLowerCase().equals("d")) 
					tempScore = tempScore + 1;
					
				if (answer4.getText().toLowerCase().equals("c")) 
					tempScore = tempScore + 1;
				
				if (answer5.getText().toLowerCase().equals("c")) 
					tempScore = tempScore + 1;
				
				if (answer6.getText().toLowerCase().equals("d")) 
					tempScore = tempScore + 1;
				
				if (answer7.getText().toLowerCase().equals("a")) 
					tempScore = tempScore + 1;
				
				if (answer8.getText().toLowerCase().equals("b")) 
					tempScore = tempScore + 1;
				
				if (answer9.getText().toLowerCase().equals("c")) 
					tempScore = tempScore + 1;
				
				if (answer10.getText().toLowerCase().equals("d")) 
					tempScore = tempScore + 1;
				
				// ==== Finalizing Progress ======
				System.out.println("ATTEMPTS: " + ChapterOneQuiz.attempts);
				
				if (ChapterOneQuiz.attempts == 2) {
					DisplayController.setProgress(25);
					ChapterOneQuiz.userProgress += 25;
					
				}	
				
				if (ChapterOneQuiz.attempts <= 0) {
					ChapterOneQuiz.attempts = 0;
					
					this.Submit.setDisable(true);
				}
				
				
				
				ChapterOneQuiz.score = tempScore;
				
				DisplayController.setQuiz1Score(tempScore);
			
				ChapterOneQuiz.userTotalScore = DisplayController.getUserTotalScore();
	
			
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


	@FXML 
	private void goBack() throws Exception {
		
	    Stage currentStage = (Stage) btnGoBack.getScene().getWindow();
	    currentStage.close();
	    
		try {
	    	Stage stage = new Stage();
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
	    	Stage stage = new Stage();
	    	chapterOneGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToChapTwo() throws Exception {
	    Stage currentStage = (Stage) btnChapTwo.getScene().getWindow();
	    currentStage.close();
	    
		try {
	    	Stage stage = new Stage();
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
	    	Stage stage = new Stage();
	    	ChapterThreeGUI chapterThreeGUI = new ChapterThreeGUI();
	    	chapterThreeGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		
	
	
}
