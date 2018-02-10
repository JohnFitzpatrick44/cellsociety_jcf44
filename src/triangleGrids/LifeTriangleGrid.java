package triangleGrids;

import XML.LifeHolder;
import triangleCells.LifeTriangleCell;
import triangleCells.TriangleCell;

public class LifeTriangleGrid extends TriangleGrid{
	
	private static final int DEAD = 0;

	private String configString = LifeHolder.getLifeGrid();

	@Override
	public TriangleCell[][] createGrid(double offset, int gridSize, double side, double cutOff) {
		int[] gridConfig = getGridConfig(configString);
		TriangleCell[][] grid = new TriangleCell[gridSize][gridSize*2];
		double heightSpacing = 0.0;
		int index = 0;
		for(int i =0;i<grid.length;i++) {
			double blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(j%2!=0 && index<gridConfig.length) {
					grid[i][j] = new LifeTriangleCell(offset+blockSpacing,offset+heightSpacing,side,gridConfig[index],true);
					blockSpacing+=side;
				} else if(j%2==0 && index<gridConfig.length) {
					grid[i][j] = new LifeTriangleCell(offset+blockSpacing,offset+heightSpacing,side,gridConfig[index],false);
				} else if(j%2!=0){
					grid[i][j] = new LifeTriangleCell(offset+blockSpacing,offset+heightSpacing,side,DEAD,true);
					blockSpacing+=side;
				} else {
					grid[i][j] = new LifeTriangleCell(offset+blockSpacing,offset+heightSpacing,side,DEAD,false);
				}
				index++;
			}
			heightSpacing += side;
		}		
		return grid;
	}
	
}
