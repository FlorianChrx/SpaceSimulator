package modele;

import javafx.geometry.Point2D;

public abstract class Entite {
	protected Point2D position;
	protected double masse;
	protected double rayon;
	protected String name;
	
	

	public Entite(Point2D position, double masse, double rayon, String name) {
		this.position = position;
		this.masse = masse;
		this.rayon = rayon;
		this.name = name;
	}

	public double getMasse() {
		return masse;
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMasse(double masse) {
		this.masse = masse;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	public Point2D getPoint() {
		return position;
	}

	public void setPoint(Point2D point) {
		this.position = point;
	}
	
	public double ecart(Entite e) {
		return position.distance(e.getPoint());
	}
	
	
}
