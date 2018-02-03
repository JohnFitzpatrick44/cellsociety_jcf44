package gridTypes;

import java.util.concurrent.ThreadLocalRandom;

import cellTypes.Cell;
import cellTypes.LifeCell;

public class LifeGrid extends Grid {
	
	private static final int SPACING = 20;
	private static final int CELL_SIZE = 20;
	private static final int GRID_SIZE = 20; 
	private static final int ALIVE = 1;
	private static final int DEAD = 0;
	
	public Cell[][] createGrid(int offset){
		Cell[][] grid = new Cell[GRID_SIZE][GRID_SIZE];
		int heightSpacing = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				int randomState = ThreadLocalRandom.current().nextInt(1, 10 + 1);
				if(randomState == 10) {
					grid[i][j] = new LifeCell(offset+blockSpacing,offset+heightSpacing,CELL_SIZE,CELL_SIZE,ALIVE);
				} else {
					grid[i][j] = new LifeCell(offset+blockSpacing,offset+heightSpacing,CELL_SIZE,CELL_SIZE,DEAD);
				}
				blockSpacing += SPACING;
			}
			heightSpacing += SPACING;
		}
		return grid;
	}
}
