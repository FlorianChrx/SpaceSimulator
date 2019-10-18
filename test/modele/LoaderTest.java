package modele;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import modele.loader.Loader;
import modele.loader.PropertiesException;
import modele.system.SystemeSolaire;

class LoaderTest {

	@Test
	void test() throws IOException, PropertiesException {
		SystemeSolaire ss = Loader.charger();
		assertTrue(ss.getEntityCenter().getName().equals("Soleil"));
		assertEquals(ss.getFa(),1);
		assertEquals(ss.getG(),0.01);
		assertEquals(ss.getRayon(),500);
	}

}
