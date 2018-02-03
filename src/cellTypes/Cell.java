package cellTypes;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Cell extends Rectangle implements IGrid, ICell{
	
	public static final Color DEFAULT_COLOR = Color.WHITE;
	public static final Color BORDER_COLOR = Color.BLACK;
	
	private ArrayList<Cell> neighbors;
	private ArrayList<Integer> neighborStates;
	private int state;
	private CellMover cm;
	private boolean swapped;
	
	public Cell(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.setFill(DEFAULT_COLOR);
		this.setStroke(BORDER_COLOR);
		this.neighbors = new ArrayList<Cell>();
		this.neighborStates = new ArrayList<Integer>();
		this.state = 0;
	}
	
	public void updateNeighborStates() {
		neighborStates.clear();
		for(Cell c: neighbors) {
//			neighborStates.set(k, neighbors.get(k).getState());
			neighborStates.add(c.getState());
		}
		swapped = false;
	}
		
	public void setState(int state) {
		this.state = state;
	}
	
	public int getState() {return state;}
	
	public void setNeighbor(Cell c) {
		this.neighbors.add(c);
	}
	
	public ArrayList<Integer> getNeighborStates() {
//		for(Cell neighbor:neighbors) {
//			neighborStates.add(neighbor.getState());
//		}
		updateNeighborStates();
		return neighborStates;
	}
	
	public ArrayList<Cell> getNeighbors() {
		return neighbors;
	}
	
	public void setCellMover(CellMover cmNew) {
		cm = cmNew;
	}
		
	public CellMover getCellMover() {
		return cm;
	}
	
	public void setSwapped(boolean b) {
		swapped = b;
	}
	
	public boolean getSwapped() {
		return swapped;
	}
	
}
