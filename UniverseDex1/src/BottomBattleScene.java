import java.math.BigDecimal;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BottomBattleScene {
	
	public static void BottomBattleDisplay(ProgressBar enemyProgressBar, Text enemyHP, BigDecimal enemyProgress, Stage menuStage) {
		StackPane root = new StackPane();
//		Button menu = new Button();
//		menu.setMaxSize(1200, 175); // Width x Length
//		menu.setTranslateY(260);
        root.setStyle("-fx-background-size: 1200; -fx-background-color: #222222; -fx-border-color: #222222");
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Button attackButton1 = new Button("Thunderbolt");
		Button attackButton2 = new Button("Dragon Ascent");
		Button attackButton3 = new Button("Dragon Claw");
		Button attackButton4 = new Button("Flamethrower");
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		///////////// ATTACK 1 /////////////////
		
		attackButton1.setMinSize(130, 75);
		attackButton1.setTranslateX(-100);
		attackButton1.setTranslateY(-30);
		
		attackButton1.setStyle(
				"-fx-text-fill: white;"
				+ "-fx-background-color: #222222;"
				+ "-fx-background-radius: 25;"
				+ "-fx-border-color: #ffffff;"
				+ "-fx-border-radius: 25;"
				+ "-fx-border-width: 3;"
				+ "-fx-font: bold 15pt \"Lucida Sans Typewriter\"; ");
		attackButton1.setOnMouseEntered(event ->{
			attackButton1.setStyle(
					"-fx-text-fill: white;"
					+ "-fx-background-color: #222222;"
					+ "-fx-background-radius: 25;"
					+ "-fx-border-color: #ccff00;"
					+ "-fx-border-radius: 25;"
					+ "-fx-border-width: 3;"
					+ "-fx-font: bold 15pt \"Lucida Sans Typewriter\"; ");
		});
		attackButton1.setOnMouseExited(event ->{
			attackButton1.setStyle(
					"-fx-text-fill: white;"
					+ "-fx-background-color: #222222;"
					+ "-fx-background-radius: 25;"
					+ "-fx-border-color: #ffffff;"
					+ "-fx-border-radius: 25;"
					+ "-fx-border-width: 3;"
					+ "-fx-font: bold 15pt \"Lucida Sans Typewriter\"; ");
		});
		attackButton1.setOnAction(event ->{
			enemyChange(enemyProgress, enemyProgressBar, enemyHP);
		});

		///////////// ATTACK 2 /////////////////
		attackButton2.setMinSize(130, 75);
		attackButton2.setTranslateX(100);
		attackButton2.setTranslateY(-30);
		
		attackButton2.setStyle(
				"-fx-text-fill: white;"
				+ "-fx-background-color: #222222;"
				+ "-fx-background-radius: 25;"
				+ "-fx-border-color: #ffffff;"
				+ "-fx-border-radius: 25;"
				+ "-fx-border-width: 3;"
				+ "-fx-font: bold 15pt \"Lucida Sans Typewriter\"; ");
		attackButton2.setOnMouseEntered(event ->{
			attackButton2.setStyle(
					"-fx-text-fill: white;"
					+ "-fx-background-color: #222222;"
					+ "-fx-background-radius: 25;"
					+ "-fx-border-color: #ccff00;"
					+ "-fx-border-radius: 25;"
					+ "-fx-border-width: 3;"
					+ "-fx-font: bold 15pt \"Lucida Sans Typewriter\"; ");
		});
		attackButton2.setOnMouseExited(event ->{
			attackButton2.setStyle(
					"-fx-text-fill: white;"
					+ "-fx-background-color: #222222;"
					+ "-fx-background-radius: 25;"
					+ "-fx-border-color: #ffffff;"
					+ "-fx-border-radius: 25;"
					+ "-fx-border-width: 3;"
					+ "-fx-font: bold 15pt \"Lucida Sans Typewriter\"; ");
		});
		// Attack 2 Damage Calculation
		attackButton2.setOnAction(event ->{
			enemyChange(enemyProgress, enemyProgressBar, enemyHP);
		});

		///////////// ATTACK 3 /////////////////
		attackButton3.setMinSize(130, 75);
		attackButton3.setTranslateX(-100);
		attackButton3.setTranslateY(60);
		
		attackButton3.setStyle(
				"-fx-text-fill: white;"
				+ "-fx-background-color: #222222;"
				+ "-fx-background-radius: 25;"
				+ "-fx-border-color: #ffffff;"
				+ "-fx-border-radius: 25;"
				+ "-fx-border-width: 3;"
				+ "-fx-font: bold 15pt \"Lucida Sans Typewriter\"; ");
		attackButton3.setOnMouseEntered(event ->{
			attackButton3.setStyle(
					"-fx-text-fill: white;"
					+ "-fx-background-color: #222222;"
					+ "-fx-background-radius: 25;"
					+ "-fx-border-color: #ccff00;"
					+ "-fx-border-radius: 25;"
					+ "-fx-border-width: 3;"
					+ "-fx-font: bold 15pt \"Lucida Sans Typewriter\"; ");
		});
		attackButton3.setOnMouseExited(event ->{
			attackButton3.setStyle(
					"-fx-text-fill: white;"
					+ "-fx-background-color: #222222;"
					+ "-fx-background-radius: 25;"
					+ "-fx-border-color: #ffffff;"
					+ "-fx-border-radius: 25;"
					+ "-fx-border-width: 3;"
					+ "-fx-font: bold 15pt \"Lucida Sans Typewriter\"; ");
		});
		attackButton3.setOnAction(event ->{
			enemyChange(enemyProgress, enemyProgressBar, enemyHP);
		});

		///////////// ATTACK 4 /////////////////
		attackButton4.setMinSize(130, 75);
		attackButton4.setTranslateX(100);
		attackButton4.setTranslateY(60);
		
		attackButton4.setStyle(
				"-fx-text-fill: white;"
				+ "-fx-background-color: #222222;"
				+ "-fx-background-radius: 25;"
				+ "-fx-border-color: #ffffff;"
				+ "-fx-border-radius: 25;"
				+ "-fx-border-width: 3;"
				+ "-fx-font: bold 15pt \"Lucida Sans Typewriter\"; ");
		attackButton4.setOnMouseEntered(event ->{
			attackButton4.setStyle(
					"-fx-text-fill: white;"
					+ "-fx-background-color: #222222;"
					+ "-fx-background-radius: 25;"
					+ "-fx-border-color: #ccff00;"
					+ "-fx-border-radius: 25;"
					+ "-fx-border-width: 3;"
					+ "-fx-font: bold 15pt \"Lucida Sans Typewriter\"; ");
		});
		attackButton4.setOnMouseExited(event ->{
			attackButton4.setStyle(
					"-fx-text-fill: white;"
					+ "-fx-background-color: #222222;"
					+ "-fx-background-radius: 25;"
					+ "-fx-border-color: #ffffff;"
					+ "-fx-border-radius: 25;"
					+ "-fx-border-width: 3;"
					+ "-fx-font: bold 15pt \"Lucida Sans Typewriter\"; ");
		});
		attackButton4.setOnAction(event ->{
			enemyChange(enemyProgress, enemyProgressBar, enemyHP);
		});
		
		Scene bottomSceneBattle = new Scene(root, 400, 300); // Length x Width
		root.getChildren().addAll(
				// Menu	
				attackButton1,
				attackButton2,
				attackButton3,
				attackButton4
				); 
		
		menuStage.setScene(bottomSceneBattle); // Start-Up
		
		menuStage.setResizable(true);
//		battleStage.setMinWidth(600);
//		battleStage.setMinHeight(600);
		
		menuStage.setTitle("Menu Console");
		menuStage.setX(1000);
		menuStage.setY(500);
//		bottomBattleStage.show();
		
	}

	public static void enemyChange(BigDecimal enemyProgress, ProgressBar enemyProgressBar, Text enemyHP) {
		enemyProgress = new BigDecimal(String.format("%.2f", enemyProgressBar.getProgress() - .08));
		enemyProgressBar.setProgress(enemyProgress.doubleValue());
		System.out.println();
		
		if(enemyProgressBar.getProgress() >= .05 && enemyProgressBar.getProgress() <= 1.0) {
			enemyProgressBar.setStyle("-fx-accent: limegreen");
		} 
		if(enemyProgressBar.getProgress() >= 0.25  && enemyProgressBar.getProgress() < 0.50) {
			enemyProgressBar.setStyle("-fx-accent: orange");
		} 
		if(enemyProgressBar.getProgress() > 0.0 && enemyProgressBar.getProgress() < 0.25) {
			enemyProgressBar.setStyle("-fx-accent: red");
		}
//			attackButton.setText(Integer.toString((int)Math.round(progress.doubleValue() * 100)) + "%");
		enemyHP.setText(Math.round(enemyProgressBar.getProgress() * 100) + "/100");
	 }
	
		public static void userChange(BigDecimal userProgress, ProgressBar userProgressBar) {
			userProgress = new BigDecimal(String.format("%.2f", userProgressBar.getProgress() - 0.1));
			userProgressBar.setProgress(userProgress.doubleValue());
			System.out.println(userProgressBar.getProgress());
			
			if(userProgressBar.getProgress() >= .05 && userProgressBar.getProgress() <= 1.0) {
				userProgressBar.setStyle("-fx-accent: limegreen");
			} 
			if(userProgressBar.getProgress() >= 0.25  && userProgressBar.getProgress() < 0.50) {
				userProgressBar.setStyle("-fx-accent: orange");
			} 
			if(userProgressBar.getProgress() > 0.0 && userProgressBar.getProgress() < 0.25) {
				userProgressBar.setStyle("-fx-accent: red");
			}
//			attackButton.setText(Integer.toString((int)Math.round(progress.doubleValue() * 100)) + "%");
		 }
	
}
