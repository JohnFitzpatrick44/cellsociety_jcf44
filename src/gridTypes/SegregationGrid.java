package gridTypes;


import java.util.concurrent.ThreadLocalRandom;

import cellTypes.Cell;
import cellTypes.CellMover;
import cellTypes.SegregationCell;

public class SegregationGrid extends Grid {

	private static final int SPACING = 20;
		
	@Override
	public Cell[][] createGrid(int offset, int gridSize, int cellSize, double cutOff) {
		CellMover cm = new CellMover();

		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j] = new SegregationCell(offset+blockSpacing,offset+heightSpacing,cellSize,cellSize,cutOff, ThreadLocalRandom.current().nextInt(0,3));
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				blockSpacing += SPACING;
			}
			heightSpacing += SPACING;
		}
		return grid;
	}

	@Override
	public void setNeighbors(Cell[][] grid) {
		
	}
}
