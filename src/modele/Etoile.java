package modele;

/**
 * @Date 26/09/2019
 * @author lefrancn
 * Class qui hérite de Entité, c'est la seul entité quin'est pas mobile et dont on a besoins pour un systéme solaire
 */
public class Etoile extends Entite {

	public Etoile(Point position, double masse, double rayon, String name) {
		super(position, masse, rayon, name);
	}
	
}
