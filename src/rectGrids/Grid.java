package rectGrids;

import rectCells.Cell;

/**
 * @author Hemanth Yakkali
 * Abstract Grid class
 * Creates a grid, gets a grid configuration, and updates cell states
 */

public abstract class Grid {
	
	/**
	 * 
	 * @param config String of integers with a space in between each
	 * @return Integer array 
	 * Takes string and converts it into an integer array
	 */
	public int[] getGridConfig(String config) {
		String [] origGridConfig = config.split(" ");
		int[] gridConfig = new int[origGridConfig.length];
		for(int i=0;i<origGridConfig.length;i++) {
			gridConfig[i] = Integer.parseInt(origGridConfig[i]);
		}
		return gridConfig;
	}
	
	/**
	 * 
	 * @param grid 2D Array of Cells
	 * Updates each cell
	 */
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
