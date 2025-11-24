package gui.guiFahrzeuguebersicht;

import business.AutosModel;
import javafx.stage.Stage;

public class FahrzeuguebersichtControl {
	private FahrzeuguebersichtView fahrzeuguebersichtView;
	private AutosModel autosModel;

	public FahrzeuguebersichtControl(Stage primaryStage) {
		this.autosModel = autosModel.getInstance();
		this.fahrzeuguebersichtView = new FahrzeuguebersichtView(this, primaryStage, autosModel);
	}
}
