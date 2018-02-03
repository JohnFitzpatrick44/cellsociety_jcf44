package View;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Main simulation = new Main();
		primaryStage.setTitle("Cell Society");
		primaryStage.setScene(simulation.initializeStartScene());
		primaryStage.show();
	}

}
