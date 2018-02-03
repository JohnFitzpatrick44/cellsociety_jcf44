package gridTypes;

import cellTypes.Cell;

public abstract class Grid {
			
	public abstract Cell[][] createGrid(int offset, int gridSize, int cellSize, double cutOff);
	
	public abstract void setNeighbors(Cell[][] grid);
	
	public static void updateStates(Cell[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].updateState();
			}
		}
	}
	
}
