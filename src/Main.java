

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	
	private static final String TITLE = "Cell Society";
	private static final int SIZE = 800;
	private static final int FRAMES_PER_SECOND = 60;
	private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;

	@Override
	public void start(Stage primaryStage) throws Exception {
//		introScene = setupMenu(stage, SIZE, SIZE, WHITE);
		primaryStage.setMaxWidth(SIZE);
		primaryStage.setMaxHeight(SIZE);
//		primaryStage.setScene(introScene);
		primaryStage.setTitle(TITLE);
		primaryStage.show();

		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> step(SECOND_DELAY));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();    
	}
	
	public void step(double elapsedTime) {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
