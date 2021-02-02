package com.projectoop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChapterTwoQuizGUI extends Application {
	
	Parent chapterOneQuizLayout;
	private static Stage window;
	private static Scene chapterOneQuizScene;
	
	
	public void start(Stage primaryStage) throws Exception {
		this.chapterOneQuizLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/chapterTwoQuiz.fxml"));
		ChapterTwoQuizGUI.window = primaryStage;
		ChapterTwoQuizGUI.window.setTitle("Data Science For Everyone - Quiz 2");
		ChapterTwoQuizGUI.chapterOneQuizScene = new Scene(chapterOneQuizLayout, 1440, 900);
	    ChapterTwoQuizGUI.window.setScene(chapterOneQuizScene);
	    ChapterTwoQuizGUI.window.show();
		
		System.out.println("Chapter One"); 
	}
}