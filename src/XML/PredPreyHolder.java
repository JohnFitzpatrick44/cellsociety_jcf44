package XML;

import javafx.scene.paint.Color;

public class PredPreyHolder extends DataHolder {

	private static Color PRED_COLOR;
	private static Color PREY_COLOR;
	private static Color WATER_COLOR;
	private static int PREY_REPRODUCTION;
	private static int PRED_ENERGY;
	private static int ENERGY_GAIN;
	private static int PRED_REPRODUCTION;
	private static String PRED_GRID;
	
	public static Color getPredColor() {
		return PRED_COLOR;
	}
	
	public static Color getPreyColor() {
		return PREY_COLOR;
	}
	
	public static Color getWaterColor() {
		return WATER_COLOR;
	}
	
	public static int getPredReproduction() {
		return PRED_REPRODUCTION;
	}
	
	public static int getPreyReproduction() {
		return PREY_REPRODUCTION;
	}
	
	public static int getPredEnergy() {
		System.out.println("data"+PRED_ENERGY);
		return PRED_ENERGY;
	}
	
	public static int getEnergyGain() {
		return ENERGY_GAIN;
	}
	
	public static String getPredGrid() {
		return PRED_GRID;
	}
	
	public static void setPredPreyColor(Color predColor, Color preyColor, Color waterColor) {
		PRED_COLOR = predColor;
		PREY_COLOR = preyColor;
		WATER_COLOR = waterColor;
	}
	
	public static void setPredPreyParams( int preyProduction, int predEnergy, int energyGain, int predReproduction, String predGrid) {
		PREY_REPRODUCTION=preyProduction;
		PRED_ENERGY=predEnergy;
		ENERGY_GAIN = energyGain;
		PRED_REPRODUCTION=predReproduction;
		PRED_GRID = predGrid;
	}
	
	
}
