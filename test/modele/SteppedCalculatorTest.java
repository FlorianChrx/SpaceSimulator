package modele;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SteppedCalculatorTest {
	public EntiteMobile v1;
	public Calculator calcul;
	
	@Before
	public void initialisation() {
		Point posInit  = new Point(6, -1);
		Vecteur vitInit = new Vecteur(-4, 2);
		Trajectoire traj = new Trajectoire(1);
		v1 = new Vaisseau(posInit, 2000, 2000, "l'étoile noir", vitInit, traj, 1, 1 );
	}
	
	@Test
	public void testCalculNextStep() {
		fail("Not yet implemented");
	}

	@Test
	public void testAcceleration() {
		fail("Not yet implemented");
	}

	@Test
	public void testForceGravitationnel() {
		fail("Not yet implemented");
	}

	@Test
	public void testeulerExplicite() {
		Point verif = new Point(3, 0);
		calcul.euleurExplicite(0, 5, v1);//plante dans la fonction
		System.out.println(v1.getPosition().getX() + " " + v1.getPosition().getY());
		assertEquals(verif, v1.getPosition()); //vérifie que le premier point 
	}

	@Test
	public void testCalculeTrajectoire() {
		fail("Not yet implemented");
	}

}
