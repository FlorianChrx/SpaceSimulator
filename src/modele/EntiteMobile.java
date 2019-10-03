package modele;

/**
 * @Date 26/09/2019
 * @author lefrancn
 * Class qui h�rite de Entit�, pour les entit�s qui se d�place
 */

public abstract class EntiteMobile extends Entite{
	protected Vecteur vitesse;
	protected Trajectoire trajectoire;
	
	public EntiteMobile(Point position, double masse, double rayon, String name,Vecteur vitesse,Trajectoire trajectoire) {
		super(position, masse, rayon, name);
		this.vitesse = vitesse;
		this.trajectoire = trajectoire;
		this.trajectoire.addLocalisation(position);
		this.trajectoire.addVector(vitesse);
	}
	
	public Trajectoire getTrajectoire() {
		return trajectoire;
	}
	
	public void setTrajectoire(Trajectoire trajectoire) {
		this.trajectoire = trajectoire;
	}

	public Vecteur getVitesse() {
		return vitesse;
	}

	public void setVitesse(Vecteur vitesse) {
		this.vitesse = vitesse;
	}
	
	
}
