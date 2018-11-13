import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testUnitaireEntite {
	
	static Entite e1;
	static Entite e2;
	static Entite e3;

	@BeforeEach
	void setUp() throws Exception {
		e2 = new Avatar("E2");
		e3 = new Monstre(1,1,"E3");
	}

	@AfterEach
	void tearDown() throws Exception {
		e2.setX(1);
		e2.setY(1);
		e2.setJ("E2");
	}

	@Test
	void newEntiteName() {
		e1 = new Fantome("E1");
		assertTrue(e1.getJ()=="E1");
	}
	
	@Test
	void newEntiteFull() {
		assertTrue(e3.getX()==1 && e3.getY()==1 && e3.getJ()=="E3");
	}
	
	@Test
	void changeEntiteXPos() {
		e2.setX(12);
		assertTrue(e2.getX()==12 && e2.getY()==1 && e2.getJ()=="E2");
	}
	
	@Test
	void changeEntiteY() {
		e2.setY(34);
		assertTrue(e2.getX()==1 && e2.getY()==34 && e2.getJ()=="E2");
	}
	
	@Test
	void changeEntiteJ() {
		e2.setJ("E2b");
		assertTrue(e2.getX()==1 && e2.getY()==1 && e2.getJ()=="E2b");
	}
	
	@Test
	void entitePDVnonInit() {
		try {
			e3.getPDV();
		}
		catch(Exception e) {
			System.out.println("Impossible d'obtenir les PdV");
		}
	}
	
	@Test
	void entiteChangePDV() {
		e3.setPDV(1203);
		assertTrue(e3.getPDV()==1203);
	}
	
	@Test
	void copyEntite() {
		e3 = e2;
		e2.setJ("E2b");
		assertFalse(e3.getJ()=="E2");
		assertTrue(e3.getJ()=="E2b");
	}
	

}
