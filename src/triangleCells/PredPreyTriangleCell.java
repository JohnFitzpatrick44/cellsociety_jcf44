package triangleCells;

import java.util.Collections;

import XML.PredPreyHolder;
import javafx.scene.paint.Color;

public class PredPreyTriangleCell extends TriangleCell{
	
	private static final Color PRED_COLOR = PredPreyHolder.getPredColor();
	private static final Color PREY_COLOR = PredPreyHolder.getPreyColor();
	private static final Color WATER_COLOR = PredPreyHolder.getWaterColor();
	private static final int PREY_REPRODUCTION_VALUE = PredPreyHolder.getPreyReproduction();
	private static final int PRED_ENERGY_VALUE = PredPreyHolder.getPredEnergy();
	private static final int ENERGY_GAIN_VALUE = PredPreyHolder.getEnergyGain();
	private static final int PRED_REPRODUCTION_VALUE = PredPreyHolder.getPredReproduction();
	private static final int MAX_STATE = 2;

	private static final int WATER = 0;
	private static final int PREY = 1;
	private static final int PRED = 2;

	private int reproduce;
	private int energy;

	public PredPreyTriangleCell(double x, double y, double side) {
		super(x, y, side);
		reproduce = 0;
		updateFill();
	}
	
	public PredPreyTriangleCell(double x, double y, double side, int state, boolean isInverted) {
		this(x, y, side);
		if(isInverted) {
			this.makeInvertedTriangle(side);
		} else {
			this.makeTriangle(side);
		}
		setState(state);
		if(state == PRED) {
			energy = PRED_ENERGY_VALUE;
		}
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
			moveToState(WATER);
		} else {
			if(energy <= 0) {
				setState(WATER);
				energy = 0;
				reproduce = 0;
			} else {
				moveToState(PREY);
				moveToState(WATER);
			}
		}
	}

	private void moveToState(int state) {
		for(TriangleCell c : getNeighbors()) {
			if(c.getState() == state) {
				swapState(c);
				reproducing(c);
				return;
			}
		}
	}
	
	private void swapState(TriangleCell swapping) {

		((PredPreyTriangleCell) swapping).setReproduce(reproduce);
		if(getState() == PRED) {
			if(swapping.getState() == PREY) {
				((PredPreyTriangleCell) swapping).setEnergy(energy + ENERGY_GAIN_VALUE);
			}
			else {
				((PredPreyTriangleCell) swapping).setEnergy(energy);
			}
		}
		swapping.setState(getState());
		swapping.setSwapped(true);
		setSwapped(true);
		swapping.updateFill();
	}

	private void reproducing(TriangleCell swapped) {
		int val;
		if(getState() == PREY) {
			val = PREY_REPRODUCTION_VALUE;
		}
		else {
			val = PRED_REPRODUCTION_VALUE;
			energy = PRED_ENERGY_VALUE;
		}
		if(reproduce > val) {
			((PredPreyTriangleCell) swapped).setReproduce(0);
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
