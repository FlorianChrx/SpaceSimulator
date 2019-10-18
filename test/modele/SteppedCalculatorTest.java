package modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class SteppedCalculatorTest {
	public EntiteMobile v1;
	public Entite centre;
	public Calculator calcul;
	
	@Before
	public void initialisation() {
		calcul = new SteppedCalculator();
		Point posInit  = new Point(0, 0);
		centre = new Etoile(posInit, 1.989 * Math.pow(10, 30), 695510, "l'étoile noir");
		v1 = new Planete(new Point(0, 149.6 * 1000000 * 1000), 5.972 * Math.pow(10, 24), 0, "Terre", new Vecteur(5, 7), new Trajectoire(1));
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
	
	@Test
	public void testForceBetween() {
		Vecteur force = calcul.forceBetween(centre, v1);
		System.out.println(force.toString());
		System.out.println(new Vecteur(0, 3.542279 * Math.pow(10, 22)));
		Vecteur base = new Vecteur(0, 3.542279 * Math.pow(10, 23));
		assertEquals(base.vitx, force.vitx, 0.001 * base.vitx);
		assertEquals(base.vity, force.vity, 0.001 * base.vity);
		force = calcul.forceBetween(v1, centre);
		base = new Vecteur(0, - 3.542279 * Math.pow(10, 23));
		assertEquals(base.vitx, force.vitx, 0.001 * base.vitx);
		assertEquals(base.vity, force.vity, Math.abs(0.001 * base.vity));
}

}
