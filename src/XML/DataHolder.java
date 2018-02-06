package XML;

import java.io.File;

import javafx.scene.paint.Color;

public class DataHolder {
	public static String TYPE;
	public static String AUTHOR;
	public static int DIMENSIONS;
	public static int ANIMATIONSPEED;
	
	
	//LifeCell
	public static Color DEAD_COLOR;
	public static Color ALIVE_COLOR;
	public static double PERCENTDEAD;
	
	//FireCell
	public static Color BURNT_COLOR;
	public static Color TREE_COLOR;
	public static Color BURNING_COLOR;
	
	//SegregationCell
	public static Color A_COLOR;
	public static Color B_COLOR;
	public static Color NEUTRAL_COLOR;
	
	//PredPreyCell
	public static Color PRED_COLOR;
	public static Color PREY_COLOR;
	public static Color WATER_COLOR;
	public static int PREY_REPRODUCTION;
	public static int PRED_ENERGY;
	public static int ENERGY_GAIN;
	public static int PRED_REPRODUCTION;

	public static File INPUTFILE = new File("data/GameOfLife.xml");

	/*
	 * creating instance of the XMLreader which calls the parse method to parse through inputfile.
	 */
	public static XMLReader fileInput = new XMLReader(INPUTFILE); 
	
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
	
	public static int getAnimationSpeed() {
		return ANIMATIONSPEED;
	}
	
	public static double getPercentDead() {
		return PERCENTDEAD;
	}
	
}