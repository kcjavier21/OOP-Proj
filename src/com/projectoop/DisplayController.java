package com.projectoop;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DisplayController implements Initializable {
	
	@FXML
	private static Label usernameee = new Label("Hello");
	
	@FXML
	private static Label userProgressLabel = new Label("0");
	
	
	private static int userProgress = 0;
	
	private static int userQuiz1Score = 0;
	private static int userQuiz2Score = 0;
	private static int userQuiz3Score = 0;
	private static int userQuiz4Score = 0;
	
	private static int userTotalScore = 0;
	
	private static int userQuiz1Attempts = 0;
	
	private static String usernameeeStr;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	// ==== USERNAME ======
	public static void setVal(String username) {
		System.out.println("SetVal called");
		System.out.println("UN: " + username);
		
		usernameee.setId("usernameLabel");
		usernameee.setText(username);
		usernameeeStr = username;
		
		System.out.println("UN Str Set Val: " + usernameeeStr);
		System.out.println("UN Set Val: " + usernameee);
	}
	
	@FXML
	public static String getUserNameStr() {
	    return usernameeeStr;
	 }
	
	
	
	// ===== USER's PROGRESS ======
	
	public static void setProgress(Integer progress) {
		DisplayController.userProgress += progress;
		userProgressLabel.setText(Integer.toString(progress));
	}
	
	@FXML
	public static Integer getUserProgress() {
	    return DisplayController.userProgress;
	 }
	
	
	
	// ===== USER's SCORE ======
	
	public static void setUserTotalScore() {
		DisplayController.userTotalScore = DisplayController.userQuiz1Score + 
				DisplayController.userQuiz2Score + DisplayController.userQuiz3Score + 
				DisplayController.userQuiz4Score;
	}
	
	@FXML
	public static Integer getUserTotalScore() {
	    return DisplayController.userTotalScore;
	 }
	
	
	
	// ===== USER's QUIZ 1 ATTRIBUTES =======
	@FXML
	public static Integer getQuiz1Attempts() {
	    return DisplayController.userQuiz1Attempts;
	 }
	
	public static void setQuiz1Attempts(Integer attempts) {
		System.out.println(DisplayController.userQuiz1Attempts);
		DisplayController.userQuiz1Attempts = attempts;
		System.out.println(DisplayController.userQuiz1Attempts);
	}
	
	
	@FXML
	public static Integer getQuiz1Score() {
	    return DisplayController.userQuiz1Score;
	 }
	
	public static void setQuiz1Score(Integer score) {
		System.out.println(DisplayController.userQuiz1Score);
		DisplayController.userQuiz1Score = score;
		System.out.println(DisplayController.userQuiz1Score);
		System.out.println(DisplayController.userTotalScore);
		DisplayController.setUserTotalScore();
	}
	
	
}
