package view;

import java.util.ArrayList;
import java.util.List;

import controller.MainController;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modele.Entite;
import modele.Etoile;


public class Interface {

	public Interface(Stage stage,MainController m) {
		List<Node> SystemeList = new ArrayList<Node>();
		HBox h = new HBox(); 
		int len = m.getSysol().getEntityList().size();
		HBox slider = new HBox();
		VBox menu = new VBox();
		Slider pas = initSlider(0.5,50,25,Orientation.VERTICAL);
		Slider ralenti = initSlider(0,500,0,Orientation.VERTICAL);
		slider.getChildren().addAll(pas,ralenti);
		Canvas c = new Canvas(500,500);
		GraphicsContext gc = c.getGraphicsContext2D();
		changerBakcgroundColorCanvas(c, gc);
		for(int i = 0;i<len;i++) {drawEntite(gc ,m.getSysol().getEntityList().get(i),c);}
		m.setOnSliderPas(pas);
		m.setOnSliderRalenti(ralenti);
		drawEntite(gc , m.getSysol().getEntityCenter(),c);
		Button b = new Button("Valider");
		//m.setOnButton(b, SystemeList.get(0));
		menu.getChildren().addAll(slider,b);
		h.getChildren().addAll(c,menu);
		Scene sc = new Scene(h,600,500);
		stage.setScene(sc);
		stage.setTitle("SpaceSimulator");
		stage.setResizable(false);
		stage.show();
	}
	
	private void drawEntite(GraphicsContext gc,Entite p,Canvas c) {
        
        if(p instanceof Etoile) {
        	gc.setFill(Color.YELLOW);
        }else{
        	gc.setFill(Color.WHITE);
        }
        
        gc.fillOval(p.getPoint().getX()+(c.getWidth()/2),p.getPoint().getY()+(c.getHeight()/2),p.getRayon(),p.getRayon());
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
	
	
	private void changerBakcgroundColorCanvas (Canvas c, GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, c.getWidth(), c.getHeight());
	}
	
	
}
