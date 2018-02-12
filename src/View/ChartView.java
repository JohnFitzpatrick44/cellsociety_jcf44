package View;

import XML.DataHolder;
import rectCells.Cell;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.util.Duration;
	/*
	 * Chartview creates a separate scene that depicts a chart that counts the number of cells types
	 * and animates the growth of those types of cells
	 * @author Ryan Fu
	 */

public class ChartView {

	public ChartView() {
	}
	
	//private static final int GRID_OFFSET = 10;
	private static final int WIDTH_SIZE = 500;
	private static final int HEIGHT_SIZE = 410;
	private static final int FRAMES_PER_SECOND = 60;
	private static final int ANIMATION_SPEED = 100000;
	private static final int MILLISECOND_DELAY = ANIMATION_SPEED / FRAMES_PER_SECOND;
	private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private static int GRID_SIZE = DataHolder.getDimensions();


	//private static String SIMULATION = DataHolder.getType();

	private static Group chartGroup;
	private static Scene chartScene;
	//private static Grid grid;
	private static Cell[][] myCellGrid;
	private static Timeline chartAnimation;
	private static int count=0;

    private static XYChart.Series<Number, Number> series = new XYChart.Series<Number,Number>();
    private static XYChart.Series<Number, Number> series2 = new XYChart.Series<Number,Number>();
    private static XYChart.Series<Number, Number> series3 = new XYChart.Series<Number,Number>();
    private static final int MAX_DATA_POINTS = 50;
    private static NumberAxis xAxis;
    private static NumberAxis yAxis;
    private static LineChart<Number,Number> lineChart;
	public Scene initializeStartScene() {
		chartGroup = new Group();
		chartScene = new Scene(chartGroup,WIDTH_SIZE,HEIGHT_SIZE,Color.WHEAT);
		setupChart(); //create the chart for the graph
		beginAnimationLoop();  //start the animation process
		return chartScene;
	}
	
	private static void setupChart() {
			xAxis = new NumberAxis(0,MAX_DATA_POINTS,MAX_DATA_POINTS/10);
	        yAxis = new NumberAxis();
	        xAxis.setLabel("Steps");
	        yAxis.setLabel("Number of Cells");
	        //creating the chart
	        lineChart = new LineChart<Number,Number>(xAxis,yAxis);
	        //defining a series
	        xAxis.setMinorTickVisible(false);
	        xAxis.setTickMarkVisible(false);
	        xAxis.setTickLabelsVisible(false);
	        
	       // xAxis.setTickLabelsVisible(false);
	        lineChart.setLegendVisible(false);
	        lineChart.setCreateSymbols(false);    
	        series.setName("Game Of Life");
	        lineChart.getData().add(series);
	        lineChart.getData().add(series2);
	        lineChart.getData().add(series3);
	        chartGroup.getChildren().add(lineChart);
	}
	public static void updateChartAttributes() {
		lineChart.setTitle(DataHolder.getType());
	}


	public void beginAnimationLoop() {
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> step(SECOND_DELAY,myCellGrid));
		chartAnimation = new Timeline();
		chartAnimation.setCycleCount(Timeline.INDEFINITE);
		chartAnimation.getKeyFrames().add(frame);
		chartAnimation.play();  
	}
	
	//update cell count and add values to the chart
	public void step(double elapsedTime, Cell[][] cellGrid) {
			if (MainView.isPlaying()) {
			System.out.println("blah");
			updateCellCount();
			}
	}
	
	//update cell count and reposition graph if the count is outside of the max x-axis range
	public static void updateCellCount() {
		Cell[][] mainCellGrid = MainView.getMyCellGrid();
		double cellCount= GRID_SIZE*GRID_SIZE*mainCellGrid[1][1].getCellMover().getPercentAlike(0);
		series.getData().add(new XYChart.Data<Number,Number>(count, cellCount));
		double cellCount2= GRID_SIZE*GRID_SIZE*mainCellGrid[1][1].getCellMover().getPercentAlike(1);
		series2.getData().add(new XYChart.Data<Number,Number>(count, cellCount2));
		double cellCount3= GRID_SIZE*GRID_SIZE*mainCellGrid[1][1].getCellMover().getPercentAlike(2);
		series3.getData().add(new XYChart.Data<Number,Number>(count, cellCount3));
		count++;
		if (count>=MAX_DATA_POINTS) {
			 series.getData().remove(0, series.getData().size() - MAX_DATA_POINTS);
		       xAxis.setLowerBound(xAxis.getLowerBound()+1);
		       xAxis.setUpperBound(xAxis.getUpperBound()+1);
		}	
	}
	//increase or decrease animation rate
	public static void updateChartAnimationRate(double rate) {
		chartAnimation.setRate(rate);
	}

	
}
