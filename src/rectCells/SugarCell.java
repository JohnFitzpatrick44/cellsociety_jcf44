package rectCells;

import javafx.scene.paint.Color;

public class SugarCell extends Cell {

	private static final int SUGAR_COLOR_RED = 255;
	private static final int SUGAR_COLOR_GREEN = 255;
	private static final int SUGAR_COLOR_BLUE = 255;
	
	private static final int GROW_RATE = 5;
	private static final int GROW_INTERVAL = 2;
	
	private int maxCapacity;
	private int interval;
	
	
	public SugarCell(int state, double...points) {
		this(points);
		this.setState(state);
		maxCapacity = state;
		interval = 0;
		updateFill();
	}

	public SugarCell(double...points) {
		super(points);
		updateFill();
	}
	
	
	public void updateState() {
		interval++;
		if(interval == GROW_INTERVAL) {
			interval = 0;
			setState(getState() + GROW_RATE);
		}
		updateFill();
	}

	public void updateFill() {
		setFill(Color.rgb(SUGAR_COLOR_RED, SUGAR_COLOR_GREEN, SUGAR_COLOR_BLUE*getState()/maxCapacity));
		
	}

	
	public void setCapacity(int c) {
		setState(c);
		maxCapacity = c;
	}
	
	public int getMaxState() {
		// TODO Auto-generated method stub
		return 100;
	}

}
