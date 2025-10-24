package anwendungssystem;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class AnwendungssystemView extends Application {
	private AnwendungssystemControl anwControl;
	private AnwendungssystemModel anwMod;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.grid.setAlignment(Pos.CENTER);
		this.grid.setHgap(10);
		this.grid.setVgap(10);
		this.grid.setPadding(new Insets(25, 25, 25, 25));
		primaryStage.setTitle(anwMod.getUeberschrift());
	    Scene scene = new Scene(grid, 350, 150);
		primaryStage.setScene(scene);
        primaryStage.show();
        
		this.initKomponenten();
		this.initListener();
		
	}

	public AnwendungssystemView(AnwendungssystemControl anwControl, AnwendungssystemModel anwMod, String[] args) {
		this.anwControl = anwControl;
		this.anwMod = anwMod;
		launch(args);
	}
	
	private GridPane grid = new GridPane();
	private TextField txtTest = new TextField();
	private Button btnTest = new Button("Test");

	private void initKomponenten() {
		this.grid.add(this.txtTest, 0, 0);
		this.grid.add(this.btnTest, 1, 0);
	}

	private void initListener() {
		btnTest.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				anwControl.schreibeInDatei(txtTest.getText());
			}
		});
	}
	void zeigeInformationsfensterAn(String meldung){
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Information");
	    alert.setContentText(meldung);
		alert.showAndWait();
	}
	    
	void zeigeFehlermeldungAn(String meldung){
	    Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Fehlermeldung");
		alert.setContentText(meldung);
		alert.showAndWait();
	}

	

}
