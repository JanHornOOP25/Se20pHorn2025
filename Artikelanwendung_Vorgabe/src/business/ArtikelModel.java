package business;

import java.io.*;
import java.util.ArrayList;

import readers.*;
import writers.*;

public class ArtikelModel {

	private ArrayList<Artikel> artikel = new ArrayList<Artikel>();
	//private int anzahlArtikel;
/*
	public int getAnzahlArtikel() {
		return anzahlArtikel;
	}

	public void setAnzahlArtikel(int anzahlArtikel) {
		this.anzahlArtikel = anzahlArtikel;
	}
*/
	public void leseArtikelAusCsvDatei() throws IOException {
		ReaderCreator readerCreator = new ConcreteCsvReaderCreator();
		ReaderProduct reader = readerCreator.factoryMethod();
		this.artikel = reader.leseArtikel();

	}

	public void schreibeArtikelInTxtDatei() throws IOException {
		WriterCreator writerCreator = new ConcreteWriterCreator();
		WriterProduct writer = writerCreator.factoryMethod("txt");
		writer.schreibeArtikel(this.artikel.size(), this.artikel);
	}

	public void schreibeArtikelInKonsole() throws IOException {
		WriterCreator writerCreator = new ConcreteWriterCreator();
		WriterProduct writer = writerCreator.factoryMethod("konsole");
		writer.schreibeArtikel(this.artikel.size(), this.artikel);
	}

}
