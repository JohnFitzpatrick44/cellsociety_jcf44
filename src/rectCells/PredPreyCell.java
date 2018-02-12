package rectCells;

import java.util.Collections;

import XML.PredPreyHolder;
import javafx.scene.paint.Color;

public class PredPreyCell extends Cell {

	private static Color PRED_COLOR = PredPreyHolder.getPredColor();
	private static Color PREY_COLOR = PredPreyHolder.getPreyColor();
	private static Color WATER_COLOR = PredPreyHolder.getWaterColor();
	private static int PREY_REPRODUCTION_VALUE = PredPreyHolder.getPreyReproduction();
	private static int PRED_ENERGY_VALUE = PredPreyHolder.getPredEnergy();
	private static int ENERGY_GAIN_VALUE = PredPreyHolder.getEnergyGain();
	private static int PRED_REPRODUCTION_VALUE = PredPreyHolder.getPredReproduction();
	private static int MAX_STATE = 2;

	private static final int WATER = 0;
	private static final int PREY = 1;
	private static final int PRED = 2;

	private int reproduce;
	private int energy;
	
	private void refreshValues() {
		PRED_ENERGY_VALUE = PredPreyHolder.getPredEnergy();
		PREY_REPRODUCTION_VALUE = PredPreyHolder.getPreyReproduction();
		ENERGY_GAIN_VALUE = PredPreyHolder.getEnergyGain();
		PRED_REPRODUCTION_VALUE = PredPreyHolder.getPredReproduction();
		PRED_COLOR = PredPreyHolder.getPredColor();
		PREY_COLOR = PredPreyHolder.getPreyColor();
		WATER_COLOR = PredPreyHolder.getWaterColor();
	}

	public PredPreyCell(int state, double...points) {
		this(points);
		setState(state);
		refreshValues();
		if(state == PRED) {
			energy = PRED_ENERGY_VALUE;
		}
		updateFill();
	}

	public PredPreyCell(double...points) {
		super(points);
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
		for(Cell c : getNeighbors()) {
			if(c.getState() == state) {
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
