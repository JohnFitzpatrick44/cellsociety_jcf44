package gridTypes;

import cellTypes.Cell;

public abstract class Grid {
		
	private static final int GRID_SIZE = 20; 
	
	public abstract Cell[][] createGrid();
	
	public void setNeighbors(Cell[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i+1][j+1]); //right bottom cell
				}
				
				if(i==0 && j==GRID_SIZE-1) { //top right corner
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i+1][j-1]); //left bottom cell
				}
				
				if(i==0 && j!=0 && j!=GRID_SIZE-1) { //top side
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i+1][j+1]); //right bottom cell
					grid[i][j].setNeighbor(grid[i+1][j-1]); //left bottom cell
				}
				
				if(i==GRID_SIZE-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i-1][j+1]); //right top cell
				}
				
				if(i==GRID_SIZE-1 && j==GRID_SIZE-1) { //bottom right corner
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i-1][j-1]); //left top cell
				}
				
				if(i==GRID_SIZE-1 && j!=0 && j!=GRID_SIZE-1) { //bottom side
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i-1][j+1]); //right top cell
					grid[i][j].setNeighbor(grid[i-1][j-1]); //left top cell
				}
				
				if(i!=0 && i!=GRID_SIZE-1 && j==0) { //left side
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i-1][j+1]); //right top cell
					grid[i][j].setNeighbor(grid[i+1][j+1]); //right bottom cell
				}
				
				if(i!=0 && i!=GRID_SIZE-1 && j==GRID_SIZE-1) { //right side
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i-1][j-1]); //left top cell
					grid[i][j].setNeighbor(grid[i+1][j-1]); //left bottom cell
				}
				
				if(i!=0 && i!=GRID_SIZE-1 && j!=0 && j!=GRID_SIZE-1) { //all other cells
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i+1][j+1]); //right bottom cell
					grid[i][j].setNeighbor(grid[i+1][j-1]); //left bottom cell
					grid[i][j].setNeighbor(grid[i-1][j+1]); //right top cell
					grid[i][j].setNeighbor(grid[i-1][j-1]); //left top cell

				}
			}
		}
	}

//	public ArrayList<Integer> storeStates(Cell[][] grid, int state) {
//		ArrayList<Integer> cellStates = new ArrayList<Integer>();
//		for(int i=0;i<grid.length;i++) {
//			for(int j=0;j<grid[i].length;j++) {
//				cellStates.add(grid[i][j].getState());
//			}
//		}
//		return cellStates;
//	}
//	
//	public ArrayList<Integer> storeNeighborStates(Cell[][] grid) {
//		ArrayList<Integer> neighborStates = new ArrayList<Integer>();
//		for(int i=0;i<grid.length;i++) {
//			for(int j=0;j<grid[i].length;j++) {
//				neighborStates.addAll(grid[i][j].getNeighborStates());
//			}
//		}
//		return neighborStates;
//	}
	
	public void updateStates(Cell[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].updateState();
			}
		}
	}
	
	
}
