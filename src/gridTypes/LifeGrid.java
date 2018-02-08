package gridTypes;

import XML.DataHolder;
import cellTypes.Cell;
import cellTypes.LifeCell;

public class LifeGrid extends Grid {

	private final int ALIVE = 1;
	private final int DEAD = 0;

	private String configString = DataHolder.getLifeGrid();

	public Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff){
		int[] gridConfig = getGridConfig(configString);
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
				blockSpacing += cellWidth;
				index++;
			}
			heightSpacing += cellHeight;
		}
		return grid;
	}

}
