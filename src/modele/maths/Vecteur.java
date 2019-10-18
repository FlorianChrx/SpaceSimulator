package math;

import java.util.List;

/**
 * 
 * @author chirauf
 * @Date ???
 * 
 */

public class Vecteur {
	protected double vitx; // vecteur en absysse, on suppose qu'on part de 0
	protected double vity; // vecteur en ordonné, on suppose qu'on part de 0

	public Vecteur(double vitx, double vity) {
		super();
		this.vitx = vitx;
		this.vity = vity;
	}

	public double getVitx() {
		return vitx;
	}

	public void setVitx(double vitx) {
		this.vitx = vitx;
	}

	public double getVity() {
		return vity;
	}

	public void setVity(double vity) {
		this.vity = vity;
	}

	public static Vecteur somme(Vecteur v1, Vecteur v2) {
		return new Vecteur(v1.getVitx() + v2.getVitx(), v1.getVity() + v2.getVity());
	}

	public static Vecteur somme(List<Vecteur> vecteurs) {
		Vecteur res = new Vecteur(0, 0);
		for (Vecteur vecteur : vecteurs) {
			res = Vecteur.somme(res, vecteur);
		}
		return res;
	}

	public static Vecteur buildVector(Point p1, Point p2) {
		return new Vecteur(p2.getX() - p1.getX(), p2.getY() - p1.getY());
	}

	public double getNorme() {
		return Math.sqrt(vitx * vitx + vity * vity);
	}

	public Vecteur Produit(double k, Vecteur v) {
		v.setVitx(v.getVitx() * k);
		v.setVity(getVity() * k);
		return v;
	}
	
	public Vecteur Division(double k) {
		this.setVitx(this.getVitx() / k);
		this.setVity(this.getVity() / k);
		return this;
	}

	public void changeNorme(double norme) {
		double ratio = norme / getNorme();
		vitx *= ratio;
		vity *= ratio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(vitx);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vity);
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
		if (Double.doubleToLongBits(vitx) != Double.doubleToLongBits(other.vitx))
			return false;
		if (Double.doubleToLongBits(vity) != Double.doubleToLongBits(other.vity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vecteur [vitx=" + vitx + ", vity=" + vity + "]";
	}
}
