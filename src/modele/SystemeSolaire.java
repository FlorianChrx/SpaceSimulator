package modele;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;

public class SystemeSolaire {
	
	protected List<EntiteMobile> entityList = new ArrayList<EntiteMobile>();
	protected Calculator calcul = new SteppedCalculator();
	protected Point2D entityCenter = new Point2D(0,0);

	public Point2D getEntityCenter() {
		return entityCenter;
	}

	public void setEntityCenter(Point2D entityCenter) {
		this.entityCenter = entityCenter;
	}

	public List<EntiteMobile> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<EntiteMobile> entityList) {
		this.entityList = entityList;
	}

	public Calculator getCalcul() {
		return calcul;
	}

	
	
	
}
