package modele;

import java.util.List;

/**
 * 20/09/2019
 * @author carpentm
 * Interface calculator permettant de faire des calcule dans d'autre classe
 *
 */
public interface Calculator {
	public void CalculNextStep(List<EntiteMobile> list);
	public void euleurExplicite(double tDebut, double tFin, EntiteMobile mobile);
	public Vecteur forceBetween(Entite v1, Entite v2);
}
