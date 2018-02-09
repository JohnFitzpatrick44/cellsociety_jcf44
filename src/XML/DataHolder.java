package XML;

import java.io.File;


public abstract class DataHolder {
	//file specifications
	private static String TYPE;
	private static String AUTHOR;
	private static int DIMENSIONS;
	
	

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
	
	
	
	public static int getDimensions() {
		return DIMENSIONS;
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
	
	
}
