package business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Autotest {
	private Auto auto;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		auto = new Auto("BO-as-232", "ford", "transit", 88, "20251202-2051204_2051207-20251215".split("_"));
		BooleanSupplier bs = () -> {return auto.getKennzeichen().equals("BO-as-232");};
		assertTrue(bs.getAsBoolean());
	}
	@Test
	void testthrwo() {
		Throwable exc= assertThrows(IllegalArgumentException.class,()->{new Auto("BO-as-232", "ford", "transit", 88, null);});
		//assertEquals("vermietetVonBis darf nicht null sein!",exc.getMessage());
	}

}
