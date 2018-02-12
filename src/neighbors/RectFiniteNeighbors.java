package neighbors;

import rectCells.Cell;
import rectCells.CellMover;

public class RectFiniteNeighbors {
	
	private CellMover cm = new CellMover();

	public void setAllCornerNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j]); //adjacent cells
					grid[i][j].setNeighbor(grid[i+1][j+1]); //right bottom cell
				}
				
				if(i==0 && j==gridSize-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j]); //adjacent cells
					grid[i][j].setNeighbor(grid[i+1][j-1]); //left bottom cell
				}
				
				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i-1][j]); //adjacent cells
					grid[i][j].setNeighbor(grid[i-1][j+1]); //right top cell
				}
				
				if(i==gridSize-1 && j==gridSize-1) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j]); //adjacent cells
					grid[i][j].setNeighbor(grid[i-1][j-1]); //left top cell
				}
			}
		}	
	}
	
	/**
	 * 
	 * @param grid 2D array of cells
	 * @param gridSize Number of rows and columns of cells
	 * Sets surrounding neighbors for cells on the side
	 */
	public void setAllSideNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j!=0 && j!=gridSize-1) { //top side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i][j-1]); //adjacent cells
					grid[i][j].setNeighbors(grid[i+1][j+1],grid[i+1][j-1]); //diagonal cells
				}
				
				if(i==gridSize-1 && j!=0 && j!=gridSize-1) { //bottom side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j+1],grid[i-1][j-1]); //diagonal cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==0) { //left side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i-1][j]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j+1],grid[i+1][j+1]); //diagonal cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==gridSize-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j],grid[i-1][j]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j-1],grid[i+1][j-1]); //diagonal cells
				}
			}
		}	
	}
	
	/**
	 * 
	 * @param grid 2D array of cells
	 * @param gridSize Number of rows and columns of cells
	 * Sets surrounding neighbors for all middle cells
	 */
	public void setAllMiddleNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=gridSize-1) { //middle cells
					grid[i][j].setNeighbors(grid[i+1][j],grid[i-1][j],grid[i][j+1],grid[i][j-1]); //adjacent cells
					grid[i][j].setNeighbors(grid[i+1][j+1],grid[i+1][j-1],grid[i-1][j+1],grid[i-1][j-1]); //diagonal cells
				}
			}
		}	
	}
	
	/**
	 * 
	 * @param grid 2D array of cells
	 * @param gridSize Number of rows and columns of cells
	 * Sets cardinal neighbors for corner cells
	 */
	public void setCardinalCornerNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j]); //adjacent cells
				}
				
				if(i==0 && j==gridSize-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j]); //adjacent cells
				}

				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i-1][j]); //adjacent cells
				}
				
				if(i==gridSize-1 && j==gridSize-1) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j]); //adjacent cells
				}
			}
		}	
	}
	
	/**
	 * 
	 * @param grid 2D array of cells
	 * @param gridSize Number of rows and columns of cells
	 * Sets cardinal neighbors for cells on the side
	 */
	public void setCardinalSideNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j!=0 && j!=gridSize-1) { //top side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i][j-1]); //adjacent cells
				}
				
				if(i==gridSize-1 && j!=0 && j!=gridSize-1) { //bottom side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j]); //adjacent cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==0) { //left side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i-1][j]); //adjacent cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==gridSize-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j],grid[i-1][j]); //adjacent cells
				}
			}
		}	
	}
	
	/**
	 * 
	 * @param grid 2D array of cells
	 * @param gridSize Number of rows and columns of cells
	 * Sets cardinal neighbors for middle cells
	 */
	public void setCardinalMiddleNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=gridSize-1) { //middle cells
					grid[i][j].setNeighbors(grid[i+1][j],grid[i-1][j],grid[i][j+1],grid[i][j-1]); //adjacent cells
				}
			}
		}	
	}
}
