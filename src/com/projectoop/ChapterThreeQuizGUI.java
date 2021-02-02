package com.projectoop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChapterThreeQuizGUI extends Application {
	
	Parent chapterOneQuizLayout;
	private static Stage window;
	private static Scene chapterOneQuizScene;
	
	
	public void start(Stage primaryStage) throws Exception {
		this.chapterOneQuizLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/chapterThreeQuiz.fxml"));
		ChapterThreeQuizGUI.window = primaryStage;
		ChapterThreeQuizGUI.window.setTitle("Data Science For Everyone - Quiz 3");
		ChapterThreeQuizGUI.chapterOneQuizScene = new Scene(chapterOneQuizLayout, 1440, 900);
	    ChapterThreeQuizGUI.window.setScene(chapterOneQuizScene);
	    ChapterThreeQuizGUI.window.show();
		
		System.out.println("Quiz Three");
		primaryStage.setResizable(false);
	}
}