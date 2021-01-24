package com.projectoop;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ChapterOne {
@FXML private Label usernameLabel = new Label("Hello");

/*
	Parent chapterOneLayout;
	Scene chapterOneScene;
	private Stage window;
	DisplayController display = new DisplayController();
	
	public void start(Stage primaryStage) throws Exception {
		 this.chapterOneLayout = FXMLLoader.load(getClass().getResource("/com/projectoop/fxml-files/chapterOne.fxml"));
		 System.out.println("Chapter One Loaded");
		 this.window = primaryStage;
		 this.window.setTitle("Data Science For Everyone - Chapter One");
		 
		 System.out.println("Welcome to Chapter One");
	}
	
	public void switchScene(String username) {
		DisplayController.setVal(username);
		System.out.println(DisplayController.getUserNameStr());
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		
		System.out.println("YEET CHAPTER ONE!");
		chapterOneScene = new Scene(chapterOneLayout, 1080, 720);
		this.window.setScene(chapterOneScene);
		this.window.show();
	}
	*/
	public void onClickRefreshButton() {
		System.out.println("Refresh button clicked!");
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		System.out.println("UN Button: " + this.usernameLabel);
	}
}
