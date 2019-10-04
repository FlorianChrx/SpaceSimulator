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
	protected List<EntiteMobile> entityList;
	protected Calculator calcul;
	protected Entite entityCenter;
	
	
	public SystemeSolaire() {
		entityList=new ArrayList<EntiteMobile>();
		calcul = new SteppedCalculator();
		entityCenter = new Etoile(new Point(0,0),20,20,"Soleil");
	}
	
	public Etoile getEntityCenter() {
		return (Etoile)entityCenter;
	}

	public void setEntityCenter(Etoile entityCenter) {
		this.entityCenter = entityCenter;
	}

	public List<EntiteMobile> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<EntiteMobile> entityList) {
		this.entityList = entityList;
	}
	
	public void addEntity(EntiteMobile em) {
		entityList.add(em);
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
