package cellTypes;

import java.util.Random;

import XML.DataHolder;

import java.awt.Color;

public class FireCell extends Cell {

	public static final Color GROUND_COLOR = DataHolder.BURNT_COLOR;
	public static final Color TREE_COLOR = DataHolder.TREE_COLOR;
	public static final Color FIRE_COLOR = DataHolder.BURNING_COLOR;
	
	private static final int EMPTY = 0;
	private static final int TREE = 1;
	private static final int BURNING = 2;
	
	public static final double probCatch = 0.5;
	
	public FireCell(int x, int y, int width, int height, int state) {
		this(x, y, width, height);
		this.setState(state);
		if(state == EMPTY) this.setFill(getPaint(GROUND_COLOR));
		else if(state == TREE) this.setFill(getPaint(TREE_COLOR));
		else this.setFill(getPaint(FIRE_COLOR));
	}
	
	public FireCell(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void updateState() {
		if(getState() == EMPTY) return;
		else if(getState() == BURNING) {
			this.setState(EMPTY);
			this.setFill(getPaint(GROUND_COLOR));
		} else {
			if(catchesFire()) {
				this.setState(BURNING);
				this.setFill(getPaint(FIRE_COLOR));
			}
		}
		
	}

	private boolean catchesFire() {
		for(int state : getNeighborStates()) {
			Random rand = new Random();
			 if (state == BURNING && rand.nextDouble() < probCatch) return true;
		}
		return false;
	}
	
}
