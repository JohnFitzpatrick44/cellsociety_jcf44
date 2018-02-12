package rectCells;

import XML.SegregationHolder;
import javafx.scene.paint.Color;

public class SegregationCell extends Cell {

	private static Color A_COLOR = SegregationHolder.getAColor();
	private static Color B_COLOR = SegregationHolder.getBColor();
	private static Color NEUTRAL_COLOR = SegregationHolder.getNeutralColor();
	
	private static final int MAX_STATE = 2;

	private static final int EMPTY = 0;
	private static final int A_STATE = 1;
	
	private static final double INIT_CO = 0.5;

	private double cutoff;

	private void refreshValues() {
		A_COLOR = SegregationHolder.getAColor();
		B_COLOR = SegregationHolder.getBColor();
		NEUTRAL_COLOR = SegregationHolder.getNeutralColor();
	}
	
	public SegregationCell(int state, double...points) {
		this(points);
		setState(state);
		refreshValues();
		updateFill();
		this.cutoff = INIT_CO;
	}

	public SegregationCell(double...points) {
		super(points);
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
