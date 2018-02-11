package triangleGrids;

import XML.PredPreyHolder;
import rectCells.Cell;
import rectCells.PredPreyCell;

public class PredPreyTriangleGrid extends TriangleGrid{
	
	private String configString = PredPreyHolder.getPredGrid();
	private static final int WATER = 0;

	@Override
	public Cell[][] createGrid(double offset, int gridSize, double height, double width, double cutOff) {
		int[] gridConfig = getGridConfig(configString);
		Cell[][] grid = new Cell[gridSize][gridSize*2];
		double heightSpacing = 0;
		int index = 0;
		for(int i=0; i<grid.length;i++) {
			double blockSpacing = 0;
			for(int j=0; j<grid[i].length;j++) {
				if(j%2!=0 && index<gridConfig.length) {
					grid[i][j] = new PredPreyCell(gridConfig[index], offset+blockSpacing, offset+heightSpacing,
		 					 										 offset+blockSpacing+width, offset+heightSpacing,
		 					 										 offset+blockSpacing+width, offset+heightSpacing+height);
					blockSpacing+=width;
				} else if(j%2==0 && index<gridConfig.length) {
					grid[i][j] = new PredPreyCell(gridConfig[index], offset+blockSpacing, offset+heightSpacing,
																	 offset+blockSpacing+width, offset+heightSpacing+height,
																	 offset+blockSpacing, offset+heightSpacing+height);
				} else if(j%2!=0) {
					grid[i][j] = new PredPreyCell(WATER, offset+blockSpacing, offset+heightSpacing,
		 					 							 offset+blockSpacing+width, offset+heightSpacing,
		 					 							 offset+blockSpacing+width, offset+heightSpacing+height);
					blockSpacing+=width;
				} else {
					grid[i][j] = new PredPreyCell(WATER, offset+blockSpacing, offset+heightSpacing,
							 							 offset+blockSpacing+width, offset+heightSpacing+height,
							 							 offset+blockSpacing, offset+heightSpacing+height);
				}
				index++;
			}
			heightSpacing+=height;
		}
		return grid;
		
	}

}
