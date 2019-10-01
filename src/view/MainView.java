package view;

import controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		new Interface(primaryStage,new MainController());
	}

	public static void main(String[] args) {
		Application.launch(args);
	}


}

