package modele.system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import modele.maths.Calculator;
import modele.maths.Point;
import modele.maths.SteppedCalculator;
import modele.maths.Trajectoire;
import modele.maths.Vecteur;

/**
 * @Date 20/09/2019
 * @author rossezr Class
 */

public class SystemeSolaire extends Observable implements Iterable<EntiteMobile> {

	
	public class MyTimerTask extends TimerTask{
		@Override
		public void run() {
			
			update();
			
		}
	}
	
	
	
	
	protected List<EntiteMobile> planetes;
	protected List<EntiteMobile> etoiles;
	protected Entite entityCenter;
	protected Vaisseau vaisseau;
	protected Calculator calcul = new SteppedCalculator();
	protected double g;
	protected double rayon;
	protected double fa;
	protected TimerTask tt;

	public SystemeSolaire() {
		planetes = new ArrayList<EntiteMobile>();
		etoiles = new ArrayList<EntiteMobile>();
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

	/**
	 * Permet de fixer le deltaT de chaque entité du système
	 * 
	 * @param pas
	 *            le pas de temps à fixer entre chaque point
	 */
	public void setAllPas(double pas) {
		for (EntiteMobile em : getEntityList()) {
			em.trajectoire.setDeltaT(pas);
		}
	}

	public Vaisseau getVaisseau() {
		return vaisseau;
	}

	public void setVaisseau(Vaisseau vaisseau) {
		this.vaisseau = vaisseau;
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
	
	public void myTimer() {
		Timer t = new Timer();
		tt = new MyTimerTask();
		t.scheduleAtFixedRate(tt, 0, 1000);
	}
	
	public void cancel() {
		tt.cancel();
	}
	
	public void update() {
		calcul.CalculNextStep(this);
		setChanged();
		notifyObservers();
	}
	
}
