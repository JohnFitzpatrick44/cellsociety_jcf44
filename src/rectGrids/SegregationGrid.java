package rectGrids;

import XML.SegregationHolder;
import rectCells.Cell;
import rectCells.SegregationCell;

public class SegregationGrid extends RectangleGrid {
	
	private String configString = SegregationHolder.getSegGrid();
	private static final int DEFAULT = 0;
	
	@Override
	public Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff) {
		int[] gridConfig = getGridConfig(configString);
		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		int index = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(index < gridConfig.length) {
					grid[i][j] = new SegregationCell(offset+blockSpacing,offset+heightSpacing,
							  offset+blockSpacing+cellWidth,offset+heightSpacing,
							  offset+blockSpacing+cellWidth, offset+heightSpacing+cellHeight,
							  offset+blockSpacing,offset+heightSpacing+cellHeight,
							  gridConfig[index]);
				} else {
					grid[i][j] = new SegregationCell(offset+blockSpacing,offset+heightSpacing,
							  offset+blockSpacing+cellWidth,offset+heightSpacing,
							  offset+blockSpacing+cellWidth, offset+heightSpacing+cellHeight,
							  offset+blockSpacing,offset+heightSpacing+cellHeight,
							  DEFAULT);
				}
				blockSpacing += cellWidth;
				index++;
			}
			heightSpacing += cellHeight;
		}
		return grid;
	}
}
