package triangleCells;

import java.util.List;

import XML.LifeHolder;
import javafx.scene.paint.Color;

public class LifeTriangleCell extends TriangleCell{
	
	private static final Color DEAD_COLOR = LifeHolder.getDeadColor();
	private static final Color ALIVE_COLOR = LifeHolder.getAliveColor();
	
	private static final int MAX_STATE = 1;
	
	private static final int DEAD = 0;
	private static final int ALIVE = 1;
	private static final int MIN_ALIVE = 1;
	private static final int MAX_ALIVE = 2;

	public LifeTriangleCell(double x, double y, double side) {
		super(x, y, side);
		setState(DEAD);
		updateFill();
	}
	
	public LifeTriangleCell(double x, double y, double side, int state) {
		this(x,y,side);
		setState(state);
		updateFill();
	}
	
	public LifeTriangleCell(double x, double y, double side, int state, boolean isInverted) {
		this(x,y,side);
		if(isInverted) {
			this.makeInvertedTriangle(side);
		} else {
			this.makeTriangle(side);
		}
		setState(state);
		updateFill();

	}
	
	public LifeTriangleCell() {
		this(0.0,0.0,0.0);
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

	@Override
	public void updateFill() {
		if(getState() == DEAD) {
			setFill(DEAD_COLOR);
		}
		else {
			setFill(ALIVE_COLOR);
		}		
	}

	@Override
	public int getMaxState() {
		return MAX_STATE;
	}

}
