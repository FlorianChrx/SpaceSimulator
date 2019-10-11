package ihm.controller;


import javafx.scene.control.Slider;
import modele.maths.Point;
import modele.maths.Trajectoire;
import modele.maths.Vecteur;
import modele.system.Etoile;
import modele.system.Planete;
import modele.system.SystemeSolaire;

public class MainController {

	SystemeSolaire sysol = new SystemeSolaire();
	Planete em = new Planete(new Point(20,20),50,20,"UrAnus",new Vecteur(10,10),new Trajectoire(0.25));
	Etoile et = new Etoile(new Point(50,50),50,20,"UrAnus",new Vecteur(10,10),new Trajectoire(0.25));
	
	public MainController() {
		sysol.addEntity(em);
		sysol.addEntity(et);
	}
	
	public SystemeSolaire getSysol() {
		return sysol;
	}
	
	public void setOnSliderPas(Slider s) {
		s.valueProperty().addListener(e->{
			changePas(s.getValue());
		});
	}
	
	public void setOnSliderRalenti(Slider s) {
		s.valueProperty().addListener(e->{
			changeRalenti(s.getValue());
		});
	}
	
	public void changePas (double newPas) {
		sysol.setAllPas(newPas);
	}
	
	public void changeRalenti(double newRalenti) {
		
	}

}
