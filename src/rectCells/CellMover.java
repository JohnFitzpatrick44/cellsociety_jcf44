package rectCells;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Jack Fitzpatrick
 * CellMover class, to be used in tandem with Cells and Grid
 * Tracks all Cells in a simulation, used to find open spaces or switch Cell states
 */
public class CellMover {

	/**
	 * List of all Cells in a simulation
	 */
	private ArrayList<Cell> cellList;

	/**
	 * Constructor, no arguments needed
	 */
	public CellMover() {
		cellList = new ArrayList<>();
	}

	/**
	 * Adds a Cell to the list
	 * @param c Cell to be added
	 */
	public void addCell(Cell c) {
		cellList.add(c);
	}

	/**
	 * Finds and returns a random open (state == 0) Cell in the grid
	 * @return Random Cell with state of 0
	 */
	public Cell findOpenCell() {
		Collections.shuffle(cellList);
		for(int k = 0; k < cellList.size(); k++) {
			if(cellList.get(k).getState() == 0) {
				return cellList.get(k);
			}
		}
		return null;
	}

	/**
	 * Copies state of one Cell into another, sets swapped values
	 * @param origin Cell to be copied
	 * @param destination Cell to be copied to
	 */
	public void copyState(Cell origin, Cell destination) {
		destination.setState(origin.getState());
		destination.setSwapped(true);
		origin.setSwapped(true);
		destination.updateFill();
	}

	public double getPercentAlike(int state) {
		double count = 0;
		for(Cell c : cellList) {
			if(c.getState() == state) {
				count++;
			}
		}
		return count/cellList.size();
	}
}
