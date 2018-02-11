package XML;

import java.io.File;


public abstract class DataHolder {
	//file specifications
	private static String TYPE;
	private static String AUTHOR;
	private static int DIMENSIONS;
	
	

	private static File INPUTFILE = new File("data/GameOfLife.xml");

	/*
	 * creating instance of the XMLreader which calls the parse method to parse through inputfile.
	 */
	private static XMLReader fileInput = new XMLReader(INPUTFILE); 
	public static XMLReader getFileInput() {
		return fileInput;
	}

	public static void setFileInput(XMLReader file) {
		fileInput = file;
	}

	//getter methods
	public static String getType() {
		return TYPE;
	}
	
	public static String getAuthor() {
		return AUTHOR;
	}
	public static void clearXMLReader() {
		fileInput= null;
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
	
	public static void setInputFile(File in) {
		INPUTFILE = in;
	}
	
	public static File getInputFile() {
		return INPUTFILE;
	}
	
	
}
