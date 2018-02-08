package gridTypes;

import View.MainView;
import XML.DataHolder;
import cellTypes.Cell;
import cellTypes.LifeCell;

public class LifeGrid extends Grid {
	
	private static final int HEIGHT_SPACING = MainView.CELL_HEIGHT;
	private static final int WIDTH_SPACING = MainView.CELL_WIDTH;
	private static final int ALIVE = 1;
	private static final int DEAD = 0;
	private static String GRID_CONFIG = DataHolder.LIFE_GRID;
	private String[] origGridConfig = GRID_CONFIG.split("\\s+");
	private int[] gridConfig;
		
	public Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff){
		gridConfig = getGridConfig(origGridConfig);
		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		int index = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(index >= gridConfig.length || gridConfig[index]==0) {
					grid[i][j] = new LifeCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,DEAD);
				} else {
					grid[i][j] = new LifeCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,ALIVE);
				}
				blockSpacing += WIDTH_SPACING;
				index++;
			}
			heightSpacing += HEIGHT_SPACING;
		}
		return grid;
	}
	
}
