package modele.maths;

import java.util.ArrayList;
import java.util.List;

import modele.system.Entite;
import modele.system.EntiteMobile;
import modele.system.SystemeSolaire;

/**
 * @Date 20/09/2019
 * @author carpentm Class qui est implementé par SteppedCalculator
 */
public class SteppedCalculator implements Calculator {
	// Les attributs
	protected double g;
	protected Vecteur acceleration;

	// Les constructeurs(ATTENTION certains sont a supprimer )
	public SteppedCalculator(double g) {
		this.g = g;
		this.acceleration = new Vecteur(0, 0);
	}

	public SteppedCalculator() {
		this(6.67408 * Math.pow(10, -10));
	}

	/**
	 * 
	 * @param s, represente le systeme solaire dans lequelle ont travaille
	 * @return le vecteur unitaire Permet de calculer le vecteur unitaire qui est
	 *         sous la forme (vecteurAB/norme ou distance AB)
	 */
	public Vecteur CalculeVecteurUnitaire(Entite e1, Entite e2) {
		Vecteur unit = Vecteur.buildVector(e1.getPosition(), e2.getPosition());
		unit.changeNorme(1);
		return unit;
	}

	/**
	 * 
	 * @param s, represente le systeme solaire dans lequelle ont travaille
	 * @return la force gravitationnelle entre deux corps celestes Le calcule est
	 */
	public double NormeForceGravitationnelle(Entite e1, Entite e2) {
		double distance = 0;
		double masse = 0;
		distance = e1.getPosition().distance(e2.getPosition());
		masse = e1.getMasse() * e2.getMasse();

		return this.g * (masse / (Math.pow(distance, 2)));
	}

	/**
	 * 
	 * @param s, represente le systeme solaire dans lequelle ont travaille
	 * @return le vecteur acceleration de ce systeme solaire a un point précis Le
	 *         calcule est (sommes des force / masse de lui meme)
	 */
	public Vecteur CalculAcceleration(SystemeSolaire s, EntiteMobile e) {
		List<Vecteur> vecteurs = new ArrayList<Vecteur>();
		for (Entite ent : s.getEntityList()) {
			Vecteur v = this.CalculeVecteurUnitaire(e, ent);
			v.changeNorme(this.NormeForceGravitationnelle(e, ent));
			vecteurs.add(v);
		}
		Vecteur sommeForce = Vecteur.somme(vecteurs);
		sommeForce.changeNorme(sommeForce.getNorme() / e.getMasse());
		// System.out.println("Accélération :" + this.acceleration.toString() + "\n");

		return sommeForce;
	}

	/**
	 * 
	 * @param s, represente le systeme solaire dans lequelle ont travaille Permet de
	 *           caculer le point suivant a l'aide d'euler explicite soit jfeg
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
		// System.out.println("Position X :" + selectionne.getPositionX() + ", Position
		// Y :" + selectionne.getPostionY() + "\n");
		// System.out.println("Vecteur Vitesse X :" + selectionne.getVitesseX() + ",
		// Vecteur Vitesse Y :" + selectionne.getVitesseY());
	}

	/**
	 * 
	 * @param s, represente le systeme solaire dans lequelle ont travaille Permet de
	 *           prés calculer la trajectoire en fesant euler explicite en boucle
	 *           mais ne peut donc pas prendre en compte un changement brusque
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

	@Override
	public void CalculNextStep(SystemeSolaire s) {
		for (EntiteMobile entite : s) {
			
		}
	}

}
