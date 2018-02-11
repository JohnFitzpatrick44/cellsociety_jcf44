package rectCells;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class BacteriaCell extends Cell {
	
	private static final int MAX_STATE = 3;
	
	private static final Color DEFAULT_COLOR = Color.WHITE;
	private static final Color A_COLOR = Color.RED;
	private static final Color B_COLOR = Color.BLUE;
	private static final Color C_COLOR = Color.YELLOW;
	
	private int level;

	public BacteriaCell(int state, double...points) {
		this(points);
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
			if(eaten(getNeighborStates().get(k))) {
				setState(getNeighborStates().get(k));
				level = Math.min(10, ((BacteriaCell) getNeighbors().get(k)).getLevel() + 2);
			}
		}
		updateFill();
	}

	private boolean eaten(int state) {
		return (state == 1 && getState() == 2) || (state == 2 && getState() == 3) || (state == 3 && getState() == 1);
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
		for(int k = 10; k > level; k--) {
			toFill = toFill.desaturate();
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
