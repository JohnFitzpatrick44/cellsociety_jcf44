package View;
import View.ChartView;

import java.io.File;

import XML.DataHolder;
import XML.XMLReader;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import rectCells.Cell;
import rectGrids.FireGrid;
import rectGrids.Grid;
import rectGrids.LifeGrid;
import rectGrids.PredPreyGrid;
import rectGrids.RectangleGrid;
import rectGrids.SegregationGrid;

public class MainView {

	public MainView() {
	}
	
	private static final double CUTOFF = 0.5;
	private static final int GRID_OFFSET = 10;
	private static final int WIDTH_SIZE = 420;
	private static final int HEIGHT_SIZE = 520;
	private static final int FRAMES_PER_SECOND = 60;
	private static final int ANIMATION_SPEED = 100000;
	private static final int MILLISECOND_DELAY = ANIMATION_SPEED / FRAMES_PER_SECOND;
	private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private static int GRID_SIZE = DataHolder.getDimensions();
	private static final int INTERFACE_BUTTON_HEIGHT = 100;
	private static final int TOTAL_OFFSET = GRID_OFFSET*2;
	private static final int INIT_CELL_WIDTH = (WIDTH_SIZE-TOTAL_OFFSET)/GRID_SIZE;
	private static final int INIT_CELL_HEIGHT = (HEIGHT_SIZE-TOTAL_OFFSET-INTERFACE_BUTTON_HEIGHT)/GRID_SIZE;
	private static int CELL_WIDTH = INIT_CELL_WIDTH;
	private static int CELL_HEIGHT = INIT_CELL_HEIGHT;

	private static String SIMULATION = DataHolder.getType();

	private static Group group;
	private static Scene myScene;
	private static RectangleGrid grid;
	private static Cell[][] myCellGrid;
	private static Timeline animation;

	//list of initial files
	public static final File GameOfLifeFile = new File("data/GameOfLife.xml");
	public static final File FireFile = new File("data/SpreadingFire.xml");
	public static final File SegregationFile = new File("data/Segregation.xml");
	public static final File PredPreyFile = new File("data/PredPrey.xml");

	//attributes of the buttons
	private static Boolean playBoolean = false;
	

	private static void setupCellGrid(int gridSize) {
		myCellGrid = grid.createGrid(GRID_OFFSET,gridSize,CELL_WIDTH,CELL_HEIGHT,CUTOFF);
	}
	
	private static void setupAllNeighbors(Cell[][] myCellGrid) {
		grid.setAllCornerNeighbors(myCellGrid,GRID_SIZE);
		grid.setAllSideNeighbors(myCellGrid,GRID_SIZE);
		grid.setAllMiddleNeighbors(myCellGrid,GRID_SIZE);
	}
	
	private static void setupCardinalNeighbors(Cell[][] myCellGrid) {
		grid.setCardinalCornerNeighbors(myCellGrid,GRID_SIZE);
		grid.setCardinalSideNeighbors(myCellGrid,GRID_SIZE);
		grid.setCardinalMiddleNeighbors(myCellGrid,GRID_SIZE);
	}

	public static void setupGrid(String name, Cell[][] myCellGrid) {
		if(name.equals("Game Of Life")) {
			grid = new LifeGrid();
			setupCellGrid(GRID_SIZE);
			setupAllNeighbors(myCellGrid);
		} else if(name.equals("Spreading Fire")) {
			grid = new FireGrid();
			setupCellGrid(GRID_SIZE);
			setupCardinalNeighbors(myCellGrid);
		} else if(name.equals("Segregation")) {
			grid = new SegregationGrid();
			setupCellGrid(GRID_SIZE);
			setupAllNeighbors(myCellGrid);
		} else if(name.equals("Predator")) {
			grid = new PredPreyGrid();
			setupCellGrid(GRID_SIZE);
			setupCardinalNeighbors(myCellGrid);
		}
	}

	public Scene initializeStartScene() {
		group = new Group();
		setupGrid(SIMULATION, myCellGrid);
		ButtonView.createButtons();
		ButtonView.arrangeButtons();
		myScene = setupScene(myCellGrid);
		beginAnimationLoop();  //start the animation process
		myScene.addEventFilter(MouseEvent.DRAG_DETECTED , new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				myScene.startFullDrag();
			}
		});
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
	public static Scene setupScene(Cell[][] myCellGrid) {
		addCells(myCellGrid);
		return new Scene(group,WIDTH_SIZE,HEIGHT_SIZE,Color.WHEAT);
	}

	public static void removeCells(Cell[][] myCellGrid) {
		for(int i=0;i<myCellGrid.length;i++) {
			for(int j=0;j<myCellGrid[i].length;j++) {
				group.getChildren().remove(myCellGrid[i][j]);
			}
		}	
	}

	public static void addCells(Cell[][] myCellGrid) {
		for(int i=0;i<myCellGrid.length;i++) {
			for(int j=0;j<myCellGrid[i].length;j++) {
				group.getChildren().add(myCellGrid[i][j]);
			}
		}
	}

	public static void step(double elapsedTime, Cell[][] cellGrid) {
		if (playBoolean) {
			Grid.updateStates(cellGrid);
			for(int i=0;i<cellGrid.length;i++) {
				for(int j=0;j<cellGrid[i].length;j++) {
					System.out.println(i);
					System.out.println(j);
					System.out.println(cellGrid[i][j].getNeighborStates());
				}
			}	
		}
		
	}

	//create the file selector drop down menu
	
	public static void createDropDownMenu() {
		ObservableList<File> fileList = FXCollections.observableArrayList(MainView.GameOfLifeFile, MainView.FireFile, MainView.SegregationFile, MainView.PredPreyFile);
		ButtonView.setFileSelector(new ComboBox<>(fileList));
		ButtonView.getFileSelector().setOnAction(e->{
			DataHolder.setInputFile((File) ButtonView.getFileSelector().getValue()); //change new file
			DataHolder.setFileInput(new XMLReader(DataHolder.getInputFile()));
			SIMULATION = DataHolder.getType();
			GRID_SIZE = DataHolder.getDimensions();
			CELL_WIDTH = (WIDTH_SIZE-TOTAL_OFFSET)/GRID_SIZE;
			CELL_HEIGHT = (HEIGHT_SIZE-TOTAL_OFFSET-INTERFACE_BUTTON_HEIGHT)/GRID_SIZE;
			ButtonView.setTitleAuthor();
			removeCells(myCellGrid);
			setupGrid(SIMULATION, myCellGrid);	
			addCells(myCellGrid);
		});
	}
	
	
	public static void setAnimationRate(double rate) {
		System.out.println(animation.getRate());
		animation.setRate(rate);
		ChartView.updateChartAnimationRate(rate);
	
	}
	
	public static Cell[][] getMyCellGrid() {
		return myCellGrid;
	}
	
	public static String getSimulation() {
		return SIMULATION;
	}
	
	public static boolean isPlaying() {
		return playBoolean;
	}
	
	public static void setPlaying(boolean b) {
		playBoolean = b;
	}
	
	public static Group getGroup() {
		return group;
	}
	
	public static void setSimulation(String s) {
		SIMULATION = s;
	}
	
}
