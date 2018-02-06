package gridTypes;

import View.MainView;
import cellTypes.Cell;

public abstract class Grid {
	
//	private static int GRID_SIZE = MainView.GRID_SIZE; 
	
	public abstract Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff);
	
	public void setAllNeighbors(Cell[][] grid, int gridSize) {

		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {		
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
	
}
