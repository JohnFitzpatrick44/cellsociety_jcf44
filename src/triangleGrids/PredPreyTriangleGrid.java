package triangleGrids;

import XML.PredPreyHolder;
import triangleCells.PredPreyTriangleCell;
import triangleCells.TriangleCell;

public class PredPreyTriangleGrid extends TriangleGrid{
	
	private String configString = PredPreyHolder.getPredGrid();
	private static final int WATER = 0;

	@Override
	public TriangleCell[][] createGrid(double offset, int gridSize, double side, double cutOff) {
		int[] gridConfig = getGridConfig(configString);
		TriangleCell[][] grid = new TriangleCell[gridSize][gridSize*2];
		double heightSpacing = 0;
		int index = 0;
		for(int i=0; i<grid.length;i++) {
			double blockSpacing = 0;
			for(int j=0; j<grid[i].length;j++) {
				if(j%2!=0 && index<gridConfig.length) {
					grid[i][j] = new PredPreyTriangleCell(offset+blockSpacing,offset+heightSpacing,side,gridConfig[index],true);
					blockSpacing+=side;
				} else if(j%2==0 && index<gridConfig.length) {
					grid[i][j] = new PredPreyTriangleCell(offset+blockSpacing,offset+heightSpacing,side,gridConfig[index],false);
				} else if(j%2!=0) {
					grid[i][j] = new PredPreyTriangleCell(offset+blockSpacing,offset+heightSpacing,side,WATER,true);
					blockSpacing+=side;
				} else {
					grid[i][j] = new PredPreyTriangleCell(offset+blockSpacing,offset+heightSpacing,side,WATER,false);
				}
				index++;
			}
			heightSpacing+=side;
		}
		return grid;
		
	}

}
