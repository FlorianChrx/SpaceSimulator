package modele;

/**
 * @Date 20/09/2019
 * @author lefrancn
 * Class qui hérite de EntitéMobile le vaisseau ayant des méthodes spécifique a lui
 */
public class Planete extends EntiteMobile{

	public Planete(Point position, double masse, double rayon, String name, Vecteur vitesse,
			Trajectoire trajectoire) {
		super(position, masse, rayon, name, vitesse, trajectoire);
	}

}
