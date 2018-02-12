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
	public void setCardinalNormalNeighbors(Cell[][] grid, int gridSize) {
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
	public void setCardinalInvertedNeighbors(Cell[][] grid, int gridSize) {
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
	public void setCardinalInvertedToroidalNeighbors(Cell[][] grid, int gridSize) {
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
	public void setCardinalNormalToroidalNeighbors(Cell[][] grid, int gridSize) {
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
	
	public void setAllNormalNeighbors(Cell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j+1]);
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i+1][j+2],grid[i+1][j+3]);
				}
				
				if(i==0 && j%2==0 && j==columns-2) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j-2],grid[i+1][j],grid[i+1][j-1],grid[i+1][j+1]);
				}
				
				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j+2],grid[i-1][j]);
				}
				
				if(i==gridSize-1 && j%2==0 && j==columns-2) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i][j-2],grid[i-1][j],grid[i-1][j-1],grid[i-1][j-2]);
				}
				
				if(i==0 && j%2==0 && j!=0 && j!=columns-2) { //top side triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i+1][j+1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i+1][j],grid[i+1][j-1],grid[i+1][j+2],grid[i+1][j+3]);
				}
				
				if(i==gridSize-1 && j!=0 && j!=columns-2 && j%2==0) { //bottom side triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i-1][j],grid[i-1][j-1],grid[i-1][j-2]);
				}
				
				if(j==0 && i!=0 && i!=gridSize-1) { //left side 
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j+2],grid[i-1][j],grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2],grid[i+1][j+3]);
				}
				
				if(j==columns-2 && i!=0 && i!=gridSize-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j-1],grid[i][j+1],grid[i-1][j],grid[i-1][j-1],grid[i-1][j-2],grid[i+1][j],grid[i+1][j-1],grid[i+1][j+1]);
				}
				
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=columns-1 && j%2==0) { //all other triangles
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i+1][j+1]);
				}
			}
		}
	}
	
	public void setAllInvertedNeighbors(Cell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				
				if(i==0 && j==columns-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j-2],grid[i+1][j]);
				}
				
				if(i==0 && j==1) { //top left corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j+2],grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2]);
				}
				
				if(i==gridSize-1 && j==1) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j+2],grid[i-1][j-1],grid[i-1][j],grid[i-1][j+1]);
				}
				
				if(i==gridSize-1 && j==columns-1) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j-2],grid[i-1][j],grid[i-1][j-1],grid[i-1][j-2],grid[i-1][j-3]);
				}
				
				if(i==0 && j%2!=0 && j!=columns-1 && j!=1) { //top side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2]);
				}
				
				if(i!=0 && i!=gridSize-1 && j==columns-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i-1][j],grid[i-1][j-2],grid[i-1][j-3],grid[i+1][j]);
				}
				
				if(i==gridSize-1 && j!=1 && j!=columns-1 && j%2!=0) { //bottom side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i-1][j],grid[i-1][j+1],grid[i-1][j-2],grid[i-1][j-3]);
				}
				
				if(i!=0 && i!=gridSize-1 && j==1) { //left side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j+2]);
					grid[i][j].setNeighbors(grid[i-1][j-1],grid[i-1][j],grid[i-1][j+1]);
					grid[i][j].setNeighbors(grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2]);
				}
				
				if(i!=0 && i!=gridSize-1 && j!=1 && j!=columns-1 && j%2!=0) { //all other odd triangles
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i-1][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2]);
					grid[i][j].setNeighbors(grid[i-1][j],grid[i-1][j+1],grid[i-1][j-2],grid[i-1][j-3]);
				}
			}
		}
	}
	
	public void setAllNormalToroidalNeighbors(Cell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j+1]);
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i+1][j+2],grid[i+1][j+3]);
					grid[i][j].setNeighbors(grid[gridSize-1][0],grid[i][columns-1],grid[i][columns-2],grid[i+1][columns-1]);
					grid[i][j].setNeighbors(grid[gridSize-1][columns-1],grid[gridSize-1][columns-2]);
				}
				
				if(i==0 && j%2==0 && j==columns-2) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j-2],grid[i+1][j],grid[i+1][j-1],grid[i+1][j+1]);
					grid[i][j].setNeighbors(grid[i][0],grid[i+1][0],grid[i+1][1]);
					grid[i][j].setNeighbors(grid[gridSize-1][j],grid[gridSize-1][j-1],grid[gridSize-1][j-2]);
				}
				
				if(i==gridSize-1 && j==0) { //bottom left corner 
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j+2],grid[i-1][j]);
					grid[i][j].setNeighbors(grid[0][j],grid[0][j+1],grid[0][j+2],grid[0][j+3]);
					grid[i][j].setNeighbors(grid[i][columns-1],grid[i][columns-2],grid[i-1][columns-1],grid[i-1][columns-2],grid[0][columns-1]);
					grid[i][j].setNeighbors(grid[0][0],grid[0][1],grid[0][2],grid[0][3]);
				}
				
				if(i==gridSize-1 && j%2==0 && j==columns-2) { //bottom right corner 
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i][j-2],grid[i-1][j],grid[i-1][j-1],grid[i-1][j-2]);
					grid[i][j].setNeighbors(grid[i][0],grid[0][0],grid[0][1],grid[0][j],grid[0][j-1],grid[0][j+1]);
				} //
				
				if(i==0 && j%2==0 && j!=0 && j!=columns-2) { //top side triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i+1][j+1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i+1][j],grid[i+1][j-1],grid[i+1][j+2],grid[i+1][j+3]);
					grid[i][j].setNeighbors(grid[gridSize-1][j],grid[gridSize-1][j-1],grid[gridSize-1][j-2]);
				}
				
				if(i==gridSize-1 && j!=0 && j!=columns-2 && j%2==0) { //bottom side triangle
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i-1][j],grid[i-1][j-1],grid[i-1][j-2]);
					grid[i][j].setNeighbors(grid[0][j],grid[0][j-1],grid[0][j+1],grid[0][j+2],grid[0][j+3]);
				}
				
				if(j==0 && i!=0 && i!=gridSize-1) { //left side 
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j+2],grid[i-1][j],grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2],grid[i+1][j+3]);
					grid[i][j].setNeighbors(grid[i][columns-1],grid[i][columns-2],grid[i-1][columns-1],grid[i-1][columns-2],grid[i+1][columns-1]);
				}
				
				if(j==columns-2 && i!=0 && i!=gridSize-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j-1],grid[i][j+1],grid[i-1][j],grid[i-1][j-1],grid[i-1][j-2],grid[i+1][j],grid[i+1][j-1],grid[i+1][j+1]);
					grid[i][j].setNeighbors(grid[i][0],grid[i+1][0],grid[i+1][1]);
				}
				
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=columns-1 && j%2==0) { //all other triangles
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i+1][j+1]);
				}
			}
		}
	}
	
	public void setAllInvertedToroidalNeighbors(Cell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				
				if(i==0 && j==columns-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j-2],grid[i+1][j]);
					grid[i][j].setNeighbors(grid[i][0],grid[i][1],grid[i+1][0],grid[i+1][1]);
					grid[i][j].setNeighbors(grid[gridSize-1][0],grid[gridSize-1][j],grid[gridSize-1][j-1],grid[gridSize-1][j-2],grid[gridSize-1][j-3]);
				}
				
				if(i==0 && j==1) { //top left corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j+2],grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2]);
					grid[i][j].setNeighbors(grid[i][columns-1],grid[gridSize-1][0],grid[gridSize-1][1],grid[gridSize-1][2],grid[gridSize-1][columns-1],grid[gridSize-1][columns-2]);
				}
				
				if(i==gridSize-1 && j==1) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j+2],grid[i-1][j-1],grid[i-1][j],grid[i-1][j+1]);
					grid[i][j].setNeighbors(grid[0][j],grid[0][j+1],grid[0][j+2],grid[i][columns-1],grid[i-1][columns-1],grid[i-1][columns-2]);
				}
				
				if(i==gridSize-1 && j==columns-1) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j-2],grid[i-1][j],grid[i-1][j-1],grid[i-1][j-2],grid[i-1][j-3]);
					grid[i][j].setNeighbors(grid[i][0],grid[i][1],grid[i-1][0],grid[0][0],grid[0][1],grid[0][j]);
				}
				
				if(i==0 && j%2!=0 && j!=columns-1 && j!=1) { //top side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2]);
					grid[i][j].setNeighbors(grid[gridSize-1][j],grid[gridSize-1][j+1],grid[gridSize-1][j-1],grid[gridSize-1][j-2],grid[gridSize-1][j-3]);
				}
				
				if(i!=0 && i!=gridSize-1 && j==columns-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i-1][j],grid[i-1][j-2],grid[i-1][j-3],grid[i+1][j]);
					grid[i][j].setNeighbors(grid[i][0],grid[i][1],grid[i-1][0],grid[i+1][0],grid[i+1][1]);
				}
				
				if(i==gridSize-1 && j!=1 && j!=columns-1 && j%2!=0) { //bottom side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i-1][j],grid[i-1][j+1],grid[i-1][j-2],grid[i-1][j-3]);
					grid[i][j].setNeighbors(grid[0][j],grid[0][j+1],grid[0][j+2]);
				}
				
				if(i!=0 && i!=gridSize-1 && j==1) { //left side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i][j+2]);
					grid[i][j].setNeighbors(grid[i-1][j-1],grid[i-1][j],grid[i-1][j+1]);
					grid[i][j].setNeighbors(grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2]);
					grid[i][j].setNeighbors(grid[i][columns-1],grid[i-1][columns-1],grid[i-1][columns-2]);
				}
				
				if(i!=0 && i!=gridSize-1 && j!=1 && j!=columns-1 && j%2!=0) { //all other odd triangles
					grid[i][j].setNeighbors(grid[i][j-1],grid[i][j+1],grid[i-1][j-1]);
					grid[i][j].setNeighbors(grid[i][j-2],grid[i][j+2],grid[i+1][j],grid[i+1][j+1],grid[i+1][j+2]);
					grid[i][j].setNeighbors(grid[i-1][j],grid[i-1][j+1],grid[i-1][j-2],grid[i-1][j-3]);
				}
			}
		}
	}
}
