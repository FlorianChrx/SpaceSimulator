package modele.maths;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author chirauxf Classe permettant de tester la Classe
 *         {@link modele.maths.Vecteur}
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
		Point a = new Point(2.5, 50);
		Point b = new Point(2.5, 100);
		assertEquals(new Vecteur(0, 50), Vecteur.buildVector(a, b));
		assertEquals(new Vecteur(0, -50), Vecteur.buildVector(b, a));
	}

	/**
	 * Test method for {@link modele.maths.Vecteur#getNorme()}.
	 */
	@Test
	public void testGetNorme() {
		assertEquals(50, new Vecteur(0, 50).getNorme(), 50 * 0.001);
		assertEquals(2000, new Vecteur(0, 2000).getNorme(), 2000 * 0.001);
		assertEquals(50.5, new Vecteur(0, 50.5).getNorme(), 50.5 * 0.001);
	}

	/**
	 * Test method for {@link modele.maths.Vecteur#changeNorme(double)}.
	 */
	@Test
	public void testChangeNorme() {
		Vecteur v = new Vecteur(0, 50);
		assertEquals(50, v.getNorme(), 50 * 0.001);
		v.changeNorme(20);
		assertEquals(20, v.getNorme(), 20 * 0.001);
	}

	/**
	 * Test method for
	 * {@link modele.maths.Vecteur#translation(Positionnable, Vecteur)}.
	 */
	@Test
	public void testTranslation() {
		Point p = new Point(0, 0);
		Vecteur v = new Vecteur(5, 5);
		assertEquals(0, 0, 0.001);
		Vecteur.translation(p, v);
		assertEquals(0, 0, 0.001);
	}

}
