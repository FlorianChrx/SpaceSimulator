package modele;

import java.util.Map;

import javafx.geometry.Point2D;

/**
 * @Date 20/09/2019
 * @author carpentm
 *Class intérable 
 */

public class SteppedCalculator implements Calculator{
	//Les attributs
	protected Map<Entite, Trajectoire> liste;
	protected final double G = 6.6742 * Math.pow(10, -11);//Constante gravitationnelle;

	@Override
	public void CalculNextStep(EntiteMobile p) {
		double x = p.getPoint().getX() + p.getVitx()/p.getTrajectoire().getPas();
		double y = p.getPoint().getY() + p.getVity()/p.getTrajectoire().getPas();
		Point2D nouvePoint = new Point2D(x, y);
		
		
	}
	
	public double VitesseX() {
		return 0;
	}
	
	public double VitesseY() {
		return 0;
	}
	
	public double Acceleration() {
		return 0;
	}
	
	public void ForceGravitationnel() {
		
	}
	
	
	
	
	
	
	
	
}
