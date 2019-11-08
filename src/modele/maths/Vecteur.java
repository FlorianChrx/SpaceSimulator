package modele.maths;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author chirauf
 * @Date ???
 * 
 */

public class Vecteur extends Point {

	public Vecteur(double x, double y) {
		super(x, y);
	}

	public static Vecteur somme(Vecteur v1, Vecteur v2) {
		return new Vecteur(v1.getX() + v2.getX(), v1.getY() + v2.getY());
	}

	public static Vecteur somme(List<Vecteur> vecteurs) {
		Vecteur res = new Vecteur(0, 0);
		for (Vecteur vecteur : vecteurs) {
			res = Vecteur.somme(res, vecteur);
		}
		return res;
	}

	public static Vecteur buildVector(Positionnable p1, Positionnable p2) {
		return new Vecteur(p2.getX() - p1.getX(), p2.getY() - p1.getY());
	}

	public double getNorme() {
		return Math.sqrt(x * x + y * y);
	}

	public Vecteur Produit(double k, Vecteur v) {
		v.setX(v.getX() * k);
		v.setY(getY() * k);
		return v;
	}

	public Vecteur Division(double k) {
		this.setX(this.getX() / k);
		this.setY(this.getY() / k);
		return this;
	}

	public void changeNorme(double norme) {
		if (getNorme() == 0)
			return;
		double ratio = norme / getNorme();
		x *= ratio;
		y *= ratio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vecteur other = (Vecteur) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vecteur [vitx=" + x + ", vity=" + y + "]";
	}

	public static Vecteur somme(Vecteur... vecteurs) {
		return somme(Arrays.asList(vecteurs));
	}

	public static void translation(Positionnable p, Vecteur v) {
		p.setX(p.getX() + v.getX());
		p.setY(p.getY() + v.getY());
		;
	}

}
