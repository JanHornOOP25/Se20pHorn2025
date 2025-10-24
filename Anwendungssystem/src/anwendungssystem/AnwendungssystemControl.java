package anwendungssystem;

public class AnwendungssystemControl {
	private AnwendungssystemView anwView;
	private AnwendungssystemModel anwModel;

	public AnwendungssystemControl(String[] args) {
		anwModel = new AnwendungssystemModel();
		anwView = new AnwendungssystemView(this, anwModel,args);
	}
	
	public void schreibeInDatei(String text){
		try{
			anwModel.schribdateu(text);
	
	       anwView.zeigeInformationsfensterAn("Der Text wurde in die Datei geschrieben.");
		}
		catch(Exception exc){	   
			anwView.zeigeFehlermeldungAn("Fehler beim Schreiben in die Datei.");
		}
	}

}
