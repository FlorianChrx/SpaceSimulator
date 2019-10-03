package modele;

import java.util.Arrays;
import java.util.List;

public class Vecteur {
	protected double vitx;
	protected double vity;
	
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
		return new Vecteur(v1.getVitx()+v2.getVitx(), v1.getVity()+v2.getVity());
	}
	
	public static Vecteur somme(Vecteur...vecteurs) {
		return somme(Arrays.asList(vecteurs));
	}
	
	public static Vecteur somme(List<Vecteur> vecteurs) {
		Vecteur res = new Vecteur(0,0);
		for (Vecteur vecteur : vecteurs) {
			res = Vecteur.somme(res, vecteur);
		}
		return res;
	}
	
	public static Vecteur buildVector(Point p1, Point p2) {
		return new Vecteur(p2.getX()-p1.getX(), p2.getY()-p1.getY());
	}
	
	public double getNorme() {
		return Math.sqrt(vitx*vitx+vity*vity);
	}

	public void changeNorme(double norme) {
		double ratio = norme / getNorme();
		vitx *= ratio;
		vity *= ratio;
	}
	
}
