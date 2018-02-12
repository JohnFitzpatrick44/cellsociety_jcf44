package agents;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import XML.AntHolder;
import javafx.scene.paint.Color;
import rectCells.AntCell;
import rectCells.Cell;

/**
 * AntAgent to run with AntCell. Tracks individual ants, updates their position and pheromone release.
 * @author team_03
 */
public class AntAgent extends Agent {

	private AntCell location;
	private boolean hasFood;
	
	private static final int FOOD = 1;
	private static final int NEST = 2;

	
	private static final Color ANT_COLOR = AntHolder.getAntColor();
	private static final double PHEROMONE_DIFFUSION = AntHolder.getPheromoneDiffusion();
	private static final int ANT_SIZE_RATIO = AntHolder.getSizeRatio();
	
	public AntAgent(Cell location) {
		super(cellWidth(location)/ANT_SIZE_RATIO);
		this.location = (AntCell) location;
		hasFood = false;
		setFill(ANT_COLOR);
	}
	
	/**
	 * Updates hasFood and pheromone levels for relevant cell
	 */
	public void updateState() {
		if(hasFood) {
			returnToNest();
		} else {
			findFood();
		}
		
		if(location.getState() == FOOD) {		// FOOOOD
			hasFood = true;
			location.reduceDurability();
			location.setFoodPheromones(FOOD);
		} else if(location.getState() == NEST) { 		// AT NEST
			hasFood = false;
			location.setNestPheromones(FOOD);
		} else {
			location.setNestPheromones(Math.max(location.getNestPheromones(), getMaxNestPheromones() * PHEROMONE_DIFFUSION));
			location.setFoodPheromones(Math.max(location.getFoodPheromones(), getMaxFoodPheromones() * PHEROMONE_DIFFUSION));
		}
	}
	
	/**
	 * Mode where ant looks for nest with food
	 */
	private void returnToNest() {
		
		Collections.shuffle(location.getNeighbors());
		Collections.sort(location.getNeighbors(), new Comparator<Cell>() {
			/**
			 * Comparator to sort list by pheromone levels
			 */
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
	
	/**
	 * Mode where ant looks for food
	 */
	private void findFood() {
		Collections.shuffle(location.getNeighbors());
		Collections.sort(location.getNeighbors(), new Comparator<Cell>() {
			/**
			 * Comparator to sort list by pheromone levels
			 */
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
	
	/**
	 * Moves to first position in list
	 * @param list Of locations
	 */
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
	
	/**
	 * Finds and returns max pheromone levels
	 * @return Max pheromones in neighbors
	 */
	private double getMaxNestPheromones() {
		double max = 0;
		for(Cell c : location.getNeighbors()) {
			if(((AntCell) c).getNestPheromones() > max) {
				max = ((AntCell) c).getNestPheromones();
			}
		}
		return  Math.max(location.getNestPheromones(), max);
		
	}
	
	/**
	 * Finds and returns max pheromone levels
	 * @return Max pheromones in neighbors
	 */
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
