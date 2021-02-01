package com.projectoop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChapterOneQuizGUI extends Application {
	
	Parent chapterOneQuizLayout;
	private static Stage window;
	private static Scene chapterOneQuizScene;
	
	
	public void start(Stage primaryStage) throws Exception {
		this.chapterOneQuizLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/chapterOneQuiz.fxml"));
		ChapterOneQuizGUI.window = primaryStage;
		ChapterOneQuizGUI.window.setTitle("Data Science For Everyone - Quiz 1");
		ChapterOneQuizGUI.chapterOneQuizScene = new Scene(chapterOneQuizLayout, 1440, 900);
	    ChapterOneQuizGUI.window.setScene(chapterOneQuizScene);
	    ChapterOneQuizGUI.window.show();
		
		System.out.println("Chapter One"); 
	}
}