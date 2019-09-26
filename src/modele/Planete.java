package modele;


public class Planete extends EntiteMobile{

	public Planete(Point position, double masse, double rayon, String name, double vitx, double vity,
			Trajectoire trajectoire) {
		super(position, masse, rayon, name, vitx, vity, trajectoire);
	}

}
