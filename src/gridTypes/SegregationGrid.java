package gridTypes;


import java.util.concurrent.ThreadLocalRandom;

import cellTypes.Cell;
import cellTypes.CellMover;
import cellTypes.SegregationCell;

public class SegregationGrid extends Grid {

	private static final int CELL_SIZE = 20;
	private static final int GRID_SIZE = 20; 
	private static final int SPACING = 20;
	
	private static final double CUTOFF = 0.5; // Add as input
	
	public Cell[][] createGrid(int offset) {
		CellMover cm = new CellMover();

		Cell[][] grid = new Cell[GRID_SIZE][GRID_SIZE];
		int heightSpacing = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j] = new SegregationCell(offset+blockSpacing,offset+heightSpacing,CELL_SIZE,CELL_SIZE,CUTOFF, ThreadLocalRandom.current().nextInt(0,3));
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				blockSpacing += SPACING;
			}
			heightSpacing += SPACING;
		}
		return grid;
	}
}
