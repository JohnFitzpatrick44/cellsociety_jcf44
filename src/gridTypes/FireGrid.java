package gridTypes;

import XML.DataHolder;
import cellTypes.Cell;
import cellTypes.FireCell;

public class FireGrid extends Grid {
	
	private final int TREE = 1;
	private final int BURNING = 2;
	private String configString = DataHolder.getFireGrid();
	
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
				blockSpacing += cellWidth;
				index++;
			}
			heightSpacing += cellHeight;
		}
		return grid;
	}

}
