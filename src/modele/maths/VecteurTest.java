/**
 * 
 */
package modele.maths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author chirauxf
 *
 */
public class VecteurTest {

	/**
	 * Test method for
	 * {@link modele.maths.Vecteur#somme(modele.maths.Vecteur, modele.maths.Vecteur)}.
	 */
	@Test
	public void testSommeVecteurVecteur() {
		for (int i = 0; i < 10000; i++) {
			double xf = Math.random() * 1000;
			double xs = Math.random() * 1000;
			double yf = Math.random() * 1000;
			double ys = Math.random() * 1000;
			Vecteur first = new Vecteur(xf, yf);
			Vecteur second = new Vecteur(xs, ys);
			assertEquals(Vecteur.somme(first, second), new Vecteur(xs + xf, ys + yf));
		}
		assertEquals(Vecteur.somme(new Vecteur(0, 0), new Vecteur(0, 0)), new Vecteur(0, 0));
	}

	/**
	 * Test method for {@link modele.maths.Vecteur#somme(modele.maths.Vecteur[])}.
	 */
	@Test
	public void testSommeVecteurArray() {
		Vecteur[] tab = new Vecteur[10000];
		double xtotal = 0;
		double ytotal = 0;
		for (int i = 0; i < tab.length; i++) {
			double x = Math.random() * 1000;
			double y = Math.random() * 1000;
			tab[i] = new Vecteur(x, y);
			xtotal += x;
			ytotal += y;
		}
		assertEquals(Vecteur.somme(tab), new Vecteur(0 + xtotal, 0 + ytotal));
	}

	/**
	 * Test method for {@link modele.maths.Vecteur#somme(java.util.List)}.
	 */
	@Test
	public void testSommeListOfVecteur() {
		List<Vecteur> list = new ArrayList<Vecteur>();
		double xtotal = 0;
		double ytotal = 0;
		for (int i = 0; i < 10000; i++) {
			double x = Math.random() * 1000;
			double y = Math.random() * 1000;
			list.add(new Vecteur(x, y));
			xtotal += x;
			ytotal += y;
		}
		assertEquals(Vecteur.somme(list), new Vecteur(0 + xtotal, 0 + ytotal));
	}

	/**
	 * Test method for
	 * {@link modele.maths.Vecteur#buildVector(modele.maths.Point, modele.maths.Point)}.
	 */
	@Test
	public void testBuildVector() {
		Point a = new Point(2.5 , 50);
		Point b = new Point(2.5 , 100);
		assertEquals(Vecteur.buildVector(a, b), new Vecteur(0, 50));
		assertEquals(Vecteur.buildVector(b, a), new Vecteur(0, -50));
	}

	/**
	 * Test method for {@link modele.maths.Vecteur#getNorme()}.
	 */
	@Test
	public void testGetNorme() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link modele.maths.Vecteur#changeNorme(double)}.
	 */
	@Test
	public void testChangeNorme() {
		fail("Not yet implemented");
	}

}
