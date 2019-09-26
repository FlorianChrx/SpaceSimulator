package modele;

public abstract class Entite {
	protected Point position;
	protected double masse;
	protected double rayon;
	protected String name;
	
	

	public Entite(Point position, double masse, double rayon, String name) {
		this.position = position;
		this.masse = masse;
		this.rayon = rayon;
		this.name = name;
	}

	public double getMasse() {
		return masse;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
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

	public Point getPoint() {
		return position;
	}

	public void setPoint(Point point) {
		this.position = point;
	}
	
	public double ecart(Entite e) {
		return position.distance(e.getPoint());
	}
	
	
}
