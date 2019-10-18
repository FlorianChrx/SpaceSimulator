package modele.system;

import modele.maths.Point;
import modele.maths.Trajectoire;
import modele.maths.Vecteur;

/**
 * @Date 20/09/2019
 * @author lefrancn
 * Class qui h�rite de Entit�Mobile le vaisseau ayant des m�thodes sp�cifique a lui
 */
public class Planete extends EntiteMobile{

	public Planete(Point position, double masse, double rayon, String name, Vecteur vitesse,
			Trajectoire trajectoire) {
		super(position, masse, rayon, name, vitesse, trajectoire);
	}

}
