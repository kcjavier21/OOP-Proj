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
	
	private static int userQuiz1Attempts = 3;
	private static int userQuiz2Attempts = 3;
	private static int userQuiz3Attempts = 3;
	private static int userQuiz4Attempts = 3;
	
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
	
	
	
	// ===== USER's TOTAL SCORE ======
	
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
	
	
	// ===== USER's QUIZ 2 ATTRIBUTES =======
		@FXML
		public static Integer getQuiz2Attempts() {
		    return DisplayController.userQuiz2Attempts;
		 }
		
		public static void setQuiz2Attempts(Integer attempts) {
			System.out.println(DisplayController.userQuiz2Attempts);
			DisplayController.userQuiz2Attempts = attempts;
			System.out.println(DisplayController.userQuiz2Attempts);
		}
		
		
		@FXML
		public static Integer getQuiz2Score() {
		    return DisplayController.userQuiz2Score;
		 }
		
		public static void setQuiz2Score(Integer score) {
			System.out.println(DisplayController.userQuiz2Score);
			DisplayController.userQuiz2Score = score;
			System.out.println(DisplayController.userQuiz2Score);
			System.out.println(DisplayController.userTotalScore);
			DisplayController.setUserTotalScore();
		}
		
		
	// ===== USER's QUIZ 3 ATTRIBUTES =======
			@FXML
			public static Integer getQuiz3Attempts() {
			    return DisplayController.userQuiz3Attempts;
			 }
			
			public static void setQuiz3Attempts(Integer attempts) {
				System.out.println(DisplayController.userQuiz3Attempts);
				DisplayController.userQuiz3Attempts = attempts;
				System.out.println(DisplayController.userQuiz3Attempts);
			}
			
			
			@FXML
			public static Integer getQuiz3Score() {
			    return DisplayController.userQuiz3Score;
			 }
			
			public static void setQuiz3Score(Integer score) {
				System.out.println(DisplayController.userQuiz3Score);
				DisplayController.userQuiz3Score = score;
				System.out.println(DisplayController.userQuiz3Score);
				System.out.println(DisplayController.userTotalScore);
				DisplayController.setUserTotalScore();
			}
			

		// ===== USER's QUIZ 3 ATTRIBUTES =======
			@FXML
			public static Integer getQuiz4Attempts() {
			    return DisplayController.userQuiz4Attempts;
			 }
			
			public static void setQuiz4Attempts(Integer attempts) {
				System.out.println(DisplayController.userQuiz4Attempts);
				DisplayController.userQuiz4Attempts = attempts;
				System.out.println(DisplayController.userQuiz4Attempts);
			}
			
			
			@FXML
			public static Integer getQuiz4Score() {
			    return DisplayController.userQuiz4Score;
			 }
			
			public static void setQuiz4Score(Integer score) {
				System.out.println(DisplayController.userQuiz4Score);
				DisplayController.userQuiz4Score = score;
				System.out.println(DisplayController.userQuiz4Score);
				System.out.println(DisplayController.userTotalScore);
				DisplayController.setUserTotalScore();
			}
	
	
}
