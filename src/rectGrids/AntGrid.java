package rectGrids;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import XML.AntHolder;
import agents.AntAgent;
import agents.AntAgentMover;
import rectCells.AntCell;
import rectCells.Cell;

public class AntGrid extends RectangleGrid {
	private String configString = AntHolder.getSugarGrid();
	
	private static final int NUM_AGENTS = 40;
	
	private AntAgentMover aam;
	
	public Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff){
		int[] gridConfig = getGridConfig(configString);
		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		int index = 0;
		aam = new AntAgentMover();
		ArrayList<int[]> nestCells = new ArrayList<>();
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(index < gridConfig.length) {
					grid[i][j] = new AntCell(gridConfig[index], offset+blockSpacing,offset+heightSpacing,
							  offset+blockSpacing+cellWidth,offset+heightSpacing,
							  offset+blockSpacing+cellWidth, offset+heightSpacing+cellHeight,
							  offset+blockSpacing,offset+heightSpacing+cellHeight);
					if(gridConfig[index] == 2) {
						nestCells.add(new int[] {i,j});
					}
				} else {
					grid[i][j] = new AntCell(0, offset+blockSpacing,offset+heightSpacing,
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
			Collections.shuffle(nestCells);
			int i = nestCells.get(0)[0];
			int j = nestCells.get(0)[1];
			int counter = 0;
			while(!((AntCell) grid[i][j]).roomForAnts()) {
				Collections.shuffle(nestCells);
				i = nestCells.get(0)[0];
				j = nestCells.get(0)[1];
				counter++;
				if(counter == 5000) {
					break;
				}
			}
			
			AntAgent sa = new AntAgent((AntCell) grid[i][j]);
			((AntCell) grid[i][j]).addAnt(sa);
			aam.addAnt(sa);
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
		
		aam.updateAnts();
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].updateState();
			}
		}
	}
	
}
