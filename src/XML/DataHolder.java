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
	public static void setGameOfLife(Color aliveColor, Color deadColor, double percent, String lifeGrid) {
		ALIVE_COLOR = aliveColor;
		DEAD_COLOR = deadColor;
		PERCENTDEAD = percent;
		LIFE_GRID = lifeGrid;
	}
	
	//spreading fire setter methods
	public static void setSpreadingFire(Color burntColor, Color burningColor, Color treeColor, double percent, String fireGrid) {
		BURNT_COLOR = burntColor;
		BURNING_COLOR = burningColor;
		TREE_COLOR = treeColor;
		PROB_CATCH = percent;
		FIRE_GRID = fireGrid;
	}
	
	//SEGRETATION SETTER METHODS
	public static void setSegregation(Color aColor, Color bColor, Color neutralColor, String segGrid) {
		A_COLOR = aColor;
		B_COLOR = bColor;
		NEUTRAL_COLOR = neutralColor;
		SEG_GRID = segGrid;
	}
	//PREDATOR SETTER METHODS
	public static void setPredPrey(Color predColor, Color preyColor, Color waterColor, int preyProduction, int predEnergy, int energyGain, int predReproduction, String predGrid) {
		PRED_COLOR = predColor;
		PREY_COLOR = preyColor;
		WATER_COLOR = waterColor;
		PREY_REPRODUCTION=preyProduction;
		PRED_ENERGY=predEnergy;
		ENERGY_GAIN = energyGain;
		PRED_REPRODUCTION=predReproduction;
		PRED_GRID = predGrid;
	}
	
}
