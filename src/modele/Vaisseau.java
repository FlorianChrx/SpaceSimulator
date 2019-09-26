package modele;

import javafx.geometry.Point2D;

public class Vaisseau extends EntiteMobile {
	protected double pPrincipale;
	protected double pRetro;
	
	
	public Vaisseau(Point2D position, double masse, double rayon, String name, double vitx, double vity,
			Trajectoire trajectoire,double pPrincipale,double pRetro) {
		super(position, masse, rayon, name, vitx, vity, trajectoire);
		this.pPrincipale=pPrincipale;
		this.pRetro=pRetro;
	}


	public double getpPrincipale() {
		return pPrincipale;
	}


	public void setpPrincipale(double pPrincipale) {
		this.pPrincipale = pPrincipale;
	}


	public double getpRetro() {
		return pRetro;
	}


	public void setpRetro(double pRetro) {
		this.pRetro = pRetro;
	}
	

}
