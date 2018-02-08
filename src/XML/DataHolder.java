package XML;

import java.io.File;

import javafx.scene.paint.Color;

public class DataHolder {
	//file specifications
	private String TYPE;
	private String AUTHOR;
	private int DIMENSIONS;
	
	//LifeCell
	private Color DEAD_COLOR;
	private Color ALIVE_COLOR;
	private double PERCENTDEAD;
	private String LIFE_GRID;
	
	//FireCell
	private Color BURNT_COLOR;
	private Color TREE_COLOR;
	private Color BURNING_COLOR;
	private double PROB_CATCH;
	private String FIRE_GRID;
	
	//SegregationCell
	private Color A_COLOR;
	private Color B_COLOR;
	private Color NEUTRAL_COLOR;
	private String SEG_GRID;
	
	//PredPreyCell
	private Color PRED_COLOR;
	private Color PREY_COLOR;
	private Color WATER_COLOR;
	private int PREY_REPRODUCTION;
	private int PRED_ENERGY;
	private int ENERGY_GAIN;
	private int PRED_REPRODUCTION;
	private String PRED_GRID;

	public static File INPUTFILE = new File("data/GameOfLife.xml");

	/*
	 * creating instance of the XMLreader which calls the parse method to parse through inputfile.
	 */
	public static XMLReader fileInput = new XMLReader(INPUTFILE); 
	//getter methods
	public String getType() {
		return TYPE;
	}
	
	public String getAuthor() {
		return AUTHOR;
	}
	
	public Color getDeadColor() {
		return DEAD_COLOR;
	}
	
	public Color getAliveColor() {
		return ALIVE_COLOR;
	}
	
	public int getDimensions() {
		return DIMENSIONS;
	}
	
	public double getPercentDead() {
		return PERCENTDEAD;
	}
	//setter methods
	public static void setType(String type) {
		TYPE = type;
	}
	public static void setAuthor(String author) {
		AUTHOR = author;
	}
	public static void setDimensions(int dimensions) {
		DIMENSIONS = dimensions;
	}
	
	//game of life setter methods
	public static void setAliveColor(Color aliveColor) {
		ALIVE_COLOR = aliveColor;
	}
	public static void setDeadColor(Color deadColor) {
		DEAD_COLOR = deadColor;
	}
	public static void setPercentDead(double percent) {
		PERCENTDEAD = percent;
	}
	public static void setLifeGrid(String lifeGrid) {
		LIFE_GRID = lifeGrid;
	}
	
	//spreading fire setter methods
	public static void setBurntColor(Color burntColor) {
		BURNT_COLOR = burntColor;
	}
	public static  void setBurningColor(Color burningColor) {
		BURNING_COLOR = burningColor;
	}
	public static void setTreeColor(Color treeColor) {
		TREE_COLOR = treeColor;
	}
	public static void setProbCatch(double percent) {
		PROB_CATCH = percent;
	}
	public static void setFireGrid(String fireGrid) {
		FIRE_GRID = fireGrid;
	}
	
	//SEGRETATION SETTER METHODS
	public static void setAColor(Color aColor) {
		A_COLOR = aColor;
	}
	public static void setBColor(Color bColor) {
		B_COLOR = bColor;
	}
	public static void setNeutralColor(Color treeColor) {
		NEUTRAL_COLOR = treeColor;
	}
	public static void setSegGrid(String segGrid) {
		SEG_GRID = segGrid;
	}
	//PREDATOR SETTER METHODS
	public static void setPredColor(Color predColor) {
		PRED_COLOR = predColor;
	}
	public static void setPreyColor(Color preyColor) {
		PREY_COLOR = preyColor;
	}
	public static void setWaterColor(Color waterColor) {
		WATER_COLOR = waterColor;
	}
	public static void setPreyProduction(int preyProduction) {
		PREY_REPRODUCTION=preyProduction;
	}
	public static void setPredEnergy(int predEnergy) {
		PRED_ENERGY=predEnergy;
	}
	public static void setPredReproduction(int predReproduction) {
		PRED_REPRODUCTION=predReproduction;
	}
	public static void setPredGrid(String predGrid) {
		PRED_GRID = predGrid;
	}
	
	
	
	
}
