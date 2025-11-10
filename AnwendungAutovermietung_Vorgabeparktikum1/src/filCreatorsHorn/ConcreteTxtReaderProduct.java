package filCreatorsHorn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteTxtReaderProduct extends ReaderProductHorn {

	private BufferedReader ein;

	public ConcreteTxtReaderProduct() throws IOException {
		this.ein = new BufferedReader(new FileReader("Auto.txt"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[] ergbniszeile = new String[5];
		String zeile = ein.readLine();
		for (int i = 0 ;i<ergbniszeile.length;i++) {
			ergbniszeile[i]= zeile;
			zeile = ein.readLine();
		}
		return ergbniszeile;
		
	}

	@Override
	public void schlisseDatei() throws IOException {
		ein.close();

	}

}
