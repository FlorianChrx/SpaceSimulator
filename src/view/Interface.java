package view;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Interface {

	public Interface(Stage stage) {
		HBox h = new HBox();
		//VBox v = new VBox();
		Canvas c = new Canvas(500,500);
		//ComboBox<String> cb = new ComboBox<String>();
		GraphicsContext gc = c.getGraphicsContext2D();
		gc.setFill(Color.ORANGE);
		gc.rect(0, 0, 50, 50);
		gc.fillRect(0, 0, 50, 50);
		//Button b = new Button("Valider");
		h.getChildren().addAll(c);
		Scene sc = new Scene(h,500,500);
		stage.setScene(sc);
		stage.setTitle("SpaceSimulator");
		stage.setResizable(false);
		stage.show();
	}
	
}
