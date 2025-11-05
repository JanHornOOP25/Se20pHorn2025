package writers;

import java.io.IOException;

import business.Artikel;

public class ConcreteKonsoleWriterProduct extends WriterProduct {

	@Override
	public void schreibeArtikel(int anzahlArtikel, Artikel[] artikel) throws IOException {
		System.out.println(anzahlArtikel + "");
		for(int i = 0; i < anzahlArtikel; i++) {
			System.out.print(artikel[i].getArtikelnummer() + ",");
			
			System.out.print(artikel[i].getArtikelname()+",");
			
			System.out.println(artikel[i].getBasispreis() + "");
			
		}    
		

	}

}
