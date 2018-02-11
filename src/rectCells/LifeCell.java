package rectCells;

import java.util.List;

import XML.LifeHolder;
import javafx.scene.paint.Color;


public class LifeCell extends Cell {

	private static final Color DEAD_COLOR = LifeHolder.getDeadColor();
	private static final Color ALIVE_COLOR = LifeHolder.getAliveColor();

	private static final int MAX_STATE = 1;

	private static final int DEAD = 0;
	private static final int ALIVE = 1;
	private static final int MIN_ALIVE = 2;
	private static final int MAX_ALIVE = 3;

	public LifeCell(int state, double...points) {
		this(points);
		setState(state);
		updateFill();
	}

	public LifeCell(double...points) {
		super(points);
		setState(DEAD);
		updateFill();
	}

	public LifeCell() {
		this(0, 0, 0, 0);
	}

	public void updateState() {
		int numAlive = sumArray(this.getNeighborStates());
		if(this.getState() == ALIVE) {
			if(numAlive < MIN_ALIVE || numAlive > MAX_ALIVE) {
				this.setState(DEAD);
			}
		} else {
			if(numAlive == MAX_ALIVE) {
				this.setState(ALIVE);
			}
		}
		updateFill();
	}

	private int sumArray(List<Integer> arr) {
		int sum = 0;
		for(int x : arr) {
			sum += x;
		}
		return sum;
	}

	public int getMaxState() {
		return MAX_STATE;
	}

	public void updateFill() {
		if(getState() == DEAD) {
			setFill(DEAD_COLOR);
		}
		else {
			setFill(ALIVE_COLOR);
		}
	}

}
