package modele;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 20/09/2019
 * @author rossezr
 * Class 
 */

public class SystemeSolaire {
	
	protected Vaisseau vaisseau;
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

	public Vaisseau getVaisseau() {
		return vaisseau;
	}

	public void setVaisseau(Vaisseau vaisseau) {
		this.vaisseau = vaisseau;
	}

	public void setCalcul(Calculator calcul) {
		this.calcul = calcul;
	}

	public void addVaisseau(Vaisseau v) {
		setVaisseau(v);
		entityList.add(v);
	}
	
	public void add(EntiteMobile em) {
		if(em instanceof Vaisseau) {
			addVaisseau((Vaisseau) em);
		} else {
			entityList.add(em);
		}
	}
	
	
}
