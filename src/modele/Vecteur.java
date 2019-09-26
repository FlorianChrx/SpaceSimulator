package modele;

/**
 * @Date 20/09/2019
 * @author lefrancn
 * Class qui h�rite de Entit�, pour les entit�s qui se d�place
 */

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
	
}
