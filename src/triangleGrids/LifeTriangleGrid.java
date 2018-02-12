package triangleGrids;

import XML.LifeHolder;
import rectCells.Cell;
import rectCells.LifeCell;

/**
 * 
 * @author Hemanth Yakkali
 * Class that creates Triangle grid for the Game of Life Simulation
 */
public class LifeTriangleGrid extends TriangleGrid{
	
	private static final int DEAD = 0;

	private String configString = LifeHolder.getLifeGrid();

	@Override
	public Cell[][] createGrid(double offset, int gridSize, double height, double width, double cutOff) {
		int[] gridConfig = getGridConfig(configString);
		Cell[][] grid = new Cell[gridSize][gridSize*2];
		double heightSpacing = 0.0;
		int index = 0;
		for(int i =0;i<grid.length;i++) {
			double blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(j%2!=0 && index<gridConfig.length) {
					grid[i][j] = new LifeCell(gridConfig[index], offset+blockSpacing, offset+heightSpacing,
		 					 									 offset+blockSpacing+width, offset+heightSpacing,
		 					 									 offset+blockSpacing+width, offset+heightSpacing+height);
					blockSpacing+=width;
				} else if(j%2==0 && index<gridConfig.length) {
					grid[i][j] = new LifeCell(gridConfig[index], offset+blockSpacing, offset+heightSpacing,
							 									 offset+blockSpacing+width, offset+heightSpacing+height,
							 									 offset+blockSpacing, offset+heightSpacing+height);
				} else if(j%2!=0){
					grid[i][j] = new LifeCell(DEAD, offset+blockSpacing, offset+heightSpacing,
													offset+blockSpacing+width, offset+heightSpacing,
													offset+blockSpacing+width, offset+heightSpacing+height);
					blockSpacing+=width;
				} else {
					grid[i][j] = new LifeCell(DEAD, offset+blockSpacing, offset+heightSpacing,
							 						offset+blockSpacing+width, offset+heightSpacing+height,
							 						offset+blockSpacing, offset+heightSpacing+height);
				}
				index++;
			}
			heightSpacing += height;
		}		
		return grid;
	}
	
}
