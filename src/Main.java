

import cellTypes.Cell;
import cellTypes.LifeCell;
import gridTypes.Grid;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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
		primaryStage.setMinWidth(SIZE);
		primaryStage.setMinHeight(SIZE);
//		primaryStage.setScene(introScene);

		primaryStage.setScene(setupGrid(primaryStage));
		primaryStage.setTitle(TITLE);
		primaryStage.show();
		
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> step(SECOND_DELAY));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();    
	}
	
	private Scene setupGrid(Stage stage) {
		Group group = new Group();
		Grid grid = new Grid();
		Cell[][] cellGrid = grid.createGrid();
	
		for(int i=0;i<cellGrid.length;i++) {
			for(int j=0;j<cellGrid[i].length;j++) {
				group.getChildren().add(cellGrid[i][j]);
			}
		}
		
		Scene startScene = new Scene(group,SIZE,SIZE,Color.WHEAT);
		return startScene;
	}
	
	public void step(double elapsedTime) {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
