package cellTypes;

import XML.DataHolder;
import javafx.scene.paint.Color;

public class SegregationCell extends Cell {
	
	public static final Color A_COLOR = DataHolder.A_COLOR;
	public static final Color B_COLOR = DataHolder.B_COLOR;
	public static final Color NEUTRAL_COLOR = DataHolder.NEUTRAL_COLOR;
	public static final int MAX_STATE = 2;
	
	private static final int EMPTY = 0;
	private static final int A_STATE = 1;
	//private static final int B_STATE = 2;
	private double cutoff;
		
	public SegregationCell(int x, int y, int width, int height, double co, int state) {
		this(x, y, width, height);
		setState(state);
		updateFill();
		this.cutoff = co;
	}

	public SegregationCell(int x, int y, int width, int height) {
		super(x, y, width, height);
		updateFill();
	}

	public SegregationCell() {
		this(0, 0, 0, 0);
	}
	
	public void updateState() {
		if(getSwapped() || getState() == EMPTY) {
			return;
		}
		
		if(getPercentAlike() < cutoff) {
			Cell swapping = getCellMover().findOpenCell();
			if(swapping == null) {
				return;
			}
			swapState(swapping);
		}
		updateFill();
	}
	
	private double getPercentAlike() {
		double like = 0;
		double unlike = 0;
		for(int state : getNeighborStates()) {
			if(state == getState()) {
				like++;
			}
			else if(state != EMPTY) {
				unlike++;
			}
		}
		if(unlike == 0) {
			return 1;
		}
		return like/(like+unlike);
	}
	
	private void swapState(Cell swapping) {
		swapping.setState(this.getState());
		this.setState(EMPTY);
		this.setSwapped(true);
		swapping.setSwapped(true);
		updateFill();
		swapping.updateFill();
	}
	
	public int getMaxState() {
		return MAX_STATE;
	}
	
	public void updateFill() {
		if(getState() == EMPTY) {
			setFill(NEUTRAL_COLOR);
		}
		else if(getState() == A_STATE) {
			setFill(A_COLOR);
		}
		else {
			setFill(B_COLOR);
		}
	}

}
