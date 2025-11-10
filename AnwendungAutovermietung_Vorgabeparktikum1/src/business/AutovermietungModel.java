package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import filCreatorsHorn.*;

public class AutovermietungModel {
	private Auto auto;

	public void autonehmeAutoAuf(String text, String text2, String text3, float float1, String[] split) {
		auto = new Auto(text, text2, text3, float1, split);

	}

	public String gibAutoZurueck(char c) {
		// TODO Auto-generated method stub
		return auto.gibAutoZurueck(c);
	}

	public Object getAuto() {
		// TODO Auto-generated method stub
		return auto;
	}

	public void lesAusDatei(String typ) throws IOException {
		ReaderCreatorHorn readercreator= new ConcreteReaderCreator();
		ReaderProductHorn reader = readercreator.factoryMethod(typ);
		String[] zeile = reader.leseAusDatei(); 
		this.auto = new Auto(zeile[0], zeile[1], zeile[2], Float.parseFloat(zeile[3]), zeile[4].split("_"));
		reader.schlisseDatei();

	}

	public void schreibeAutoInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("AutosAusgabe.csv", true));
		aus.write(auto.gibAutoZurueck(';'));
		aus.close();
	}



}
