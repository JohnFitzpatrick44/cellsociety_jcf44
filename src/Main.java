

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	Grid grid = new Grid();

	@Override
	public void start(Stage primaryStage) throws Exception {
//		introScene = setupMenu(stage, SIZE, SIZE, WHITE);
		primaryStage.setMinWidth(SIZE);
		primaryStage.setMinHeight(SIZE);
//		primaryStage.setScene(introScene);
		
		Cell[][] myCellGrid = grid.createGrid();
//		for(Cell[] cell: Arrays.asList(myCellGrid)) {
//			
//		}
		grid.setNeighbors(myCellGrid);
		
		for(int i=0;i<myCellGrid.length;i++) {
			for(int j=0;j<myCellGrid[i].length;j++) {
//				System.out.println(myCellGrid[i][j]);
//				System.out.println(myCellGrid[i][j].getState());
				System.out.println(i);
				System.out.println(j);
				System.out.println(myCellGrid[i][j].getNeighborStates());
			}
		}

		primaryStage.setScene(setupScene(primaryStage,myCellGrid));
		primaryStage.setTitle(TITLE);
		primaryStage.show();
		
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> step(SECOND_DELAY,myCellGrid));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();    
	}
	
	private Scene setupScene(Stage stage, Cell[][] cellGrid) {
		Group group = new Group();
		for(int i=0;i<cellGrid.length;i++) {
			for(int j=0;j<cellGrid[i].length;j++) {
				group.getChildren().add(cellGrid[i][j]);
			}
		}
		
		Scene startScene = new Scene(group,SIZE,SIZE,Color.WHEAT);
		return startScene;
	}
	
	public void step(double elapsedTime, Cell[][] cellGrid) {
		grid.updateStates(cellGrid);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
