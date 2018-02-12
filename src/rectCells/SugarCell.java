package rectCells;

import XML.SugarHolder;
import javafx.scene.paint.Color;

public class SugarCell extends Cell {

	private static int SUGAR_COLOR_RED = SugarHolder.getColorOne();
	private static int SUGAR_COLOR_GREEN = SugarHolder.getColorTwo();
	private static int SUGAR_COLOR_BLUE = SugarHolder.getColorThree();
	
	private static int GROW_RATE = SugarHolder.getGrowthRate();
	private static int GROW_INTERVAL = SugarHolder.getGrowthInterval();
	
	private static final int MAX_CAPACITY = 100;
	
	private int maxCapacity;
	private int interval;
	private SugarAgent agent;
	
	
	private static void refreshValues() {
		SUGAR_COLOR_RED = SugarHolder.getColorOne();
		SUGAR_COLOR_GREEN = SugarHolder.getColorTwo();
		SUGAR_COLOR_BLUE = SugarHolder.getColorThree();
		GROW_RATE = SugarHolder.getGrowthRate();
		GROW_INTERVAL = SugarHolder.getGrowthInterval();
	}
	
	
	public SugarCell(int state, double...points) {
		this(points);
		refreshValues();
		this.setState(state);
		maxCapacity = state;
		interval = 0;
		updateFill();
		agent = null;
	}

	public SugarCell(double...points) {
		super(points);
		updateFill();
	}
	
	
	public void updateState() {
		
		if(getState() == maxCapacity) {
			interval = 0;
		} else {
			interval++;
		}
		
		if(interval == GROW_INTERVAL) {
			interval = 0;
			setState(getState() + GROW_RATE);
		}
		if(getState() > maxCapacity) {
			setState(maxCapacity);
		}
		updateFill();
	}

	public void updateFill() {
		if(getState() > maxCapacity) {
			setState(maxCapacity);
		}
		if(maxCapacity != 0) {
			setFill(Color.rgb(SUGAR_COLOR_RED, SUGAR_COLOR_GREEN, SUGAR_COLOR_BLUE-SUGAR_COLOR_BLUE*getState()/MAX_CAPACITY));
		}
		
	}

	
	public void setCapacity(int c) {
		setState(c);
		maxCapacity = c;
	}
	
	public int getMaxState() {
		return MAX_CAPACITY;
	}
	
	public SugarAgent getAgent() {
		return agent;
	}
	
	public void setAgent(SugarAgent sa) {
		agent = sa;
	}
	
	

}
