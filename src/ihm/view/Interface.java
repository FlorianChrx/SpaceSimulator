package ihm.view;


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


public class Interface {

	public Interface(Stage stage,MainController m) {
		PlaneteManagementModel model = new PlaneteManagementModel(m.getSysol());
		HBox h = new HBox(); 
		int len = m.getSysol().getEntityList().size();
		HBox slider = new HBox();
		VBox menu = new VBox();
		Slider pas = model.initSlider(0.5,50,25,Orientation.VERTICAL);
		Slider ralenti = model.initSlider(0,500,0,Orientation.VERTICAL);
		slider.getChildren().addAll(pas,ralenti);
		Canvas c = new Canvas(500,500);
		GraphicsContext gc = c.getGraphicsContext2D();
		model.changerBakcgroundColorCanvas(c, gc);
		model.drawAllEntite(len, gc, c);
		m.setOnSliderPas(pas);
		m.setOnSliderRalenti(ralenti);
		model.drawCentre(gc, c);
		Button b = new Button("Valider");
		b.setOnAction(e->{
			model.launchCalcul();
		});
		menu.getChildren().addAll(slider,b);
		h.getChildren().addAll(c,menu);
		model.launchCalcul();
		Scene sc = new Scene(h,600,500);
		stage.setScene(sc);
		stage.setTitle("SpaceSimulator");
		stage.setResizable(false);
		stage.show();
	}
	

	
	
}
