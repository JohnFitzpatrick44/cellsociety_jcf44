package View;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import XML.DataHolder;
import XML.XMLReader;
import buttons.JumpButton;
import buttons.PauseButton;
import buttons.PlayButton;
import buttons.ResetButton;
import buttons.StepButton;
import cellTypes.Cell;
import gridTypes.FireGrid;
import gridTypes.Grid;
import gridTypes.LifeGrid;
import gridTypes.PredPreyGrid;
import gridTypes.SegregationGrid;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MainView {
	
	public static final int GRID_OFFSET = 10;
	private static final int WIDTH_SIZE = 420;
	private static final int HEIGHT_SIZE = 500;
	private static final int FRAMES_PER_SECOND = 60;
	private static final int ANIMATION_SPEED = DataHolder.getAnimationSpeed();
	private static final int MILLISECOND_DELAY = ANIMATION_SPEED / FRAMES_PER_SECOND;
	private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private static final Color BUTTON_COLOR = Color.BLACK;	
	private static final int GRID_SIZE = DataHolder.getDimensions();
	public static String SIMULATION = DataHolder.getType();
	
	public static Group group;
	public static Scene myScene;
	public static Grid grid;
	public static Cell[][] myCellGrid;
	//list of files
	File GameOfLifeFile = new File("data/GameOfLife.xml");
	File FireFile = new File("data/SpreadingFire.xml");
	
	//creating instance variables of the buttons
	private PlayButton playBtn;
	private ResetButton resetBtn;
	private JumpButton jumpBtn;
	private PauseButton pauseBtn;
	private StepButton stepBtn;
	private ComboBox<File> fileSelector;
	
	//attributes of the buttons
	public static Boolean playBoolean = false;
	private static final int BUTTON_Y_POSITION = 420;
	private static final int BUTTONROW2_Y_POSITION = 460;
	private static final int PLAYBTN_X_POSITION = 20;
	private static final int PAUSEBTN_X_POSITION = 90;
	private static final int STEPBTN_X_POSITION = 160;
	private static final int RESETBTN_X_POSITION = 240;
	private static final int JUMPBTN_X_POSITION = 310;
	
	private static void setupCellGrid() {
		myCellGrid = grid.createGrid(GRID_OFFSET,GRID_SIZE,GRID_SIZE,0.5);
	}
	
	public static void setupGrid(String name) {
		if(name.equals("Game Of Life")) {
			grid = new LifeGrid();
			setupCellGrid();
			grid.setAllNeighbors(myCellGrid);
		} else if(name.equals("Spreading Fire")) {
			grid = new FireGrid();
			setupCellGrid();
			grid.setImmediateNeighbors(myCellGrid);
		} else if(name.equals("Segregation")) {
			grid = new SegregationGrid();
			setupCellGrid();
			grid.setAllNeighbors(myCellGrid);
		} else if(name.equals("Predator")) {
			grid = new PredPreyGrid();
			setupCellGrid();
			grid.setImmediateNeighbors(myCellGrid);
		}
	}
		
	public Scene initializeStartScene() {
		group = new Group();
		setupGrid(SIMULATION);
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
	public static Scene setupScene(Cell[][] cellGrid) {
		addCells(cellGrid);
		Scene startScene = new Scene(group,WIDTH_SIZE,HEIGHT_SIZE,Color.WHEAT);
		return startScene;
	}
	
	public static void removeCells(Cell[][] cellGrid) {
		for(int i=0;i<cellGrid.length;i++) {
			for(int j=0;j<cellGrid[i].length;j++) {
				group.getChildren().remove(cellGrid[i][j]);
			}
		}	
	}
	
	public static void addCells(Cell[][] cellGrid) {
		for(int i=0;i<cellGrid.length;i++) {
			for(int j=0;j<cellGrid[i].length;j++) {
				group.getChildren().add(cellGrid[i][j]);
			}
		}	
	}
	
	public void step(double elapsedTime, Cell[][] cellGrid) {
		if (playBoolean) {
			Grid.updateStates(cellGrid);
		}
	}
	
	//create the file selector drop down menu
	public void createDropDownMenu() {
		ObservableList<File> fileList = FXCollections.observableArrayList(GameOfLifeFile, FireFile);
		fileSelector = new ComboBox<File>(fileList);
		fileSelector.setOnAction(e->{
			DataHolder.INPUTFILE = (File) fileSelector.getValue(); //change new file
			DataHolder.fileInput = new XMLReader(DataHolder.INPUTFILE);
			SIMULATION = DataHolder.getType();
			System.out.println(SIMULATION);
			removeCells(myCellGrid);
			setupGrid(SIMULATION);	
			addCells(myCellGrid);
			
			//ResetButton.reset();
		});
	}
	
	
	//create all the buttons
	public void createButtons() {
		playBtn = new PlayButton(BUTTON_COLOR);
		resetBtn = new ResetButton(BUTTON_COLOR);
		pauseBtn = new PauseButton(BUTTON_COLOR);
		jumpBtn = new JumpButton(BUTTON_COLOR);
		stepBtn = new StepButton(BUTTON_COLOR);
		createDropDownMenu();
		group.getChildren().addAll(playBtn, resetBtn, pauseBtn, jumpBtn, stepBtn, fileSelector);
	}
	
	//arrange all the buttons on the screen
	public void arrangeButtons() {
		playBtn.setPosition(PLAYBTN_X_POSITION, BUTTON_Y_POSITION);
		pauseBtn.setPosition(PAUSEBTN_X_POSITION,  BUTTON_Y_POSITION);
		stepBtn.setPosition(STEPBTN_X_POSITION, BUTTON_Y_POSITION);
		resetBtn.setPosition(RESETBTN_X_POSITION, BUTTON_Y_POSITION);
		jumpBtn.setPosition(JUMPBTN_X_POSITION, BUTTON_Y_POSITION);
		fileSelector.setLayoutY(BUTTONROW2_Y_POSITION);
		fileSelector.setLayoutX(PLAYBTN_X_POSITION);
	}
}
