package cellTypes;

import java.util.List;

import XML.DataHolder;
import javafx.scene.paint.Color;


public class LifeCell extends Cell {

	private final Color DEAD_COLOR = DataHolder.getDeadColor();
	private final Color ALIVE_COLOR = DataHolder.getAliveColor();

	private final int MAX_STATE = 1;

	private final int DEAD = 0;
	private final int ALIVE = 1;
	private final int MIN_ALIVE = 2;
	private final int MAX_ALIVE = 3;

	public LifeCell(int x, int y, int width, int height, int state) {
		this(x, y, width, height);
		setState(state);
		if(state == 0) {
			this.setFill(DEAD_COLOR);
		}
		else {
			this.setFill(ALIVE_COLOR);
		}
		updateFill();
	}

	public LifeCell(int x, int y, int width, int height) {
		super(x, y, width, height);
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
		} else if(this.getState() == DEAD) {
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
