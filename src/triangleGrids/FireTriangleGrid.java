package triangleGrids;

import triangleCells.FireTriangleCell;
import triangleCells.TriangleCell;

public class FireTriangleGrid extends TriangleGrid{

	@Override
	public TriangleCell[][] createGrid(double offset, int gridSize, double side, double cutOff) {
		TriangleCell[][] grid = new TriangleCell[gridSize][gridSize*2];
		double heightSpacing = 0.0;
		for(int i =0;i<grid.length;i++) {
			double blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(j==0) {
					grid[i][j] = new FireTriangleCell(offset+blockSpacing,offset+heightSpacing,side,2,false);
				}
				if(j%2!=0) {
					grid[i][j] = new FireTriangleCell(offset+blockSpacing,offset+heightSpacing,side,1,true);
					blockSpacing+=side;
				} else if(j!=0){
					grid[i][j] = new FireTriangleCell(offset+blockSpacing,offset+heightSpacing,side,1,false);
				}
			}
			heightSpacing += side;
		}		
		return grid;
	}
		

}
