package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Artikeltest {
	
	private Artikel a1;

	@BeforeEach
	void setUp() throws Exception {
		this.a1 = new Artikel(0, null, 100.00);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void nullTest() {
		try {
			this.a1.berechnePreisJeArtikel(-1);
			fail("keine exaetio ngeworfe");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
	void für250Test() {
		Artikel a1 = new Artikel(0, null, 100);
		double ausgerchenetwerte = a1.berechnePreisJeArtikel(500);
		System.out.print(ausgerchenetwerte);
	}

}
