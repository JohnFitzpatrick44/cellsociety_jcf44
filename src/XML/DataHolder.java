package XML;

import java.io.File;

import javafx.scene.paint.Color;

public class DataHolder {
	//file specifications
	private static String TYPE;
	private static String AUTHOR;
	private static int DIMENSIONS;
	
	//LifeCell
	private static Color DEAD_COLOR;
	private static Color ALIVE_COLOR;
	private static double PERCENTDEAD;
	private static String LIFE_GRID;
	
	//FireCell
	private static Color BURNT_COLOR;
	private static Color TREE_COLOR;
	private static Color BURNING_COLOR;
	private static double PROB_CATCH;
	private static String FIRE_GRID;
	
	//SegregationCell
	private static Color A_COLOR;
	private static Color B_COLOR;
	private static Color NEUTRAL_COLOR;
	private static String SEG_GRID;
	
	//PredPreyCell
	private static Color PRED_COLOR;
	private static Color PREY_COLOR;
	private static Color WATER_COLOR;
	private static int PREY_REPRODUCTION;
	private static int PRED_ENERGY;
	private static int ENERGY_GAIN;
	private static int PRED_REPRODUCTION;
	private static String PRED_GRID;

	public static File INPUTFILE = new File("data/GameOfLife.xml");

	/*
	 * creating instance of the XMLreader which calls the parse method to parse through inputfile.
	 */
	public static XMLReader fileInput = new XMLReader(INPUTFILE); 
	//getter methods
	public static String getType() {
		return TYPE;
	}
	
	public static String getAuthor() {
		return AUTHOR;
	}
	
	public static Color getDeadColor() {
		return DEAD_COLOR;
	}
	
	public static Color getAliveColor() {
		return ALIVE_COLOR;
	}
	
	public static int getDimensions() {
		return DIMENSIONS;
	}
	
	public static double getPercentDead() {
		return PERCENTDEAD;
	}
	
	public static String getLifeGrid() {
		return LIFE_GRID;
	}
	
	public static String getFireGrid() {
		return FIRE_GRID;
	}
	
	public static Color getBurntColor() {
		return BURNT_COLOR;
	}
	
	public static Color getTreeColor() {
		return TREE_COLOR;
	}
	
	public static Color getBurningColor() {
		return BURNING_COLOR;
	}
	
	public static double getProbCatch() {
		return PROB_CATCH;
	}
	
	//setter methods
	public void setType(String type) {
		TYPE = type;
	}
	public void setAuthor(String author) {
		AUTHOR = author;
	}
	public void setDimensions(int dimensions) {
		DIMENSIONS = dimensions;
	}
	
	//game of life setter methods
	public void setAliveColor(Color aliveColor) {
		ALIVE_COLOR = aliveColor;
	}
	public void setDeadColor(Color deadColor) {
		DEAD_COLOR = deadColor;
	}
	public void setPercentDead(double percent) {
		PERCENTDEAD = percent;
	}
	public void setLifeGrid(String lifeGrid) {
		LIFE_GRID = lifeGrid;
	}
	
	//spreading fire setter methods
	public void setBurntColor(Color burntColor) {
		BURNT_COLOR = burntColor;
	}
	public void setBurningColor(Color burningColor) {
		BURNING_COLOR = burningColor;
	}
	public void setTreeColor(Color treeColor) {
		TREE_COLOR = treeColor;
	}
	public void setProbCatch(double percent) {
		PROB_CATCH = percent;
	}
	public void setFireGrid(String fireGrid) {
		FIRE_GRID = fireGrid;
	}
	
	//SEGRETATION SETTER METHODS
	public void setAColor(Color aColor) {
		A_COLOR = aColor;
	}
	public void setBColor(Color bColor) {
		B_COLOR = bColor;
	}
	public void setNeutralColor(Color treeColor) {
		NEUTRAL_COLOR = treeColor;
	}
	public void setSegGrid(String segGrid) {
		SEG_GRID = segGrid;
	}
	//PREDATOR SETTER METHODS
	public void setPredColor(Color predColor) {
		PRED_COLOR = predColor;
	}
	public void setPreyColor(Color preyColor) {
		PREY_COLOR = preyColor;
	}
	public void setWaterColor(Color waterColor) {
		WATER_COLOR = waterColor;
	}
	public void setPreyProduction(int preyProduction) {
		PREY_REPRODUCTION=preyProduction;
	}
	public void setPredEnergy(int predEnergy) {
		PRED_ENERGY=predEnergy;
	}
	public void setPredReproduction(int predReproduction) {
		PRED_REPRODUCTION=predReproduction;
	}
	public void setPredGrid(String predGrid) {
		PRED_GRID = predGrid;
	}
	
}
