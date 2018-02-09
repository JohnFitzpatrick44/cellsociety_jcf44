package cellTypes;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

public abstract class TriangleCell extends Triangle implements IGrid{
	
	public static final Color BORDER_COLOR = Color.BLACK;

	/**
	 * Array of neighboring cells, as determined by grid
	 */
	private List<Cell> neighbors;

	/**
	 * Array to store neighboring cell states, so that storing neighbor states and updating state are separate steps
	 */
	private List<Integer> neighborStates;

	/**
	 * Number and type of states vary by simulation, but will be stored as an int
	 */
	private int state;

	/**
	 * Allows individual cells access to information about the grid as a whole
	 */
	private CellMover cm;

	/**
	 * For simulations that move cells, can track if a cell has been moved already
	 */
	private boolean swapped;

	public TriangleCell(double x, double y, double side) {
		super(x, y, side);
		this.setStroke(BORDER_COLOR);
		this.neighbors = new ArrayList<>();
		this.neighborStates = new ArrayList<>();
		this.state = 0;
	}
	
	public void makeInvertedTriangle(double side) {
		this.getPoints().addAll(
				0.0,0.0,
				side,0.0,
				side,side
				);
	}
	
	public void makeTriangle(double side) {
		this.getPoints().addAll(
				0.0,0.0,
				0.0,side,
				side,side
				);
	}
	
	/**
	 * Abstract class to change Cell color based on state
	 */
	public abstract void updateFill();

	/**
	 * Tells Cells to store states of neighbors into Array
	 */
	public void updateNeighborStates() {
		neighborStates.clear();
		for(Cell c: neighbors) {
			neighborStates.add(c.getState());
		}
		swapped = false;
	}

	/**
	 * Method to find largest possible state of a simulation specific Cell
	 * @return Max state of simulation Cell
	 */
	public abstract int getMaxState();

	/**
	 * Sets state of a Cell
	 * @param state New state of Cell
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * Gets state of Cell
	 * @return Cell state
	 */
	public int getState() {
		return state;
	}

	/**
	 * Adds a new Cell to neighbor list
	 * @param New neighboring Cell
	 */
	public void setNeighbor(Cell c) {
		this.neighbors.add(c);
	}

	/**
	 * Adds multiple Cells to neighbor list
	 * @param neighborCells Cells to be added to neighbors
	 */
	public void setNeighbors(Cell...neighborCells) {
		for(Cell neighbor:neighborCells) {
			this.neighbors.add(neighbor);
		}
	}

	/**
	 * Gets states of neighbors
	 * @return Array of neighbor states
	 */
	public List<Integer> getNeighborStates() {
		return neighborStates;
	}

	/**
	 * Gets array of neighbors
	 * @return Neighbors array
	 */
	public List<Cell> getNeighbors() {
		return neighbors;
	}

	/**
	 * Adds a CellMover, if required by simulation
	 * @param cmNew New CellMover object
	 */
	public void setCellMover(CellMover cmNew) {
		cm = cmNew;
	}

	/**
	 * Gets simulation's CellMover
	 * @return Simulation's CellMover
	 */
	public CellMover getCellMover() {
		return cm;
	}

	/**
	 * Sets swapped value
	 * @param b New swapped value
	 */
	public void setSwapped(boolean b) {
		swapped = b;
	}

	/**
	 * Gets swapped value
	 * @return Swapped value
	 */
	public boolean getSwapped() {
		return swapped;
	}

	@Override
	public void updateState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setX(double x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWidth(double w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeight(double h) {
		// TODO Auto-generated method stub
		
	}
	
	
}
