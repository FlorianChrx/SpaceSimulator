package controller;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
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
			transitionPlanete(rectPath);
		});
	}
	
	public void transitionPlanete(Node rectPath) {
	Path path = new Path();
	path.getElements().add(new MoveTo(20,20));
	path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
	path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
	PathTransition pathTransition = new PathTransition();
	pathTransition.setDuration(Duration.millis(4000));
	pathTransition.setPath(path);
	pathTransition.setNode(rectPath);
	pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
	pathTransition.setCycleCount(Timeline.INDEFINITE);
	pathTransition.setAutoReverse(true);
	pathTransition.play();
	}
}
