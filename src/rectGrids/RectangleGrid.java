package rectGrids;

import rectCells.Cell;
import rectCells.CellMover;

/**
 * 
 * @author Hemanth Yakkali
 * Abstract class to be used in tandem with Rectangle-shaped cells
 * Creates a grid, methods for setting cardinal and all neighbors
 */

public abstract class RectangleGrid extends Grid{
	
	private CellMover cm = new CellMover();
	
	/**
	 * @param offset Amount of offset from edge of user interface
	 * @param gridSize Number of rows and columns of cells
	 * @param cellWidth Width of each cell
	 * @param cellHeight Height of each cell
	 * @param cutOff
	 * @return 2D array of Cells
	 */
	public abstract Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff);
	
	public CellMover getCm() {return cm;}
	
}
