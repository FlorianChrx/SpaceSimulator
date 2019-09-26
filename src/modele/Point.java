package modele;

public class Point {
	protected double x;
	protected double y;
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
	public double distance(Point point) {
		double save = (this.getX() - point.getX()) + this.getY() - point.getY();
		return save;
	}
}
