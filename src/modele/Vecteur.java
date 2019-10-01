package modele;

import java.util.Arrays;
import java.util.List;

/**
 * @Date 20/09/2019
 * @author lefrancn
 * Class qui h�rite de Entit�, pour les entit�s qui se d�place
 */

public class Vecteur {
	protected double vectx;
	protected double vecty;
	
	public Vecteur(double vitx, double vity) {
		super();
		this.vectx = vitx;
		this.vecty = vity;
	}
	
	public double getVitx() {
		return vectx;
	}
	
	public void setVitx(double vitx) {
		this.vectx = vitx;
	}
	
	public double getVity() {
		return vecty;
	}
	
	public void setVity(double vity) {
		this.vecty = vity;
	}
	
	//Si jamais on decide d'avoir une vitesse variable
	public Vecteur calculeDuVecteur(double valeur) {
		return this;
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
