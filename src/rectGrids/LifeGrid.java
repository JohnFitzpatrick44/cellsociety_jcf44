package rectGrids;

import XML.LifeHolder;
import rectCells.Cell;
import rectCells.LifeCell;

public class LifeGrid extends RectangleGrid {

	private static final int DEAD = 0;

	private String configString = LifeHolder.getLifeGrid();

	public Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff){
		int[] gridConfig = getGridConfig(configString);
		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		int index = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(index < gridConfig.length) {
					grid[i][j] = new LifeCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,gridConfig[index]);
				} else {
					grid[i][j] = new LifeCell(offset+blockSpacing,offset+heightSpacing,cellWidth,cellHeight,DEAD);
				}
				blockSpacing += cellWidth;
				index++;
			}
			heightSpacing += cellHeight;
		}
		return grid;
	}

}
