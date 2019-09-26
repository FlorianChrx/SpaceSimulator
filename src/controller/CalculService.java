package controller;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class CalculService extends Service<Void> {
	
	@Override
	protected Task<Void> createTask() {
		return new CalculTask();
	}

}
