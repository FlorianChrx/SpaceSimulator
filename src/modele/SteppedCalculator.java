package modele;

import java.util.List;

/**
 * @Date 20/09/2019
 * @author carpentm
 * Class intÃ©rable 
 */

public class SteppedCalculator implements Calculator {
	//Les attributs
	protected final double G = 6.67408 * Math.pow(10, -10);//Constante gravitationnelle en m3.kg^-1.s^-1;

	//Les méthodes
	
	/**
	 * Bonne question
	 */
	public void CalculNextStep(List<EntiteMobile> entities) {
		/*
		for (EntiteMobile entiteMobile : entities) {
			double x = entiteMobile.getTrajectoire().getPoint(idxStep).getX() + entiteMobile.getTrajectoire().getVitX(idxStep)/entiteMobile.getTrajectoire().getPas();
			double y = entiteMobile.getTrajectoire().getPoint(idxStep).getY() + entiteMobile.getTrajectoire().getVitY(idxStep)/entiteMobile.getTrajectoire().getPas();
			
			Point nouvePoint = new Point(x, y);
			entiteMobile.getTrajectoire().addLocalisation(nouvePoint);
			entiteMobile.getTrajectoire().addVitX(0.00);
			entiteMobile.getTrajectoire().addVitY(0.00);
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
	 * Où l'utiliser dans les calcules ?
	 */
	public double ForceGravitationnel(Vaisseau vaisseau, Entite entite) {
		double distance = vaisseau.getPoint().distance(entite.getPoint());
		//vérifier sion laisse le -
		return (this.G * (( entite.masse * vaisseau.masse ) / Math.pow(distance, 2)));
	}
	
	//Attention il ne fait que calculer une trajectoire approximative en fonction des coordonné de départ
	//Voir si ont doit faire les tangentes au vecteurs pour faire la direction
	//met a jour la vitesse du vaisseau et ses coordonné
	//Permet "d'avoir" et de mettre a jour point et vitesse suivante pour le vaisseau mais ne prend pas en compte les autres astres du systeme ni la force gravitationelle(evident ?)
	//Pour simplifier le code et avancer pour l'instant la vitesse seras une constante
	public void euleurExplicite(double tDebut, double tFin, Vaisseau vaisseau, Trajectoire traj) {
		
		double nouvoPointX = vaisseau.getVitesse().getVitx() + vaisseau.getPoint().getX();
		double nouvoPointY = vaisseau.getVitesse().getVity() + vaisseau.getPoint().getY();
		Point nouvoPoint = new Point(nouvoPointX, nouvoPointY);
		vaisseau.setPoint(nouvoPoint);
		traj.localisations.add(nouvoPoint);
		
		traj.trajectoire.add(vaisseau.getVitesse());
	}
	
	//Permet d'avoir le chemin prés calculer
	//Pour simplifier le code et avancer pour l'instant la vitesse seras une constante
	public void CalculeTrajectoire(double tDebut, double tFin, Vaisseau vaisseau, Trajectoire traj) {
		double t = tDebut;
		for(int i = 1; i < (int)tFin+1; i ++) {
			t += traj.getPas();
			
			double pointX = traj.localisationsPrevision.get(i - 1).getX() + traj.trajectoirePrevision.get(i - 1).getVitx();
			double pointY = traj.localisationsPrevision.get(i - 1).getY() + traj.trajectoirePrevision.get(i - 1).getVity();
			Point point = new Point(pointX, pointY);
			traj.localisationsPrevision.add(point);
			
			traj.trajectoirePrevision.add(vaisseau.getVitesse());
			//traj.trajectoire.add(vaisseau.getVitesse().calculeDuVecteur(t)); Si la vitesse n'est plus une constante décommenter
		}
	}
	
	
	
	
	
	
	
	
	
	
}
