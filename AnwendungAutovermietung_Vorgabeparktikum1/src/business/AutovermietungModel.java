package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

	public void lesAusDatei() throws IOException {
		BufferedReader ein = new BufferedReader(new FileReader("Auto.csv"));
		String[] zeile = ein.readLine().split(";");
		this.auto = new Auto(zeile[0], zeile[1], zeile[2], Float.parseFloat(zeile[3]), zeile[4].split("_"));
		ein.close();

	}

	public void schreibeAutoInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("AutosAusgabe.csv", true));
		aus.write(auto.gibAutoZurueck(';'));
		aus.close();
	}

}
