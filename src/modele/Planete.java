package modele;

import javafx.geometry.Point2D;

public class Planete extends EntiteMobile{

	public Planete(Point2D position, double masse, double rayon, String name, double vitx, double vity,
			Trajectoire trajectoire) {
		super(position, masse, rayon, name, vitx, vity, trajectoire);
	}

}
