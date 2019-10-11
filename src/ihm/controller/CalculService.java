package ihm.controller;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import modele.maths.Calculator;
import modele.system.SystemeSolaire;

public class CalculService extends Service<Void> {
	
	protected SystemeSolaire sol;
	protected Calculator calculator;
	protected int ralentissement;
	
	/**
	 * @param list
	 * @param calculator
	 */
	public CalculService(SystemeSolaire sol, Calculator calculator) {
		super();
		this.sol = sol;
		this.calculator = calculator;
	}

	@Override
	protected Task<Void> createTask() {
		return new CalculTask();
	}
	
	public class CalculTask extends Task<Void> {
		@Override
		protected Void call() throws Exception {
			calculator.CalculNextStep(sol);
			Thread.sleep(ralentissement);
			return null;
		}
	}

	public int getRalentissement() {
		return ralentissement;
	}

	public void setRalentissement(int ralentissement) {
		this.ralentissement = ralentissement;
	}
	
}
