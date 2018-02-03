package gridTypes;

import cellTypes.Cell;

public class FireGrid extends Grid {
	
	private static final int GRID_SIZE = 20; 

	@Override
	public Cell[][] createGrid(int offset, int gridSize, int cellSize, double cutOff) {

		return null;
	}
	
	@Override
	public void setNeighbors(Cell[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
				}
				
				if(i==0 && j==GRID_SIZE-1) { //top right corner
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
				}
				
				if(i==0 && j!=0 && j!=GRID_SIZE-1) { //top side
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
				}
				
				if(i==GRID_SIZE-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
				}
				
				if(i==GRID_SIZE-1 && j==GRID_SIZE-1) { //bottom right corner
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
				}
				
				if(i==GRID_SIZE-1 && j!=0 && j!=GRID_SIZE-1) { //bottom side
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
				}
				
				if(i!=0 && i!=GRID_SIZE-1 && j==0) { //left side
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
				}
				
				if(i!=0 && i!=GRID_SIZE-1 && j==GRID_SIZE-1) { //right side
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
				}
				
				if(i!=0 && i!=GRID_SIZE-1 && j!=0 && j!=GRID_SIZE-1) { //all other cells
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
				}
			}
		}		
	}

}
