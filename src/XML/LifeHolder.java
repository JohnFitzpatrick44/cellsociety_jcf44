package XML;

import javafx.scene.paint.Color;

public class LifeHolder extends DataHolder {
	private static Color DEAD_COLOR;
	private static Color ALIVE_COLOR;
	private static double PERCENTDEAD;
	private static String LIFE_GRID;
	
	public static double getPercentDead() {
		return PERCENTDEAD;
	}
	
	public static String getLifeGrid() {
		return LIFE_GRID;
	}
	
	public static Color getDeadColor() {
		return DEAD_COLOR;
	}
	
	public static Color getAliveColor() {
		return ALIVE_COLOR;
	}
	
	public static void setGameOfLife(Color aliveColor, Color deadColor, double percent, String lifeGrid) {
		ALIVE_COLOR = aliveColor;
		DEAD_COLOR = deadColor;
		PERCENTDEAD = percent;
		LIFE_GRID = lifeGrid;
	}
	
}
