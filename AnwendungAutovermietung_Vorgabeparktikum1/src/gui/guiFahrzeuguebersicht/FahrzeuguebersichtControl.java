package gui.guiFahrzeuguebersicht;

import java.io.IOException;

import business.auto.*;
import business.motorrad.MotorradModel;
import javafx.stage.Stage;

public class FahrzeuguebersichtControl {
	private FahrzeuguebersichtView fahrzeuguebersichtView;
	private AutosModel autosModel;
	private MotorradModel motModel;

	public FahrzeuguebersichtControl(Stage primaryStage) {
		this.autosModel = autosModel.getInstance();
		this.motModel = motModel.getInstance();
		this.fahrzeuguebersichtView = new FahrzeuguebersichtView(this, primaryStage, autosModel,motModel);
	}

	public void leseMotorradAusCsvDatei() {
		try {
			this.motModel.leseMotorradAusCsvDatei();
		} catch (IOException exc) {
			this.fahrzeuguebersichtView.zeigeFehlermeldungsfensterAn("IOException beim Lesen von Sporthallen!");
		} catch (Exception exc) {
			this.fahrzeuguebersichtView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen von " + " Sporthallen!");
		}
	}

}
