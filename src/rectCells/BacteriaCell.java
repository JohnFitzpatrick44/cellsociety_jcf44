package rectCells;

import java.util.concurrent.ThreadLocalRandom;

import XML.BacteriaHolder;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class BacteriaCell extends Cell {
	
	private static final int MAX_STATE = 3;
	
	private static final int A = 1;
	private static final int B = 2;
	private static final int C = 3;	
	
	private static Color DEFAULT_COLOR = BacteriaHolder.getDefaultColor();
	private static Color A_COLOR = BacteriaHolder.getColorA();
	private static Color B_COLOR = BacteriaHolder.getColorB();
	private static Color C_COLOR = BacteriaHolder.getColorC();
	
	private static final int MAX_LEVEL = 10;
	
	private int level;
	
	private void refreshValues() {
		DEFAULT_COLOR = BacteriaHolder.getDefaultColor();
		A_COLOR = BacteriaHolder.getColorA();
		B_COLOR = BacteriaHolder.getColorB();
		C_COLOR = BacteriaHolder.getColorC();
	}

	public BacteriaCell(int state, double...points) {
		this(points);
		refreshValues();
		setState(state);
		updateFill();
	}

	public BacteriaCell(double...points) {
		super(points);
		setState(0);
		level = MAX_LEVEL;
		EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>() { // Allows user to change cell states by right or left clicking
			@Override
			public void handle(MouseEvent me) {
				if(getState() < getMaxState()) {
					setState(getState()+1);
				}
				else {
					setState(0);
				}
				level = MAX_LEVEL;
				updateFill();
			}
		};
		this.setOnMouseClicked(eh);
		this.setOnMouseDragEntered(eh);
		updateFill();
	}
	
	public void updateState() {
		int k = ThreadLocalRandom.current().nextInt(0, getNeighbors().size());
		if(getState() == 0) {
			setState(getNeighborStates().get(k));
			level = ((BacteriaCell) getNeighbors().get(k)).getLevel()-1;
			if(level <= 0) {
				setState(0);
				level = 0;
			}
		} else {
			if(eaten(getNeighborStates().get(k), getState())) {
				level -= ((BacteriaCell) getNeighbors().get(k)).getLevel()/2;
				if(level<= 0) {
					level = 0;
					setState(0);
				}
			} else if(eaten(getState(), getNeighborStates().get(k))) {
				level += ((BacteriaCell) getNeighbors().get(k)).getLevel()/2;
				if(level > MAX_LEVEL) {
					level = MAX_LEVEL;
				}
			}
		}
		updateFill();
	}

	private boolean eaten(int state1, int state2) {
		boolean ab = (state1 == A && state2 == B);
		boolean bc = (state1 == B && state2 == C);
		boolean ca = (state1 == C && state2 == A);
		
		return ab || bc || ca;
	}
	
	public void updateFill() {
		Color toFill = DEFAULT_COLOR;
		switch(getState()) {
		case 0:
			setFill(toFill);
			return;
		case A:
			toFill = A_COLOR;
			break;
		case B:
			toFill = B_COLOR;
			break;
		case C:
			toFill = C_COLOR;
			break;
		}
		for(int k = MAX_LEVEL/2; k > level; k--) {
			toFill = toFill.darker();
		}
		setFill(toFill);
	}

	public int getMaxState() {
		return MAX_STATE;
	}

	public void setLevel(int lvl) {
		level = lvl;
	}
	
	public int getLevel() {
		return level;
	}
	
}
