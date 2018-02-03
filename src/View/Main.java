package View;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import buttons.JumpButton;
import buttons.PauseButton;
import buttons.PlayButton;
import buttons.ResetButton;
import buttons.StepButton;
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
	private static final int SIZE = 600;
	private static final int FRAMES_PER_SECOND = 60;
	private static final int MILLISECOND_DELAY = 80000 / FRAMES_PER_SECOND;
	private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private static final Color BUTTON_COLOR = Color.BLACK;
	Grid grid = new LifeGrid();
	Group group = new Group();
	//creating instance variables of the buttons
	private PlayButton playBtn;
	private ResetButton resetBtn;
	private JumpButton jumpBtn;
	private PauseButton pauseBtn;
	private StepButton stepBtn;
	
	//attributes
	public static Boolean playBoolean = false;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setMinWidth(SIZE);
		primaryStage.setMinHeight(SIZE);
		
		Cell[][] myCellGrid = grid.createGrid(10);

		grid.setNeighbors(myCellGrid);
		createButtons();
		arrangeButtons();

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

		for(int i=0;i<cellGrid.length;i++) {
			for(int j=0;j<cellGrid[i].length;j++) {
				group.getChildren().add(cellGrid[i][j]);
			}
		}
		
		Scene startScene = new Scene(group,SIZE,SIZE,Color.WHEAT);
		return startScene;
	}
	
	public void step(double elapsedTime, Cell[][] cellGrid) {
		if (playBoolean) {
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
	}
	
	//return the state of the playBoolean
	public Boolean getPlayBoolean () {
		return playBoolean;
	}
	
	//setter for boolean 
	public static Boolean setPlayBoolean(Boolean state) {
	        return playBoolean = state;
	  }
	
	//create all the buttons
	public void createButtons() {
		playBtn = new PlayButton(BUTTON_COLOR);
		resetBtn = new ResetButton(BUTTON_COLOR);
		pauseBtn = new PauseButton(BUTTON_COLOR);
		jumpBtn = new JumpButton(BUTTON_COLOR);
		stepBtn = new StepButton(BUTTON_COLOR);
		group.getChildren().addAll(playBtn, resetBtn, pauseBtn, jumpBtn, stepBtn);
	}
	
	//arrange all the buttons on the screen
	public void arrangeButtons() {
		playBtn.setPosition(100, 400);
		resetBtn.setPosition(200, 400);
		pauseBtn.setPosition(300,  400);
		jumpBtn.setPosition(400, 400);
		stepBtn.setPosition(500, 400);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
