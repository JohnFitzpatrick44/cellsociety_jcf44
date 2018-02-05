package XML;
import java.awt.Color;
import java.io.File;

public class DataHolder {
	public static String TYPE;
	public static Color DEAD_COLOR;
	public static java.awt.Color ALIVE_COLOR;
	public static int DIMENSIONS;
	public static int ANIMATIONSPEED;
	public static double PERCENTDEAD;
	public static File INPUTFILE = new File("/Users/Ryan/cs308/cellsociety_team03/data/GameOfLife.xml");

	
	/*
	 * creating instance of the XMLreader which calls the parse method to parse through inputfile.
	 */
	public static XMLReader fileInput = new XMLReader(INPUTFILE); 
	
	public DataHolder() {
		/*
		 * constructor for DataHolder();
		 */
	}
	
//	public static void main(String[] argv) {
//		//fileInput = new XMLReader(INPUTFILE);
//		System.out.print(getType());
//	}
	
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
