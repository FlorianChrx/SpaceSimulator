package modéle;

import java.util.List;

/**
 * @Date 20/09/2019
 * @author carpentm
 * Class qui est implementé par SteppedCalculator
 */

public class SteppedCalculator implements Calculator {
	//Les attributs
	protected final double G = 6.67408 * Math.pow(10, -10);//Constante gravitationnelle en m3.kg^-1.s^-1;
	protected Vecteur acceleration = new Vecteur(0, 0);
	
	//Le constructeur
	public SteppedCalculator(Vaisseau v) {
		this.acceleration = new Vecteur (v.getpPrincipale(), v.getpRetro());
	}

	//Les m�thodes
	
	/**
	 * Bonne question
	 */
	public void CalculNextStep(List<EntiteMobile> entities) {
		
	}
	
	public Vecteur calculeAcceleration(Vaisseau mobile, List<Entite> entites, Entite entiteSelected) {
		Vecteur numerateur = this.vecteurUnitaire(mobile, entites.get(0));
		Vecteur denominateur = this.acceleration;
		
		for (int i = 1 ; i < entites.size() ; i++) {
			Vecteur v = this.vecteurUnitaire(mobile, entites.get(i));
			numerateur = Vecteur.somme(numerateur, v);
			denominateur.setVitx(denominateur.getVitx() + entites.get(i).getMasse());
			denominateur.setVity(denominateur.getVity() + entites.get(i).getMasse());
		}
		
		 acceleration.setVitx(numerateur.getVitx() / denominateur.getVitx());
		 acceleration.setVity(numerateur.getVity() / denominateur.getVity());
		
		return this.acceleration;
	}
	
	/*
	 * Formule V = racine((vitesse initial)² + (2 * distance * acceleration) )
	 */
	public double calculeVitesse() {
		
		return 0;
		
	}
	
	public Vecteur vecteurUnitaire(Entite mobile, Entite entite) {
		Vecteur unitaire = Vecteur.buildVector(mobile.getPosition(), entite.getPosition());
		double distance = unitaire.getNorme();
		unitaire.setVitx(unitaire.getVitx() * distance);
		unitaire.setVity(unitaire.getVity() * distance);

		return unitaire;
	}
	
	/**
	 * Permet de calculer la force gravitationnelle
	 * @param vaisseau
	 * @param entite
	 * @return la force gravitationnelle
	 */
	public double normeForceGravitationnel(Entite mobile, Entite entite) {
		double distance = mobile.getPoint().distance(entite.getPoint());
		if (this.vecteurUnitaire(mobile, entite).getVitx() >= 0 || this.vecteurUnitaire(mobile, entite).getVity() >= 0) {
			return this.G * (( mobile.masse * entite.masse ) / Math.pow(distance, 2));
		}else {
			return - this.G * (( mobile.masse * entite.masse ) / Math.pow(distance, 2));
		}
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
	public void euleurExplicite(EntiteMobile mobile) {
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
		}
	}
	
	
	
	
	
	
}
