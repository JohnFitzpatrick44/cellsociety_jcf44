package rectCells;

import java.util.ArrayList;

import agents.AntAgent;
import javafx.scene.paint.Color;

public class AntCell extends Cell {
	
	private static final Color FOOD_COLOR = Color.BLUE;
	private static final Color NEST_COLOR = Color.GREEN;
	
	private static final int INIT_DURABILITY = 50;
	private static final double DECAY_RATE = 0.05;
	
	private static final int MAX_ANTS = 3;
	
	private static final int MAX_STATE = 2; //Empty, Food, Nest
	
	private static final int FOOD = 1;
	private static final int NEST = 2;

	private static final int COLOR_RATIO = 128;
	
	private double foodPheromones;
	private double nestPheromones;
	
	private int foodDurability;
	
	private ArrayList<AntAgent> ants;
	
	public AntCell(int state, double...points) {
		this(points);
		this.setState(state);
		if(state == FOOD) {
			foodPheromones = FOOD;
			foodDurability = INIT_DURABILITY;
		} else if(state == NEST) {
			nestPheromones = FOOD;
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
		foodPheromones -= DECAY_RATE*foodPheromones;
		if(foodPheromones < DECAY_RATE) {
			foodPheromones = 0;
		}
		nestPheromones -= DECAY_RATE*nestPheromones;
		if(nestPheromones < DECAY_RATE) {
			nestPheromones = 0;
		}
		updateFill();
	}

	public void updateFill() {
		switch(getState()) {
		case 0:
			setFill(Color.rgb(0, (int)(COLOR_RATIO*nestPheromones), (int)(COLOR_RATIO*foodPheromones)));
			break;
		case FOOD:
			setFill(FOOD_COLOR);
			break;
		case NEST:
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
