package modele;


/**
 * @Date 20/09/2019
 * @author carpentm
 *Class intérable 
 */

public class SteppedCalculator implements Calculator{
	//Les attributs
	protected final double G = 6.6742 * Math.pow(10, -11);//Constante gravitationnelle;

	//Les méthodes
	@Override
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
	
	public void ForceGravitationnel() {
		
	}
	
	public void euleurExplicite() {
		
	}
	
	
	
	
	
	
	
	
	
	
}
