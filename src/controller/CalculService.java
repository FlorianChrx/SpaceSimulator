package controller;

import java.util.List;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import modele.Calculator;
import modele.EntiteMobile;

public class CalculService extends Service<Void> {
	
	protected List<EntiteMobile> list;
	protected Calculator calculator;
	
	public CalculService(List<EntiteMobile> list, Calculator calculator) {
		super();
		this.list = list;
		this.calculator = calculator;
	}

	@Override
	protected Task<Void> createTask() {
		return new CalculTask(null, null);
	}

}
