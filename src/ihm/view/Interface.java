package ihm.view;


import java.util.Observable;
import java.util.Observer;

import ihm.controller.MainController;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import viewModele.PlaneteManagementModel;


public class Interface implements Observer {

	PlaneteManagementModel model;
	Canvas c;
	GraphicsContext gc;
	int len;
	
	public Interface(Stage stage,MainController m) {
		model = new PlaneteManagementModel(m.getSysol());
		model.addObservers(this);
		HBox h = new HBox(); 
		len = m.getSysol().getEntityList().size();
		HBox slider = new HBox();
		VBox menu = new VBox();
		Slider pas = model.initSlider(0.5,50,25,Orientation.VERTICAL);
		Slider ralenti = model.initSlider(0,500,0,Orientation.VERTICAL);
		slider.getChildren().addAll(pas,ralenti);
		c = new Canvas(500,500);
		gc = c.getGraphicsContext2D();
		model.changerBakcgroundColorCanvas(c, gc);
		model.drawAllEntite(len, gc, c);
		m.setOnSliderPas(pas);
		m.setOnSliderRalenti(ralenti);
		model.drawCentre(gc, c);
		Button b = new Button("Arreter");
		Button refresh = new Button("Refresh");
		refresh.setOnAction(e->{
			model.clear(c, gc);
			model.drawAllEntite(len, gc, c);
			model.drawCentre(gc, c);
		});
		b.setOnAction(e->{
			model.cancel();
		});
		menu.getChildren().addAll(slider,b,refresh);
		h.getChildren().addAll(c,menu);
		Scene sc = new Scene(h,600,500);
		stage.setOnCloseRequest(e->{
			model.cancel();
		});
		stage.setScene(sc);
		stage.setTitle("SpaceSimulator");
		stage.setResizable(false);
		model.startSimulation();
		stage.show();
	}

	@Override
	public void update(Observable o, Object arg) {
		model.clear(c, gc);
		model.drawAllEntite(len, gc, c);
		model.drawCentre(gc, c);
	}	
}
