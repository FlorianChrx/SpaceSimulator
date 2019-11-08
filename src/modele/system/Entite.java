package modele.system;

import modele.maths.Point;
import modele.maths.Positionnable;

/**
 * @Date 20/09/2019
 * @author lefrancn
 * Class abstract cr�ant une entiter
 */

public abstract class Entite implements Positionnable {
	protected Point position; // compos� d'un x et d'un y
	protected double masse; //en kg
	protected double rayon; //en m
	protected String name; // nom de l'entit�
	
	
	
	@Override
	public double getX() {
		return position.getX();
	}

	@Override
	public double getY() {
		return position.getY();
	}

	@Override
	public void setX(double x) {
		position.setX(x);
	}

	@Override
	public void setY(double y) {
		position.setY(y);
	}

	public Entite(Positionnable position, double masse, double rayon, String name) {
		this.position = new Point(position.getX(), position.getY());
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
	
	public double getPositionX() {
		return getPosition().getX();
	}
	
	public double getPositionY() {
		return getPosition().getY();
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
	 * @return la distance en double entre le point courant et celui passer en param�tre
	 */
	public double ecart(Point point) {
		return position.distance(point);
	}
}
