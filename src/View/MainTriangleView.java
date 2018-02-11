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
import triangleGrids.FireTriangleGrid;
import triangleGrids.LifeTriangleGrid;
import triangleGrids.PredPreyTriangleGrid;
import triangleGrids.SegregationTriangleGrid;
import triangleGrids.TriangleGrid;

public class MainTriangleView {
	
	public MainTriangleView() {
		
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
	private static int TRIANGLE_HEIGHT = (HEIGHT_SIZE-TOTAL_OFFSET-INTERFACE_BUTTON_HEIGHT)/GRID_SIZE;

	private static String SIMULATION = DataHolder.getType();

	private static Group group;
	private static Scene myScene;
	private static TriangleGrid triangleGrid;
	private static Cell[][] myTriangleCellGrid;
	private static Timeline animation;

	//list of files
	public static final File GameOfLifeFile = new File("data/GameOfLife.xml");
	public static final File FireFile = new File("data/SpreadingFire.xml");
	public static final File SegregationFile = new File("data/Segregation.xml");
	public static final File PredPreyFile = new File("data/PredPrey.xml");

	//attributes of the buttons
	private static Boolean playBoolean = false;
	
	private static void setupTriangleCellGrid(int gridSize) {
		myTriangleCellGrid = triangleGrid.createGrid(GRID_OFFSET, GRID_SIZE, TRIANGLE_HEIGHT, CUTOFF);
	}
	
	private static void setupNeighbors() {
		triangleGrid.setAllEvenNeighbors(myTriangleCellGrid, GRID_SIZE);
		triangleGrid.setAllOddNeighbors(myTriangleCellGrid, GRID_SIZE);
	}

	public static void setupGrid(String name) {
		if(name.equals("Game Of Life")) {
			triangleGrid = new LifeTriangleGrid();
			setupTriangleCellGrid(GRID_SIZE);
			setupNeighbors();
		} else if(name.equals("Spreading Fire")) {
			triangleGrid = new FireTriangleGrid();
			setupTriangleCellGrid(GRID_SIZE);
			setupNeighbors();
		} else if(name.equals("Segregation")) {
			triangleGrid = new SegregationTriangleGrid();
			setupTriangleCellGrid(GRID_SIZE);
			setupNeighbors();
		} else if(name.equals("Predator")) {
			triangleGrid = new PredPreyTriangleGrid();
			setupTriangleCellGrid(GRID_SIZE);
			setupNeighbors();
		}
	}

	public Scene initializeStartScene() {
		group = new Group();
		setupGrid(SIMULATION);
		ButtonView.createButtons();
		ButtonView.arrangeButtons();
		myScene = setupScene(myTriangleCellGrid);
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
				e -> step(SECOND_DELAY,myTriangleCellGrid));
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();  
	}

	//removed Scene stage from parameters
	public static Scene setupScene(Cell[][] myTriangleCellGrid) {
		addCells(myTriangleCellGrid);
		return new Scene(group,WIDTH_SIZE,HEIGHT_SIZE,Color.WHEAT);
	}

	public static void removeCells(Cell[][] cellGrid) {
		for(int i=0;i<cellGrid.length;i++) {
			for(int j=0;j<cellGrid[i].length;j++) {
				group.getChildren().remove(cellGrid[i][j]);
			}
		}	
	}

	public static void addCells(Cell[][] myTriangleCellGrid) {
		for(int i=0;i<myTriangleCellGrid.length;i++) {
			for(int j=0;j<myTriangleCellGrid[i].length;j++) {
				group.getChildren().add(myTriangleCellGrid[i][j]);
			}
		}
	}
	
	public static void step(double elapsedTime, Cell[][] myTriangleCellGrid) {
		if (playBoolean) {
			TriangleGrid.updateStates(myTriangleCellGrid);
//			Grid.updateStates(myTriangleCellGrid);
//			for(int i=0;i<myTriangleCellGrid.length;i++) {
//				for(int j=0;j<myTriangleCellGrid[i].length;j++) {
//					System.out.println(i);
//					System.out.println(j);
//					System.out.println(myTriangleCellGrid[i][j].getNeighborStates());
//				}
//			}	
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
			TRIANGLE_HEIGHT = (HEIGHT_SIZE-TOTAL_OFFSET-INTERFACE_BUTTON_HEIGHT)/GRID_SIZE;
			ButtonView.setTitleAuthor();
			removeCells(myTriangleCellGrid);
			setupGrid(SIMULATION);	
			addCells(myTriangleCellGrid);
		});
	}
	
	
	public static void multiplyAnimationRate(double rate) {
		animation.setRate(rate*animation.getRate());
	}
	
	public static Cell[][] getMyTriangleCellGrid() {
		return myTriangleCellGrid;
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
