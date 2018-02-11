package triangleGrids;

import rectCells.FireCell;
import rectCells.Cell;

public class FireTriangleGrid extends TriangleGrid{

	@Override
	public Cell[][] createGrid(double offset, int gridSize, double side, double cutOff) {
		Cell[][] grid = new Cell[gridSize][gridSize*2];
		double heightSpacing = 0.0;
		for(int i =0;i<grid.length;i++) {
			double blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(j==0) {
					grid[i][j] = new FireCell(2, offset+blockSpacing, offset+heightSpacing,
												 offset+blockSpacing+side, offset+heightSpacing+side,
												 offset+blockSpacing, offset+heightSpacing+side);
				}
				if(j%2!=0) {
					grid[i][j] = new FireCell(1, offset+blockSpacing, offset+heightSpacing,
							 					 offset+blockSpacing+side, offset+heightSpacing,
							 					 offset+blockSpacing+side, offset+heightSpacing+side);
					blockSpacing+=side;
				} else if(j!=0){
					grid[i][j] = new FireCell(1, offset+blockSpacing, offset+heightSpacing,
												 offset+blockSpacing+side, offset+heightSpacing+side,
												 offset+blockSpacing, offset+heightSpacing+side);
				}
			}
			heightSpacing += side;
		}		
		return grid;
	}
		

}
