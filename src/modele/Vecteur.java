package modele;

/**
 * @Date 20/09/2019
 * @author lefrancn
 * Class qui hérite de Entité, pour les entités qui se déplace
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
	
}
