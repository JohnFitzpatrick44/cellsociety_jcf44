package XML;

import java.io.File;

import javafx.scene.paint.Color;

public class DataHolder {
	public static String TYPE;
	public static Color DEAD_COLOR;
	public static Color ALIVE_COLOR;
	public static int DIMENSIONS;
	public static int ANIMATIONSPEED;
	public static double PERCENTDEAD;
	public static Color BURNT_COLOR;
	public static Color TREE_COLOR;
	public static Color BURNING_COLOR;
	public static File INPUTFILE = new File("data/SpreadingFire.xml");

	
	/*
	 * creating instance of the XMLreader which calls the parse method to parse through inputfile.
	 */
	public static XMLReader fileInput = new XMLReader(INPUTFILE); 
	
	public static String getType() {
		return TYPE;
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
