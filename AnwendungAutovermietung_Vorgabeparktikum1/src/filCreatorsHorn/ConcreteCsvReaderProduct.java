package filCreatorsHorn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ConcreteCsvReaderProduct extends ReaderProductHorn {
	private BufferedReader ein;

	public ConcreteCsvReaderProduct() throws IOException {
		this.ein = new BufferedReader(new FileReader("Auto.csv"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		
		String[] zeile = ein.readLine().split(";");
		return zeile;
	}

	@Override
	public void schlisseDatei() throws IOException {
		ein.close();

	}

}
