package XML;

import javafx.scene.paint.Color;

public class SugarHolder extends DataHolder {
	private static int COLOR_ONE;
	private static int COLOR_TWO;
	private static int COLOR_THREE;
	private static int GROWTH_RATE;
	private static int GROWTH_INTERVAL;
	private static String SUGAR_GRID;
	
	public static String getSugarGrid() {
		return SUGAR_GRID;
	}
	
	public static int getColorOne() {
		return COLOR_ONE;
	}
	
	public static int getColorTwo() {
		return COLOR_TWO;
	}
	
	public static int getColorThree() {
		return COLOR_THREE;
	}
	
	public static int getGrowthRate() {
		return GROWTH_RATE;
	}
	public static int getGrowthInterval() {
		return GROWTH_INTERVAL;
	}
	
	public static void setSugarScape(int colorOne, int colorTwo, int colorThree, int growthRate, int growthInterval, String sugarGrid) {
		SUGAR_GRID = sugarGrid;
		COLOR_ONE = colorOne;
		COLOR_TWO = colorTwo;
		COLOR_THREE = colorThree;
		GROWTH_RATE = growthRate;
		GROWTH_INTERVAL = growthInterval;
	}
}
