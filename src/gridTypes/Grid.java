package gridTypes;
import java.util.ArrayList;

import cellTypes.Cell;
import cellTypes.ICell;
import cellTypes.IGrid;
import cellTypes.LifeCell;

public class Grid {
		
	private static final int SPACING = 20;
	private static final int CELL_SIZE = 20;
	private static final int OFFSET = 200;
	private static final int GRID_SIZE = 20; 
	
	public Cell[][] createGrid() {
		Cell[][] grid = new Cell[GRID_SIZE][GRID_SIZE];
		int heightSpacing = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j] = new LifeCell(OFFSET+blockSpacing,OFFSET+heightSpacing,CELL_SIZE,CELL_SIZE);
				blockSpacing += SPACING;
			}
			heightSpacing += SPACING;
		}
		return grid;
	}

	public void storeStates(Cell[][] grid, int state) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				state = grid[i][j].getState();
			}
		}
	}
	
	public void storeNeighborStates(Cell[][] grid, ArrayList<Integer> neighborStates) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				neighborStates = grid[i][j].getNeighborStates();
			}
		}
	}
	
	public void updateStates(Cell[][] grid) {
		for(Cell[] cell:grid) {
			for(Cell singleCell: cell) {
				singleCell.updateState();
			}
		}
	}
	
	
}
