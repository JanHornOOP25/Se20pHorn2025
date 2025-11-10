package filCreatorsHorn;

import java.io.IOException;

public class ConcreteReaderCreator extends ReaderCreatorHorn {

	@Override
	public ReaderProductHorn factoryMethod(String typ) throws IOException {
		if ("csv".equals(typ)) {
			return new ConcreteCsvReaderProduct();
		}else {
			return new ConcreteTxtReaderProduct();
		}
	}

}
