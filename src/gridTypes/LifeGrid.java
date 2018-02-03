package gridTypes;

import java.util.concurrent.ThreadLocalRandom;

import cellTypes.Cell;
import cellTypes.LifeCell;

public class LifeGrid extends Grid {
	
	private static final int SPACING = 20;
	private static final int CELL_SIZE = 20;
	private static final int GRID_SIZE = 20; 
	private static final int ALIVE = 1;
	private static final int DEAD = 0;
	
	public Cell[][] createGrid(int offset, int gridSize, int cellSize){
		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				int randomState = ThreadLocalRandom.current().nextInt(1, 10 + 1);
				if(randomState == 10) {
					grid[i][j] = new LifeCell(offset+blockSpacing,offset+heightSpacing,cellSize,cellSize,ALIVE);
				} else {
					grid[i][j] = new LifeCell(offset+blockSpacing,offset+heightSpacing,cellSize,cellSize,DEAD);
				}
				blockSpacing += SPACING;
			}
			heightSpacing += SPACING;
		}
		return grid;
	}

	@Override
	public void setNeighbors(Cell[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i+1][j+1]); //right bottom cell
				}
				
				if(i==0 && j==GRID_SIZE-1) { //top right corner
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i+1][j-1]); //left bottom cell
				}
				
				if(i==0 && j!=0 && j!=GRID_SIZE-1) { //top side
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i+1][j+1]); //right bottom cell
					grid[i][j].setNeighbor(grid[i+1][j-1]); //left bottom cell
				}
				
				if(i==GRID_SIZE-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i-1][j+1]); //right top cell
				}
				
				if(i==GRID_SIZE-1 && j==GRID_SIZE-1) { //bottom right corner
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i-1][j-1]); //left top cell
				}
				
				if(i==GRID_SIZE-1 && j!=0 && j!=GRID_SIZE-1) { //bottom side
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i-1][j+1]); //right top cell
					grid[i][j].setNeighbor(grid[i-1][j-1]); //left top cell
				}
				
				if(i!=0 && i!=GRID_SIZE-1 && j==0) { //left side
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i-1][j+1]); //right top cell
					grid[i][j].setNeighbor(grid[i+1][j+1]); //right bottom cell
				}
				
				if(i!=0 && i!=GRID_SIZE-1 && j==GRID_SIZE-1) { //right side
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i-1][j-1]); //left top cell
					grid[i][j].setNeighbor(grid[i+1][j-1]); //left bottom cell
				}
				
				if(i!=0 && i!=GRID_SIZE-1 && j!=0 && j!=GRID_SIZE-1) { //all other cells
					grid[i][j].setNeighbor(grid[i+1][j]); //bottom cell
					grid[i][j].setNeighbor(grid[i-1][j]); //top cell
					grid[i][j].setNeighbor(grid[i][j+1]); //right cell
					grid[i][j].setNeighbor(grid[i][j-1]); //left cell
					grid[i][j].setNeighbor(grid[i+1][j+1]); //right bottom cell
					grid[i][j].setNeighbor(grid[i+1][j-1]); //left bottom cell
					grid[i][j].setNeighbor(grid[i-1][j+1]); //right top cell
					grid[i][j].setNeighbor(grid[i-1][j-1]); //left top cell

				}
			}
		}		
	}
}
