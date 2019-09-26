package modele;

/**
 * @Date 20/09/2019
 * @author lefrancn
 * Class Point permettant de creer des points a partir d'absysse et d'ordonné
 */
public class Point {
	protected double x; //axe des absysses
	protected double y; //axe des ordonné
	
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
	 * 
	 * @param point
	 * @return la distance en double entre 2 points
	 * Soustrait les x et les y pour ensuite additionner le résultat
	 */
	public double distance(Point point) {
		return (this.getX() - point.getX()) + this.getY() - point.getY();
	}
}
