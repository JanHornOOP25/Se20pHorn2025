package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;



import filCreatorsHorn.*;
import ownUtil.Observable;
import ownUtil.Observer;

public class AutosModel implements Observable {
	private Auto auto;
	private static AutosModel instans = null;
	public Vector<Observer> observers = new Vector<Observer>();
	
	public static AutosModel getInstance() {
		if (instans == null) {
			instans = new AutosModel();
		}
		return instans;
		
	}
	

	private AutosModel() {
		super();
	}


	public void autonehmeAutoAuf(String text, String text2, String text3, float float1, String[] split) {
		auto = new Auto(text, text2, text3, float1, split);
		notifyObserver();

	}

	public String gibAutoZurueck(char c) {
		// TODO Auto-generated method stub
		return auto.gibAutoZurueck(c);
	}

	public Auto getAuto() {
		// TODO Auto-generated method stub
		return auto;
	}

	public void lesAusDatei(String typ) throws IOException {
		ReaderCreatorHorn readercreator= new ConcreteReaderCreator();
		ReaderProductHorn reader = readercreator.factoryMethod(typ);
		String[] zeile = reader.leseAusDatei(); 
		this.auto = new Auto(zeile[0], zeile[1], zeile[2], Float.parseFloat(zeile[3]), zeile[4].split("_"));
		reader.schlisseDatei();
		notifyObserver();

	}

	public void schreibeAutoInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("AutosAusgabe.csv", true));
		aus.write(auto.gibAutoZurueck(';'));
		aus.close();
	}


	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
		
	}


	@Override
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
		
	}


	@Override
	public void notifyObserver() {
		for(Observer obs :observers) {
			obs.update();
		}
		
	}





}
