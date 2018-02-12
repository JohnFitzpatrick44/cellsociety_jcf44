package XML;

import javafx.scene.paint.Color;

public class BacteriaHolder extends DataHolder {
	private static Color COLOR_A;
	private static Color COLOR_B;
	private static Color COLOR_C;
	private static Color DEFAULT_COLOR;
	private static String BACTERIA_GRID;
	
	
	public static String getBacteriaGrid() {
		return BACTERIA_GRID;
	}
	public static Color getColorA() {
		return COLOR_A;
	}
	
	public static Color getColorB() {
		return COLOR_B;
	}
	public static Color getColorC() {
		return COLOR_C;
	}
	public static Color getDefaultColor() {
		return DEFAULT_COLOR;
	}
	
	public static void setBacteria(Color colorA, Color colorB, Color colorC, Color defaultColor, String bacteriaGrid) {
		COLOR_A = colorA;
		COLOR_B = colorB;
		COLOR_C = colorC;
		DEFAULT_COLOR = defaultColor;
		BACTERIA_GRID = bacteriaGrid;
	}
}
