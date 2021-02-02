package com.projectoop;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChapterTwoGUI {
	
	Parent chapterOneLayout;
	private static Stage window;
	private static Scene chapterOneScene;
	
	
	public void start(Stage primaryStage) throws Exception {
		this.chapterOneLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/chapterTwo.fxml"));
		ChapterTwoGUI.window = primaryStage;
		ChapterTwoGUI.window.setTitle("Data Science For Everyone - Chapter Two");
		ChapterTwoGUI.chapterOneScene = new Scene(chapterOneLayout, 1440, 900);
	    ChapterTwoGUI.window.setScene(chapterOneScene);
	    ChapterTwoGUI.window.show();
		
		System.out.println("Chapter One"); 
		primaryStage.setResizable(false);
	}

}
