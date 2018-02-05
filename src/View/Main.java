package View;
import XML.DataHolder;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static final String TITLE = "Cell Society";
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainView simulation = new MainView();
		primaryStage.setTitle(TITLE);
		primaryStage.setScene(simulation.initializeStartScene());
		primaryStage.show();
	}

}
