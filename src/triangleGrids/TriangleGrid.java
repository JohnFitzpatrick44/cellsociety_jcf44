package triangleGrids;

import rectCells.Cell;

import rectCells.CellMover;
import rectGrids.Grid;

/**
 * 
 * @author Hemanth Yakkali
 * Abstract TriangleGrid class, to be used in tandem with other triangle grids
 * Creates a triangle grid, sets neighbors
 */

public abstract class TriangleGrid extends Grid{

	/**
	 * 
	 * @param offset Amount of offset from edge of user interface
	 * @param gridSize Number of rows and columns of cells
	 * @param height Height of each triangle cell
	 * @param width Width of each triangle cell
	 * @param cutOff 
	 * @return 2D array of triangle-shaped cells
	 * Creates a 2D array of triangle-shaped cells
	 */
	public abstract Cell[][] createGrid(double offset, int gridSize, double height, double width, double cutOff);

	private CellMover cm = new CellMover();
	
	/**
	 * 
	 * @param grid 2D array of triangle-shaped cells
	 * @param gridSize Number of rows and columns of cells
	 * Sets neighbors for all "normal" oriented triangle cells
	 */
	public void setAllNormalNeighbors(Cell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				
				if(i==0 && j==0) { //left side even triangle and top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j+1]);
				}
				
				if(i==0 && j%2==0 && j!=0) { //top side even triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i+1][j+1]);
				}
				
				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbor(grid[i][j+1]);
				}
				
				if(i==gridSize-1 && j!=0 && j!=columns-1 && j%2==0) { //bottom side even triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1]);
				}
				
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=columns-1 && j%2==0) { //all other even triangles
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i+1][j+1]);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param grid
	 * @param gridSize
	 * Sets neighbors for all inverted triangle cells
	 */
	public void setAllInvertedNeighbors(Cell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				
				if(i==0 && j==columns-1) { //top right corner
					grid[i][j].setNeighbor(grid[i][j-1]);
				}
				
				if(i==0 && j%2!=0 && j!=columns-1) { //top side odd triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1]);
				}
				
				if(i!=0 && j==columns-1) { //right side odd triangle and bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j-1]);
				}
				
				if(i==gridSize-1 && j!=0 && j!=columns-1 && j%2!=0) { //bottom side odd triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j-1]);
				}
				
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=columns-1 && j%2!=0) { //all other odd triangles
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i-1][j-1]);
				}
				
			}
		}	
	}
	
	/**
	 * 
	 * @param grid
	 * @param gridSize
	 * Sets toroidal neighbors for all inverted triangle cells
	 */
	public void setAllInvertedToroidalNeighbors(Cell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				
				if(i==0 && j==columns-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[gridSize-1][0]);
				}
				
				if(i==0 && j%2!=0 && j!=columns-1) { //top side odd triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[gridSize-1][j-1]);
				}
				
				if(i!=0 && j==columns-1) { //right side odd triangle and bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j-1],grid[i][0]);
				}
				
				if(i==gridSize-1 && j!=0 && j!=columns-1 && j%2!=0) { //bottom side odd triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j-1]);
				}
				
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=columns-1 && j%2!=0) { //all other odd triangles
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i-1][j-1]);
				}
				
			}
		}
	}
	
	/**
	 * 
	 * @param grid
	 * @param gridSize
	 * Sets neighbors for all normal-oriented triangle cells
	 */
	public void setAllNormalToroidalNeighbors(Cell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				
				if(i==0 && j==0) { //left side even triangle and top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j+1],grid[i][columns-1]);
				}
				
				if(i==0 && j%2==0 && j!=0) { //top side even triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i+1][j+1]);
				}
				
				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][columns-1],grid[0][j+1]);
				}
				
				if(i==gridSize-1 && j!=0 && j!=columns-1 && j%2==0) { //bottom side even triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[0][j+1]);
				}
				
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=columns-1 && j%2==0) { //all other even triangles
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i+1][j+1]);
				}
			}
		}
	}
	
}
