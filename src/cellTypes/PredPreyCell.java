package cellTypes;

import java.util.Collections;

import javafx.scene.paint.Color;

public class PredPreyCell extends Cell {

	public static final Color PRED_COLOR = Color.RED;
	public static final Color PREY_COLOR = Color.GREEN;
	public static final Color WATER_COLOR = Color.BLUE;
	public static final int PREY_REPRODUCTION_VALUE = 5;
	public static final int PRED_ENERGY_VALUE = 5;
	
	private int productionCounter;
	private int energy;
	
	public PredPreyCell(int x, int y, int width, int height, int state) {
		this(x, y, width, height);
		setState(state);
		if(state == 0) this.setFill(WATER_COLOR);
		else if(state == 1) this.setFill(PREY_COLOR);
		else this.setFill(PRED_COLOR);
	}
	
	public PredPreyCell(int x, int y, int width, int height) {
		super(x, y, width, height);
		productionCounter = 0;
	}

	public void updateState() {
		if(getState() == 0 || getSwapped()) return;
		if(getState() == 1) {
			productionCounter++;

		} else {
			productionCounter--;

		}
	}
	
	public int getProductionCount() {
		return productionCounter;
	}
	
	public void setProductionCount(int p) {
		productionCounter = p;
	}
	
	private void move() {
		Collections.shuffle(getNeighbors());
		if(getState() == 1) {
			for(Cell c : getNeighbors()) {
				if(c.getState() == 0) {
					swapState(c);
					if(productionCounter > PREY_REPRODUCTION_VALUE) {
						((PredPreyCell) c).setProductionCount(0);
					} else {
						setState(0);
						setFill(WATER_COLOR);
					}
					productionCounter = 0;
					return;
				}
			}
		} else {
			for(Cell c : getNeighbors()) {
				if(c.getState() == 1)
			}
			
			
			for(Cell c : getNeighbors()) {
				if(c.getState() == 0) {
					swapState(c);
					energy--;
					if(energy == 0) {
						
					}
				}
			}
		}
	}
	
	private void swapState(Cell swapping) {
		swapping.setState(this.getState());
		if(swapping.getState() == 1) swapping.setFill(PREY_COLOR);
		else swapping.setFill(PRED_COLOR);
		((PredPreyCell) swapping).setProductionCount(productionCounter);
		swapping.setSwapped(true);
		this.setSwapped(true);
	}
	
}
