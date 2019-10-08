package controller;


import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import modele.Planete;
import modele.Point;
import modele.SystemeSolaire;
import modele.Trajectoire;
import modele.Vecteur;

public class MainController {

	SystemeSolaire sysol= new SystemeSolaire();
	Planete em = new Planete(new Point(20,20),50,20,"UrAnus",new Vecteur(10,10),new Trajectoire(0.25));
	
	public MainController() {
		sysol.addEntity(em);
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
	
	public void setOnButton(Button b,Node rectPath) {
		b.setOnAction(e->{
			
		});
	}
	

}
