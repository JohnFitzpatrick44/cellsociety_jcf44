package gridTypes;

import View.MainView;
import cellTypes.Cell;

import cellTypes.PredPreyCell;

public class PredPreyGrid extends Grid {
	
	private static final int HEIGHT_SPACING = MainView.CELL_HEIGHT;
	private static final int WIDTH_SPACING = MainView.CELL_WIDTH;

	@Override
	public Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff) {
		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;

			for(int j=0;j<grid[i].length;j++) {				
				if(Math.random() < 0.04) {
					grid[i][j] = new PredPreyCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,2);
				} else if (Math.random()< 0.1){
					grid[i][j] = new PredPreyCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,1);
				} else{
					grid[i][j] = new PredPreyCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,0);
				}
				blockSpacing += WIDTH_SPACING;
			}
			heightSpacing += HEIGHT_SPACING;
		}
		return grid;
	}

}
