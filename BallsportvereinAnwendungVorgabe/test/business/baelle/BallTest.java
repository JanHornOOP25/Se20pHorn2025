package business.baelle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BallTest {
	
	private Ball b1 ;

	@BeforeEach
	void setUp() throws Exception {
		this.b1=new Ball(0, null, null, null, null, 0);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertTrue(!b1.ueberpruefeSportart(), "Die Metode Funkrionirt nicht");
		b1.setSportart("Fusball");
		assertTrue(b1.ueberpruefeSportart(),()-> "Die Metode Funkrionirt");
	}

}
