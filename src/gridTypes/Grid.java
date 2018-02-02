package gridTypes;
import java.util.ArrayList;

import cellTypes.Cell;
import cellTypes.ICell;
import cellTypes.IGrid;
import cellTypes.LifeCell;

public class Grid {
		
	private static int BLOCK_SPACING = 40;
	private static int HEIGHT_SPACING = 40;
	
	public Cell[][] createGrid() {
		Cell[][] grid = new Cell[10][10];
		int heightSpacing = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j] = new LifeCell(200+blockSpacing,200+heightSpacing,40,40);
				blockSpacing += BLOCK_SPACING;
			}
			heightSpacing += HEIGHT_SPACING;
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
