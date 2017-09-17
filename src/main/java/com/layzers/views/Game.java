package com.layzers.views;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Game extends Application {
	
	private Stage window;
	private Scene IntroScene, PlayerScene;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Layzers!");
		window.setResizable(false);
		window.setWidth(1200);
		window.setHeight(1000);

		GridPane grid = new GridPane();
		grid.setHgap(0);
		grid.setVgap(0);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text welcome = new Text("Welcome to Layzers!");
		welcome.setFont(Font.font("Tahoma", FontWeight.NORMAL, 100));
		HBox welcomeBox = new HBox(welcome);
		welcomeBox.setAlignment(Pos.CENTER);
		grid.setAlignment(Pos.TOP_CENTER);
		grid.add(welcomeBox, 0, 0, 2, 1);

		Text lasers = new Text("Lasers!");
		lasers.setId("fancytext");
		lasers.setFill(Color.FIREBRICK);
		HBox lasersBox = new HBox(lasers);
		lasersBox.setAlignment(Pos.CENTER);
		grid.setAlignment(Pos.CENTER);
		grid.add(lasersBox, 0, 1, 2, 1);

		Text requirements = new Text("This game requires two participants.\n" + "Are you ready to play?");
		requirements.setFont(Font.font("Tahoma", 70));
		requirements.setTextAlignment(TextAlignment.CENTER);
		HBox reqBox = new HBox(requirements);
		reqBox.setAlignment(Pos.CENTER);
		grid.setAlignment(Pos.BASELINE_CENTER);
		grid.add(reqBox, 0, 2, 2, 1);

		Button goBtn = new Button("Let's Go!");

		Button cancelBtn = new Button("Cancel");

		HBox btnBox = new HBox(10);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().add(goBtn);
		btnBox.getChildren().add(cancelBtn);
		grid.add(btnBox, 0, 3, 2, 1);

		goBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(PlayerScene);
			}
		});

		cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ExitDialog.exitGame(window);
			}
		});

		IntroScene = new Scene(grid);
		IntroScene.setFill(Color.DARKBLUE);
		IntroScene.getStylesheets().add(this.getClass().getResource("/test/layzers/stylesheets/Game.css").toExternalForm());
		window.setScene(IntroScene);
		window.show();
		
//		List<String> fonts = javafx.scene.text.Font.getFamilies();
//		for(String s:fonts){
//			System.out.println(s);
//		}
	}
}

// btn.getStyleClass().add("testbutton");

//// A button with an empty text caption.
// Button button1 = new Button();
//// A button with the specified text caption.
// Button button2 = new Button("Accept");
//// A button with the specified text caption and icon.
// Image imageOk = new Image(getClass().getResourceAsStream("ok.png"));
// Button button3 = new Button("Accept", new ImageView(imageOk));

// DropShadow shadow = new DropShadow();
//// Adding the shadow when the mouse cursor is on
// goBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, new
// EventHandler<MouseEvent>() {
// @Override
// public void handle(MouseEvent e) {
// goBtn.setEffect(shadow);
// }
// });
//// Removing the shadow when the mouse cursor is off
// goBtn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>()
// {
// @Override
// public void handle(MouseEvent e) {
// goBtn.setEffect(null);
// }
// });

// TextField playerOneNameField = new TextField();
// grid.add(playerOneNameField, 1, 1);
//
// Label playerTwo = new Label("Player 2:");
// grid.add(playerTwo, 0, 2);
//
// TextField playerTwoNameField = new TextField();
// grid.add(playerTwoNameField, 1, 2);