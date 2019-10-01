package view;

import controller.MainController;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import modele.Planete;


public class Interface {

	public Interface(Stage stage,MainController m) {
		HBox h = new HBox(); 
		Planete affiche = m.getPlaneteTest();
		HBox slider = new HBox();
		VBox menu = new VBox();
		Slider pas = initSlider(0.5,50,25,Orientation.VERTICAL);
		Slider ralenti = initSlider(0,500,0,Orientation.VERTICAL);
		slider.getChildren().addAll(pas,ralenti);
		Canvas c = new Canvas(500,500);
		GraphicsContext gc = c.getGraphicsContext2D();
		Button b = new Button("Valider");
		menu.getChildren().addAll(slider,b);
		drawPlanete(gc,affiche);
		h.getChildren().addAll(c,menu);
		Scene sc = new Scene(h,600,500);
		stage.setScene(sc);
		stage.setTitle("SpaceSimulator");
		stage.setResizable(false);
		stage.show();
	}
	
	private void drawPlanete(GraphicsContext gc,Planete p) {
        gc.setFill(Color.BLACK);
        gc.fillOval(p.getPoint().getX(),p.getPoint().getY(),p.getRayon(),p.getRayon());
    }
	
	private Slider initSlider(double min,double max,double valInit,Orientation o) {
		Slider res = new Slider(min,max,valInit);
		res.setShowTickMarks(true);
		res.setShowTickLabels(true);
		res.setMajorTickUnit(10);
		res.setMinorTickCount(10);
		res.setBlockIncrement(1);
		res.setOrientation(o);
		return res;
	}
}
