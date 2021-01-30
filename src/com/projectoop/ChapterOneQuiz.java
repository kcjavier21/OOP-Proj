package com.projectoop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChapterOneQuiz {
	
	@FXML private Label usernameLabel = new Label("Hello");
	
	@FXML private TextField answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10;
	
	@FXML private Label scoreLabel = new Label("Hello");
	
	@FXML
	private Button Submit;
	

	
	public void onClickRefreshButton() {
		System.out.println("Refresh button clicked!");
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		System.out.println("UN Button: " + this.usernameLabel);
	}
	
	@FXML private void submitAnswers() throws Exception {
		int score = 0;
		
		System.out.println("1. " + answer1.getText().toLowerCase());
		System.out.println("2. " + answer2.getText().toLowerCase());
		System.out.println("3. " + answer3.getText().toLowerCase());
		System.out.println("4. " + answer4.getText().toLowerCase());
		System.out.println("5. " + answer5.getText().toLowerCase());
		System.out.println("6. " + answer6.getText().toLowerCase());
		System.out.println("7. " + answer7.getText().toLowerCase());
		System.out.println("8. " + answer8.getText().toLowerCase());
		System.out.println("9. " + answer9.getText().toLowerCase());
		System.out.println("10. " + answer10.getText().toLowerCase());
		
		
		if (answer1.getText().toLowerCase().equals("b")) 
			score = score + 1;
		
		
		if (answer2.getText().toLowerCase().equals("a")) 
			score = score + 1;
		
		
		if (answer3.getText().toLowerCase().equals("d")) 
			score = score + 1;
		
		
		if (answer4.getText().toLowerCase().equals("c")) 
			score = score + 1;
		
		if (answer5.getText().toLowerCase().equals("c")) 
			score = score + 1;
		
		if (answer6.getText().toLowerCase().equals("d")) 
			score = score + 1;
		
		if (answer7.getText().toLowerCase().equals("a")) 
			score = score + 1;
		
		if (answer8.getText().toLowerCase().equals("b")) 
			score = score + 1;
		
		if (answer9.getText().toLowerCase().equals("c")) 
			score = score + 1;
		
		if (answer10.getText().toLowerCase().equals("d")) 
			score = score + 1;
		
		System.out.println(score);
		int finalScore = score;
		this.scoreLabel.setText(Integer.toString(finalScore));
		System.out.println(this.scoreLabel);
	}
	
	
	
	
	
	

}
