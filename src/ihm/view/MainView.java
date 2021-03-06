package ihm.view;

import ihm.controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainController m = new MainController();
		new Interface(primaryStage, m);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
