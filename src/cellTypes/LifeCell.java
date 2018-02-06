package cellTypes;

import java.util.List;

import XML.DataHolder;
import javafx.scene.paint.Color;


public class LifeCell extends Cell {
	
	public static final Color DEAD_COLOR = DataHolder.getDeadColor();
	public static final Color ALIVE_COLOR = DataHolder.getAliveColor();

	public static final int MAX_STATE = 1;
			
	public LifeCell(int x, int y, int width, int height, int state) {
		this(x, y, width, height);
		setState(state);
		if(state == 0) this.setFill(DEAD_COLOR);
		else this.setFill(ALIVE_COLOR);
		updateFill();
	}
	
	public LifeCell(int x, int y, int width, int height) {
		super(x, y, width, height);
		setState(0);
		updateFill();
	}
	
	public LifeCell() {
		this(0, 0, 0, 0);
	}

	public void updateState() {
		int numAlive = sumArray(this.getNeighborStates());
		if(this.getState() == 1) {
			if(numAlive <= 1 || numAlive > 3) {
				this.setState(0);
			}
		} else if(this.getState() == 0) {
			if(numAlive == 3) {
				this.setState(1);
			}
		}
		updateFill();
	}

	private int sumArray(List<Integer> arr) {
		int sum = 0;
		for(int x : arr) sum += x;
		return sum;
	}

	public int getMaxState() {
		return MAX_STATE;
	}
	
	public void updateFill() {
		if(getState() == 0) setFill(DEAD_COLOR);
		else setFill(ALIVE_COLOR);
	}
	
}
