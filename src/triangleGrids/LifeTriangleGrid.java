package triangleGrids;

import XML.LifeHolder;
import rectCells.Cell;
import rectCells.LifeCell;

public class LifeTriangleGrid extends TriangleGrid{
	
	private static final int DEAD = 0;

	private String configString = LifeHolder.getLifeGrid();

	@Override
	public Cell[][] createGrid(double offset, int gridSize, double side, double cutOff) {
		int[] gridConfig = getGridConfig(configString);
		Cell[][] grid = new Cell[gridSize][gridSize*2];
		double heightSpacing = 0.0;
		int index = 0;
		for(int i =0;i<grid.length;i++) {
			double blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(j%2!=0 && index<gridConfig.length) {
					grid[i][j] = new LifeCell(gridConfig[index], offset+blockSpacing, offset+heightSpacing,
		 					 									 offset+blockSpacing+side, offset+heightSpacing,
		 					 									 offset+blockSpacing+side, offset+heightSpacing+side);
					blockSpacing+=side;
				} else if(j%2==0 && index<gridConfig.length) {
					grid[i][j] = new LifeCell(gridConfig[index], offset+blockSpacing, offset+heightSpacing,
							 									 offset+blockSpacing+side, offset+heightSpacing+side,
							 									 offset+blockSpacing, offset+heightSpacing+side);
				} else if(j%2!=0){
					grid[i][j] = new LifeCell(DEAD, offset+blockSpacing, offset+heightSpacing,
													offset+blockSpacing+side, offset+heightSpacing,
													offset+blockSpacing+side, offset+heightSpacing+side);
					blockSpacing+=side;
				} else {
					grid[i][j] = new LifeCell(DEAD, offset+blockSpacing, offset+heightSpacing,
							 						offset+blockSpacing+side, offset+heightSpacing+side,
							 						offset+blockSpacing, offset+heightSpacing+side);
				}
				index++;
			}
			heightSpacing += side;
		}		
		return grid;
	}
	
}
