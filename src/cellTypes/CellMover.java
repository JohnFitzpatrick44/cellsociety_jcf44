package cellTypes;

import java.util.ArrayList;
import java.util.Collections;

public class CellMover {
	
	private ArrayList<Cell> cellList;
	
	public CellMover() {
		cellList = new ArrayList<Cell>();
	}
	
	public void addCell(Cell c) {
		cellList.add(c);
	}
	
	public Cell findOpenCell() {
		Collections.shuffle(cellList);
		for(int k = 0; k < cellList.size(); k++) {
			if(cellList.get(k).getState() == 0) return cellList.get(k);
		}
		return null;
	}
}
