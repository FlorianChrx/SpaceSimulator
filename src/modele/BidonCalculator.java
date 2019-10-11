package modele;

public class BidonCalculator implements Calculator {
	
	SystemeSolaire sol = new SystemeSolaire();
	int var = 0;

	@Override
	public void CalculNextStep(SystemeSolaire s) {
		if(var%30 == 0) var *= -1;
		for (EntiteMobile entite :s.getEntityList()) {
			entite.setPosition(new Point(entite.getPosition().getX()+var, entite.getPosition().getY()+var));
		}
		var++;
	}

}
