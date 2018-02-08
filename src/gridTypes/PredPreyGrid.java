package gridTypes;

import XML.DataHolder;
import cellTypes.Cell;

import cellTypes.PredPreyCell;

public class PredPreyGrid extends Grid {
		
	private String configString = DataHolder.getPredGrid();

	@Override
	public Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff) {
		int[] gridConfig = getGridConfig(configString);
		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		int index = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {		
				if(!(index >= gridConfig.length) && gridConfig[index]==2) {
					grid[i][j] = new PredPreyCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,2);
				} else if(!(index >= gridConfig.length) && gridConfig[index]==1) {
					grid[i][j] = new PredPreyCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,1);
				} else {
					grid[i][j] = new PredPreyCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,0);
				}
				blockSpacing += cellWidth;
				index++;
			}
			heightSpacing += cellHeight;
		}
		return grid;
	}

}
