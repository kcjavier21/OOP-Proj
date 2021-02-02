package com.projectoop;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChapterFourGUI {
	
	Parent chapterOneLayout;
	private static Stage window;
	private static Scene chapterOneScene;
	
	
	public void start(Stage primaryStage) throws Exception {
		this.chapterOneLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/chapterFour.fxml"));
		ChapterFourGUI.window = primaryStage;
		ChapterFourGUI.window.setTitle("Data Science For Everyone - Chapter Four");
		ChapterFourGUI.chapterOneScene = new Scene(chapterOneLayout, 1440, 900);
	    ChapterFourGUI.window.setScene(chapterOneScene);
	    ChapterFourGUI.window.show();
		
		System.out.println("Chapter Four"); 
		primaryStage.setResizable(false);
	}

}
