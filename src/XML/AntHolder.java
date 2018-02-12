package XML;

import javafx.scene.paint.Color;

public class AntHolder  extends DataHolder {
	private static Color ANT_COLOR;
	private static String ANT_GRID;
	private static double PHEROMONE_DIFFUSION;
	private static int SIZE_RATIO;
	
	public static void setSugarScape(int ratio, double pDiff, Color antColor, String antGrid) {
		ANT_GRID = antGrid;
		ANT_COLOR = antColor;
		PHEROMONE_DIFFUSION = pDiff;
		SIZE_RATIO = ratio;
	}

	public static Color getAntColor() {
		return ANT_COLOR;
	}
	
	public static String getAntGrid() {
		return ANT_GRID;
	}

	public static double getPheromoneDiffusion() {
		return PHEROMONE_DIFFUSION;
	}

	public static int getSizeRatio() {
		return SIZE_RATIO;
	}
}
