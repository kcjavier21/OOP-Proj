package com.projectoop;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChapterFourQuiz {
	
	@FXML private Label usernameLabel = new Label("Username");
	@FXML private Label userProgressLabel = new Label("0");
	@FXML private Label userTotalScoreLabel = new Label("0");
	
	@FXML private TextField answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10;
	
	@FXML private Button Submit;
	@FXML private Button btnLogOut;
	@FXML private Button btnGoBack;
	@FXML private Button btnDashboard;
	
	@FXML private Button btnChapOne;
	@FXML private Button btnChapTwo;
	@FXML private Button btnChapThree;
	@FXML private Button btnChapFour;
	
	private static int attempts = 3;
	private static int score = 3;
	private static int userProgress = 0;
	private static int userTotalScore = 0;
	
	@FXML private Label scoreLabel = new Label("0");
	@FXML private Label attemptLabel = new Label("3");
	
	private static String username = new String("Username");
	
	ChapterFourGUI chapterFourGUI = new ChapterFourGUI();  // ==> GET the Chapter Three's GUI
	Dashboard dashboard = new Dashboard();
	
	
	// ============ REFRESH =============
	
	public void onClickRefreshButton() {
		DisplayController.loadAttributes();
		System.out.println("Refresh button clicked!");
		ChapterFourQuiz.username = DisplayController.getUserNameStr();
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		System.out.println("UN Button: " + this.usernameLabel);
		
		ChapterFourQuiz.userProgress = DisplayController.getUserProgress();
		this.userProgressLabel.setText(Integer.toString(ChapterFourQuiz.userProgress));
		
		ChapterFourQuiz.userTotalScore = DisplayController.getUserTotalScore();
		this.userTotalScoreLabel.setText(Integer.toString(ChapterFourQuiz.userTotalScore));
		
		if (ChapterFourQuiz.attempts <= 0) {
			ChapterFourQuiz.attempts = 0;
			
			this.Submit.setDisable(true);
		}
		
		ChapterFourQuiz.attempts = DisplayController.getQuiz4Attempts();
		this.attemptLabel.setText(Integer.toString(ChapterFourQuiz.attempts));
		
		ChapterFourQuiz.score = DisplayController.getQuiz4Score();
		this.scoreLabel.setText(Integer.toString(ChapterFourQuiz.score));
	}
	
	
	// ============= SUBMIT =============
	
	@FXML private void submitAnswers() throws Exception {
		int tempScore = 0;
		System.out.println("ATTEMPTS: " + ChapterFourQuiz.attempts);
		ChapterFourQuiz.attempts -= 1;
		
		// ===== Identifying number of Attempts =====
		if (ChapterFourQuiz.attempts < 0) {
			ChapterFourQuiz.attempts = 0;
			
			this.Submit.setDisable(true);
		}
		else {
				if (answer1.getText().toLowerCase().equals("a")) 
					tempScore = tempScore + 1;
				
				if (answer2.getText().toLowerCase().equals("b")) 
					tempScore = tempScore + 1;
				
				if (answer3.getText().toLowerCase().equals("c")) 
					tempScore = tempScore + 1;
					
				if (answer4.getText().toLowerCase().equals("a")) 
					tempScore = tempScore + 1;
				
				if (answer5.getText().toLowerCase().equals("b")) 
					tempScore = tempScore + 1;
				
				if (answer6.getText().toLowerCase().equals("c")) 
					tempScore = tempScore + 1;
				
				if (answer7.getText().toLowerCase().equals("b")) 
					tempScore = tempScore + 1;
				
				if (answer8.getText().toLowerCase().equals("a")) 
					tempScore = tempScore + 1;
				
				if (answer9.getText().toLowerCase().equals("c")) 
					tempScore = tempScore + 1;
				
				if (answer10.getText().toLowerCase().equals("c")) 
					tempScore = tempScore + 1;
				
				// ==== Finalizing Progress ======
				System.out.println("ATTEMPTS: " + ChapterFourQuiz.attempts);
				
				if (ChapterFourQuiz.attempts == 2) {
					DisplayController.setProgress(25);
					ChapterFourQuiz.userProgress += 25;
					
				}
				
				if (ChapterFourQuiz.attempts <= 0) {
					ChapterFourQuiz.attempts = 0;
					
					this.Submit.setDisable(true);
				}
				
				ChapterFourQuiz.score = tempScore;
				DisplayController.setQuiz4Score(tempScore);
				ChapterFourQuiz.userTotalScore = DisplayController.getUserTotalScore();
			
		}
		
		// ========= Displaying Important Attributes =====
		this.userProgressLabel.setText(Integer.toString(ChapterFourQuiz.userProgress));
		this.userTotalScoreLabel.setText(Integer.toString(ChapterFourQuiz.userTotalScore));
		this.scoreLabel.setText(Integer.toString(ChapterFourQuiz.score));
		
		// ==== Displaying Number of Attempts =====
		DisplayController.setQuiz4Attempts(ChapterFourQuiz.attempts);
		this.attemptLabel.setText(Integer.toString(ChapterFourQuiz.attempts));
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
	    	Stage stage = new Stage();
	    	chapterFourGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToChapOne() throws Exception {
		
	    Stage currentStage = (Stage) btnChapOne.getScene().getWindow();
	    currentStage.close();
	    
		try {
	    	Stage stage = new Stage();
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
	
	public void navigateToDashboard() throws Exception {
		
	    Stage currentStage = (Stage) btnDashboard.getScene().getWindow();
	    currentStage.close();
	    Stage window = new Stage();
	    dashboard.start(window);
		dashboard.switchScene(ChapterFourQuiz.username);
	}
		
	
}
