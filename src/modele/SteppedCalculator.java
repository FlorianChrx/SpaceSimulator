package modele;

import java.util.List;

/**
 * @Date 20/09/2019
 * @author carpentm
 * Class intérable 
 */

public class SteppedCalculator implements Calculator {
	//Les attributs
	protected final double G = 6.67408 * Math.pow(10, -10);//Constante gravitationnelle en m3.kg^-1.s^-1;

	//Les m�thodes
	
	/**
	 * Bonne question
	 */
	public void CalculNextStep(List<EntiteMobile> entities) {
		/*
		for (EntiteMobile entiteMobile : entities) {
			double x = entiteMobile.getTrajectoire().getPoint(idxStep).getX() + entiteMobile.getTrajectoire().getVitX(idxStep)/entiteMobile.getTrajectoire().getPas();
			double y = entiteMobile.getTrajectoire().getPoint(idxStep).getY() + entiteMobile.getTrajectoire().getVitY(idxStep)/entiteMobile.getTrajectoire().getPas();
			
			Point nouvePoint = new Point(x, y);
			Vecteur nouveVecteur = new Vecteur(0,0);
			entiteMobile.getTrajectoire().addLocalisation(nouvePoint);
			entiteMobile.getTrajectoire().addVector(nouveVecteur);
		}	
		*/
	}
	
	public double Acceleration() {
		return 0;
	}
	
	/**
	 * Permet de calculer la force gravitationnelle
	 * @param vaisseau
	 * @param entite
	 * @return la force gravitationnelle
	 * O� l'utiliser dans les calcules ?
	 */
	public double ForceGravitationnel(EntiteMobile mobile, Entite entite) {
		double distance = mobile.getPoint().distance(entite.getPoint());
		//v�rifier sion laisse le -
		return this.G * (( entite.masse * mobile.masse ) / Math.pow(distance, 2));
	}
	
	//Attention il ne fait que calculer une trajectoire approximative en fonction des coordonn� de d�part
	//Voir si ont doit faire les tangentes au vecteurs pour faire la direction
	//met a jour la vitesse du vaisseau et ses coordonn�
	//Permet "d'avoir" et de mettre a jour point et vitesse suivante pour le vaisseau mais ne prend pas en compte les autres astres du systeme ni la force gravitationelle(evident ?)
	//Pour simplifier le code et avancer pour l'instant la vitesse seras une constante
	public void euleurExplicite(double tDebut, double tFin, EntiteMobile mobile) {
		
		double nouvoPointX = mobile.getVitesse().getVitx() + mobile.getPoint().getX();
		double nouvoPointY = mobile.getVitesse().getVity() + mobile.getPoint().getY();
		Point nouvoPoint = new Point(nouvoPointX, nouvoPointY);
		mobile.setPoint(nouvoPoint);
		mobile.getTrajectoire().localisations.add(nouvoPoint);
		
		mobile.getTrajectoire().addVector(mobile.getVitesse());
	}
	
	//Permet d'avoir le chemin pr�s calculer
	//Pour simplifier le code et avancer pour l'instant la vitesse seras une constante
	public void CalculeTrajectoire(double tDebut, double tFin, EntiteMobile mobile) {
		double t = tDebut;
		for(int i = 1; i < (int)tFin+1; i ++) {
			t += mobile.getTrajectoire().getPas();
			
			double point1 = mobile.getTrajectoire().getVecteur(i-1).getVitx() + mobile.getTrajectoire().getPoint(i-1).getX();
			double point2 = mobile.getTrajectoire().getVecteur(i-1).getVity() + mobile.getTrajectoire().getPoint(i-1).getY();
			Point point = new Point(point1, point2);
			mobile.getTrajectoire().localisations.add(point);
			
			mobile.getTrajectoire().vecteurs.add(mobile.getVitesse());
			//traj.trajectoire.add(vaisseau.getVitesse().calculeDuVecteur(t)); Si la vitesse n'est plus une constante d�commenter
		}
	}
	
	
	
	
	
	
	
	
	
	
}
