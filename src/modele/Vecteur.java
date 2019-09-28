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
	
}
