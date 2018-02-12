package triangleGrids;

import rectCells.Cell;

import rectCells.CellMover;
import rectGrids.Grid;

/**
 * 
 * @author Hemanth Yakkali
 * Abstract TriangleGrid class, to be used in tandem with other triangle grids
 * Creates a triangle grid
 */

public abstract class TriangleGrid extends Grid{

	/**
	 * 
	 * @param offset Amount of offset from edge of user interface
	 * @param gridSize Number of rows and columns of cells
	 * @param height Height of each triangle cell
	 * @param width Width of each triangle cell
	 * @param cutOff 
	 * @return 2D array of triangle-shaped cells
	 * Creates a 2D array of triangle-shaped cells
	 */
	public abstract Cell[][] createGrid(double offset, int gridSize, double height, double width, double cutOff);

	private CellMover cm = new CellMover();

}
