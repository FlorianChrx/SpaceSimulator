package viewModele;

import ihm.controller.CalculService;
import javafx.concurrent.Service;
import javafx.geometry.Orientation;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import modele.system.Entite;
import modele.system.SystemeSolaire;

public class PlaneteManagementModel {

	SystemeSolaire sysol;

	public PlaneteManagementModel(SystemeSolaire sysol) {
		this.sysol = sysol;
	}

	public int nbEntity() {
		return sysol.getEntityList().size();
	}

	public void drawAllEntite(int len, GraphicsContext gc, Canvas c) {
		for (Entite e : sysol.getEtoiles()) {
			drawEntite(gc, e, c,Color.YELLOW);
		}
		for (Entite e : sysol.getPlanetes()) {
			drawEntite(gc, e, c,Color.WHITE);
		}
	}

	public void drawCentre(GraphicsContext gc, Canvas c) {
		gc.setFill(Color.YELLOW);
		gc.fillOval(sysol.getEntityCenter().getPoint().getX() + (c.getWidth() / 2),
				sysol.getEntityCenter().getPoint().getY() + (c.getHeight() / 2), sysol.getEntityCenter().getRayon(),
				sysol.getEntityCenter().getRayon());
	}

	public void drawEntite(GraphicsContext gc, Entite p, Canvas c,Color col) {
		gc.setFill(col);
		gc.fillOval(p.getPoint().getX() + (c.getWidth() / 2), p.getPoint().getY() + (c.getHeight() / 2), p.getRayon(),
				p.getRayon());
	}
	

	public void changerBakcgroundColorCanvas(Canvas c, GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, c.getWidth(), c.getHeight());
	}

	public Slider initSlider(double min, double max, double valInit, Orientation o) {
		Slider res = new Slider(min, max, valInit);
		res.setShowTickMarks(true);
		res.setShowTickLabels(true);
		res.setMajorTickUnit(10);
		res.setMinorTickCount(10);
		res.setBlockIncrement(1);
		res.setOrientation(o);
		return res;
	}

}
