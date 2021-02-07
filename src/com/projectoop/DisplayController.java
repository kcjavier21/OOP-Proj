package com.projectoop;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DisplayController implements Initializable {
	
	@FXML
	private static Label usernameLabel = new Label("Hello");
	
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
	
	private static String username;
	private static String firstname;
	private static String lastname;
	
	private static DBConnection connectNow = new DBConnection();
	private static Connection connectDB = connectNow.getConnection();
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	// ==== USERNAME ======
	public static void setVal(String username) {
		System.out.println("SetVal called");
		System.out.println("UN: " + username);
		
		usernameLabel.setId("usernameLabel");
		usernameLabel.setText(username);
		DisplayController.username = username;
	}
	
	@FXML
	public static String getUserNameStr() {
	    return username;
	 }
	
	
	// === LOAD ATTRIBUTES FROM DATABASE ====
	public static void loadAttributes(){
		try {
			ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM users WHERE username = '" + DisplayController.username + "'");
			
			while(rs.next()){
				DisplayController.firstname = rs.getString("firstname");
				DisplayController.lastname = rs.getString("lastname");
				
				DisplayController.userQuiz1Attempts = rs.getInt("quiz1attempts");
				DisplayController.userQuiz2Attempts = rs.getInt("quiz2attempts");
				DisplayController.userQuiz3Attempts = rs.getInt("quiz3attempts");
				DisplayController.userQuiz4Attempts = rs.getInt("quiz4attempts");
				
				DisplayController.userQuiz1Score = rs.getInt("quiz1score");
				DisplayController.userQuiz2Score = rs.getInt("quiz2score");
				DisplayController.userQuiz3Score = rs.getInt("quiz3score");
				DisplayController.userQuiz4Score = rs.getInt("quiz4score");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
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
		DisplayController.userQuiz1Attempts = attempts;
		
		try {
			Statement statement = connectDB.createStatement();
			statement.executeUpdate("UPDATE users SET quiz1attempts = " + attempts + " WHERE username = '" + username + "'");
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
	
	
	@FXML
	public static Integer getQuiz1Score() {
	    return DisplayController.userQuiz1Score;
	 }
	
	public static void setQuiz1Score(Integer score) {
		DisplayController.userQuiz1Score = score;
		
		try {
			Statement statement = connectDB.createStatement();
			statement.executeUpdate("UPDATE users SET quiz1score = " + score + " WHERE username = '" + username + "'");
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
		
		DisplayController.setUserTotalScore();
	}
	
	
	// ===== USER's QUIZ 2 ATTRIBUTES =======
	
	@FXML
	public static Integer getQuiz2Attempts() {
	    return DisplayController.userQuiz2Attempts;
	 }
	
	public static void setQuiz2Attempts(Integer attempts) {
		DisplayController.userQuiz2Attempts = attempts;
		
		try {
			Statement statement = connectDB.createStatement();
			statement.executeUpdate("UPDATE users SET quiz2attempts = " + attempts + " WHERE username = '" + username + "'");
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
	
	
	@FXML
	public static Integer getQuiz2Score() {
	    return DisplayController.userQuiz2Score;
	 }
	
	public static void setQuiz2Score(Integer score) {
		DisplayController.userQuiz2Score = score;
		
		try {
			Statement statement = connectDB.createStatement();
			statement.executeUpdate("UPDATE users SET quiz2score = " + score + " WHERE username = '" + username + "'");
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
		
		DisplayController.setUserTotalScore();
	}
		
		
	// ===== USER's QUIZ 3 ATTRIBUTES =======
	@FXML
	public static Integer getQuiz3Attempts() {
	    return DisplayController.userQuiz3Attempts;
	 }
	
	public static void setQuiz3Attempts(Integer attempts) {
		DisplayController.userQuiz3Attempts = attempts;
		
		try {
			Statement statement = connectDB.createStatement();
			statement.executeUpdate("UPDATE users SET quiz3attempts = " + attempts + " WHERE username = '" + username + "'");
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
	
	
	@FXML
	public static Integer getQuiz3Score() {
	    return DisplayController.userQuiz3Score;
	 }
	
	public static void setQuiz3Score(Integer score) {
		DisplayController.userQuiz3Score = score;
		
		try {
			Statement statement = connectDB.createStatement();
			statement.executeUpdate("UPDATE users SET quiz3score = " + score + " WHERE username = '" + username + "'");
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
		
		DisplayController.setUserTotalScore();
	}
			

	// ===== USER's QUIZ 4 ATTRIBUTES =======
	@FXML
	public static Integer getQuiz4Attempts() {
	    return DisplayController.userQuiz4Attempts;
	 }
	
	public static void setQuiz4Attempts(Integer attempts) {
		DisplayController.userQuiz4Attempts = attempts;
		
		try {
			Statement statement = connectDB.createStatement();
			statement.executeUpdate("UPDATE users SET quiz1attempts = " + attempts + " WHERE username = '" + username + "'");
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
		
	}
	
	
	@FXML
	public static Integer getQuiz4Score() {
	    return DisplayController.userQuiz4Score;
	 }
	
	public static void setQuiz4Score(Integer score) {
		DisplayController.userQuiz4Score = score;
		
		try {
			Statement statement = connectDB.createStatement();
			statement.executeUpdate("UPDATE users SET quiz4score = " + score + " WHERE username = '" + username + "'");
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
		
		DisplayController.setUserTotalScore();
	}
}
