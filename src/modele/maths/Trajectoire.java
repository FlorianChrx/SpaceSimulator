package modele.maths;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 20/09/2019
 * @author CHIRAUX Florian
 *
 * Classe permettant de représenter une trajectoire: la succesion de point et ses vecteurs vitesse associés
 * ATTENTION: si vous utilisez les méthodes deprecated, utiliser uniquement cette partie car le nouveau fonctionnement 
 * 			  est complètement dissocié
 */
public class Trajectoire {
	/**
	 * Attribut representant la trajectoire à travers une succession de points
	 */
	protected List<Point> localisations;
	/**
	 * Attribut représentant la liste des vecteurs liés aux points de la trajectoire
	 */
	protected List<Vecteur> vecteurs;
	/**
	 * Ancien attribut de vecteur vitesse, voué à disparaître
	 */
	@Deprecated
	protected List<Double> vitx;
	/**
	 * Ancien attribut de vecteur vitesse, voué à disparaître
	 */
	@Deprecated
	protected List<Double> vity;
	
	/**
	 * Attribut représentant le pas entre chaque calcul de point
	 */
	protected double deltaT;
	
	/**
	 * permet d'ajouter un point à la trajectoire;
	 * @param point
	 */
	public void addLocalisation(Point point) {
		localisations.add(point);
	}
	
	/**
	 * permet d'obtenir le dernier point de la trajectoire;
	 * @return
	 */
	public Point getLastPoint() {
		return getPoint(localisations.size()-1);
	}
	
	/**
	 * permet d'obtenir le point à un indice donné
	 * @param idx l'indice du point recherché
	 * @return
	 */
	public Point getPoint(int idx) {
		return localisations.get(idx);
	}
	
	/**
	 * Méthode d'accès à un vecteur de la trajectoire à l'indice donné
	 * @param idx l'index du vecteur dans la trajectoire
	 * @return Le vecteur à cette position de la trajectoire
	 */
	public Vecteur getVecteur(int idx) {
		return vecteurs.get(idx);
	}
	
	/**
	 * Méthode d'accès au dernier vecteur de la trajectoire
	 * @return le dernier vecteur de la trajectoire
	 */
	public Vecteur getLastVecteur() {
		return getVecteur(vecteurs.size()-1);
	}
	
	/**
	 * Ancien getter de coordonnée de vecteur, voué à disparaître
	 * @return une coordonnée de vecteur (x)
	 */
	@Deprecated
	public double getLastVitX() {
		return getVitX(vitx.size()-1);
	}
	
	/**
	 * Ancien getter de coordonnée de vecteur, voué à disparaître
	 * @return une coordonnée de vecteur (x)
	 */
	@Deprecated
	public double getVitX(int idx) {
		return vitx.get(idx);
	}
	
	/**
	 * Ancien getter de coordonnée de vecteur, voué à disparaître
	 * @return une coordonnée de vecteur (y)
	 */
	@Deprecated	
    public double getLastVitY() {
    	return getVitY(vity.size()-1);
	}

	/**
	 * Ancien getter de coordonnée de vecteur, voué à disparaître
	 * @return une coordonnée de vecteur (y)
	 */
	@Deprecated
    public double getVitY(int idx) {
    	return vity.get(idx);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((localisations == null) ? 0 : localisations.hashCode());
		long temp;
		temp = Double.doubleToLongBits(deltaT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Trajectoire)) {
			return false;
		}
		Trajectoire other = (Trajectoire) obj;
		if (localisations == null) {
			if (other.localisations != null) {
				return false;
			}
		} else if (!localisations.equals(other.localisations)) {
			return false;
		}
		if (Double.doubleToLongBits(deltaT) != Double.doubleToLongBits(other.deltaT)) {
			return false;
		}
		return true;
	}

	/**
	 * Constructeur prenant tous les attibuts en paramètre
	 * @param localisations
	 * @param pas
	 */
	public Trajectoire(List<Point> localisations, List<Vecteur> vecteur, double pas) {
		super();
		this.localisations = localisations;
		this.deltaT = pas;
		this.vecteurs = vecteur;
	}
	
	/**
	 * Constructeur ne prenant que le pas et initialisant une nouvelle liste de points
	 * @param pas
	 */
	public Trajectoire(double pas) {
		this(new ArrayList<Point>(), new ArrayList<Vecteur>(), pas);
	}
	
	/**
	 * A modifier
	 * Constructeur mettant le pas par default 
	 * @param localisation
	 */
	public Trajectoire(List<Point> localisation, List<Vecteur> vecteur) {
		this(localisation, vecteur,  0.1);
	}
	
	/**
	 * Fonction permettant d'obtenir le pas actuel de cette trajectoire
	 * @return un double représentant le pas de la trajectoire (le temps qui s'écoule entre 2 points)
	 */
	public double getPas() {
		return deltaT;
	}
	
	public void setPas(double pas) {
		this.deltaT=pas;
	}
	
	public void addVector(Vecteur v) {
		vecteurs.add(v);
	}

	/**
	 * Ancienne méthode permettant d'ajouter une coordonée de vecteur
	 * @param vitx
	 */
	@Deprecated
	public void addVitX(double vitx) {
		this.vitx.add(vitx);
	}
	
	/**
	 * Ancienne méthode permettant d'ajouter une coordonée de vecteur
	 * @param vity
	 */
	@Deprecated
	public void addVitY(double vity) {
		this.vity.add(vity);
	}
	
	
}