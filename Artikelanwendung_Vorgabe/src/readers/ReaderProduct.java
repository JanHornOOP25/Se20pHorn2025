package readers;

import java.io.IOException;

import business.Artikel;

public abstract class ReaderProduct {
	public abstract int leseAnzahlArtikel() throws IOException;
	public abstract Artikel[] leseArtikel() throws IOException;

}
