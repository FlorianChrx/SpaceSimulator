package controller;

import java.util.List;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import modele.Calculator;
import modele.EntiteMobile;

public class CalculService extends Service<Void> {
	
	protected List<EntiteMobile> list;
	protected Calculator calculator;
	protected int ralentissement;
	
	public CalculService(List<EntiteMobile> list, Calculator calculator) {
		super();
		this.list = list;
		this.calculator = calculator;
	}

	@Override
	protected Task<Void> createTask() {
		return new CalculTask();
	}
	
	public class CalculTask extends Task<Void> {
		@Override
		protected Void call() throws Exception {
			calculator.CalculNextStep(list);
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
