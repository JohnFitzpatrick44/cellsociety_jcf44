package gridTypes;

import cellTypes.Cell;

public abstract class Grid {
		
	private static final int GRID_SIZE = 20; 
	
	public abstract Cell[][] createGrid(int offset);
	
	public abstract void setNeighbors(Cell[][] grid);

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
	
	public static void updateStates(Cell[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].updateState();
			}
		}
	}
	
	
}
