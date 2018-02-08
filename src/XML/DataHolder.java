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
	
	public static Color getAColor() {
		return A_COLOR;
	}
	
	public static Color getBColor() {
		return B_COLOR;
	}
	
	public static Color getNeutralColor() {
		return NEUTRAL_COLOR;
	}
	
	public static String getSegGrid() {
		return SEG_GRID;
	}
	
	public static Color getPredColor() {
		return PRED_COLOR;
	}
	
	public static Color getPreyColor() {
		return PREY_COLOR;
	}
	
	public static Color getWaterColor() {
		return WATER_COLOR;
	}
	
	public static int getPredReproduction() {
		return PRED_REPRODUCTION;
	}
	
	public static int getPreyReproduction() {
		return PREY_REPRODUCTION;
	}
	
	public static int getPredEnergy() {
		return PRED_ENERGY;
	}
	
	public static int getEnergyGain() {
		return ENERGY_GAIN;
	}
	
	public static String getPredGrid() {
		return PRED_GRID;
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
