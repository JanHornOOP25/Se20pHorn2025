package business.motorrad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import business.auto.Auto;
import business.auto.AutosModel;
import filCreatorsHorn.ConcreteReaderCreator;
import filCreatorsHorn.ReaderCreatorHorn;
import filCreatorsHorn.ReaderProductHorn;
import ownUtil.Observable;
import ownUtil.Observer;

public class MotorradModel {
	private ArrayList<Motorrad> motorrads = new ArrayList<Motorrad>() ;
	private static MotorradModel instans = null;

	
	public static MotorradModel getInstance() {
		if (instans == null) {
			instans = new MotorradModel();
		}
		return instans;
		
	}
	

	private MotorradModel() {
		super();
	}
	
	public void leseMotorradAusCsvDatei()
			throws IOException {
			BufferedReader ein = new BufferedReader(new FileReader("Motorad.csv"));
	 		ArrayList<Motorrad> ergebnis = new ArrayList<Motorrad>(); 
			String zeileStr = ein.readLine();
			while(zeileStr != null) {
				String[] zeile = zeileStr.split(";");
				
	           		ergebnis.add( new Motorrad(zeile[0], zeile[1], zeile[2]));
	           		zeileStr = ein.readLine();
			}    
	 		ein.close();
	 		this.motorrads = ergebnis;
	 	}


	public ArrayList<Motorrad> getMotorrads() {
		return motorrads;
	}


	public void setMotorrads(ArrayList<Motorrad> motorrads) {
		this.motorrads = motorrads;
	}








}