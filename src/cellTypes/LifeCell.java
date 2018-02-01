package cellTypes;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class LifeCell extends Cell {
	
	public static final Color DEAD_COLOR = Color.WHITE;
	public static final Color ALIVE_COLOR = Color.BLACK;
		
	public LifeCell(int x, int y, int width, int height, int state) {
		this(x, y, width, height);
		setState(state);
		if(state == 0) this.setFill(DEAD_COLOR);
		else this.setFill(ALIVE_COLOR);
	}
	
	public LifeCell(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.setFill(DEAD_COLOR);
	}
	
	public LifeCell() {
		this(0, 0, 0, 0);
	}

	public void updateState() {
		int numAlive = sumArray(this.getNeighborStates());
		if(getState() != 0) {
			if(numAlive < 0 || numAlive > 3) {
				setState(0);
				this.setFill(DEAD_COLOR);
			}
		} else {
			if(numAlive == 3) {
				setState(1);
				this.setFill(ALIVE_COLOR);
			}
		}
	}
	
	private int sumArray(ArrayList<Integer> arr) {
		int sum = 0;
		for(int x : arr) {
			sum += x;
		}
		return sum;
	}
	
}
