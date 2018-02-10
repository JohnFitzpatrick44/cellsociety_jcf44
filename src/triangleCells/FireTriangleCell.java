package triangleCells;

import java.util.Random;

import XML.FireHolder;
import javafx.scene.paint.Color;

public class FireTriangleCell extends TriangleCell{
	
	private static final Color GROUND_COLOR = FireHolder.getBurntColor();
	private static final Color TREE_COLOR = FireHolder.getTreeColor();
	private static final Color FIRE_COLOR = FireHolder.getBurningColor();
	private static final int MAX_STATE = 2;

	private static final int EMPTY = 0;
	private static final int TREE = 1;
	private static final int BURNING = 2;

	private static final double PROB_CATCH = FireHolder.getProbCatch();

	public FireTriangleCell(double x, double y, double side) {
		super(x, y, side);
		updateFill();
	}
	
	public FireTriangleCell(double x, double y, double side, int state) {
		this(x, y, side);
		this.setState(state);
		updateFill();
	}
	
	public FireTriangleCell(double x, double y, double side, int state, boolean isInverted) {
		this(x, y, side);
		if(isInverted) {
			this.makeInvertedTriangle(side);
		} else {
			this.makeTriangle(side);
		}
		this.setState(state);
		updateFill();
	}
	
	public FireTriangleCell() {
		this(0.0,0.0,0.0);
	}

	@Override
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

	@Override
	public int getMaxState() {
		return MAX_STATE;
	}
	
	@Override
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
