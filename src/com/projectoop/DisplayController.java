package com.projectoop;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DisplayController implements Initializable {
	
	@FXML
	private static Label usernameee = new Label("Hello");
	
	private static String usernameeeStr;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	public static void setVal(String username) {
		System.out.println("SetVal called");
		System.out.println("UN: " + username);
		
		usernameee.setId("usernameLabel");
		usernameee.setText(username);
		usernameeeStr = username;
		
		System.out.println("UN Str Set Val: " + usernameeeStr);
		System.out.println("UN Set Val: " + usernameee);
	}
	
	@FXML
	public static String getUserNameStr() {
	    return usernameeeStr;
	  }
	
	/*
	@FXML
	public void buttonIsClicked() {
		System.out.println("Nice!");
		//System.out.println("UN Str Button: " + this.usernameeeStr);
		this.usernameee.setText(this.getUserNameStr());

		System.out.println("UN Button: " + this.usernameee);
	}
	*/
}
