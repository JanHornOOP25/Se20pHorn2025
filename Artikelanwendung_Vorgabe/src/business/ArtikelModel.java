package business;

import java.io.*;

import readers.*;
import writers.*;

public class ArtikelModel {

	private Artikel[] artikel = new Artikel[100];
	private int anzahlArtikel;

	public int getAnzahlArtikel() {
		return anzahlArtikel;
	}

	public void setAnzahlArtikel(int anzahlArtikel) {
		this.anzahlArtikel = anzahlArtikel;
	}

	public void leseArtikelAusCsvDatei() throws IOException {
		ReaderCreator readerCreator = new ConcreteCsvReaderCreator();
		ReaderProduct reader = readerCreator.factoryMethod();
		this.setAnzahlArtikel(reader.leseAnzahlArtikel());
		this.artikel = reader.leseArtikel();

	}

	public void schreibeArtikelInTxtDatei() throws IOException {
		WriterCreator writerCreator = new ConcreteWriterCreator();
		WriterProduct writer = writerCreator.factoryMethod("txt");
		writer.schreibeArtikel(this.getAnzahlArtikel(), this.artikel);
	}

	public void schreibeArtikelInKonsole() throws IOException {
		WriterCreator writerCreator = new ConcreteWriterCreator();
		WriterProduct writer = writerCreator.factoryMethod("konsole");
		writer.schreibeArtikel(this.getAnzahlArtikel(), this.artikel);
	}

}
