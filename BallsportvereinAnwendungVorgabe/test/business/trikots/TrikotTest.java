package business.trikots;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TrikotTest {
	

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void Trikotnummertest() {
		Trikot t1=new Trikot(9, 52, 50.00, 2508);
		assertTrue(()->t1.getTrikotnummer()==9,"trikonummer ist richtig");
	}
	@Test
	void Grösetest() {
		Trikot t1=new Trikot(9, 52, 50.00, 2508);
		assertTrue(()->t1.getGroesse()==52,"Größe ist richtig");
	}
	@Test
	void newillgelagumtTriko() {
		Throwable ex = assertThrows(IllegalArgumentException.class,()->{new Trikot(-9, 52, 50.00, 2508);} );
		assertEquals("Nummer darf nicht kleiner al 0 sein", ex.getMessage());
	}

}
