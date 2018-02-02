package cellTypes;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class LifeCell extends Cell {
	
	public static final Color DEAD_COLOR = Color.WHITE;
	public static final Color ALIVE_COLOR = Color.BLACK;
	
	private int state;
	
	public LifeCell(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.state = 0;
		this.setFill(DEAD_COLOR);
		this.setStroke(ALIVE_COLOR);
	}
	
	public LifeCell() {
		this(0, 0, 0, 0);
	}

	public void updateState() {
		int numAlive = sumArray(this.getNeighborStates());
		if(state != 0) {
			if(numAlive < 0 || numAlive > 3) {
				state = 0;
				this.setFill(DEAD_COLOR);
			}
		} else {
			if(numAlive == 3) {
				state = 1;
				this.setFill(ALIVE_COLOR);
			}
		}
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public int getState() {
		return state;
	}
	
	private int sumArray(ArrayList<Integer> arr) {
		int sum = 0;
		for(int x : arr) {
			sum += x;
		}
		return sum;
	}
	
}
