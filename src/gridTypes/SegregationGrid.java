package gridTypes;


import java.util.concurrent.ThreadLocalRandom;

import View.MainView;
import cellTypes.Cell;
import cellTypes.CellMover;
import cellTypes.SegregationCell;

public class SegregationGrid extends Grid {

	private static final int HEIGHT_SPACING = MainView.CELL_HEIGHT;
	private static final int WIDTH_SPACING = MainView.CELL_WIDTH;
		
	@Override
	public Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff) {
		CellMover cm = new CellMover();

		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j] = new SegregationCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,cutOff, ThreadLocalRandom.current().nextInt(0,3));
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				blockSpacing += WIDTH_SPACING;
			}
			heightSpacing += HEIGHT_SPACING;
		}
		return grid;
	}
}
