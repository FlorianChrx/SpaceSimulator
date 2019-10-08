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
	
	public Vecteur Acceleration() {
		return new Vecteur(0, 0);
	}
	
	public Vecteur vitesse(EntiteMobile e) {
		Vecteur vec = new Vecteur(e.getTrajectoire().getLastVecteur().vitx, e.getTrajectoire().getLastVecteur().vitx);
		//0.01 = valeur de la pousée du vaisseau
		vec.changeNorme(vec.getNorme()+0.01);
		return Vecteur.somme(Acceleration(), vec);
	}
	
	/**
	 * Permet de calculer la force gravitationnelle
	 * @param vaisseau
	 * @param entite
	 * @return la force gravitationnelle
	 * O� l'utiliser dans les calcules ?
	 */
	public double normeForceGravitationnel(Entite mobile, Entite entite) {
		double distance = mobile.getPoint().distance(entite.getPoint());
		//v�rifier sion laisse le -
		return this.G * (( entite.masse * mobile.masse ) / Math.pow(distance, 2));
	}
	
	public Vecteur forceBetween(Entite mobile, Entite entite) {
		Vecteur vector = Vecteur.buildVector(mobile.getPosition(), entite.getPosition());
		vector.changeNorme(normeForceGravitationnel(mobile, entite));
		return vector;
	}
	
	public Vecteur forceSystem(List<Entite> entites, Entite entiteSelected) {
		Vecteur res = new Vecteur(0, 0);
		for (Entite entite : entites) {
			if(!entite.equals(entiteSelected)) {
				res = Vecteur.somme(res, forceBetween(entite, entiteSelected));
			};
		}
		return res;
	}
	
	//Attention il ne fait que calculer une trajectoire approximative en fonction des coordonn� de d�part
	//met a jour la vitesse du vaisseau et ses coordonn�
	//Permet "d'avoir" et de mettre a jour point et vitesse suivante pour le vaisseau mais ne prend pas en compte les autres astres du systeme ni la force gravitationelle(evident ?)
	//Pour simplifier le code et avancer pour l'instant la vitesse seras une constante
	public void euleurExplicite(double tDebut, double tFin, EntiteMobile mobile) {
		System.out.println("test1");
		double nouvoPointX = mobile.getVitesse().getVitx() + mobile.getPoint().getX();
		double nouvoPointY = mobile.getVitesse().getVity() + mobile.getPoint().getY();
		System.out.println("test 2");
		Point nouvoPoint = new Point(nouvoPointX, nouvoPointY);
		mobile.setPoint(nouvoPoint);
		System.out.println(mobile.getPosition().getX() + "  " + mobile.getPosition().getY());
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
