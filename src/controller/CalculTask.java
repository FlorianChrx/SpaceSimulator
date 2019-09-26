package controller;

import java.util.List;

import javafx.concurrent.Task;
import modele.Calculator;
import modele.EntiteMobile;

public class CalculTask extends Task<Void> {
	
	protected List<EntiteMobile> list;
	protected Calculator calculator;

	public CalculTask(List<EntiteMobile> list, Calculator calculator) {
		super();
		this.list = list;
		this.calculator = calculator;
	}

	@Override
	protected Void call() throws Exception {
		calculator.CalculNextStep(list);
		return null;
	}

}
