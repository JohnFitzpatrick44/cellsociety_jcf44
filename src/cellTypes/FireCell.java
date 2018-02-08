package cellTypes;

import java.util.Random;

import XML.DataHolder;

import javafx.scene.paint.Color;

/**
 * @author Jack Fitzpatrick
 * Cell specific to the Spreading Fire simulation
 */
public class FireCell extends Cell {

	private final Color GROUND_COLOR = DataHolder.BURNT_COLOR;
	private final Color TREE_COLOR = DataHolder.TREE_COLOR;
	private final Color FIRE_COLOR = DataHolder.BURNING_COLOR;
	private final int MAX_STATE = 2;

	private final int EMPTY = 0;
	private final int TREE = 1;
	private final int BURNING = 2;

	private final double probCatch = DataHolder.PROB_CATCH;

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
		if(getState() == EMPTY) {
			return;
		}
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
			if (state == BURNING && rand.nextDouble() < probCatch) {
				return true;
			}
		}
		return false;
	}

	public int getMaxState() {
		return MAX_STATE;
	}

	public void updateFill() {
		if(getState() == EMPTY) {
			setFill(GROUND_COLOR);
		}
		else if(getState() == TREE) {
			setFill(TREE_COLOR);
		}
		else {
			setFill(FIRE_COLOR);
		}
	}

}
