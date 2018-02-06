package View;

import java.io.File;

import XML.DataHolder;
import XML.XMLReader;
import buttons.JumpButton;
import buttons.PauseButton;
import buttons.PlayButton;
import buttons.ResetButton;
import buttons.SlowButton;
import buttons.SpeedButton;
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
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MainView {
	
	public static final int GRID_OFFSET = 10;
	private static final int WIDTH_SIZE = 420;
	private static final int HEIGHT_SIZE = 520;
	private static final int FRAMES_PER_SECOND = 60;
	public static int ANIMATION_SPEED = 100000;
	private static int MILLISECOND_DELAY = ANIMATION_SPEED / FRAMES_PER_SECOND;
	public static double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private static final Color BUTTON_COLOR = Color.BLACK;	
	private static final int GRID_SIZE = DataHolder.getDimensions();

	public static String SIMULATION = DataHolder.getType();
	
	public static Group group;
	public static Scene myScene;
	public static Grid grid;
	public static Cell[][] myCellGrid;
	public static Timeline animation;
	
	//list of files
	File GameOfLifeFile = new File("data/GameOfLife.xml");
	File FireFile = new File("data/SpreadingFire.xml");
	File SegregationFile = new File("data/Segregation.xml");
	File PredPreyFile = new File("data/PredPrey.xml");
	
	//creating instance variables of the buttons
	private PlayButton playBtn;
	private ResetButton resetBtn;
	private JumpButton jumpBtn;
	private PauseButton pauseBtn;
	private StepButton stepBtn;
	private SpeedButton speedBtn;
	private SlowButton slowBtn;
	private ComboBox<File> fileSelector;
	public static TextField jumpField;
	private Text title;
	
	//attributes of the buttons
	public static Boolean playBoolean = false;
	private static final int BUTTON_Y_POSITION = 440;
	private static final int BUTTONROW2_Y_POSITION = 480;
	private static final int PLAYBTN_X_POSITION = 20;
	private static final int PAUSEBTN_X_POSITION = 90;
	private static final int STEPBTN_X_POSITION = 160;
	private static final int RESETBTN_X_POSITION = 225;
	private static final int JUMPBTN_X_POSITION = 310;
	private static final int JUMPTXTFIELD_X_POSITION = 310;
	private static final int JUMPTXT_DIMENSIONS = 80;
	private static final int TITLE_X_POSITION = 140;
	private static final int TITLE_Y_POSITION = 430;
	private static final int SPEEDBTN_X_POSITION = 260;
	private static final int SLOWBTN_X_POSITION = 220;
	
	
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
	
	public static void beginAnimationLoop() {
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> step(SECOND_DELAY,myCellGrid));
		animation = new Timeline();
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
	
	public static void step(double elapsedTime, Cell[][] cellGrid) {
		if (playBoolean) {
			Grid.updateStates(cellGrid);
		}
	}
	
	//create the file selector drop down menu
	private void createDropDownMenu() {
		ObservableList<File> fileList = FXCollections.observableArrayList(GameOfLifeFile, FireFile, SegregationFile, PredPreyFile);
		fileSelector = new ComboBox<File>(fileList);
		fileSelector.setOnAction(e->{
			DataHolder.INPUTFILE = (File) fileSelector.getValue(); //change new file
			DataHolder.fileInput = new XMLReader(DataHolder.INPUTFILE);
			SIMULATION = DataHolder.getType();
			setTitleAuthor();
			removeCells(myCellGrid);
			setupGrid(SIMULATION);	
			addCells(myCellGrid);
		});
	}
	
	//update the title with the name of the simulation and the author
	private void setTitleAuthor() {
		title.setText(DataHolder.getType()+" by "+DataHolder.getAuthor());
	}
	
	//create all the buttons
	private void createButtons() {
		playBtn = new PlayButton(BUTTON_COLOR);
		resetBtn = new ResetButton(BUTTON_COLOR);
		pauseBtn = new PauseButton(BUTTON_COLOR);
		jumpBtn = new JumpButton(BUTTON_COLOR);
		stepBtn = new StepButton(BUTTON_COLOR);
		speedBtn = new SpeedButton(BUTTON_COLOR);
		slowBtn = new SlowButton(BUTTON_COLOR);
		jumpField = new TextField();
		title = new Text();
		setTitleAuthor();
		createDropDownMenu();
		group.getChildren().addAll(playBtn, resetBtn, pauseBtn, jumpBtn, stepBtn, fileSelector, jumpField, title, slowBtn, speedBtn);
	}
	
	//arrange all the buttons on the screen
	private void arrangeButtons() {
		playBtn.setPosition(PLAYBTN_X_POSITION, BUTTON_Y_POSITION);
		pauseBtn.setPosition(PAUSEBTN_X_POSITION,  BUTTON_Y_POSITION);
		stepBtn.setPosition(STEPBTN_X_POSITION, BUTTON_Y_POSITION);
		resetBtn.setPosition(RESETBTN_X_POSITION, BUTTON_Y_POSITION);
		jumpBtn.setPosition(JUMPBTN_X_POSITION, BUTTON_Y_POSITION);
		speedBtn.setPosition(SPEEDBTN_X_POSITION, BUTTONROW2_Y_POSITION);
		slowBtn.setPosition(SLOWBTN_X_POSITION, BUTTONROW2_Y_POSITION);
		fileSelector.setLayoutY(BUTTONROW2_Y_POSITION);
		fileSelector.setLayoutX(PLAYBTN_X_POSITION);
		jumpField.setLayoutX(JUMPTXTFIELD_X_POSITION);
		jumpField.setLayoutY(BUTTONROW2_Y_POSITION);
		jumpField.setMaxWidth(JUMPTXT_DIMENSIONS);
		title.setLayoutX(TITLE_X_POSITION);
		title.setLayoutY(TITLE_Y_POSITION);
	}
}
