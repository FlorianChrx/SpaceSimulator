package modele.maths;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PointTest {
	Point p1, p2, p3, p4;

	@Before 
	public void initialiser() {
		p1 = new Point(0, 0);
		p2 = new Point(1, 2);
		p3 = new Point(2, 2);
		p4 = new Point(3, 3);
	}
	
	@Test
	public void TestDistance() {
		assertEquals(Math.sqrt(5), Point.distance(p1, p2), 0);
		assertEquals(Math.sqrt(5), p1.distance(p2), 0);
		assertEquals(Math.sqrt(2), p3.distance(p4), 0);
	}
	
	@Test
	public void testProduit() {
		//System.out.println("On cherche a avoir 0,0 " + Point.produit(p1, 8).toString());
		//System.out.println("On cherche a avoir 4,4 " + Point.produit(p3, 2));
	}
}
