package rectGrids;

import rectCells.Cell;
import rectCells.CellMover;

public abstract class RectangleGrid extends Grid{
	
	private CellMover cm = new CellMover();
	
	/**
	 * @param offset Amount of offset from edge of user interface
	 * @param gridSize Number of rows and columns of cells
	 * @param cellWidth Width of each cell
	 * @param cellHeight Height of each cell
	 * @param cutOff
	 * @return 2D array of Cells
	 */
	public abstract Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff);

	public void setAllCornerNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j]); //adjacent cells
					grid[i][j].setNeighbor(grid[i+1][j+1]); //right bottom cell
				}
				
				if(i==0 && j==gridSize-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j]); //adjacent cells
					grid[i][j].setNeighbor(grid[i+1][j-1]); //left bottom cell
				}
				
				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i-1][j]); //adjacent cells
					grid[i][j].setNeighbor(grid[i-1][j+1]); //right top cell
				}
				
				if(i==gridSize-1 && j==gridSize-1) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j]); //adjacent cells
					grid[i][j].setNeighbor(grid[i-1][j-1]); //left top cell
				}
			}
		}	
	}
	
	public void setAllSideNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j!=0 && j!=gridSize-1) { //top side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i][j-1]); //adjacent cells
					grid[i][j].setNeighbors(grid[i+1][j+1],grid[i+1][j-1]); //diagonal cells
				}
				
				if(i==gridSize-1 && j!=0 && j!=gridSize-1) { //bottom side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j+1],grid[i-1][j-1]); //diagonal cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==0) { //left side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i-1][j]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j+1],grid[i+1][j+1]); //diagonal cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==gridSize-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j],grid[i-1][j]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j-1],grid[i+1][j-1]); //diagonal cells
				}
			}
		}	
	}
	
	public void setAllMiddleNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=gridSize-1) { //middle cells
					grid[i][j].setNeighbors(grid[i+1][j],grid[i-1][j],grid[i][j+1],grid[i][j-1]); //adjacent cells
					grid[i][j].setNeighbors(grid[i+1][j+1],grid[i+1][j-1],grid[i-1][j+1],grid[i-1][j-1]); //diagonal cells
				}
			}
		}	
	}
	
	public void setCardinalCornerNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j]); //adjacent cells
				}
				
				if(i==0 && j==gridSize-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j]); //adjacent cells
				}

				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i-1][j]); //adjacent cells
				}
				
				if(i==gridSize-1 && j==gridSize-1) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j]); //adjacent cells
				}
			}
		}	
	}
	
	public void setCardinalSideNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j!=0 && j!=gridSize-1) { //top side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i][j-1]); //adjacent cells
				}
				
				if(i==gridSize-1 && j!=0 && j!=gridSize-1) { //bottom side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j]); //adjacent cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==0) { //left side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i-1][j]); //adjacent cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==gridSize-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j],grid[i-1][j]); //adjacent cells
				}
			}
		}	
	}
	
	public void setCardinalMiddleNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i!=0 && i!=gridSize-1 && j!=0 && j!=gridSize-1) { //middle cells
					grid[i][j].setNeighbors(grid[i+1][j],grid[i-1][j],grid[i][j+1],grid[i][j-1]); //adjacent cells
				}
			}
		}	
	}
	
	public void setCardinalSideToroidalNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j!=0 && j!=gridSize-1) { //top side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i][j-1],grid[gridSize-1][j]); //adjacent cells
				}
				
				if(i==gridSize-1 && j!=0 && j!=gridSize-1) { //bottom side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j],grid[0][j]); //adjacent cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==0) { //left side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i-1][j],grid[i][gridSize-1]); //adjacent cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==gridSize-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j],grid[i-1][j],grid[i][0]); //adjacent cells
				}
			}
		}
	}
	
	public void setCardinalCornerToroidalNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[gridSize-1][j],grid[i][gridSize-1]); //adjacent cells
				}
				
				if(i==0 && j==gridSize-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j],grid[gridSize-1][j],grid[0][j]); //adjacent cells
				}

				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i-1][j],grid[0][j],grid[i][gridSize-1]); //adjacent cells
				}
				
				if(i==gridSize-1 && j==gridSize-1) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j],grid[0][j],grid[i][0]); //adjacent cells
				}
			}
		}	
	}
	
	public void setAllCornerToroidalNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j==0) { //top left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[gridSize-1][j],grid[i][gridSize-1]); //adjacent cells
					grid[i][j].setNeighbors(grid[i+1][j+1],grid[i+1][gridSize-1],grid[gridSize-1][j+1]); //right bottom cell
				}
				
				if(i==0 && j==gridSize-1) { //top right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j],grid[gridSize-1][j],grid[0][j]); //adjacent cells
					grid[i][j].setNeighbors(grid[i+1][j-1],grid[i+1][0],grid[gridSize-1][j-1]); //left bottom cell
				}
				
				if(i==gridSize-1 && j==0) { //bottom left corner
					grid[i][j].setNeighbors(grid[i][j+1],grid[i-1][j],grid[0][j],grid[i][gridSize-1]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j+1],grid[i-1][gridSize-1],grid[0][j+1]); //right top cell
				}
				
				if(i==gridSize-1 && j==gridSize-1) { //bottom right corner
					grid[i][j].setNeighbors(grid[i][j-1],grid[i-1][j],grid[0][j],grid[i][0]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j-1],grid[i-1][0],grid[0][j-1]); //left top cell
				}
			}
		}	
	}
	
	public void setAllSideToroidalNeighbors(Cell[][] grid, int gridSize) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].setCellMover(cm);
				cm.addCell(grid[i][j]);
				if(i==0 && j!=0 && j!=gridSize-1) { //top side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i][j-1], grid[gridSize-1][j]); //adjacent cells
					grid[i][j].setNeighbors(grid[i+1][j+1],grid[i+1][j-1],grid[gridSize-1][j-1],grid[gridSize-1][j+1]); //diagonal cells
				}
				
				if(i==gridSize-1 && j!=0 && j!=gridSize-1) { //bottom side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i][j-1],grid[i-1][j],grid[0][j]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j+1],grid[i-1][j-1],grid[0][j-1],grid[0][j+1]); //diagonal cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==0) { //left side
					grid[i][j].setNeighbors(grid[i][j+1],grid[i+1][j],grid[i-1][j],grid[i][gridSize-1]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j+1],grid[i+1][j+1],grid[i+1][gridSize-1],grid[i-1][gridSize-1]); //diagonal cells
				}
				
				if(i!=0 && i!=gridSize-1 && j==gridSize-1) { //right side
					grid[i][j].setNeighbors(grid[i][j-1],grid[i+1][j],grid[i-1][j],grid[i][0]); //adjacent cells
					grid[i][j].setNeighbors(grid[i-1][j-1],grid[i+1][j-1],grid[i+1][0],grid[i-1][0]); //diagonal cells
				}
			}
		}	
	}
	
	public CellMover getCm() {return cm;}
	
}
