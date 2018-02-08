package gridTypes;

import cellTypes.Cell;
import cellTypes.CellMover;

/**
 * @author Hemanth Yakkali
 * Abstract Grid class, to be used in tandem with Cells and CellMover
 * Creates a grid, gets a grid configuration, sets neighbors for each cell, and updates cell states
 */

public abstract class Grid {
		
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
	
	public int[] getGridConfig(String config) {
		String [] origGridConfig = config.split(" ");
		int[] gridConfig = new int[origGridConfig.length];
		for(int i=0;i<origGridConfig.length;i++) {
			gridConfig[i] = Integer.parseInt(origGridConfig[i]);
		}
		return gridConfig;
	}
	
	public void setAllNeighbors(Cell[][] grid, int gridSize) {
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
				
				if(i==0 && j!=0 && j!=gridSize-1) { //top side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i][j-1]); //adjacent cells
					grid[i][j].setNeighbors(grid[i+1][j+1],grid[i+1][j-1]); //diagonal cells
				}
				
				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i-1][j]); //adjacent cells
					grid[i][j].setNeighbor(grid[i-1][j+1]); //right top cell
				}
				
				if(i==gridSize-1 && j==gridSize-1) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j]); //adjacent cells
					grid[i][j].setNeighbor(grid[i-1][j-1]); //left top cell
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
				
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=gridSize-1) { //all other cells
					grid[i][j].setNeighbors(grid[i+1][j],grid[i-1][j],grid[i][j+1],grid[i][j-1]); //adjacent cells
					grid[i][j].setNeighbors(grid[i+1][j+1],grid[i+1][j-1],grid[i-1][j+1],grid[i-1][j-1]); //diagonal cells
				}
			}
		}	
	}
	
	public void setImmediateNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j]); //adjacent cells
				}
				
				if(i==0 && j==gridSize-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j]); //adjacent cells
				}
				
				if(i==0 && j!=0 && j!=gridSize-1) { //top side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i][j-1]); //adjacent cells
				}
				
				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i-1][j]); //adjacent cells
				}
				
				if(i==gridSize-1 && j==gridSize-1) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j]); //adjacent cells
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
				
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=gridSize-1) { //all other cells
					grid[i][j].setNeighbors(grid[i+1][j],grid[i-1][j],grid[i][j+1],grid[i][j-1]); //adjacent cells
				}
			}
		}	
	}
	
	public static void updateStates(Cell[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].updateNeighborStates();
			}
		}
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].updateState();
			}
		}
	}
	
	public CellMover getCm() {return cm;}
	
}
