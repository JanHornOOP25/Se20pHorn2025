
package gui.guiFahrzeuguebersicht;

import business.auto.*;
import business.motorrad.Motorrad;
import business.motorrad.MotorradModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class FahrzeuguebersichtView implements Observer {

	private FahrzeuguebersichtControl fahrzeuguebersichtControl;
	private AutosModel autosModel;
	private MotorradModel motModel;
	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeAutos = new Label("Anzeige Autos");
	private TextArea txtAnzeigeAutos = new TextArea();
	private Label lblAnzeigeMotorad = new Label("Anzeige Motorad");
	private TextArea txtAnzeigeMotorad = new TextArea();
	
	private Button btnAnzeigeAutos = new Button("Anzeige");
	private Button btnAnzeigeMotor = new Button("csv import");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public FahrzeuguebersichtView(FahrzeuguebersichtControl fahrzeuguebersichtControl, Stage primaryStage,
			AutosModel autosModel, MotorradModel motModel) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Fahrzeugen");
		primaryStage.show();
		this.fahrzeuguebersichtControl = fahrzeuguebersichtControl;
		this.autosModel = autosModel;
		this.motModel = motModel;
		autosModel.addObserver(this);
		this.initKomponenten();
		this.initListener();
	}

	private void initKomponenten() {
		// Label
		initKomponentenauto();
		initKomponentenMotrad();
		/*
		Font font = new Font("Arial", 20);
		lblAnzeigeAutos.setLayoutX(310);
		lblAnzeigeAutos.setLayoutY(40);
		lblAnzeigeAutos.setFont(font);
		lblAnzeigeAutos.setStyle("-fx-font-weight: bold;");
		*/
		pane.getChildren().addAll(lblAnzeigeAutos,lblAnzeigeMotorad);
		// Textbereich
		/*
		txtAnzeigeAutos.setEditable(false);
		txtAnzeigeAutos.setLayoutX(310);
		txtAnzeigeAutos.setLayoutY(90);
		txtAnzeigeAutos.setPrefWidth(220);
		txtAnzeigeAutos.setPrefHeight(185);
		*/
		pane.getChildren().addAll(txtAnzeigeAutos,txtAnzeigeMotorad);
		// Button
		pane.getChildren().addAll(btnAnzeigeAutos,btnAnzeigeMotor);
	}
	private void initKomponentenauto() {
		Font font = new Font("Arial", 20);
		lblAnzeigeAutos.setLayoutX(310); //20
		lblAnzeigeAutos.setLayoutY(40);
		lblAnzeigeAutos.setFont(font);
		lblAnzeigeAutos.setStyle("-fx-font-weight: bold;");
		txtAnzeigeAutos.setEditable(false);
		txtAnzeigeAutos.setLayoutX(310);
		txtAnzeigeAutos.setLayoutY(90);
		txtAnzeigeAutos.setPrefWidth(220);
		txtAnzeigeAutos.setPrefHeight(185);
		btnAnzeigeAutos.setLayoutX(310);
		btnAnzeigeAutos.setLayoutY(290);
	}
	
	private void initKomponentenMotrad() {
		Font font = new Font("Arial", 20);
		lblAnzeigeMotorad.setLayoutX(20);
		lblAnzeigeMotorad.setLayoutY(40);
		lblAnzeigeMotorad.setFont(font);
		lblAnzeigeMotorad.setStyle("-fx-font-weight: bold;");
		txtAnzeigeMotorad.setEditable(false);
		txtAnzeigeMotorad.setLayoutX(20);
		txtAnzeigeMotorad.setLayoutY(90);
		txtAnzeigeMotorad.setPrefWidth(220);
		txtAnzeigeMotorad.setPrefHeight(185);
		btnAnzeigeMotor.setLayoutX(20);
		btnAnzeigeMotor.setLayoutY(290);
	}

	private void initListener() {
		btnAnzeigeAutos.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeAutosAn();
			}
		});
		btnAnzeigeMotor.setOnAction(e->zeigeSporthallenAn());
	}

	public void zeigeAutosAn() {
		/*
		 * if (autosModel.getAuto() != null) {
		 * txtAnzeigeAutos.setText(autosModel.getAuto().gibAutoZurueck(' ')); }
		 */

		if (this.autosModel.getAuto().size() > 0) {
			StringBuffer text = new StringBuffer();
			for (Auto auto : this.autosModel.getAuto()) {
				text.append(auto.gibAutoZurueck(' ') + "\n");
			}

			this.txtAnzeigeAutos.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Auto aufgenommen!");
		}
	}

	private void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	@Override
	public void update() {
		zeigeAutosAn();

	}

	void zeigeFehlermeldungsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
	}

	private void zeigeSporthallenAn() {
		fahrzeuguebersichtControl.leseMotorradAusCsvDatei();
		if (motModel.getMotorrads().size() > 0) {
			StringBuffer text = new StringBuffer();
			for (Motorrad sh : motModel.getMotorrads()) {
				text.append(sh.gibMotorradZurueck(' ') + "\n");
			}
			this.txtAnzeigeMotorad.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Es gibt keine Sporthalle in der csv-Datei!");
		}
	}

}
