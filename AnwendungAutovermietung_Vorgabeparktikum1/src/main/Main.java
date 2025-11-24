package main;


import gui.guiAutovermietung.AutovermietungControl;
import gui.guiFahrzeuguebersicht.FahrzeuguebersichtControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new AutovermietungControl(primaryStage);
		Stage fahrzeuguebersicht = new Stage();
		new FahrzeuguebersichtControl(fahrzeuguebersicht);
		
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
