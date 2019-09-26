package modele;


public abstract class EntiteMobile extends Entite{
	protected double vitx;
	protected double vity;
	protected Trajectoire trajectoire;
	
	
	public EntiteMobile(Point position, double masse, double rayon, String name,double vitx,double vity,Trajectoire trajectoire) {
		super(position, masse, rayon, name);
		this.vitx=vitx;
		this.vity=vity;
		this.trajectoire=trajectoire;
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
	public Trajectoire getTrajectoire() {
		return trajectoire;
	}
	public void setTrajectoire(Trajectoire trajectoire) {
		this.trajectoire = trajectoire;
	}
}
