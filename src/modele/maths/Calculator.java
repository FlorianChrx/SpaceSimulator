package modele.maths;
/**
 * 20/09/2019
 * @author carpentm
 * Interface calculator permettant de faire des calcule dans d'autre classe
 *
 */

import modele.system.SystemeSolaire;

public interface Calculator {
	public void CalculNextStep(SystemeSolaire sys);
}
