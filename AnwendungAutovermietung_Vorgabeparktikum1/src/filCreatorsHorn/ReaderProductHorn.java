package filCreatorsHorn;

import java.io.IOException;

public abstract class ReaderProductHorn {
	
	public abstract String[] leseAusDatei() throws IOException;
	
	public abstract void schlisseDatei() throws IOException;

}
