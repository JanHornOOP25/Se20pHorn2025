package business.trikots;

import java.util.ArrayList;
import java.util.Vector;

import business.SportartikelListe;
import ownUtil.*;

public class TrikotsModel implements Observable{
	 
	private Vector<Observer> observers = new Vector<Observer>();
  		
	private SportartikelListe<Trikot> trikots = new SportartikelListe<>();
	private static TrikotsModel trikotsModel;
	
	private TrikotsModel() {	
	}
	
	public static TrikotsModel getInstance() {
		if(trikotsModel == null) {
			try {
				trikotsModel = new TrikotsModel();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return trikotsModel;
	}
	
	// Nur zum Test (Dummies): Bisher gibt es keine Eingabe-
	// funktionalitaet oder Lesefunktionalitaet von Trikots.
	public void fetchDummyTrikots() {
	    this.trikots.addSportartikel(new Trikot(10, 40, 49.90, 20200601));
	    this.trikots.addSportartikel(new Trikot(7, 52, 65.90, 20200601));	
	    notifyObservers();
	}
	
	public String gibTrikotsZurueck(char trenner) {
		String ergebnis = "";
		int i = 0;
		while (i < this.trikots.getAnzahlSportartikel()) {
		    ergebnis = ergebnis + this.trikots.getSportartikel(i).gibZurueck(trenner) + "\n";
			i++;
		}
		return ergebnis;
	}
	
	public void addObserver(Observer obs){
		this.observers.addElement(obs);
	}
	
	public void removeObserver(Observer obs){
		this.observers.removeElement(obs);
	}
	
	public void notifyObservers(){
		for(int i = 0; i < this.observers.size(); i++){
			this.observers.elementAt(i).update(this);
		}
	}

}