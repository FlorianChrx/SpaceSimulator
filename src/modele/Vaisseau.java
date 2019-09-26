package modele;
/**
 * @Date 20/09/2019
 * @author lefrancn
 * Class qui hérite de EntitéMobile étant la seule a avoir des méthode différente
 */

public class Vaisseau extends EntiteMobile {
	protected double pPrincipale; // propulseur principale
	protected double pRetro; // propulseur
	
	
	public Vaisseau(Point position, double masse, double rayon, String name, double vitx, double vity,
			Trajectoire trajectoire,double pPrincipale,double pRetro) {
		super(position, masse, rayon, name, vitx, vity, trajectoire);
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
