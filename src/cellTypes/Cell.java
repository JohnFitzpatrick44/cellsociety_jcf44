package cellTypes;

import java.util.ArrayList;

//import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.awt.Color;

public abstract class Cell extends Rectangle implements IGrid, ICell{
	
//	public static final Color DEFAULT_COLOR = Color.WHITE;
//	public static final Color BORDER_COLOR = Color.BLACK;
	
	private ArrayList<Cell> neighbors;
	private ArrayList<Integer> neighborStates;
	private int state;
	private CellMover cm;
	private boolean swapped;
	
	public Cell(int x, int y, int width, int height) {
		super(x, y, width, height);
//		this.setFill(DEFAULT_COLOR);
//		this.setStroke(BORDER_COLOR);
		this.neighbors = new ArrayList<Cell>();
		this.neighborStates = new ArrayList<Integer>();
		this.state = 0;
	}
	
	public void updateNeighborStates() {
		neighborStates.clear();
		for(Cell c: neighbors) {
			neighborStates.add(c.getState());
		}
		swapped = false;
	}
	
	public Paint getPaint(Color color) {
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		int a = color.getAlpha();
		double opacity = a/255.0;
		javafx.scene.paint.Color newColor = javafx.scene.paint.Color.rgb(r, g, b, opacity);
		return newColor;
	}
		
	public void setState(int state) {
		this.state = state;
	}
	
	public int getState() {return state;}
	
	public void setNeighbor(Cell c) {
		this.neighbors.add(c);
	}
	
	public void setNeighbors(Cell...neighborCells) {
		for(Cell neighbor:neighborCells) {
			this.neighbors.add(neighbor);
		}
	}
	
	public ArrayList<Integer> getNeighborStates() {
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
