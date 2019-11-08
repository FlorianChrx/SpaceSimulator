package modele.system;

import modele.maths.Positionnable;
import modele.maths.Trajectoire;
import modele.maths.Vecteur;

/**
 * @Date 26/09/2019
 * @author lefrancn Class qui h�rite de Entit�, c'est la seul entit� quin'est
 *         pas mobile et dont on a besoins pour un syst�me solaire
 */
public class Etoile extends EntiteMobile {

	public Etoile(Positionnable position, double masse, double rayon, String name, Vecteur vitesse, Trajectoire trajectoire) {
		super(position, masse, rayon, name, vitesse, trajectoire);
	}

}
