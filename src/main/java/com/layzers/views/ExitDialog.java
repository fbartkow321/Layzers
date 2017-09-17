package com.layzers.views;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class ExitDialog {
	
	public ExitDialog(){
		throw new RuntimeException("Can't instantiate class ExitDialog.");
	}
	
	public static void exitGame(Stage primaryStage){
		Alert exitDialog = new Alert(AlertType.CONFIRMATION);
		exitDialog.setTitle("Exit Confirmation");
		exitDialog.setHeaderText("Exit Confirmation");
		exitDialog.setContentText("Are you sure you want to close Layzers?");
		ButtonType closeGameButton = new ButtonType("Yes - Close this application");
		ButtonType noButton = new ButtonType("No - Let's keep playing");
		exitDialog.getButtonTypes().setAll(closeGameButton, noButton);
		Optional<ButtonType> result = exitDialog.showAndWait();
		if (result.get() == closeGameButton){
			System.out.println("Close this whole thing.");
			primaryStage.close();
		}
	}
}
