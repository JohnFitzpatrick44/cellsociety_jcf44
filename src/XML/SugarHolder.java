package XML;


public class SugarHolder extends DataHolder {
	private static int COLOR_ONE;
	private static int COLOR_TWO;
	private static int COLOR_THREE;
	private static int GROWTH_RATE;
	private static int GROWTH_INTERVAL;
	private static String SUGAR_GRID;
	private static int MAX_AGE;
	private static int MIN_FERTILITY;
	private static int MAX_FERTILITY;
	private static int RATIO;
	
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
	
	public static int getMaxFertility() {
		return MAX_FERTILITY;
	}

	public static int getMinFertility() {
		return MIN_FERTILITY;
	}

	public static int getMaxAge() {
		return MAX_AGE;
	}

	public static int getSizeRatio() {
		return RATIO;
	}
	
	public static void setSugarScape(int colorOne, int colorTwo, int colorThree, int growthRate, int growthInterval, String sugarGrid) {
		SUGAR_GRID = sugarGrid;
		COLOR_ONE = colorOne;
		COLOR_TWO = colorTwo;
		COLOR_THREE = colorThree;
		GROWTH_RATE = growthRate;
		GROWTH_INTERVAL = growthInterval;
	}
	
	public static void setSugarAgents(int mAge, int minF, int maxF, int ratio) {
		MAX_AGE = mAge;
		MIN_FERTILITY = minF;
		MAX_FERTILITY = maxF;
		RATIO = ratio;
	}

}
