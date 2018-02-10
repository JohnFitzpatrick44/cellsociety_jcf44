package triangleCells;

import XML.SegregationHolder;
import javafx.scene.paint.Color;
import rectCells.Cell;

public class SegregationTriangleCell extends TriangleCell{
	
	private static final Color A_COLOR = SegregationHolder.getAColor();
	private static final Color B_COLOR = SegregationHolder.getBColor();
	private static final Color NEUTRAL_COLOR = SegregationHolder.getNeutralColor();
	private static final int MAX_STATE = 2;

	private static final int EMPTY = 0;
	private static final int A_STATE = 1;
	
	private double cutoff;

	public SegregationTriangleCell(double x, double y, double side) {
		super(x, y, side);
		updateFill();
	}
	
	public SegregationTriangleCell(double x, double y, double side, double co, int state) {
		this(x,y,side);
		setState(state);
		updateFill();
		this.cutoff = co;
	}
	
	public SegregationTriangleCell(double x, double y, double side, double co, int state, boolean isInverted) {
		this(x,y,side);
		if(isInverted) {
			this.makeInvertedTriangle(side);
		} else {
			this.makeTriangle(side);
		}
		setState(state);
		updateFill();
	}

	@Override
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
		int like = 0;
		int unlike = 0;
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
		return (double)like/ (double)(like+unlike);
	}

	private void swapState(Cell swapping) {
		swapping.setState(this.getState());
		this.setState(EMPTY);
		this.setSwapped(true);
		swapping.setSwapped(true);
		updateFill();
		swapping.updateFill();
	}

	@Override
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

	@Override
	public int getMaxState() {
		return MAX_STATE;
	}

}
