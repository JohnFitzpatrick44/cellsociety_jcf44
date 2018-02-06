package gridTypes;


import java.util.concurrent.ThreadLocalRandom;

import View.MainView;
import XML.DataHolder;
import cellTypes.Cell;
import cellTypes.CellMover;
import cellTypes.SegregationCell;

public class SegregationGrid extends Grid {

	private static final int HEIGHT_SPACING = MainView.CELL_HEIGHT;
	private static final int WIDTH_SPACING = MainView.CELL_WIDTH;
	private static String GRID_CONFIG = DataHolder.SEG_GRID;
	private String[] origGridConfig = GRID_CONFIG.split("\\s+");
	private int[] gridConfig;
		
	@Override
	public Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff) {
		gridConfig = getGridConfig(origGridConfig);
		CellMover cm = new CellMover();
		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		int index = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(gridConfig[index]==2) {
					grid[i][j] = new SegregationCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,cutOff, 2);
				} else if(gridConfig[index]==1) {
					grid[i][j] = new SegregationCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,cutOff, 1);

				} else {
					grid[i][j] = new SegregationCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,cutOff, 0);

				}
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				blockSpacing += WIDTH_SPACING;
				index++;
			}
			heightSpacing += HEIGHT_SPACING;
		}
		return grid;
	}
}
