package modele.system;

import modele.maths.Positionnable;
import modele.maths.Trajectoire;
import modele.maths.Vecteur;

/**
 * @Date 20/09/2019
 * @author lefrancn
 * Class qui h�rite de Entit�Mobile �tant la seule a avoir des m�thode diff�rente
 */

public class Vaisseau extends EntiteMobile {
	protected double pPrincipale; // propulseur principale
	protected double pRetro; // propulseur
	
	
	public Vaisseau(Positionnable positionInitial, double masse, double rayon, String name, Vecteur vitesseInitial,
			Trajectoire trajectoire,double pPrincipale,double pRetro) {
		super(positionInitial, masse, rayon, name, vitesseInitial, trajectoire);
		this.pPrincipale=pPrincipale;
		this.pRetro=pRetro;
	}


	public double getpPrincipale() {
		return pPrincipale;
	}


	public void setpPrincipale(double pPrincipale) {
		this.pPrincipale = pPrincipale;
	}


	public double getpRetro() {
		return pRetro;
	}


	public void setpRetro(double pRetro) {
		this.pRetro = pRetro;
	}
	

}
