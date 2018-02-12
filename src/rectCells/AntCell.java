package rectCells;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class AntCell extends Cell {
	
	private static final Color EMPTY_COLOR = Color.BLACK;
	private static final Color FOOD_COLOR = Color.BLUE;
	private static final Color NEST_COLOR = Color.GREEN;
	
	private static final int MAX_STATE = 2; //Empty, Food, Nest

	private double foodPheromones;
	private double nestPheromones;
	
	private ArrayList<AntAgent> ants;
	
	public AntCell(int state, double...points) {
		this(points);
		this.setState(state);
		updateFill();
	}

	public AntCell(double...points) {
		super(points);
		foodPheromones = 0;
		nestPheromones = 0;
		ants = new ArrayList<>();
		updateFill();
	}
	
	public void updateState() {
		
	}

	public void updateFill() {
		switch(getState()) {
		case 0:
			setFill(EMPTY_COLOR);
			break;
		case 1:
			setFill(FOOD_COLOR);
			break;
		case 2:
			setFill(NEST_COLOR);
			break;
		}
	}

	public int getMaxState() {
		return MAX_STATE;
	}

}
