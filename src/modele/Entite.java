package modele;

import javafx.geometry.Point2D;

public abstract class Entite {
	protected Point2D point;
	protected double masse;

	public Point2D getPoint() {
		return point;
	}

	public void setPoint(Point2D point) {
		this.point = point;
	}
	
	
}
