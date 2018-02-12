package neighbors;

import rectCells.Cell;
import rectCells.CellMover;

public class RectToroidalNeighbors {
	
	private CellMover cm = new CellMover();

	/**
	 * 
	 * @param grid 2D array of cells
	 * @param gridSize Number of rows and columns of cells
	 * Sets toroidal cardinal neighbors for cells on the side
	 */
	public void setCardinalSideToroidalNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j!=0 && j!=gridSize-1) { //top side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i][j-1],grid[gridSize-1][j]); //adjacent cells
				}
				
				if(i==gridSize-1 && j!=0 && j!=gridSize-1) { //bottom side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j],grid[0][j]); //adjacent cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==0) { //left side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i-1][j],grid[i][gridSize-1]); //adjacent cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==gridSize-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j],grid[i-1][j],grid[i][0]); //adjacent cells
				}
			}
		}
	}
	
	/**
	 * 
	 * @param grid 2D array of cells
	 * @param gridSize Number of rows and columns of cells
	 * Sets toroidal cardinal neighbors for corner cells
	 */
	public void setCardinalCornerToroidalNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[gridSize-1][j],grid[i][gridSize-1]); //adjacent cells
				}
				
				if(i==0 && j==gridSize-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j],grid[gridSize-1][j],grid[0][j]); //adjacent cells
				}

				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i-1][j],grid[0][j],grid[i][gridSize-1]); //adjacent cells
				}
				
				if(i==gridSize-1 && j==gridSize-1) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j],grid[0][j],grid[i][0]); //adjacent cells
				}
			}
		}	
	}
	
	/**
	 * 
	 * @param grid 2D array of cells
	 * @param gridSize Number of rows and columns of cells
	 * Sets toroidal surrounding neighbors for corner cells
	 */
	public void setAllCornerToroidalNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[gridSize-1][j],grid[i][gridSize-1]); //adjacent cells
					grid[i][j].setNeighbors(grid[i+1][j+1],grid[i+1][gridSize-1],grid[gridSize-1][j+1]); //right bottom cell
				}
				
				if(i==0 && j==gridSize-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j],grid[gridSize-1][j],grid[0][j]); //adjacent cells
					grid[i][j].setNeighbors(grid[i+1][j-1],grid[i+1][0],grid[gridSize-1][j-1]); //left bottom cell
				}
				
				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i-1][j],grid[0][j],grid[i][gridSize-1]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j+1],grid[i-1][gridSize-1],grid[0][j+1]); //right top cell
				}
				
				if(i==gridSize-1 && j==gridSize-1) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j],grid[0][j],grid[i][0]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j-1],grid[i-1][0],grid[0][j-1]); //left top cell
				}
			}
		}	
	}
	
	/**
	 * 
	 * @param grid 2D array of cells
	 * @param gridSize Number of rows and columns of cells
	 * Sets toroidal surrounding neighbors for cells on the side
	 */
	public void setAllSideToroidalNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j!=0 && j!=gridSize-1) { //top side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i][j-1], grid[gridSize-1][j]); //adjacent cells
					grid[i][j].setNeighbors(grid[i+1][j+1],grid[i+1][j-1],grid[gridSize-1][j-1],grid[gridSize-1][j+1]); //diagonal cells
				}
				
				if(i==gridSize-1 && j!=0 && j!=gridSize-1) { //bottom side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j],grid[0][j]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j+1],grid[i-1][j-1],grid[0][j-1],grid[0][j+1]); //diagonal cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==0) { //left side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i-1][j],grid[i][gridSize-1]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j+1],grid[i+1][j+1],grid[i+1][gridSize-1],grid[i-1][gridSize-1]); //diagonal cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==gridSize-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j],grid[i-1][j],grid[i][0]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j-1],grid[i+1][j-1],grid[i+1][0],grid[i-1][0]); //diagonal cells
				}
			}
		}	
	}
}
