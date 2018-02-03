

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import buttons.JumpButton;
import buttons.PauseButton;
import buttons.PlayButton;
import buttons.ResetButton;
import cellTypes.Cell;
import cellTypes.LifeCell;
import gridTypes.Grid;
import gridTypes.LifeGrid;
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
	private static final int MILLISECOND_DELAY = 80000 / FRAMES_PER_SECOND;
	private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private static final Color BUTTON_COLOR = Color.BLACK;
	Grid grid = new LifeGrid();

	//creating instance variables of the buttons
	private PlayButton playBtn;
	private ResetButton resetBtn;
	private JumpButton jumpBtn;
	private PauseButton pauseBtn;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setMinWidth(SIZE);
		primaryStage.setMinHeight(SIZE);
		
		Cell[][] myCellGrid = grid.createGrid(200);

		grid.setNeighbors(myCellGrid);

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
		for(int i=0;i<cellGrid.length;i++) {
			for(int j=0;j<cellGrid[i].length;j++) {
//				System.out.println(cellGrid[i][j]);
//				System.out.println(cellGrid[i][j].getState());
				System.out.print(i+" "+j);
				System.out.println(cellGrid[i][j].getNeighborStates());
			}
		}
	}
	//create all the buttons
	public void createButtons() {
		playBtn = new PlayButton(BUTTON_COLOR);
		resetBtn = new ResetButton(BUTTON_COLOR);
		pauseBtn = new PauseButton(BUTTON_COLOR);
		jumpBtn = new JumpButton(BUTTON_COLOR);
	}
	//arrange all the buttons on the screen
	public void arrangeButtons() {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
