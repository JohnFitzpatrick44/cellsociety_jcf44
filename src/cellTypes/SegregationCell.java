package cellTypes;

import javafx.scene.paint.Color;

public class SegregationCell extends Cell {
	
	public static final Color A_COLOR = Color.RED;
	public static final Color B_COLOR = Color.BLUE;
	public static final Color NEUTRAL_COLOR = Color.WHITE;
	
	private double cutoff;
		
	public SegregationCell(int x, int y, int width, int height, double co, int state) {
		this(x, y, width, height);
		setState(state);
		if(state == 0) this.setFill(NEUTRAL_COLOR);
		else if(state == 1) this.setFill(A_COLOR);
		else this.setFill(B_COLOR);
		this.cutoff = co;
	}

	public SegregationCell(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.setFill(NEUTRAL_COLOR);
	}

	public SegregationCell() {
		this(0, 0, 0, 0);
	}
	
	public void updateState() {
		if(getSwapped() || getState() == 0) return;
		
		if(getPercentAlike() < cutoff) {
			Cell swapping = getCellMover().findOpenCell();
			swapState(swapping);
		}
		
	}
	
	
	private double getPercentAlike() {
		double like = 0;
		double unlike = 0;
		for(int state : getNeighborStates()) {
			if(state == getState()) like++;
			else if(state != 0) unlike++;
		}
		if(unlike == 0) return 1;
		return like/unlike;
	}
	
	private void swapState(Cell swapping) {
		swapping.setState(this.getState());
		if(swapping.getState() == 1) swapping.setFill(A_COLOR);
		else swapping.setFill(B_COLOR);
		this.setState(0);
		this.setFill(NEUTRAL_COLOR);
		this.setSwapped(true);
		swapping.setSwapped(true);
	}

}
