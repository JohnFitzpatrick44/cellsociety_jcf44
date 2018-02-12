package agents;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import View.MainView;
import rectCells.AntCell;
import rectCells.Cell;

public class AntAgent extends Agent {

	private AntCell location;
	private boolean hasFood;
	
	public AntAgent(Cell location) {
		super(cellWidth(location)/8);
		this.location = (AntCell) location;
		hasFood = false;
		MainView.getGroup().getChildren().add(this);
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
				
		moveToFirst(location.getNeighbors());
		
		if(location.getState() == 2) { 		// AT NEST
			hasFood = false;
			location.setFoodPheromones(1);
		} else {
			location.setFoodPheromones(getMaxFoodPheromones() * 0.9);
		}
	}
	
	private void findFood() {
		
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
		
		if(location.getState() == 1) {		// FOOOOD
			hasFood = true;
			location.setNestPheromones(1);
		} else {
			location.setNestPheromones(getMaxNestPheromones() * 0.9);
		}
		
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
