package rectCells;

import java.util.concurrent.ThreadLocalRandom;

import XML.BacteriaHolder;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class BacteriaCell extends Cell {
	
	private static final int MAX_STATE = 3;
	
	private static Color DEFAULT_COLOR = BacteriaHolder.getDefaultColor();
	private static Color A_COLOR = BacteriaHolder.getColorA();
	private static Color B_COLOR = BacteriaHolder.getColorB();
	private static Color C_COLOR = BacteriaHolder.getColorC();
	
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
		level = 10;
		EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>() { // Allows user to change cell states by right or left clicking
			@Override
			public void handle(MouseEvent me) {
				if(getState() < getMaxState()) {
					setState(getState()+1);
				}
				else {
					setState(0);
				}
				level = 10;
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
				if(level > 10) {
					level = 10;
				}
			}
		}
		updateFill();
	}

	private boolean eaten(int state1, int state2) {
		return (state1 == 1 && state2 == 2) || (state1 == 2 && state2 == 3) || (state1 == 3 && state2 == 1);
	}
	
	public void updateFill() {
		Color toFill = DEFAULT_COLOR;
		switch(getState()) {
		case 0:
			setFill(toFill);
			return;
		case 1:
			toFill = A_COLOR;
			break;
		case 2:
			toFill = B_COLOR;
			break;
		case 3:
			toFill = C_COLOR;
			break;
		}
		for(int k = 5; k > level; k--) {
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
