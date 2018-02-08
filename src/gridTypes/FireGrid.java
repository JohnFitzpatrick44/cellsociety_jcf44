package gridTypes;

import View.MainView;
import XML.DataHolder;
import cellTypes.Cell;
import cellTypes.FireCell;

public class FireGrid extends Grid {
	
	private static final int HEIGHT_SPACING = MainView.CELL_HEIGHT;
	private static final int WIDTH_SPACING = MainView.CELL_WIDTH;
	private static final int EMPTY = 0;
	private static final int TREE = 1;
	private static final int BURNING = 2;
	private String configString = DataHolder.FIRE_GRID;
	
	@Override
	public Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff) {
		int[] gridConfig = getGridConfig(configString);
		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		int index = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(!(index >= gridConfig.length) && gridConfig[index]==1) {
					grid[i][j] = new FireCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,BURNING);
				} else {
					grid[i][j] = new FireCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,TREE);
				}
				blockSpacing += WIDTH_SPACING;
				index++;
			}
			heightSpacing += HEIGHT_SPACING;
		}
		return grid;
	}

}
