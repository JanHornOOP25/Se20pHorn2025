package gui.sportartikel;

import business.baelle.BaelleModel;
import business.trikots.TrikotsModel;
import javafx.stage.Stage;

public class SportartikelControl {
	
	private SportartikelView sportartikelView;
	
	private TrikotsModel trikotsModel;
	private BaelleModel baelleModel;

	public SportartikelControl(Stage stage){
		this.trikotsModel = TrikotsModel.getInstance();
		this.baelleModel = BaelleModel.getinstesns();
		this.sportartikelView = new SportartikelView(this, stage, 
			trikotsModel, baelleModel);
		// Nur zum Test (Dummies): Bisher gibt es keine Eingabe-
		// funktionalitaet oder Lesefunktionalitaet von Trikots.
		this.trikotsModel.fetchDummyTrikots();
	}

}
