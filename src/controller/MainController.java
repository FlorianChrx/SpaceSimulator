package controller;

import modele.Planete;
import modele.Point;
import modele.Trajectoire;
import modele.Vecteur;

public class MainController {

	Planete em = new Planete(new Point(20,20),50,20,"UrAnus",new Vecteur(10,10),new Trajectoire(0.25));
	
	public Planete getPlaneteTest() {
		return em;
	}
	
	
}
