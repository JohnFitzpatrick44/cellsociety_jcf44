package agents;

import java.util.Collections;
import java.util.Comparator;

import javafx.scene.shape.Circle;
import rectCells.AntCell;
import rectCells.Cell;

public class AntAgent extends Agent {

	private AntCell location;
	private boolean hasFood;
	
	public AntAgent(Cell location) {
		super(cellWidth(location)/8);
		this.location = (AntCell) location;
		hasFood = false;
	}
	
	public void updateState() {
		if(hasFood) {
			returnToNest();
		} else {
			findFood();
		}
	}
	
	private void returnToNest() {
		Collections.shuffle(location.getNeighbors());
		Collections.sort(location.getNeighbors(), new Comparator<Cell>() {
			@Override
			public int compare(Cell o1, Cell o2) {
				if(((AntCell) o2).getNestPheromones() > ((AntCell) o1).getNestPheromones()) {
					return 1;
				} else if (((AntCell) o2).getNestPheromones() == ((AntCell) o1).getNestPheromones()) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		
		location.setFoodPheromones(1);
		
		for(int k = 0; k < location.getNeighbors().size(); k++) {
			if(((AntCell) location.getNeighbors().get(k)).roomForAnts()) {
				((AntCell) location.getNeighbors().get(k)).addAnt(this);
				location.removeAnt(this);
				location = (AntCell) location.getNeighbors().get(k);
				updatePos(location);
				break;
			}
		}
		
		if(location.getState() == 2) { 		// AT NEST
			hasFood = false;
		}
	}
	
	private void findFood() {
		
	}
	
	
	
}
