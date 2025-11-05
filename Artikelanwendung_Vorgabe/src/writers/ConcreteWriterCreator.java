package writers;

public class ConcreteWriterCreator extends WriterCreator {



	@Override
	public WriterProduct factoryMethod(String typ) {
		if("txt".equals(typ)){
			return new ConcreteTxtWriterProduct();
			}
			else{
			return new ConcreteKonsoleWriterProduct();
			}
	}

}
