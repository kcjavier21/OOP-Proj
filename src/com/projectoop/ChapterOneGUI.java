package com.projectoop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChapterOneGUI extends Application {
	
	Parent chapterOneLayout;
	private static Stage window;
	private static Scene chapterOneScene;
	
	
	public void start(Stage primaryStage) throws Exception {
		this.chapterOneLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/chapterOne.fxml"));
		ChapterOneGUI.window = primaryStage;
		ChapterOneGUI.window.setTitle("Data Science For Everyone - Chapter One");
		ChapterOneGUI.chapterOneScene = new Scene(chapterOneLayout, 1440, 900);
	    ChapterOneGUI.window.setScene(chapterOneScene);
	    ChapterOneGUI.window.show();
		
		System.out.println("Chapter One"); 
	}
}
