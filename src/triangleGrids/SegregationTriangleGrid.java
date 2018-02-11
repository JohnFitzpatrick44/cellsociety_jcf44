package triangleGrids;

import XML.SegregationHolder;
import rectCells.Cell;
import rectCells.SegregationCell;


public class SegregationTriangleGrid extends TriangleGrid{
	
	private String configString = SegregationHolder.getSegGrid();
	private static final int DEFAULT = 0;

	@Override
	public Cell[][] createGrid(double offset, int gridSize, double side, double cutOff) {
		int[] gridConfig = getGridConfig(configString);
		Cell[][] grid = new Cell[gridSize][gridSize*2];
		double heightSpacing = 0;
		int index = 0;
		for(int i=0; i<grid.length;i++) {
			double blockSpacing = 0;
			for(int j=0; j<grid[i].length;j++) {
				if(j%2!=0 && index<gridConfig.length) {
					grid[i][j] = new SegregationCell(gridConfig[index], offset+blockSpacing, offset+heightSpacing,
																		offset+blockSpacing+side, offset+heightSpacing,
																		offset+blockSpacing+side, offset+heightSpacing+side);
					blockSpacing+=side;
				} else if(j%2==0 && index<gridConfig.length) {
					grid[i][j] = new SegregationCell(gridConfig[index], offset+blockSpacing, offset+heightSpacing,
																		offset+blockSpacing+side, offset+heightSpacing+side,
																		offset+blockSpacing, offset+heightSpacing+side);
				} else if(j%2!=0) {
					grid[i][j] = new SegregationCell(DEFAULT, offset+blockSpacing, offset+heightSpacing,
		 					 								  offset+blockSpacing+side, offset+heightSpacing,
		 					 								  offset+blockSpacing+side, offset+heightSpacing+side);
					blockSpacing+=side;
				} else {
					grid[i][j] = new SegregationCell(DEFAULT, offset+blockSpacing, offset+heightSpacing,
							 								  offset+blockSpacing+side, offset+heightSpacing+side,
							 								  offset+blockSpacing, offset+heightSpacing+side);
				}
				index++;
			}
			heightSpacing+=side;
		}
		return grid;
	}

}
