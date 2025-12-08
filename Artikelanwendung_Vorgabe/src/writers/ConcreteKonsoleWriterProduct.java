package writers;

import java.io.IOException;
import java.util.ArrayList;

import business.Artikel;


public class ConcreteKonsoleWriterProduct extends WriterProduct {

	@Override
	public void schreibeArtikel(int anzahlArtikel, ArrayList<Artikel> artikels) throws IOException {
		System.out.println(anzahlArtikel + "");
		for(Artikel artikel : artikels) {
			System.out.print(artikel.getArtikelnummer() + ",");
			System.out.print(artikel.getArtikelname()+",");
			System.out.println(artikel.getBasispreis() + "");
			
		}    
		

	}

}
