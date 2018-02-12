package neighbors;

import rectCells.Cell;
import rectCells.CellMover;

public class TriangleFiniteNeighbors {
	
	private CellMover cm = new CellMover();

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
}
