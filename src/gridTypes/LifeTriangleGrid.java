package gridTypes;

import cellTypes.LifeTriangleCell;
import cellTypes.TriangleCell;

public class LifeTriangleGrid extends TriangleGrid{

	@Override
	public TriangleCell[][] createGrid(double offset, int gridSize, double side, double cutOff) {
		TriangleCell[][] grid = new TriangleCell[gridSize][gridSize*2];
		double heightSpacing = 0.0;
		for(int i =0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(j%2!=0 || j==1) {
					grid[i][j] = new LifeTriangleCell(offset+blockSpacing,offset+heightSpacing,side,0,true);
					blockSpacing+=side;
					System.out.println("White!");
				} else {
					grid[i][j] = new LifeTriangleCell(offset+blockSpacing,offset+heightSpacing,side,1,false);
					System.out.println("Black!");
				}
//				blockSpacing+=side;
			}
			heightSpacing += side;
		}		
		return grid;
	}
	
}
