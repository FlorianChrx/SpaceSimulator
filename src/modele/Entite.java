package modele;

/**
 * @Date 20/09/2019
 * @author lefrancn
 * Class abstract créant une entiter
 */

public abstract class Entite {
	protected Point position; // composé d'un x et d'un y
	protected double masse; //en kg
	protected double rayon; //en m
	protected String name; // nom de l'entité
	
	
	public Entite(Point position, double masse, double rayon, String name) {
		this.position = position;
		this.masse = masse;
		this.rayon = rayon;
		this.name = name;
	}
	
	/**
	 * renvoie la masse
	 * @return renvoie la masse en double
	 */
	public double getMasse() {
		return masse;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	/**
	 * renvoie le nom
	 * @return renvoie le nom en String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * remplace le nom
	 * @param name nouveau nom
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * remplace la masse
	 * @param masse nouvelle masse
	 */
	public void setMasse(double masse) {
		this.masse = masse;
	}
	
	/**
	 * renvoie le rayon
	 * @return renvoie le rayon en double
	 */
	public double getRayon() {
		return rayon;
	}
	
	/**
	 * remplace le rayon
	 * @param rayon nouveau rayon
	 */
	public void setRayon(double rayon) {
		this.rayon = rayon;
	}
	
	public Point getPoint() {
		return position;
	}

	public void setPoint(Point point) {
		this.position = point;
	}
	
	/**
	 * @param point
	 * @return la distance en double entre le point courant et celui passer en paramétre
	 */
	public double ecart(Point point) {
		return position.distance(point);
	}
}
