package modele;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.io.File;

/**
 * @Date 20/09/2019
 * @author CHIRAUX Florian
 *
 * Classe permettant de représenter une trajectoire: cette 
 */
public class Trajectoire {
	/**
	 * Attributs representant la trajectoire à travers une succession de points
	 */
	protected List<Point> localisationsPrevision;
	protected List<Double> vitx;
	protected List<Double> vity;
	protected List<Vecteur> trajectoirePrevision;
	protected List<Point> localisations;
	protected List<Vecteur> trajectoire;
	
	/**
	 * Attribut représentant le pas entre chaque calcul de point
	 */
	protected double pas;
	
	
	//Constructeur mad'
	public Trajectoire(Vaisseau v) {
		this.localisations = new ArrayList<Point>();
		this.trajectoire = new ArrayList<Vecteur>();
		this.localisationsPrevision = new ArrayList<Point>();
		this.trajectoirePrevision = new ArrayList<Vecteur>();
		this.localisations.add(v.getPoint());//Point de d�part du vaisseau
		this.trajectoire.add(v.getVitesse());//Vitesse de d�part du vaisseau
		this.localisationsPrevision.add(v.getPoint());
		this.trajectoirePrevision.add(v.getVitesse());
	}
	
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
	
	public double getLastVitX() {
		return getVitX(vitx.size()-1);
	}
	
	public double getVitX(int idx) {
		return vitx.get(idx);
	}
		
    public double getLastVitY() {
    	return getVitY(vity.size()-1);
	}
    
    public double getVitY(int idx) {
    	return vity.get(idx);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((localisations == null) ? 0 : localisations.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pas);
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
		if (Double.doubleToLongBits(pas) != Double.doubleToLongBits(other.pas)) {
			return false;
		}
		return true;
	}

	/**
	 * Constructeur prenant tous les attibuts en paramètre
	 * @param localisations
	 * @param pas
	 */
	public Trajectoire(List<Point> localisations, double pas) {
		super();
		this.localisations = localisations;
		this.pas = pas;
	}
	
	/**
	 * Constructeur ne prenant que le pas et initialisant une nouvelle liste de points
	 * @param pas
	 */
	public Trajectoire(double pas) {
		this(new ArrayList<Point>(), pas);
	}
	
	/**
	 * A modifier
	 * Constructeur mettant le pas par default 
	 * @param localisation
	 */
	public Trajectoire(List<Point> localisation) {
		this(localisation, 0.1);
	}
	
	/**
	 * Constructeur ne prenant aucun paramètre, initialise une nouvelle liste de points
	 * et utilise le pas par défaut defini dans le fichier config
	 * @throws Exception
	 */
	public Trajectoire() throws Exception {
		Properties props = new Properties();
		new File("config/").mkdirs();
		try {
			props.load(new FileInputStream("config/config.yml"));
			pas = Double.parseDouble(props.getProperty("pas"));
		} catch (IOException e) {
			throw new Exception("Fichier de configuration manquant");
		}
	}

	public double getPas() {
		return pas;
	}

	public void addVitX(double vitx) {
		this.vitx.add(vitx);
	}
	
	public void addVitY(double vity) {
		this.vity.add(vity);
	}
	
	
	
}
