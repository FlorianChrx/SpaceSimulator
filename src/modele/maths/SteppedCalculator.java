package math;

import system.EntiteMobile;
import system.SystemeSolaire;

/**
 * @Date 20/09/2019
 * @author carpentm Class qui est implementé par SteppedCalculator
 */
public class SteppedCalculator implements Calculator {
	// Les attributs
	protected double g;
	protected Vecteur acceleration;

	// Les constructeurs(ATTENTION certains sont a supprimer )
	public SteppedCalculator(double g, Vecteur a) {
		this.g = g;
		this.acceleration = a;
	}

	public SteppedCalculator(double g, SystemeSolaire s) {
		this(g, new Vecteur(s.getVaisseau().getpPrincipale(), s.getVaisseau().getpRetro()));
	}

	public SteppedCalculator(SystemeSolaire s) {
		this(6.67408 * Math.pow(10, -10), s);
	}

	public SteppedCalculator() {
		this(6.67408 * Math.pow(10, -10), new Vecteur(0, 0));
	}

	// Les fonctions
	@Override
	public void CalculNextStep(SystemeSolaire sys, EntiteMobile selectione) {
		this.EulerExplicite(sys, selectione);
	}

	/**
	 * 
	 * @param s, represente le systeme solaire dans lequelle ont travaille
	 * @return le vecteur unitaire Permet de calculer le vecteur unitaire qui est
	 *         sous la forme (vecteurAB/norme ou distance AB)
	 */
	public Vecteur CalculeVecteurUnitaire(SystemeSolaire s, EntiteMobile selectionne) {
		Vecteur numerateur = new Vecteur(0, 0);
		double denominateur = 0;

		for (int i = 0; i < s.getEntityList().size(); i++) {
			if (s.getEntityList().get(i).equals(selectionne)) {
				i++;
			}
			numerateur = Vecteur.buildVector(s.getEntityList().get(i).getPosition(), selectionne.getPosition());
			double x = selectionne.getPositionX() - s.getEntityList().get(i).getPositionX();
			double y = selectionne.getPostionY() - s.getEntityList().get(i).getPostionY();
			denominateur = Math.sqrt(Math.pow(x, 2)) + Math.sqrt(Math.pow(y, 2));
		}
		return numerateur.Division(denominateur);
	}

	/**
	 * 
	 * @param s, represente le systeme solaire dans lequelle ont travaille
	 * @return la force gravitationnelle entre deux corps celestes Le calcule est
	 */
	public double NormeForceGravitationnelle(SystemeSolaire s, EntiteMobile selectionne) {
		double distance = 0;
		double masse = 0;
		for (int i = 0; i < s.getEntityList().size(); i++) {
			distance = s.getEntityList().get(i).getPosition().distance(selectionne.getPosition());
			masse += selectionne.getMasse() * s.getEntityList().get(i).getMasse();
		}

		if (this.CalculeVecteurUnitaire(s, selectionne).getVitx() >= 0
				&& this.CalculeVecteurUnitaire(s, selectionne).getVity() >= 0) {
			return this.g * (masse / (Math.pow(distance, 2)));
		} else {
			return -this.g * (masse / (Math.pow(distance, 2)));
		}
	}

	/**
	 * 
	 * @param s, represente le systeme solaire dans lequelle ont travaille
	 * @return le vecteur acceleration de ce systeme solaire a un point précis Le
	 *         calcule est (sommes des force / masse de lui meme)
	 */
	public Vecteur CalculAcceleration(SystemeSolaire s, EntiteMobile selectionne) {
		this.acceleration.setVitx(
				this.acceleration.getVitx() + this.NormeForceGravitationnelle(s, selectionne) / selectionne.getMasse());
		this.acceleration.setVity(
				this.acceleration.getVity() + this.NormeForceGravitationnelle(s, selectionne) / selectionne.getMasse());
		return this.acceleration;
	}

	/**
	 * 
	 * @param s, represente le systeme solaire dans lequelle ont travaille Permet de
	 *        caculer le point suivant a l'aide d'euler explicite soit jfeg
	 */
	public void EulerExplicite(SystemeSolaire s, EntiteMobile selectionne) {
		double nouvPointX = selectionne.getVitesseX() + selectionne.getPositionX();
		double nouvPointY = selectionne.getVitesseY() + selectionne.getPostionY();
		Point nouvPoint = new Point(nouvPointX, nouvPointY);

		selectionne.getTrajectoire().addLocalisation(nouvPoint);

		this.CalculAcceleration(s, selectionne);
		double nouvVitX = selectionne.getVitesseX()
				+ this.acceleration.getVitx() * selectionne.getTrajectoire().getDeltaT();
		double nouvVitY = selectionne.getVitesseY()
				+ this.acceleration.getVity() * selectionne.getTrajectoire().getDeltaT();

		Vecteur nouvVecteur = new Vecteur(nouvVitX, nouvVitY);
		selectionne.setPosition(nouvPoint);
		selectionne.setVitesse(nouvVecteur);
		selectionne.getTrajectoire().addVector(nouvVecteur);
	}

	/**
	 * 
	 * @param s, represente le systeme solaire dans lequelle ont travaille Permet de
	 *        prés calculer la trajectoire en fesant euler explicite en boucle mais
	 *        ne peut donc pas prendre en compte un changement brusque
	 */
	public void CalculePreTrajectoire(SystemeSolaire s, EntiteMobile selectionne) {
		while (true) {
			this.EulerExplicite(s, selectionne);
		}
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

}
