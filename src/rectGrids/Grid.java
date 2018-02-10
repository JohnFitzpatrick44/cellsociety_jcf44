package rectGrids;

import rectCells.Cell;
import rectCells.CellMover;

/**
 * @author Hemanth Yakkali
 * Abstract Grid class, to be used in tandem with Cells and CellMover
 * Creates a grid, gets a grid configuration, sets neighbors for each cell, and updates cell states
 */

public abstract class Grid {
	
	public int[] getGridConfig(String config) {
		String [] origGridConfig = config.split(" ");
		int[] gridConfig = new int[origGridConfig.length];
		for(int i=0;i<origGridConfig.length;i++) {
			gridConfig[i] = Integer.parseInt(origGridConfig[i]);
		}
		return gridConfig;
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
