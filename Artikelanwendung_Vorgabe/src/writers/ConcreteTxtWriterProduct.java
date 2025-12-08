package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import business.Artikel;

public class ConcreteTxtWriterProduct extends WriterProduct {

	@Override
	public void schreibeArtikel(int anzahlArtikel, ArrayList<Artikel> artikels) throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("Artikel.txt"));
		aus.write(anzahlArtikel + "");
		aus.newLine();
		for(Artikel artikel : artikels) {
			aus.write(artikel.getArtikelnummer() + "");
			aus.newLine();
			aus.write(artikel.getArtikelname());
			aus.newLine();
			aus.write(artikel.getBasispreis() + "");
			aus.newLine();
		}    
		aus.close();
		
	}

}
