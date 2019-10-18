package math;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Date 20/09/2019
 * @author CHIRAUX Florian
 *
 *         Classe permettant de représenter une trajectoire: la succesion de
 *         point et ses vecteurs vitesse associés ATTENTION: si vous utilisez
 *         les méthodes deprecated, utiliser uniquement cette partie car le
 *         nouveau fonctionnement est complètement dissocié
 */
public class Trajectoire {
	// attributs
	protected List<Point> localisations;// Attribut representant la trajectoire à travers une succession de points
	protected List<Vecteur> vecteurs;// Attribut représentant la liste des vecteurs liés aux points de la trajectoire
	protected double deltaT;// Attribut représentant le pas entre chaque calcul de point

	// Constructeur
	/**
	 * Constructeur ne prenant aucun paramètre, initialise une nouvelle liste de
	 * points et utilise le pas par défaut defini dans le fichier config
	 * 
	 * @throws Exception
	 */
	public Trajectoire() throws Exception {
		Properties props = new Properties();
		new File("config/").mkdirs();
		try {
			props.load(new FileInputStream("config/config.yml"));
			this.deltaT = Double.parseDouble(props.getProperty("pas"));
		} catch (IOException e) {
			throw new Exception("Fichier de configuration manquant");
		}
	}

	/**
	 * Constructeur prenant tous les attibuts en paramètre
	 * 
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
	 * Constructeur ne prenant que le pas et initialisant une nouvelle liste de
	 * points
	 * 
	 * @param pas
	 */
	public Trajectoire(double pas) {
		this(new ArrayList<Point>(), new ArrayList<Vecteur>(), pas);
	}

	/**
	 * A modifier Constructeur mettant le pas par default
	 * 
	 * @param localisation
	 */
	public Trajectoire(List<Point> localisation, List<Vecteur> vecteur) {
		this(localisation, vecteur, 0.1);
	}

	// méthode
	public double getDeltaT() {
		return deltaT;
	}

	public void setDeltaT(double t) {
		this.deltaT = t;
	}

	public void addVector(Vecteur v) {
		vecteurs.add(v);
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

	public Vecteur getVecteur(int idx) {
		return vecteurs.get(idx);
	}

	public double getVecteurX(int idx) {
		return this.vecteurs.get(idx).getVitx();
	}

	public double getVecteurY(int idx) {
		return this.vecteurs.get(idx).getVity();
	}

	public Point getPoint(int idx) {
		return localisations.get(idx);
	}

	public double getPointX(int idx) {
		return localisations.get(idx).getX();
	}

	public double getPointY(int idx) {
		return localisations.get(idx).getY();
	}

	public void addLocalisation(Point point) {
		localisations.add(point);
	}

	public Point getLastPoint() {
		return getPoint(localisations.size() - 1);
	}

	public double getLastPointX() {
		return getPoint(localisations.size() - 1).getX();
	}

	public double getLastPointY() {
		return getPoint(localisations.size() - 1).getY();
	}

	public Vecteur getLastVecteur() {
		return getVecteur(vecteurs.size() - 1);
	}

	public double getLastVecteurX() {
		return getVecteurX(vecteurs.size() - 1);
	}

	public double getLastVecteurY() {
		return getVecteurY(vecteurs.size() - 1);
	}

	public List<Point> getLocalisations() {
		return localisations;
	}

	public List<Vecteur> getVecteurs() {
		return vecteurs;
	}

}
