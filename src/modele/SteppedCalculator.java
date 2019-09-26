package modele;


/**
 * @Date 20/09/2019
 * @author carpentm
 *Class intérable 
 */

public class SteppedCalculator implements Calculator{
	//Les attributs
	protected final double G = 6.6742 * Math.pow(10, -10);//Constante gravitationnelle en m3.kg^-1.s^-1;

	//Les méthodes
	@Override
	/**
	 * Permet de calculer le prochain point et de l'ajouter a la liste des points sur la trajectoire
	 */
	public void CalculNextStep(EntiteMobile p) {
			double x = p.getTrajectoire().getLastPoint().getX() + p.getTrajectoire().getLastVitX()/p.getTrajectoire().getPas();
			double y = p.getTrajectoire().getLastPoint().getY() + p.getTrajectoire().getLastVitY()/p.getTrajectoire().getPas();
			
			Point nouvePoint = new Point(x, y);
			
			p.setPoint(nouvePoint);
			p.getTrajectoire().addLocalisation(nouvePoint);
	}
	
	public double VitesseXVaisseau() {
		return 0;
	}
	
	public double VitesseYVaisseaux() {
		return 0;
	}
	
	public double Acceleration() {
		return 0;
	}
	
	public double ForceGravitationnel(Vaisseau vaisseau, Entite entite) {
		double distance = vaisseau.getPoint().distance(entite.getPoint());
		Vecteur vecteur = new Vecteur(vaisseau.getPoint().getX(), entite.getPoint().getX());
		
		return -this.G * ((vaisseau.masse * entite.masse) / Math.pow(distance, 2));
		
	}
	
	public void euleurExplicite() {
		
	}
	
	public void CalculeTrajectoire() {
		
	}
	
	
	
	
	
	
	
	
	
	
}
