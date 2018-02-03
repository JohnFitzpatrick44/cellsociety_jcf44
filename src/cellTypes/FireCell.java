package cellTypes;

import java.util.Random;

import javafx.scene.paint.Color;

public class FireCell extends Cell {

	public static final Color GROUND_COLOR = Color.YELLOW;
	public static final Color TREE_COLOR = Color.GREEN;
	public static final Color FIRE_COLOR = Color.RED;
	
	public static final double probCatch = 0.5;
	
	public FireCell(int x, int y, int width, int height, int state) {
		this(x, y, width, height);
		setState(state);
		if(state == 0) this.setFill(GROUND_COLOR);
		else if(state == 1) this.setFill(TREE_COLOR);
		else this.setFill(FIRE_COLOR);
	}
	
	public FireCell(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void updateState() {
		if(getState() == 0) return;
		else if(getState() == 2) {
			setState(0);
			setFill(GROUND_COLOR);
		} else {
			if(catchesFire()) {
				setState(2);
				setFill(FIRE_COLOR);
			}
		}
		
	}

	private boolean catchesFire() {
		for(int state : getNeighborStates()) {
			Random rand = new Random();
			 if (state == 2 && rand.nextDouble() < probCatch) return true;
		}
		return false;
	}
	
}
