package XML;

import javafx.scene.paint.Color;

public class FireHolder extends DataHolder {
	private static Color BURNT_COLOR;
	private static Color TREE_COLOR;
	private static Color BURNING_COLOR;
	private static double PROB_CATCH;
	private static String FIRE_GRID;
	
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
	
	public static void setSpreadingFire(Color burntColor, Color burningColor, Color treeColor, double percent, String fireGrid) {
		BURNT_COLOR = burntColor;
		BURNING_COLOR = burningColor;
		TREE_COLOR = treeColor;
		PROB_CATCH = percent;
		FIRE_GRID = fireGrid;
	}
}
