package rectGrids;

import java.util.concurrent.ThreadLocalRandom;

import XML.AntHolder;
import agents.AntAgent;
import rectCells.AntCell;
import rectCells.Cell;

public class AntGrid extends RectangleGrid {
	private String configString = AntHolder.getSugarGrid();
	
	private static final int NUM_AGENTS = 40;
	
	//private SugarAgentMover sam;
	
	public Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff){
		int[] gridConfig = getGridConfig(configString);
		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		int index = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(index < gridConfig.length) {
					grid[i][j] = new AntCell(gridConfig[index], offset+blockSpacing,offset+heightSpacing,
							  offset+blockSpacing+cellWidth,offset+heightSpacing,
							  offset+blockSpacing+cellWidth, offset+heightSpacing+cellHeight,
							  offset+blockSpacing,offset+heightSpacing+cellHeight);
				} else {
					grid[i][j] = new AntCell(5, offset+blockSpacing,offset+heightSpacing,
							  offset+blockSpacing+cellWidth,offset+heightSpacing,
							  offset+blockSpacing+cellWidth, offset+heightSpacing+cellHeight,
							  offset+blockSpacing,offset+heightSpacing+cellHeight);
				}
				blockSpacing += cellWidth;
				index++;
				
			}
			heightSpacing += cellHeight;
		}
		for(int k = 0; k < NUM_AGENTS; k++) {
			int i = ThreadLocalRandom.current().nextInt(0, gridSize);
			int j = ThreadLocalRandom.current().nextInt(0, gridSize);
			
			while(!((AntCell) grid[i][j]).roomForAnts()) {
				i = ThreadLocalRandom.current().nextInt(0, gridSize);
				j = ThreadLocalRandom.current().nextInt(0, gridSize);
			}
			
			AntAgent sa = new AntAgent((AntCell) grid[i][j]);
			((AntCell) grid[i][j]).addAnt(sa);
		}
		return grid;
	}
	
	@Override
	public void updateStates(Cell[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].updateNeighborStates();
			}
		}
		
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].updateState();
			}
		}
	}
	
}
