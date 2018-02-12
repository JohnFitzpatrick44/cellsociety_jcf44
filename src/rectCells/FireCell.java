package rectCells;

import java.util.Random;

import XML.FireHolder;
import javafx.scene.paint.Color;

/**
 * @author Jack Fitzpatrick
 * Cell specific to the Spreading Fire simulation
 */
public class FireCell extends Cell {

	private static Color GROUND_COLOR = FireHolder.getBurntColor();
	private static Color TREE_COLOR = FireHolder.getTreeColor();
	private static Color FIRE_COLOR = FireHolder.getBurningColor();
	private static final int MAX_STATE = 2;

	private static final int EMPTY = 0;
	private static final int TREE = 1;
	private static final int BURNING = 2;

	private static final double PROB_CATCH = FireHolder.getProbCatch();

	/**
	 * Constructor for a fire cell
	 * @param x X position
	 * @param y Y position
	 * @param width Width of Cell
	 * @param height Height of Cell
	 * @param state Initial state of Cell
	 */
	public FireCell(int state, double...points) {
		this(points);
		refreshValues();
		this.setState(state);
		updateFill();
	}

	public FireCell(double...points) {
		super(points);
		updateFill();
	}

	private void refreshValues() {
		GROUND_COLOR = FireHolder.getBurntColor();
		TREE_COLOR = FireHolder.getTreeColor();
		FIRE_COLOR = FireHolder.getBurningColor();
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
			if (state == BURNING && rand.nextDouble() < PROB_CATCH) {
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
