package com.projectoop;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChapterThreeGUI {
	
	Parent chapterOneLayout;
	private static Stage window;
	private static Scene chapterOneScene;
	
	
	public void start(Stage primaryStage) throws Exception {
		this.chapterOneLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/chapterThree.fxml"));
		ChapterThreeGUI.window = primaryStage;
		ChapterThreeGUI.window.setTitle("Data Science For Everyone - Chapter Three");
		ChapterThreeGUI.chapterOneScene = new Scene(chapterOneLayout, 1440, 900);
	    ChapterThreeGUI.window.setScene(chapterOneScene);
	    ChapterThreeGUI.window.show();
		
		System.out.println("Chapter Three"); 
		primaryStage.setResizable(false);
	}

}
