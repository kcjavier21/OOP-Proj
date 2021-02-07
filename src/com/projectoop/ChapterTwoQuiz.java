package com.projectoop;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChapterTwoQuiz {
	
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
	
	Stage stage = new Stage();
	
	private static String username = new String("Username");
	
	ChapterTwoGUI chapterTwoGUI = new ChapterTwoGUI();  // ==> GET the Chapter Two's GUI
	Dashboard dashboard = new Dashboard();
	
	
	// ============ REFRESH =============
	
	public void onClickRefreshButton() {
		System.out.println("Refresh activated!");
		DisplayController.loadAttributes();
		
		ChapterTwoQuiz.username = DisplayController.getUserNameStr();
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		
		ChapterTwoQuiz.userProgress = DisplayController.getUserProgress();
		this.userProgressLabel.setText(Integer.toString(ChapterTwoQuiz.userProgress));
		
		ChapterTwoQuiz.userTotalScore = DisplayController.getUserTotalScore();
		this.userTotalScoreLabel.setText(Integer.toString(ChapterTwoQuiz.userTotalScore));
		
		if (ChapterTwoQuiz.attempts <= 0) {
			ChapterTwoQuiz.attempts = 0;
			this.Submit.setDisable(true);
		}
		
		ChapterTwoQuiz.attempts = DisplayController.getQuiz2Attempts();
		this.attemptLabel.setText(Integer.toString(ChapterTwoQuiz.attempts));
		
		ChapterTwoQuiz.score = DisplayController.getQuiz2Score();
		this.scoreLabel.setText(Integer.toString(ChapterTwoQuiz.score));
	}
	
	
	// ============= SUBMIT =============
	
	@FXML private void submitAnswers() throws Exception {
		int tempScore = 0;
		ChapterTwoQuiz.attempts -= 1;
		
		// ===== Identifying number of Attempts =====
		if (ChapterTwoQuiz.attempts < 0) {
			ChapterTwoQuiz.attempts = 0;
			this.Submit.setDisable(true);
		}
		else {
			if (answer1.getText().toLowerCase().equals("a")) 
				tempScore = tempScore + 1;
			
			if (answer2.getText().toLowerCase().equals("a")) 
				tempScore = tempScore + 1;
			
			if (answer3.getText().toLowerCase().equals("c")) 
				tempScore = tempScore + 1;
				
			if (answer4.getText().toLowerCase().equals("a")) 
				tempScore = tempScore + 1;
			
			if (answer5.getText().toLowerCase().equals("c")) 
				tempScore = tempScore + 1;
			
			if (answer6.getText().toLowerCase().equals("b")) 
				tempScore = tempScore + 1;
			
			if (answer7.getText().toLowerCase().equals("a")) 
				tempScore = tempScore + 1;
			
			if (answer8.getText().toLowerCase().equals("c")) 
				tempScore = tempScore + 1;
			
			if (answer9.getText().toLowerCase().equals("c")) 
				tempScore = tempScore + 1;
			
			if (answer10.getText().toLowerCase().equals("d")) 
				tempScore = tempScore + 1;
			
			// ==== Finalizing Progress ======
			if (ChapterTwoQuiz.attempts == 2) {
				DisplayController.setProgress(25);
				ChapterTwoQuiz.userProgress += 25;
			}	
			
			if (ChapterTwoQuiz.attempts <= 0) {
				ChapterTwoQuiz.attempts = 0;
				this.Submit.setDisable(true);
			}
			
			ChapterTwoQuiz.score = tempScore;
			DisplayController.setQuiz2Score(tempScore);	
			ChapterTwoQuiz.userTotalScore = DisplayController.getUserTotalScore();
		}
		
		// ========= Displaying Important Attributes =====
		this.userProgressLabel.setText(Integer.toString(ChapterTwoQuiz.userProgress));
		this.userTotalScoreLabel.setText(Integer.toString(ChapterTwoQuiz.userTotalScore));
		this.scoreLabel.setText(Integer.toString(ChapterTwoQuiz.score));
		
		// ==== Displaying Number of Attempts =====
		DisplayController.setQuiz2Attempts(ChapterTwoQuiz.attempts);
		this.attemptLabel.setText(Integer.toString(ChapterTwoQuiz.attempts));
	}
	
	
	
	// ========== NAVIGATE ===========
	
	public void logOut() throws Exception {

	    Stage currentStage = (Stage) btnLogOut.getScene().getWindow();
	    currentStage.close();
	    
		try {
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
	    	chapterTwoGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToChapOne() throws Exception {
		
	    Stage currentStage = (Stage) btnChapOne.getScene().getWindow();
	    currentStage.close();
	    
		try {
	    	ChapterOneGUI chapterOneGUI = new ChapterOneGUI();
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
	

	public void navigateToDashboard() throws Exception {
		
	    Stage currentStage = (Stage) btnDashboard.getScene().getWindow();
	    currentStage.close();
	    Stage window = new Stage();
	    dashboard.start(window);
		dashboard.switchScene(ChapterTwoQuiz.username);
	}
		
}
