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


	private static String SIMULATION = DataHolder.getType();

	private static Group chartGroup;
	private static Scene chartScene;
	private static Grid grid;
	private static Cell[][] myCellGrid;
	private static Timeline animation;
	private int count=0;

	//attributes of the buttons
	private static Boolean playBoolean = false;
    private static XYChart.Series<Number, Number> series = new XYChart.Series<Number,Number>();
    private static final int MAX_DATA_POINTS = 50;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    
	public Scene initializeStartScene() {
		chartGroup = new Group();
		chartScene = new Scene(chartGroup,WIDTH_SIZE,HEIGHT_SIZE,Color.WHEAT);
		setupChart(); //create the chart for the graph
		beginAnimationLoop();  //start the animation process
		return chartScene;
	}
	
	private void setupChart() {
			xAxis = new NumberAxis(0,MAX_DATA_POINTS,MAX_DATA_POINTS/10);
	        yAxis = new NumberAxis();
	        xAxis.setLabel("Steps");
	        //creating the chart
	        final LineChart<Number,Number> lineChart = 
	                new LineChart<Number,Number>(xAxis,yAxis);
	      //  lineChart.setTitle("Stock Monitoring, 2010");
	        //defining a series
	        xAxis.setMinorTickVisible(false);
	       // xAxis.setTickLabelsVisible(false);
	        lineChart.setCreateSymbols(false);
	        series.setName("Game Of Life");
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
	
	
	public void step(double elapsedTime, Cell[][] cellGrid) {
			if (MainView.isPlaying()) {
			System.out.println("blah");
			updateCellCount();
			}
	}
	
	public void updateCellCount() {
		double cellCount= GRID_SIZE*GRID_SIZE*CellMover.getPercentAlike(1);
		series.getData().add(new XYChart.Data<Number,Number>(count, cellCount));
		count++;
		if (count>=MAX_DATA_POINTS) {
			 series.getData().remove(0, series.getData().size() - MAX_DATA_POINTS);
		       xAxis.setLowerBound(xAxis.getLowerBound()+1);
		       xAxis.setUpperBound(xAxis.getUpperBound()+1);
		}	
	}
	public static void updateChartAnimationRate(double rate) {
		animation.setRate(rate);
	}

	
}
