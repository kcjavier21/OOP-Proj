package com.projectoop;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.Initializable;


public class ChapterOne implements Initializable {

	@FXML private Label usernameLabel = new Label("Hello");
	
	@FXML 
	private MediaView mv;
	
	@FXML
	private Button btn_play;
	
	@FXML
	private Button btn_pause;
	
	@FXML
	private Button btn_stop;
	
	@FXML
	private Button btn_take_quiz;
	
	@FXML
	private Slider progressBar;
	
	@FXML
	private Slider volumeSlider;
	
	MediaPlayer mediaplayer;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		String VUrl = new File("src/media/test.mp4").getAbsolutePath();
		Media media = new Media(new File(VUrl).toURI().toString());
		mediaplayer = new MediaPlayer(media);
		
		mv.setFitHeight(480);
		mv.setFitWidth(720);
		mv.setMediaPlayer(mediaplayer);
		
		mediaplayer.setAutoPlay(true);
		
		mediaplayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
			@Override
			public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
				progressBar.setValue(newValue.toSeconds());
				
			}
		});
		
		// === TO SEEK VIDEO ======
		
		progressBar.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mediaplayer.seek(Duration.seconds(progressBar.getValue()));
			}
		});
		
		progressBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mediaplayer.seek(Duration.seconds(progressBar.getValue()));
			}
		});
		
		volumeSlider.setValue(mediaplayer.getVolume() * 100);
		
		volumeSlider.valueProperty().addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable observable) {
				mediaplayer.setVolume(volumeSlider.getValue()/100);
			}
		});
		
		
	}
	
	@FXML
	private void on_click_btn_stop() {
		mediaplayer.stop();
	}
	
	@FXML
	private void on_click_btn_play() {
		mediaplayer.play();
	}
	
	@FXML
	private void on_click_btn_pause() {
		mediaplayer.pause();
	}

	public void onClickRefreshButton() {
		System.out.println("Refresh button clicked!");
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		System.out.println("UN Button: " + this.usernameLabel);
	}
	
	
	
	@FXML 
	private void navigateToQuizOne(InputEvent event) throws Exception {
		mediaplayer.stop();
		
		Platform.exit();
		
		try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/projectoop/fxml-files/chapterOneQuiz.fxml"));
	    	Parent root = (Parent) loader.load();
	    	Stage stage = new Stage();
	    	stage.setScene(new Scene(root));
	    	stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
		
	}
	
}
