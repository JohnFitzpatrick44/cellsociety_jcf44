package XML;

import java.io.File;

import javafx.scene.paint.Color;

public class DataHolder {
	//file specifications
	public static String TYPE;
	public static String AUTHOR;
	public static int DIMENSIONS;
	
	//LifeCell
	public static Color DEAD_COLOR;
	public static Color ALIVE_COLOR;
	public static double PERCENTDEAD;
	public static String LIFE_GRID;
	
	//FireCell
	public static Color BURNT_COLOR;
	public static Color TREE_COLOR;
	public static Color BURNING_COLOR;
	public static double PROB_CATCH;
	public static String FIRE_GRID;
	
	//SegregationCell
	public static Color A_COLOR;
	public static Color B_COLOR;
	public static Color NEUTRAL_COLOR;
	public static String SEG_GRID;
	
	//PredPreyCell
	public static Color PRED_COLOR;
	public static Color PREY_COLOR;
	public static Color WATER_COLOR;
	public static int PREY_REPRODUCTION;
	public static int PRED_ENERGY;
	public static int ENERGY_GAIN;
	public static int PRED_REPRODUCTION;
	public static String PRED_GRID;

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
	//setter methods
	public static void setType(String type) {
		DataHolder.TYPE = type;
	}
	public static void setAuthor(String author) {
		DataHolder.AUTHOR = author;
	}
	public static void setDimensions(int dimensions) {
		DataHolder.DIMENSIONS = dimensions;
	}
	
	//game of life setter methods
	public static void setAliveColor(Color aliveColor) {
		DataHolder.ALIVE_COLOR = aliveColor;
	}
	public static void setDeadColor(Color deadColor) {
		DataHolder.DEAD_COLOR = deadColor;
	}
	public static void setPercentDead(double percent) {
		DataHolder.PERCENTDEAD = percent;
	}
	public static void setLifeGrid(String lifeGrid) {
		DataHolder.LIFE_GRID = lifeGrid;
	}
	
	//spreading fire setter methods
	public static void setBurntColor(Color burntColor) {
		DataHolder.BURNT_COLOR = burntColor;
	}
	public static void setBurningColor(Color burningColor) {
		DataHolder.BURNING_COLOR = burningColor;
	}
	public static void setTreeColor(Color treeColor) {
		DataHolder.TREE_COLOR = treeColor;
	}
	public static void setProbCatch(double percent) {
		DataHolder.PROB_CATCH = percent;
	}
	public static void setFireGrid(String fireGrid) {
		DataHolder.FIRE_GRID = fireGrid;
	}
	
	//SEGRETATION SETTER METHODS
	public static void setAColor(Color aColor) {
		DataHolder.A_COLOR = aColor;
	}
	public static void setBColor(Color bColor) {
		DataHolder.B_COLOR = bColor;
	}
	public static void setNeutralColor(Color treeColor) {
		DataHolder.NEUTRAL_COLOR = treeColor;
	}
	public static void setSegGrid(String segGrid) {
		DataHolder.SEG_GRID = segGrid;
	}
	//PREDATOR SETTER METHODS
	public static void setPredColor(Color predColor) {
		DataHolder.PRED_COLOR = predColor;
	}
	public static void setPreyColor(Color preyColor) {
		DataHolder.PREY_COLOR = preyColor;
	}
	public static void setWaterColor(Color waterColor) {
		DataHolder.WATER_COLOR = waterColor;
	}
	public static void setPreyProduction(int preyProduction) {
		DataHolder.PREY_REPRODUCTION=preyProduction;
	}
	public static void setPredEnergy(int predEnergy) {
		DataHolder.PRED_ENERGY=predEnergy;
	}
	public static void setPredReproduction(int predReproduction) {
		DataHolder.PRED_REPRODUCTION=predReproduction;
	}
	public static void setPredGrid(String predGrid) {
		DataHolder.PRED_GRID = predGrid;
	}
	
	
	
	
}
