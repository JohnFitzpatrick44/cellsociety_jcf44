package gridTypes;

import cellTypes.Cell;
import cellTypes.PredPreyCell;

public class PredPreyGrid extends Grid {
	
	private static final int SPACING = 20;

	@Override
	public Cell[][] createGrid(int offset, int gridSize, int cellSize, double cutOff) {
		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {				
				if(Math.random() < 0.04) {
					grid[i][j] = new PredPreyCell(offset+blockSpacing,offset+heightSpacing,cellSize,cellSize,2);
				} else if (Math.random()< 0.1){
					grid[i][j] = new PredPreyCell(offset+blockSpacing,offset+heightSpacing,cellSize,cellSize,1);
				} else{
					grid[i][j] = new PredPreyCell(offset+blockSpacing,offset+heightSpacing,cellSize,cellSize,0);
				}
				blockSpacing += SPACING;
			}
			heightSpacing += SPACING;
		}
		return grid;
	}

}
