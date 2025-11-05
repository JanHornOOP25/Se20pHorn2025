package readers;

public class ConcreteCsvReaderCreator extends ReaderCreator {

	@Override
	public ReaderProduct factoryMethod() {
		// TODO Auto-generated method stub
		return new ConcreteCsvReaderProduct();
	}

}
