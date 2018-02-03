package View;
import buttons.JumpButton;
import buttons.PauseButton;
import buttons.PlayButton;
import buttons.ResetButton;
import buttons.StepButton;
import cellTypes.Cell;
import cellTypes.LifeCell;
import gridTypes.FireGrid;
import gridTypes.Grid;
import gridTypes.LifeGrid;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Main {
	
	private static final String TITLE = "Cell Society";
	public static final int GRID_OFFSET = 10;
	private static final int WIDTH_SIZE = 420;
	private static final int HEIGHT_SIZE = 460;
	private static final int FRAMES_PER_SECOND = 60;
	private static final int MILLISECOND_DELAY = 10000 / FRAMES_PER_SECOND;
	private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private static final Color BUTTON_COLOR = Color.BLACK;
	private Group group;
	private Scene myScene;
	private Grid grid;
	public static Cell[][] myCellGrid;
	//creating instance variables of the buttons
	private PlayButton playBtn;
	private ResetButton resetBtn;
	private JumpButton jumpBtn;
	private PauseButton pauseBtn;
	private StepButton stepBtn;
	//attributes of the buttons
	private static final int BUTTON_Y_POSITION = 420;
	private static final int PLAYBTN_X_POSITION = 20;
	private static final int PAUSEBTN_X_POSITION = 90;
	private static final int STEPBTN_X_POSITION = 160;
	private static final int RESETBTN_X_POSITION = 240;
	private static final int JUMPBTN_X_POSITION = 310;
	private void setupGrid(String name) {
		if(name.equals("Life")) {
			grid = new LifeGrid();
		} else if(name.equals("Fire")) {
			grid = new FireGrid();
		}
	}
	
	//attributes
	public static Boolean playBoolean = false;
	
	public Scene initializeStartScene() {
		group = new Group();
		setupGrid("Life");
		myCellGrid = grid.createGrid(GRID_OFFSET,20,20,0.5);
		grid.setNeighbors(myCellGrid);
		createButtons();
		arrangeButtons();
		myScene = setupScene(myCellGrid);
		beginAnimationLoop();  //start the animation process
		return myScene;
		
	}
	
	public void beginAnimationLoop() {
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> step(SECOND_DELAY,myCellGrid));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();  
	}
	
	//removed Scene stage from parameters
	private Scene setupScene(Cell[][] cellGrid) {
		for(int i=0;i<cellGrid.length;i++) {
			for(int j=0;j<cellGrid[i].length;j++) {
				group.getChildren().add(cellGrid[i][j]);
			}
		}	
		Scene startScene = new Scene(group,WIDTH_SIZE,HEIGHT_SIZE,Color.WHEAT);
		return startScene;
	}
	
	public void step(double elapsedTime, Cell[][] cellGrid) {
		if (playBoolean) {
			Grid.updateStates(cellGrid);
//			for(int i=0;i<cellGrid.length;i++) {
//				for(int j=0;j<cellGrid[i].length;j++) {
//					System.out.println(cellGrid[i][j]);
//					System.out.println(cellGrid[i][j].getState());
//					System.out.print(i+" "+j);
//					System.out.println(cellGrid[i][j].getNeighborStates());
//				}
//			}
		}
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
		playBtn.setPosition(PLAYBTN_X_POSITION, BUTTON_Y_POSITION);
		pauseBtn.setPosition(PAUSEBTN_X_POSITION,  BUTTON_Y_POSITION);
		stepBtn.setPosition(STEPBTN_X_POSITION, BUTTON_Y_POSITION);
		resetBtn.setPosition(RESETBTN_X_POSITION, BUTTON_Y_POSITION);
		jumpBtn.setPosition(JUMPBTN_X_POSITION, BUTTON_Y_POSITION);
		
	}
}
