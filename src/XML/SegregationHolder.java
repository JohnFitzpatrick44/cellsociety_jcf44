package XML;

import javafx.scene.paint.Color;

public class SegregationHolder extends DataHolder {
	
	private static Color A_COLOR;
	private static Color B_COLOR;
	private static Color NEUTRAL_COLOR;
	private static String SEG_GRID;
	
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
	
	public static void setSegregation(Color aColor, Color bColor, Color neutralColor, String segGrid) {
		A_COLOR = aColor;
		B_COLOR = bColor;
		NEUTRAL_COLOR = neutralColor;
		SEG_GRID = segGrid;
	}

}
