package modele.system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modele.maths.BidonCalculator;
import modele.maths.Calculator;
import modele.maths.Point;
import modele.maths.Trajectoire;
import modele.maths.Vecteur;

/**
 * @Date 20/09/2019
 * @author rossezr Class
 */

public class SystemeSolaire implements Iterable<EntiteMobile> {

	protected List<EntiteMobile> planetes;
	protected List<EntiteMobile> etoiles;
	protected Calculator calcul;
	protected Entite entityCenter;
	protected Vaisseau vaisseau;
	protected double g;
	protected double rayon;
	protected double fa;

	public SystemeSolaire() {
		planetes = new ArrayList<EntiteMobile>();
		etoiles = new ArrayList<EntiteMobile>();
		calcul = new BidonCalculator();
		entityCenter = new Etoile(new Point(0, 0), 20, 20, "Soleil", new Vecteur(0, 0), new Trajectoire(0));
	}

	public Etoile getEntityCenter() {
		return (Etoile) entityCenter;
	}

	public void setEntityCenter(Etoile entityCenter) {
		this.entityCenter = entityCenter;
	}

	public List<EntiteMobile> getPlanetes() {
		return planetes;
	}

	public List<EntiteMobile> getEtoiles() {
		return etoiles;
	}

	/**
	 * retourne la liste de toutes les entites mobiles du systèm ATTENTION: seul les
	 * éléments sont modifiables, vous ne pouvez pas ajouter des éléments via la
	 * liste obtenue
	 * 
	 * @return un liste non modifiable des entites mobiles du système
	 */
	public List<EntiteMobile> getEntityList() {
		List<EntiteMobile> list = new ArrayList<EntiteMobile>();
		list.addAll(etoiles);
		list.addAll(planetes);
		list.add(vaisseau);
		return list;
	}

	/**
	 * Permet d'ajouter une entite mobile de n'importe quel type
	 * 
	 * @param em
	 *            l'entite mobile qui doit etre ajoutée au système
	 * @return si l'objet a bien été ajouté au système
	 */
	public boolean addEntity(EntiteMobile em) {
		if (em instanceof Etoile) {
			addEntity((Etoile) em);
			return true;
		} else if (em instanceof Planete) {
			addEntity((Planete) em);
			return true;
		}
		return false;
	}

	public void addEntity(Etoile e) {
		etoiles.add(e);
	}

	public void addEntity(Planete e) {
		planetes.add(e);
	}

	public Calculator getCalcul() {
		return calcul;
	}

	/**
	 * Permet de fixer le deltaT de chaque entité du système
	 * 
	 * @param pas
	 *            le pas de temps à fixer entre chaque point
	 */
	public void setAllPas(double pas) {
		for (EntiteMobile em : getEntityList()) {
			em.setPas(pas);
		}
	}

	public Vaisseau getVaisseau() {
		return vaisseau;
	}

	public void setVaisseau(Vaisseau vaisseau) {
		this.vaisseau = vaisseau;
	}

	public void setCalcul(Calculator calcul) {
		this.calcul = calcul;
	}

	@Override
	public Iterator<EntiteMobile> iterator() {
		return getEntityList().iterator();
	}
	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	public void setFa(double fa) {
		this.fa = fa;
		
	}
	public double getFa() {
		return fa;
	}

}
