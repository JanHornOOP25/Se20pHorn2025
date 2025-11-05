package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Artikel;

public class ConcreteTxtWriterProduct extends WriterProduct {

	@Override
	public void schreibeArtikel(int anzahlArtikel, Artikel[] artikel) throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("Artikel.txt"));
		aus.write(anzahlArtikel + "");
		aus.newLine();
		for(int i = 0; i < anzahlArtikel; i++) {
			aus.write(artikel[i].getArtikelnummer() + "");
			aus.newLine();
			aus.write(artikel[i].getArtikelname());
			aus.newLine();
			aus.write(artikel[i].getBasispreis() + "");
			aus.newLine();
		}    
		aus.close();
		
	}

}
