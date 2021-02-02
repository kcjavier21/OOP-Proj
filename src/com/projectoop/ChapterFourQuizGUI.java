package com.projectoop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChapterFourQuizGUI extends Application {
	
	Parent chapterOneQuizLayout;
	private static Stage window;
	private static Scene chapterOneQuizScene;
	
	
	public void start(Stage primaryStage) throws Exception {
		this.chapterOneQuizLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/chapterFourQuiz.fxml"));
		ChapterFourQuizGUI.window = primaryStage;
		ChapterFourQuizGUI.window.setTitle("Data Science For Everyone - Quiz 4");
		ChapterFourQuizGUI.chapterOneQuizScene = new Scene(chapterOneQuizLayout, 1440, 900);
	    ChapterFourQuizGUI.window.setScene(chapterOneQuizScene);
	    ChapterFourQuizGUI.window.show();
		
		System.out.println("Quiz Four"); 
		primaryStage.setResizable(false);
	}
}