package modele;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 20/09/2019
 * @author rossezr
 * Class 
 */

public class SystemeSolaire {
	
	protected List<EntiteMobile> entityList = new ArrayList<EntiteMobile>();
	protected Calculator calcul = new SteppedCalculator();
	protected Point entityCenter = new Point(0,0);
	
	
	public Point getEntityCenter() {
		return entityCenter;
	}

	public void setEntityCenter(Point entityCenter) {
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
