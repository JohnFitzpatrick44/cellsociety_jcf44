package rectCells;

import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

import View.MainView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SugarAgent extends Circle {
	
	private int vision;
	private int metabolism;
	private int sugar;
	private int initialSugar;
	private SugarCell place;
	private SugarAgentMover sam;
	
	private static final Color MALE_COLOR = Color.BLUE;
	private static final Color FEMALE_COLOR = Color.RED;
	private static final Color OLD_COLOR = Color.GRAY;
	
	private boolean gender;		// Female is true, male is false
	private int age;
	private static final int MAX_AGE = 80;
	private static final int FERTILITY_MIN = 20;
	private static final int FERTILITY_MAX = 55;
	private boolean reproduced;
	
	public SugarAgent(SugarCell c, int vision, int metabolism, int initSugar) {
		super(cellWidth(c)/4);
		this.vision = vision;
		age = 0;
		this.metabolism = metabolism;
		this.sugar = initSugar;
		this.initialSugar = initSugar;
		this.place = c;
		updatePos();
		this.toFront();
		reproduced = false;
		gender = ThreadLocalRandom.current().nextBoolean();
		if(gender) {
			setFill(FEMALE_COLOR); 
		} else {
			setFill(MALE_COLOR);
		}
	}
	
	public SugarCell getCell() {
		return place;
	}
	
	public void setCell(SugarCell sc) {
		place = sc;
		
	}
	
	public void updateState() {
		age++;
		reproduced = false;
		lookAndMove();
		
		sugar -= metabolism;
		if(sugar <= 0 || age > MAX_AGE) {
			place.setAgent(null);
			sam.removeAgent(this);
		} else {
			updatePos();
		}
		if(age > FERTILITY_MAX) {
			setFill(OLD_COLOR);
		}
	}
	
	public void updatePos() {
		setCenterX(place.getPoints().get(0) + cellWidth(place)/2);
		setCenterY(place.getPoints().get(1) + cellWidth(place)/2);
		this.toFront();
	}
	
	private static double cellWidth(Cell c) {
		return c.getPoints().get(2)-c.getPoints().get(0);
	}
	
	private void lookAndMove() {
		Collections.shuffle(place.getNeighbors());
		Collections.sort(place.getNeighbors(), new Comparator<Cell>() {

			@Override
			public int compare(Cell o1, Cell o2) {
				return o2.getState() - o1.getState();
			}
			
		});
		
		for(int k = 0; k < place.getNeighbors().size(); k++) {
			if(((SugarCell) place.getNeighbors().get(k)).getAgent() == null) {
				place.setAgent(null);
				place = (SugarCell) place.getNeighbors().get(k);
				place.setAgent(this);
				break;
			}
		}
		
		sugar += place.getState();
		place.setState(0);
	}
	
	public void addSAM(SugarAgentMover samAdd) {
		sam = samAdd;
	}
	
	public boolean isFertile() {
		return age > FERTILITY_MIN && age < FERTILITY_MAX && sugar >= initialSugar && !reproduced;
	}

	public boolean isFemale() {
		return gender;
	}
	
	public void setSugar(int s) {
		sugar = s;
	}
	
	public int getSugar() {
		return sugar;
	}
	
	public void reproduce() {
		sugar = sugar - initialSugar/2;
		reproduced = true;
	}

	public int getVision() {
		return vision;
	}

	public int getMetabolism() {
		return metabolism;
	}

	public int getInitialSugar() {
		return initialSugar;
	}

	public SugarCell findSpot() {
		for(Cell c : place.getNeighbors()) {
			if(((SugarCell) c).getAgent() == null) {
				return (SugarCell) c;
			}
		}
		return null;
	}
	
}
