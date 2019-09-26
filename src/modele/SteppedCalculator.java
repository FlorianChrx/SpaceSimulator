package modele;

import java.util.Map;

/**
 * @Date 20/09/2019
 * @author carpentm
 *Class intérable 
 */

public class SteppedCalculator implements Calculator{
	//Les attributs
	protected Map<Entite, Trajectoire> liste;
	protected double acceleration;

	@Override
	public void CalculNextStep(EntiteMobile p) {
		
	}
	
	public double VitesseX() {
		return 0;
	}
	
	public double VitesseY() {
		return 0;
	}
	
	public double acceleration() {
		return 0;
	}
	
	
	
	
	
	
	
	
}
