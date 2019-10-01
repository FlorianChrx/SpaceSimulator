package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		new Interface(primaryStage);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}


}

