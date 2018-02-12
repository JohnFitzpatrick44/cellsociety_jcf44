package rectCells;

import java.util.ArrayList;

import agents.AntAgent;
import javafx.scene.paint.Color;

public class AntCell extends Cell {
	
	private static final Color EMPTY_COLOR = Color.BLACK;
	private static final Color FOOD_COLOR = Color.BLUE;
	private static final Color NEST_COLOR = Color.GREEN;
	
	private static final int INIT_DURABILITY = 50;
	
	private static final int MAX_ANTS = 3;
	
	private static final int MAX_STATE = 2; //Empty, Food, Nest

	private double foodPheromones;
	private double nestPheromones;
	
	private int foodDurability;
	
	private ArrayList<AntAgent> ants;
	
	public AntCell(int state, double...points) {
		this(points);
		this.setState(state);
		if(state == 1) {
			foodPheromones = 1;
			foodDurability = INIT_DURABILITY;
		} else if(state == 2) {
			nestPheromones = 1;
		}
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
		foodPheromones -= 0.02*foodPheromones;
		if(foodPheromones < 0.02) {
			foodPheromones = 0;
		}
		nestPheromones -= 0.02*nestPheromones;
		if(nestPheromones < 0.02) {
			nestPheromones = 0;
		}
		updateFill();
	}

	public void updateFill() {
		switch(getState()) {
		case 0:
			setFill(Color.rgb(0, (int)(128*nestPheromones), (int)(128*foodPheromones)));
			break;
		case 1:
			setFill(FOOD_COLOR);
			break;
		case 2:
			setFill(NEST_COLOR);
			break;

		}
		
	}
	
	public void reduceDurability() {
		foodDurability--;
		if(foodDurability <= 0) {
			setState(0);
		}
	}

	public int getMaxState() {
		return MAX_STATE;
	}
	
	public void addAnt(AntAgent a) {
		ants.add(a);
	}
	
	public void removeAnt(AntAgent a) {
		if(ants.contains(a)) {
			ants.remove(a);
		}
	}
	
	public boolean roomForAnts() {
		return !(ants.size() >= MAX_ANTS);
	}
	
	public double getNestPheromones() {
		return nestPheromones;
	}
	
	public double getFoodPheromones() {
		return foodPheromones;
	}
	
	public void setNestPheromones(double np) {
		nestPheromones = np;
	}
	
	public void setFoodPheromones(double fp) {
		foodPheromones = fp;
	}

}
