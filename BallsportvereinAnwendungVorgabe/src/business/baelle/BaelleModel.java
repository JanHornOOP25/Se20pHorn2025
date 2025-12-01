package business.baelle;

import java.io.*;
//import java.util.Observable;
import java.util.Vector;
import ownUtil.*;

import business.SportartikelListe;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;







public class BaelleModel implements Observable {
 		
	private SportartikelListe<Ball> baelle = new  SportartikelListe<Ball>() ;
	//private int anzahlBaelle;
	private static BaelleModel instesns = null;
	public Vector<Observer> observers = new Vector<Observer>();
	
	private BaelleModel() {
		
	}
	public static BaelleModel getinstesns() {
		if (instesns == null) {
			instesns = new BaelleModel();
		}
		return instesns;
		
	}
	/*
	public int getAnzahlBaelle() {
		return anzahlBaelle;
	}

	public void setAnzahlBaelle(int anzahlBaelle) {
		this.anzahlBaelle = anzahlBaelle;
	}
	
	public SportartikelListe<Ball> holeBaelle() {
		/*
		Ball[] result = new Ball[baelle.getAnzahlSportartikel()];
		for(int i = 0; i < result.length; i++) {
			result[i] = this.baelle.getSportartikel(i);
		}
		
		SportartikelListe<Ball>result = null ;
		for(int i = 0; i < this.baelle.getAnzahlSportartikel(); i++) {
			result.addSportartikel(this.baelle.getSportartikel(i));			
		}
		return result;
	}
*/
	
	public Ball gibBall(String einkaufsdatum) {
		Ball ball = null;
		int i = 0;
		while (ball == null && i < this.baelle.getAnzahlSportartikel()) {
			if(Integer.parseInt(einkaufsdatum) == baelle.getSportartikel(i).getEinkaufsdatum()){
				ball = this.baelle.getSportartikel(i);
			}
			i++;
		}
		return ball;
	}
	

	public SportartikelListe<Ball> getBaelle() {
		return baelle;
	}
	// Die Fabrik-Methode wurde zum Lesen aus der CsvDatei nicht angewendet
	public void leseBaelleAusDatei()
	    throws Exception{
	    BufferedReader ein = new BufferedReader(new FileReader("Baelle.csv"));
	   	/*
	    for(int i = 0; i < this.baelle.getAnzahlSportartikel(); i++) {
	   		this.baelle.getSportartikel(i)= null;
	   	}
	   	*/
	   	//this.anzahlBaelle = Integer.parseInt(ein.readLine());
	   	String[] zeile;
	   	/*
	   	for(int i = 0; i < this.getAnzahlBaelle(); i++) {
	   		zeile = ein.readLine().split(";");
	   		this.baelle[i] = new Ball(
	   			Integer.parseInt(zeile[0]), 
	   			zeile[1], zeile[2], zeile[3], zeile[4], 
	   			Double.parseDouble(zeile[5]));
	   	}
	   	*/
	   	while(ein.readLine()!=null) {
	   		zeile = ein.readLine().split(";");
	   		this.baelle.addSportartikel(new Ball(
	   			Integer.parseInt(zeile[0]), 
	   			zeile[1], zeile[2], zeile[3], zeile[4], 
	   			Double.parseDouble(zeile[5])));
	   	}
	   	//setChanged();
	   	notifyObserver();
	    ein.close();
 	}
	
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
		
	}
	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
		
	}
	
	@Override
	public void notifyObserver() {
		for(Observer obs : observers) {
			obs.update();
		}
	}
}