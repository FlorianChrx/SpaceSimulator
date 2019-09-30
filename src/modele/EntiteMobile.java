package modele;

/**
 * @Date 26/09/2019
 * @author lefrancn
 * Class qui hérite de Entité, pour les entités qui se déplace
 */

public abstract class EntiteMobile extends Entite{
	protected Vecteur vitesse;
	protected Trajectoire trajectoire;
	
	public EntiteMobile(Point position, double masse, double rayon, String name,Vecteur vitesse,Trajectoire trajectoire) {
		super(position, masse, rayon, name);
		this.vitesse = vitesse;
		this.trajectoire = trajectoire;
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
