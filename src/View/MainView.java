package View;

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
import rectGrids.BacteriaGrid;
import rectGrids.FireGrid;
import rectGrids.Grid;
import rectGrids.LifeGrid;
import rectGrids.PredPreyGrid;
import rectGrids.RectangleGrid;
import rectGrids.SegregationGrid;
import rectGrids.SugarGrid;
import triangleGrids.FireTriangleGrid;
import triangleGrids.LifeTriangleGrid;
import triangleGrids.PredPreyTriangleGrid;
import triangleGrids.SegregationTriangleGrid;
import triangleGrids.TriangleGrid;

/**
 * 
 * @author Hemanth Yakkali, Ryan Fu
 * Class that holds methods to start a simulation and sets layout for user interface
 */

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
	private static final int INTERFACE_BUTTON_HEIGHT = 140; //height of button layout
	private static final int TOTAL_OFFSET = GRID_OFFSET*2;
	private static final int INIT_CELL_WIDTH = (WIDTH_SIZE-TOTAL_OFFSET)/GRID_SIZE;
	private static final int INIT_CELL_HEIGHT = (HEIGHT_SIZE-TOTAL_OFFSET-INTERFACE_BUTTON_HEIGHT)/GRID_SIZE;
	private static int CELL_WIDTH = INIT_CELL_WIDTH;
	private static int CELL_HEIGHT = INIT_CELL_HEIGHT;
	private static boolean isTriangle = false;
	private static boolean isToroidal = false;
	private static boolean isChart = false;

	private static String SIMULATION = DataHolder.getType();

	private static Group group;
	private static Scene myScene;
	private static RectangleGrid grid;
	private static TriangleGrid triangleGrid;
	private static Cell[][] myCellGrid;
	private static Timeline animation;

	//list of initial files
	public static final File LIFE_FILE = new File("data/GameOfLife.xml");
	public static final File FIRE_FILE = new File("data/SpreadingFire.xml");
	public static final File SEGREGATION_FILE = new File("data/Segregation.xml");
	public static final File PRED_PREY_FILE = new File("data/PredPrey.xml");
	public static final File SUGAR_SCAPE_FILE = new File("data/SugarScape.xml");
	public static final File BACTERIA_FILE = new File("data/Bacteria.xml");

	//attributes of the buttons
	private static Boolean playBoolean = false;
	
	private static void setupCellGrid(int gridSize) {
		myCellGrid = grid.createGrid(GRID_OFFSET,gridSize,CELL_WIDTH,CELL_HEIGHT,CUTOFF);
	}
	
	/**
	 * Sets up proper cardinal neighbor configuration, either toroidal or finite based on a boolean
	 */
	private static void setupRectangleCardinalNeighbors() {
		if(isToroidal) {
			grid.setCardinalCornerToroidalNeighbors(myCellGrid,GRID_SIZE);
			grid.setCardinalSideToroidalNeighbors(myCellGrid,GRID_SIZE);
			grid.setCardinalMiddleNeighbors(myCellGrid,GRID_SIZE);
		} else {
			grid.setCardinalCornerNeighbors(myCellGrid,GRID_SIZE);
			grid.setCardinalSideNeighbors(myCellGrid,GRID_SIZE);
			grid.setCardinalMiddleNeighbors(myCellGrid,GRID_SIZE);
		}
	}
	
	/**
	 * Sets up proper surrounding neighbor configuration, either toroidal or finite based on a boolean
	 */
	private static void setupRectangleAllNeighbors() {
		if(isToroidal) {
			grid.setAllCornerToroidalNeighbors(myCellGrid,GRID_SIZE);
			grid.setAllSideToroidalNeighbors(myCellGrid,GRID_SIZE);
			grid.setAllMiddleNeighbors(myCellGrid,GRID_SIZE);
		} else {
			grid.setAllCornerNeighbors(myCellGrid,GRID_SIZE);
			grid.setAllSideNeighbors(myCellGrid,GRID_SIZE);
			grid.setAllMiddleNeighbors(myCellGrid,GRID_SIZE);
		}
	}
	
	private static void setupTriangleAllNeighbors() {
		if(isToroidal) {
			triangleGrid.setAllNormalToroidalNeighbors(myCellGrid, GRID_SIZE);
			triangleGrid.setAllInvertedToroidalNeighbors(myCellGrid, GRID_SIZE);
		}else {
			triangleGrid.setAllNormalNeighbors(myCellGrid, GRID_SIZE);
			triangleGrid.setAllInvertedNeighbors(myCellGrid, GRID_SIZE);
		}
	}
	
	private static void setupTriangleCardinalNeighbors() {
		if(isToroidal) {
			triangleGrid.setCardinalNormalToroidalNeighbors(myCellGrid, GRID_SIZE);
			triangleGrid.setCardinalInvertedToroidalNeighbors(myCellGrid, GRID_SIZE);
		}else {
			triangleGrid.setCardinalNormalNeighbors(myCellGrid, GRID_SIZE);
			triangleGrid.setCardinalInvertedNeighbors(myCellGrid, GRID_SIZE);
		}
	}
	
	private static void setupTriangleGrid(int gridSize) {
		myCellGrid = triangleGrid.createGrid(GRID_OFFSET, gridSize, CELL_HEIGHT,CELL_WIDTH,CUTOFF);
	}

	/**
	 * 
	 * @param name String containing name of the simulation
	 * Sets up a rectangle grid for a specific simulation
	 */
	public static void setupGrid(String name) {
		if(name.equals("Game Of Life")) {
			grid = new LifeGrid();
			setupCellGrid(GRID_SIZE);
			setupRectangleAllNeighbors();
		} else if(name.equals("Spreading Fire")) {
			grid = new FireGrid();
			setupCellGrid(GRID_SIZE);
			setupRectangleCardinalNeighbors();
		} else if(name.equals("Segregation")) {
			grid = new SegregationGrid();
			setupCellGrid(GRID_SIZE);
			setupRectangleAllNeighbors();
		} else if(name.equals("Predator")) {
			grid = new PredPreyGrid();
			setupCellGrid(GRID_SIZE);
			setupRectangleCardinalNeighbors();
		} else if(name.equals("SugarScape")) {
			grid = new SugarGrid();
			setupCellGrid(GRID_SIZE);
			setupRectangleCardinalNeighbors();
		} else if(name.equals("Bacteria")) {
			grid = new BacteriaGrid();
			setupCellGrid(GRID_SIZE);
			setupRectangleCardinalNeighbors();
		}
	}
	
	/**
	 * 
	 * @param name String containing name of the simulation
	 * Sets up a triangle grid for a specific simulation
	 */
	public static void setupTriangleGrid(String name) {
		if(name.equals("Game Of Life")) {
			triangleGrid = new LifeTriangleGrid();
			setupTriangleGrid(GRID_SIZE);
			setupTriangleAllNeighbors();
		} else if(name.equals("Spreading Fire")) {
			triangleGrid = new FireTriangleGrid();
			setupTriangleGrid(GRID_SIZE);
			setupTriangleCardinalNeighbors();
		} else if(name.equals("Segregation")) {
			triangleGrid = new SegregationTriangleGrid();
			setupTriangleGrid(GRID_SIZE);
			setupTriangleAllNeighbors();
		} else if(name.equals("Predator")) {
			triangleGrid = new PredPreyTriangleGrid();
			setupTriangleGrid(GRID_SIZE);
			setupTriangleCardinalNeighbors();
		}
	}
	
	public Scene initializeStartScene() {
		group = new Group();
		if(isTriangle) {
			setupTriangleGrid(SIMULATION);
		} else {
			setupGrid(SIMULATION);
		}
		ButtonView.createButtons();
		ButtonView.arrangeButtons();
		myScene = setupScene();
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

	/**
	 * 
	 * @return New scene with the grid, buttons, and a background color
	 */
	public static Scene setupScene() {
		addCells();
		return new Scene(group,WIDTH_SIZE,HEIGHT_SIZE,Color.WHEAT);
	}

	/**
	 * Removes cells from the scene
	 */
	public static void removeCells() {
		for(int i=0;i<myCellGrid.length;i++) {
			for(int j=0;j<myCellGrid[i].length;j++) {
				group.getChildren().remove(myCellGrid[i][j]);
			}
		}	
	}

	/**
	 * Adds cells to the scene
	 */
	public static void addCells() {
		for(int i=0;i<myCellGrid.length;i++) {
			for(int j=0;j<myCellGrid[i].length;j++) {
				group.getChildren().add(myCellGrid[i][j]);
			}
		}
	}

	public static void step(double elapsedTime, Cell[][] cellGrid) {
		if (playBoolean) {
			grid.updateStates(cellGrid);
		}
	}
	
	/**
	 * Switches simulation, recreates the grid
	 */
	public static void switchSimulation() {
		removeCells();
		if(isTriangle) {
			setupTriangleGrid(SIMULATION);	
		} else {
			setupGrid(SIMULATION);	
		}
		addCells();
	}
	
	/**
	 * Switch shape from rectangle to triangle and vice versa
	 */
	public static void switchShape() {
		isTriangle = !isTriangle;
	}
	
	/**
	 * Switch neighbor configuration from toroidal to finite and vice versa
	 */
	public static void switchNeighborConfig() {
		isToroidal = !isToroidal;
	}

	/**
	 * Create the file selector drop down menu
	 */
	public static void createDropDownMenu() {
		ObservableList<File> fileList = FXCollections.observableArrayList(LIFE_FILE, FIRE_FILE, SEGREGATION_FILE, PRED_PREY_FILE,
				SUGAR_SCAPE_FILE);
		ButtonView.setFileSelector(new ComboBox<>(fileList));
		ButtonView.getFileSelector().setOnAction(e->{
			DataHolder.clearXMLReader();
			//XMLReader newFile = new XMLReader(DataHolder.getInputFile());
			DataHolder.setInputFile((File) ButtonView.getFileSelector().getValue()); //change new file
			DataHolder.setFileInput(new XMLReader(DataHolder.getInputFile()));
		//	DataHolder.setFileInput(newFile);
			SIMULATION = DataHolder.getType();
			GRID_SIZE = DataHolder.getDimensions();
			CELL_WIDTH = (WIDTH_SIZE-TOTAL_OFFSET)/GRID_SIZE;
			CELL_HEIGHT = (HEIGHT_SIZE-TOTAL_OFFSET-INTERFACE_BUTTON_HEIGHT)/GRID_SIZE;
			ButtonView.setTitleAuthor();
			switchSimulation();
			if(isCharting()) {
				ChartView.updateChartAttributes();
			}
		});
	}
	
	public static void setAnimationRate(double rate) {
		System.out.println(animation.getRate());
		animation.setRate(rate);
		if (isChart) {
			ChartView.updateChartAnimationRate(rate);
		}
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
	
	public static boolean isCharting() {
		return isChart;
	}
	
	public static void setChartBoolean(boolean b) {
		isChart = b;
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
	
	public static Grid getGrid() {
		return grid;
	}
	
}
