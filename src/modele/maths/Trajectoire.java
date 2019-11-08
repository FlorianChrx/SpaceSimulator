package modele.maths;

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
 *         Classe permettant de repr�senter une trajectoire: la succesion de
 *         point et ses vecteurs vitesse associ�s ATTENTION: si vous utilisez
 *         les m�thodes deprecated, utiliser uniquement cette partie car le
 *         nouveau fonctionnement est compl�tement dissoci�
 */
public class Trajectoire {
	// attributs
	protected List<Positionnable> localisations;// Attribut representant la trajectoire � travers une succession de points
	protected List<Vecteur> vecteurs;// Attribut repr�sentant la liste des vecteurs li�s aux points de la trajectoire
	protected double deltaT;// Attribut repr�sentant le pas entre chaque calcul de point

	// Constructeur
	/**
	 * Constructeur ne prenant aucun param�tre, initialise une nouvelle liste de
	 * points et utilise le pas par d�faut defini dans le fichier config
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
	 * Constructeur prenant tous les attibuts en param�tre
	 * 
	 * @param localisations
	 * @param pas
	 */
	public Trajectoire(List<Positionnable> localisations, List<Vecteur> vecteur, double pas) {
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
		this(new ArrayList<Positionnable>(), new ArrayList<Vecteur>(), pas);
	}

	/**
	 * A modifier Constructeur mettant le pas par default
	 * 
	 * @param localisation
	 */
	public Trajectoire(List<Positionnable> localisation, List<Vecteur> vecteur) {
		this(localisation, vecteur, 0.1);
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
		return this.vecteurs.get(idx).getX();
	}
	
	public void addVector(Vecteur v) {
		vecteurs.add(v);
	}

	public double getPointY(int idx) {
		return localisations.get(idx).getY();
	}

	public void addLocalisation(Positionnable position) {
		localisations.add(position);
	}

	public Positionnable getLastPoint() {
		return localisations.get(localisations.size() - 1);
	}

	public void setDeltaT(double deltaT) {
		this.deltaT = deltaT;
	}
	
	public double getDeltaT() {
		return deltaT;
	}
}
