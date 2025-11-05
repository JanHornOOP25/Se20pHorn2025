package writers;

import java.io.IOException;

import business.Artikel;

public abstract class WriterProduct {
	public abstract void schreibeArtikel(int anzahlArtikel, Artikel[] artikel) throws IOException;

}
