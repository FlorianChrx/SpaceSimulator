package math;

import math.Point;

/**
 * @Date 20/09/2019
 * @author lefrancn Class Point permettant de creer des points a partir
 *         d'absysse et d'ordonné
 */
public class Point {
	protected double x; // axe des absysses
	protected double y; // axe des ordonné

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @param point
	 * @return la distance en double entre 2 points Soustrait les x et les y pour
	 *         ensuite additionner le résultat
	 */
	public double distance(Point point) {
		double save = Math.sqrt(Math.pow((this.getX() - point.getX()), 2) + Math.pow((this.getY() - point.getY()), 2));
		System.out.println(save);
		return save;
	}

	/**
	 * 
	 * @param p1 un point
	 * @param p2 un autre point
	 * @return la distance entre ces deux points
	 */
	public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2));
	}

	/**
	 * 
	 * @param p, un point
	 * @param k, un double coefficient directeur
	 * @return le nouveau point qui a été multiplier par le produit
	 */
	public Point produit(Point p, double k) {
		p.setX(p.getX() * k);
		p.setY(p.getY() * k);
		return p;
	}
}
