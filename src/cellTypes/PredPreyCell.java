package cellTypes;

import java.util.Collections;

import XML.DataHolder;
import javafx.scene.paint.Color;

public class PredPreyCell extends Cell {

	private final Color PRED_COLOR = DataHolder.getPredColor();
	private final Color PREY_COLOR = DataHolder.getPreyColor();
	private final Color WATER_COLOR = DataHolder.getWaterColor();
	private final int PREY_REPRODUCTION_VALUE = DataHolder.getPreyReproduction();
	private final int PRED_ENERGY_VALUE = DataHolder.getPredEnergy();
	private final int ENERGY_GAIN_VALUE = DataHolder.getEnergyGain();
	private final int PRED_REPRODUCTION_VALUE = DataHolder.getPredReproduction();
	private final int MAX_STATE = 2;

	private final int WATER = 0;
	private final int PREY = 1;
	private final int PRED = 2;

	private int reproduce;
	private int energy;

	public PredPreyCell(int x, int y, int width, int height, int state) {
		this(x, y, width, height);
		setState(state);
		if(state == PRED) {
			energy = PRED_ENERGY_VALUE;
		}
		updateFill();
	}

	public PredPreyCell(int x, int y, int width, int height) {
		super(x, y, width, height);
		reproduce = 0;
		updateFill();
	}

	public void updateState() {
		if(getState() == WATER || getSwapped()) {
			return;
		}
		reproduce++;
		if(getState() == PRED) {
			energy--;
		}
		move();
		updateFill();
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
		if(getState() == PREY) {
			moveToWater();
		} else {
			if(energy <= 0) {
				setState(WATER);
				energy = 0;
				reproduce = 0;
			} else {
				for(Cell c : getNeighbors()) {
					if(c.getState() == PREY) {
						swapState(c);
						reproducing(c);
						return;
					}
				}
				moveToWater();
			}
		}
	}

	private void moveToWater() {
		for(Cell c : getNeighbors()) {
			if(c.getState() == WATER) {
				swapState(c);
				reproducing(c);
				return;
			}
		}
	}
	
	private void swapState(Cell swapping) {

		((PredPreyCell) swapping).setReproduce(reproduce);
		if(getState() == PRED) {
			if(swapping.getState() == PREY) {
				((PredPreyCell) swapping).setEnergy(energy + ENERGY_GAIN_VALUE);
			}
			else {
				((PredPreyCell) swapping).setEnergy(energy);
			}
		}
		//getCellMover().copyState(this, swapping);
		swapping.setState(getState());
		swapping.setSwapped(true);
		setSwapped(true);
		swapping.updateFill();
	}

	private void reproducing(Cell swapped) {
		int val;
		if(getState() == PREY) {
			val = PREY_REPRODUCTION_VALUE;
		}
		else {
			val = PRED_REPRODUCTION_VALUE;
			energy = PRED_ENERGY_VALUE;
		}
		if(reproduce > val) {
			((PredPreyCell) swapped).setReproduce(0);
		} else {
			setState(WATER);
			energy = 0;
		}
		reproduce = 0;
		updateFill();
	}

	public int getMaxState() {
		return MAX_STATE;
	}

	public void updateFill() {
		if(getState() == WATER) {
			setFill(WATER_COLOR);
		}
		else if(getState() == PREY) {
			setFill(PREY_COLOR);
		}
		else {
			setFill(PRED_COLOR);
		}
	}

}
