package gui.guiAutovermietung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.auto.*;

import javafx.stage.Stage;

public class AutovermietungControl {
	 private AutovermietungView avView;
	 private AutosModel avModel;
	 
	 

	 
	  public AutovermietungControl(Stage primaryStage) {
		super();
		this.avModel = avModel.getInstance();
		this.avView =new  AutovermietungView(this, avModel, primaryStage);
	}

	  void nehmeAutoAuf(){
	    	try{ 
	    		avModel.autonehmeAutoAuf(
	    				avView.txtKennzeichen.getText(), 
	    				avView.txtTyp.getText(),
	    				avView.txtModell.getText(),
	   	            Float.parseFloat(avView.txtTagespreis.getText()),
	   	         avView.txtVermietetVonBis.getText().split(";"));
	    		avView.zeigeInformationsfensterAn("Das Auto wurde aufgenommen!");
	       	}
	       	catch(Exception exc){
	       		avView.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	    }
	   
	     void zeigeAutosAn(){
	    	if(avModel.getAuto() != null){
	    		avView.txtAnzeige.setText(
	    			avModel.gibAutoZurueck(' '));
	    	}
	    	else{
	    		avView.zeigeInformationsfensterAn("Bisher wurde kein Auto aufgenommen!");
	    	}
	    }    
			  
	     void leseAusDatei(String typ){
	    	try {
	      		
	      			avModel.lesAusDatei(typ);
	      	  			avView.zeigeInformationsfensterAn(
	      	  	   			"Das Auto wurde gelesen!");
	      		
			}
			catch(IOException exc){
				avView.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				avView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
			}
		}
			
		 void schreibeAutoInCsvDatei() {
			try {
				avModel.schreibeAutoInCsvDatei();
				avView.zeigeInformationsfensterAn(
		   			"Die Autos wurden gespeichert!");
			}	
			catch(IOException exc){
				avView.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
			}
			catch(Exception exc){
				avView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			}
		}
}
