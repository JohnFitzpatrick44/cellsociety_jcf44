package cellTypes;

import java.util.Random;

import XML.DataHolder;

import javafx.scene.paint.Color;

/**
 * @author Jack Fitzpatrick
 * Cell specific to the Spreading Fire simulation
 */
public class FireCell extends Cell {

	public static final Color GROUND_COLOR = DataHolder.BURNT_COLOR;
	public static final Color TREE_COLOR = DataHolder.TREE_COLOR;
	public static final Color FIRE_COLOR = DataHolder.BURNING_COLOR;
	public static final int MAX_STATE = 2;
	
	private static final int EMPTY = 0;
	private static final int TREE = 1;
	private static final int BURNING = 2;
	
	public static final double probCatch = 0.5;
	
	/**
	 * Constructor for a fire cell
	 * @param x X position
	 * @param y Y position
	 * @param width Width of Cell
	 * @param height Height of Cell
	 * @param state Initial state of Cell
	 */
	public FireCell(int x, int y, int width, int height, int state) {
		this(x, y, width, height);
		this.setState(state);
		updateFill();
	}
	
	public FireCell(int x, int y, int width, int height) {
		super(x, y, width, height);
		updateFill();
	}

	public void updateState() {
		if(getState() == EMPTY) return;
		else if(getState() == BURNING) {
			this.setState(EMPTY);
		} else {
			if(catchesFire()) {
				this.setState(BURNING);
			}
		}
		updateFill();
		
	}

	private boolean catchesFire() {
		for(int state : getNeighborStates()) {
			Random rand = new Random();
			 if (state == BURNING && rand.nextDouble() < probCatch) return true;
		}
		return false;
	}
	
	public int getMaxState() {
		return MAX_STATE;
	}
	
	public void updateFill() {
		if(getState() == EMPTY) setFill(GROUND_COLOR);
		else if(getState() == TREE) setFill(TREE_COLOR);
		else setFill(FIRE_COLOR);
	}
	
}
