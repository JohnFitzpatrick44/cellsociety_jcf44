package triangleGrids;

import gridTypes.Grid;
import triangleCells.TriangleCell;

public abstract class TriangleGrid extends Grid{

	public abstract TriangleCell[][] createGrid(double offset, int gridSize, double side, double cutOff);

//	private CellMover cm = new CellMover();
	
	public void setAllEvenNeighbors(TriangleCell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
//				grid[i][j].setCellMover(cm);
//				cm.addCell(grid[i][j]);
				
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
	
	public void setAllOddNeighbors(TriangleCell[][] grid, int gridSize) {
		int columns = gridSize*2;
		for(int i=0;i<grid.length;i++) { //i=10
			for(int j=0;j<grid[i].length;j++) { //j=20
//				grid[i][j].setCellMover(cm);
//				cm.addCell(grid[i][j]);
				
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
	
}
