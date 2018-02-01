package cellTypes;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Cell extends Rectangle implements IGrid, ICell{
	
	public static final Color DEFAULT_COLOR = Color.WHITE;
	
	private int state;
	private ArrayList<ICell> neighbors;
	private ArrayList<Integer> neighborStates;
	
	public Cell(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.setFill(DEFAULT_COLOR);
		this.neighbors = new ArrayList<ICell>();
		this.neighborStates = new ArrayList<Integer>();
		this.state = 0;
	}
	
	public void updateNeighborStates() {
		for(int k = 0; k < neighbors.size(); k++) {
			neighborStates.set(k, neighbors.get(k).getState());
		}
	}
	
	//public void updateState() {}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public int getState() {return state;}
	
	public void setNeighbor(Cell c) {
		this.neighbors.add(c);
	}
	
	public ArrayList<Integer> getNeighborStates() {
		return neighborStates;
	}
		
}
