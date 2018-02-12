package agents;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.paint.Color;
import rectCells.AntCell;
import rectCells.Cell;

public class AntAgent extends Agent {

	private AntCell location;
	private boolean hasFood;
	private static final Color ANT_COLOR = Color.RED;
	
	public AntAgent(Cell location) {
		super(cellWidth(location)/8);
		this.location = (AntCell) location;
		hasFood = false;
		setFill(ANT_COLOR);
	}
	
	public void updateState() {
		if(hasFood) {
			returnToNest();
		} else {
			findFood();
		}
	}
	
	private void returnToNest() {
		
		if(location.getState() == 2) { 		// AT NEST
			hasFood = false;
			location.setNestPheromones(1);
		} else {
			location.setFoodPheromones(Math.max(location.getFoodPheromones(), getMaxFoodPheromones() * 0.95));
		}
		
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
				
		moveToFirst(location.getNeighbors());
		
		
	}
	
	private void findFood() {
		
		if(location.getState() == 1) {		// FOOOOD
			hasFood = true;
			location.reduceDurability();
			location.setFoodPheromones(1);
		} else {
			location.setNestPheromones(Math.max(location.getNestPheromones(), getMaxNestPheromones() * 0.95));
		}
		
		Collections.shuffle(location.getNeighbors());
		Collections.sort(location.getNeighbors(), new Comparator<Cell>() {
			@Override
			public int compare(Cell o1, Cell o2) {
				if(((AntCell) o2).getFoodPheromones() > ((AntCell) o1).getFoodPheromones()) {
					return 1;
				} else if (((AntCell) o2).getFoodPheromones() == ((AntCell) o1).getFoodPheromones()) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		
		moveToFirst(location.getNeighbors());
		
		
		
	}
	
	private void moveToFirst(List<Cell> list) {
		for(int k = 0; k < list.size(); k++) {
			if(((AntCell) list.get(k)).roomForAnts()) {
				((AntCell) list.get(k)).addAnt(this);
				location.removeAnt(this);
				location = (AntCell) list.get(k);
				updatePos(location);
				break;
			}
		}
	}
	
	private double getMaxNestPheromones() {
		double max = 0;
		for(Cell c : location.getNeighbors()) {
			if(((AntCell) c).getNestPheromones() > max) {
				max = ((AntCell) c).getNestPheromones();
			}
		}
		return  Math.max(location.getNestPheromones(), max);
		
	}
	
	private double getMaxFoodPheromones() {
		double max = 0;
		for(Cell c : location.getNeighbors()) {
			if(((AntCell) c).getFoodPheromones() > max) {
				max = ((AntCell) c).getFoodPheromones();
			}
		}
		
		return  Math.max(location.getFoodPheromones(), max);
		
	}
	
}
