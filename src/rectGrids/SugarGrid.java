package rectGrids;

import java.util.concurrent.ThreadLocalRandom;

import View.MainView;
import XML.FireHolder;
import XML.LifeHolder;
import XML.SugarHolder;
import rectCells.BacteriaCell;
import rectCells.Cell;
import rectCells.SugarAgent;
import rectCells.SugarAgentMover;
import rectCells.SugarCell;

public class SugarGrid extends RectangleGrid {
	private String configString = SugarHolder.getFireGrid();
	
	private static final int NUM_AGENTS = 5;
	
	private SugarAgentMover sam;
	
	public Cell[][] createGrid(int offset, int gridSize, int cellWidth, int cellHeight, double cutOff){
		int[] gridConfig = getGridConfig(configString);
		Cell[][] grid = new Cell[gridSize][gridSize];
		int heightSpacing = 0;
		int index = 0;
		for(int i=0;i<grid.length;i++) {
			int blockSpacing = 0;
			for(int j=0;j<grid[i].length;j++) {
				if(index < gridConfig.length) {
					grid[i][j] = new SugarCell(gridConfig[index], offset+blockSpacing,offset+heightSpacing,
							  offset+blockSpacing+cellWidth,offset+heightSpacing,
							  offset+blockSpacing+cellWidth, offset+heightSpacing+cellHeight,
							  offset+blockSpacing,offset+heightSpacing+cellHeight);
				} else {
					grid[i][j] = new SugarCell(5, offset+blockSpacing,offset+heightSpacing,
							  offset+blockSpacing+cellWidth,offset+heightSpacing,
							  offset+blockSpacing+cellWidth, offset+heightSpacing+cellHeight,
							  offset+blockSpacing,offset+heightSpacing+cellHeight);
				}
				blockSpacing += cellWidth;
				index++;
				
			}
			heightSpacing += cellHeight;
		}
		sam = new SugarAgentMover();
		for(int k = 0; k < NUM_AGENTS; k++) {
			int i = ThreadLocalRandom.current().nextInt(0, gridSize);
			int j = ThreadLocalRandom.current().nextInt(0, gridSize);
			
			if(((SugarCell) grid[i][j]).getAgent() == null) {
				int init_vision = 1;
				int init_metabolism = ThreadLocalRandom.current().nextInt(5, 21);
				int init_sugar = ThreadLocalRandom.current().nextInt(15, 31);
				SugarAgent sa = new SugarAgent((SugarCell) grid[i][j], init_vision, init_metabolism, init_sugar);
				((SugarCell) grid[i][j]).setAgent(sa);
				sam.addAgent(sa);
				sa.addSAM(sam);
			} else {
				k--;
				continue;
			}
			
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
		
		sam.updateAgents();
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j].updateState();
			}
		}
	}
	
}