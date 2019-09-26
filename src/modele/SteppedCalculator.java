package modele;

import java.util.List;

/**
 * @Date 20/09/2019
 * @author carpentm
 * Class intérable 
 */

public class SteppedCalculator implements Calculator {
	//Les attributs
	protected final double G = 6.6742 * Math.pow(10, -10);//Constante gravitationnelle en m3.kg^-1.s^-1;
	/**
	 * Indice de la step en cours de calcul
	 */
	protected int idxStep;
	

	//Les méthodes
	
	/**
	 * Permet de calculer le prochain point et de l'ajouter a la liste des points sur la trajectoire
	 */
	public void CalculNextStep(List<EntiteMobile> entities) {
		for (EntiteMobile entiteMobile : entities) {
			double x = entiteMobile.getTrajectoire().getPoint(idxStep).getX() + entiteMobile.getTrajectoire().getVitX(idxStep)/entiteMobile.getTrajectoire().getPas();
			double y = entiteMobile.getTrajectoire().getPoint(idxStep).getY() + entiteMobile.getTrajectoire().getVitY(idxStep)/entiteMobile.getTrajectoire().getPas();
			
			Point nouvePoint = new Point(x, y);
			Vecteur nouveVecteur = new Vecteur(0,0);
			entiteMobile.getTrajectoire().addLocalisation(nouvePoint);
			entiteMobile.getTrajectoire().addVector(nouveVecteur);
		}	
	}
	
	public double VitesseXVaisseau() {
		return 0;
	}
	
	public double VitesseYVaisseaux() {
		return 0;
	}
	
	public double Acceleration() {
		return 0;
	}
	
	public double ForceGravitationnel(Entite e1, Entite e2) {
		double distance = e1.getPoint().distance(e2.getPoint());
		//Vecteur vecteur = new Vecteur(e1.getPoint().getX(), e2.getPoint().getX());
		
		return -this.G * ((e1.masse * e2.masse) / Math.pow(distance, 2));
		
	}
	
	public void euleurExplicite() {
		
	}
	
	public void CalculeTrajectoire() {
		
	}
	
	
	
	
	
	
	
	
	
	
}
