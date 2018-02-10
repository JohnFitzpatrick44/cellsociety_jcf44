package View;

import java.io.File;
import cellTypes.CellMover;
import XML.DataHolder;
import XML.XMLReader;
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
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ChartView {

	public ChartView() {
	}
	
	private static final int GRID_OFFSET = 10;
	private static final int WIDTH_SIZE = 500;
	private static final int HEIGHT_SIZE = 430;
	private static final int FRAMES_PER_SECOND = 60;
	private static final int ANIMATION_SPEED = 100000;
	private static final int MILLISECOND_DELAY = ANIMATION_SPEED / FRAMES_PER_SECOND;
	private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private static int GRID_SIZE = DataHolder.getDimensions();
	private static final int INTERFACE_BUTTON_HEIGHT = 110;
	private static final int INIT_CELL_WIDTH = (WIDTH_SIZE-2*GRID_OFFSET)/GRID_SIZE;
	private static final int INIT_CELL_HEIGHT = (HEIGHT_SIZE-2*GRID_OFFSET-INTERFACE_BUTTON_HEIGHT)/GRID_SIZE;
	private static int CELL_WIDTH = INIT_CELL_WIDTH;
	private static int CELL_HEIGHT = INIT_CELL_HEIGHT;
	private static final int TOTAL_OFFSET = GRID_OFFSET*2;

	private static String SIMULATION = DataHolder.getType();

	private static Group chartGroup;
	private static Scene chartScene;
	private static Grid grid;
	private static Cell[][] myCellGrid;
	private static Timeline animation;

	//list of initial files
	public static final File GameOfLifeFile = new File("data/GameOfLife.xml");
	public static final File FireFile = new File("data/SpreadingFire.xml");
	public static final File SegregationFile = new File("data/Segregation.xml");
	public static final File PredPreyFile = new File("data/PredPrey.xml");

	//attributes of the buttons
	private static Boolean playBoolean = false;
    private static XYChart.Series<Number, Number> series = new XYChart.Series<Number,Number>();
    
	public Scene initializeStartScene() {
		chartGroup = new Group();
		chartScene = new Scene(chartGroup,WIDTH_SIZE,HEIGHT_SIZE,Color.WHEAT);
		setupChart(); //create the chart for the graph
		beginAnimationLoop();  //start the animation process
		return chartScene;
	}
	
	private void setupChart() {
			final NumberAxis xAxis = new NumberAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        xAxis.setLabel("Number of Month");
	        //creating the chart
	        final LineChart<Number,Number> lineChart = 
	                new LineChart<Number,Number>(xAxis,yAxis);
	                
	        lineChart.setTitle("Stock Monitoring, 2010");
	        //defining a series

	        series.setName("My portfolio");
	        //populating the series with data
//	        series.getData().add(new XYChart.Data<Number,Number>(1, 23));
//	        series.getData().add(new XYChart.Data<Number,Number>(2, 14));
//	        series.getData().add(new XYChart.Data<Number,Number>(3, 15));
//	        series.getData().add(new XYChart.Data<Number,Number>(4, 24));
//	        series.getData().add(new XYChart.Data<Number,Number>(5, 34));
//	        series.getData().add(new XYChart.Data<Number,Number>(6, 36));
	        lineChart.getData().add(series);
	        chartGroup.getChildren().add(lineChart);
	}

	public void beginAnimationLoop() {
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> step(SECOND_DELAY,myCellGrid));
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();  
	}
	
	int count=1;
	public void step(double elapsedTime, Cell[][] cellGrid) {
			System.out.println("blah");
		
			series.getData().add(new XYChart.Data<Number,Number>(count, count));
			count++;
//			CellMover.getPercentAlike(1)

	}

	
}
