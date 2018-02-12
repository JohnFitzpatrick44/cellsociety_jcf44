package XML;

import javafx.scene.paint.Color;

public class SugarHolder extends DataHolder {
	private static Color BURNT_COLOR;
	private static Color TREE_COLOR;
	private static Color BURNING_COLOR;
	private static double PROB_CATCH;
	private static String SUGAR_GRID;
	
	public static String getFireGrid() {
		return SUGAR_GRID;
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
		SUGAR_GRID = fireGrid;
	}
}
