package com.projectoop;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.Initializable;


public class ChapterOne implements Initializable {

	@FXML private Label usernameLabel = new Label("Hello");
	@FXML private Label userProgressLabel = new Label("0");
	@FXML private Label userTotalScoreLabel = new Label("0");
	
	@FXML private MediaView mv;
	
	@FXML private Button btn_play;
	@FXML private Button btn_pause;
	@FXML private Button btn_stop;
	@FXML private Button btn_take_quiz;
	@FXML private Button btnDashboard;
	@FXML private Button btnLogOut;
	@FXML private Button btnSeePDF;
	
	@FXML private Button btnChapTwo;
	@FXML private Button btnChapThree;
	@FXML private Button btnChapFour;
	
	@FXML private Slider progressBar;
	@FXML private Slider volumeSlider;
	
	MediaPlayer mediaplayer;
	
	ChapterOneQuizGUI chapterOneQuizGUI = new ChapterOneQuizGUI();
	ChapterOneQuiz chapterOneQuiz = new ChapterOneQuiz();
	Dashboard dashboard = new Dashboard();
	
	private static int userProgress = 0;
	private static int userTotalScore = 0;
	private static String username = new String("Username");
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		String VUrl = new File("src/media/ChapterOne.mp4").getAbsolutePath();
		Media media = new Media(new File(VUrl).toURI().toString());
		mediaplayer = new MediaPlayer(media);
		
		mv.setFitHeight(540);
		mv.setFitWidth(810);
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
		
		mediaplayer.setOnReady(new Runnable() {
			@Override
			public void run() {
				Duration total = media.getDuration();			
				progressBar.setMax(total.toSeconds());
			}
		});
		
		
		// ==== ADJUST VOLUME =====
		
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
		ChapterOne.username = DisplayController.getUserNameStr();
		this.usernameLabel.setText(DisplayController.getUserNameStr());
		System.out.println("UN Button: " + this.usernameLabel);
		
		ChapterOne.userProgress = DisplayController.getUserProgress();
		this.userProgressLabel.setText(Integer.toString(ChapterOne.userProgress));
		
		ChapterOne.userTotalScore = DisplayController.getUserTotalScore();
		this.userTotalScoreLabel.setText(Integer.toString(ChapterOne.userTotalScore));
		
	}
	
	// ============= NAVIGATION ===============
	
	public void seePDF() throws Exception {
		mediaplayer.pause();
	    
		Desktop d = Desktop.getDesktop();
		d.browse(new URI("https://bit.ly/2MttJDE"));
	}
	
	public void logOut() throws Exception {
		mediaplayer.stop();
		
	    Stage currentStage = (Stage) btnLogOut.getScene().getWindow();
	    currentStage.close();
	    
		try {
	    	Stage stage = new Stage();
	    	LoginPageGUI loginPageGUI = new LoginPageGUI();
	    	loginPageGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


		
	public void navigateToDashboard() throws Exception {
		mediaplayer.stop();
		
	    Stage currentStage = (Stage) btnDashboard.getScene().getWindow();
	    currentStage.close();
	    Stage window = new Stage();
	    dashboard.start(window);
		dashboard.switchScene(ChapterOne.username);
	}
	
	
	@FXML 
	private void navigateToQuizOne() throws Exception {
		mediaplayer.stop();
		
	    Stage currentStage = (Stage) btn_take_quiz.getScene().getWindow();
	    currentStage.close();
		
		try {
	    	Stage stage = new Stage();
	    	chapterOneQuizGUI.start(stage);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
	}
	
	public void navigateToChapTwo() throws Exception {
		mediaplayer.stop();
		
	    Stage currentStage = (Stage) btnChapTwo.getScene().getWindow();
	    currentStage.close();
	    
		try {
	    	Stage stage = new Stage();
	    	ChapterTwoGUI chapterTwoGUI = new ChapterTwoGUI();
	    	chapterTwoGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToChapThree() throws Exception {
		mediaplayer.stop();
		
		Stage currentStage = (Stage) btnChapThree.getScene().getWindow();
	    currentStage.close();
		
		try {
	    	Stage stage = new Stage();
	    	ChapterThreeGUI chapterThreeGUI = new ChapterThreeGUI();
	    	chapterThreeGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToChapFour() throws Exception {
		mediaplayer.stop();
		
		Stage currentStage = (Stage) btnChapFour.getScene().getWindow();
	    currentStage.close();
		
		try {
	    	Stage stage = new Stage();
	    	ChapterFourGUI chapterFourGUI = new ChapterFourGUI();
	    	chapterFourGUI.start(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
