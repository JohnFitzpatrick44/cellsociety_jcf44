package triangleGrids;

import rectCells.FireCell;
import rectCells.Cell;

public class FireTriangleGrid extends TriangleGrid{

	@Override
	public Cell[][] createGrid(double offset, int gridSize, double height, double width, double cutOff) {
		Cell[][] grid = new Cell[gridSize][gridSize*2];
		double heightSpacing = 0.0;
		for(int i =0;i<grid.length;i++) {
			double blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(j==0) {
					grid[i][j] = new FireCell(2, offset+blockSpacing, offset+heightSpacing,
												 offset+blockSpacing+width, offset+heightSpacing+height,
												 offset+blockSpacing, offset+heightSpacing+height);
				}
				if(j%2!=0) {
					grid[i][j] = new FireCell(1, offset+blockSpacing, offset+heightSpacing,
							 					 offset+blockSpacing+width, offset+heightSpacing,
							 					 offset+blockSpacing+width, offset+heightSpacing+height);
					blockSpacing+=width;
				} else if(j!=0){
					grid[i][j] = new FireCell(1, offset+blockSpacing, offset+heightSpacing,
												 offset+blockSpacing+width, offset+heightSpacing+height,
												 offset+blockSpacing, offset+heightSpacing+height);
				}
			}
			heightSpacing += height;
		}		
		return grid;
	}
		

}
