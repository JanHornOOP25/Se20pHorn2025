package main;

import java.io.IOException;

import business.*;

public class Main {

	public static void main(String[] args) {
		ArtikelModel artikelModel = new ArtikelModel();
		try {
			artikelModel.leseArtikelAusCsvDatei();
			artikelModel.schreibeArtikelInTxtDatei();
			artikelModel.schreibeArtikelInKonsole();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
