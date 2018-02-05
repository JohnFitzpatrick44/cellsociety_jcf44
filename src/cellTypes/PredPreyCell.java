package cellTypes;

import java.util.Collections;

import javafx.scene.paint.Color;

public class PredPreyCell extends Cell {

	public static final Color PRED_COLOR = Color.RED;
	public static final Color PREY_COLOR = Color.GREEN;
	public static final Color WATER_COLOR = Color.BLUE;
	public static final int PREY_REPRODUCTION_VALUE = 5;
	public static final int PRED_ENERGY_VALUE = 5;
	public static final int ENERGY_GAIN_VALUE = 2;
	public static final int PRED_REPRODUCTION_VALUE = 5;
	
	private int reproduce;
	private int energy;
	
	public PredPreyCell(int x, int y, int width, int height, int state) {
		this(x, y, width, height);
		setState(state);
		if(state == 0) this.setFill(WATER_COLOR);
		else if(state == 1) {
			this.setFill(PREY_COLOR);
		}
		else {
			this.setFill(PRED_COLOR);
			energy = PRED_ENERGY_VALUE;
		}
	}
	
	public PredPreyCell(int x, int y, int width, int height) {
		super(x, y, width, height);
		reproduce = 0;
	}

	public void updateState() {
		if(getState() == 0 || getSwapped()) return;
		reproduce++;
		if(getState() == 2) energy--;
		move();
	}
	
	public int getReproduce() {
		return reproduce;
	}
	
	public void setReproduce(int e) {
		reproduce = e;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public void setEnergy(int e) {
		energy = e;
	}
	
	private void move() {
		Collections.shuffle(getNeighbors());
		if(getState() == 1) {
			for(Cell c : getNeighbors()) {
				if(c.getState() == 0) {
					swapState(c);
					reproducing(c);
				}
			}
		} else {
			if(energy == 0) {
				setState(0);
				setFill(WATER_COLOR);
				energy = 0;
				reproduce = 0;
			} else {
				for(Cell c : getNeighbors()) {
					if(c.getState() == 1) {
						swapState(c);
						reproducing(c);
						return;
					}
				}
				
				for(Cell c : getNeighbors()) {
					if(c.getState() == 0) {
						swapState(c);
						reproducing(c);
						return;
					}
				}
			}
		}
	}
	
	private void swapState(Cell swapping) {
		swapping.setState(this.getState());
		if(swapping.getState() == 1) swapping.setFill(PREY_COLOR);
		else swapping.setFill(PRED_COLOR);
		((PredPreyCell) swapping).setReproduce(reproduce);
		if(getState() == 2) ((PredPreyCell) swapping).setEnergy(energy + ENERGY_GAIN_VALUE * swapping.getState());
		swapping.setSwapped(true);
		this.setSwapped(true);
	}
	
	private void reproducing(Cell swapped) {
		int val;
		if(getState() == 1) val = PREY_REPRODUCTION_VALUE;
		else {
			val = PRED_REPRODUCTION_VALUE;
			energy = PRED_ENERGY_VALUE;
		}
		if(reproduce > val) {
			((PredPreyCell) swapped).setReproduce(0);
		} else {
			setState(0);
			setFill(WATER_COLOR);
			energy = 0;
		}
		reproduce = 0;
	}
	
}
