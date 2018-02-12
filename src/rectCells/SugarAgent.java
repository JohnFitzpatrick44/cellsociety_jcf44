package rectCells;

import java.util.Collections;
import java.util.Comparator;

import View.MainView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SugarAgent extends Circle {
	
	private int vision;
	private int metabolism;
	private int sugar;
	private SugarCell place;
	
	public SugarAgent(SugarCell c, int vision, int metabolism, int initSugar) {
		super(cellWidth(c)/4, Color.RED);
		this.vision = vision;
		this.metabolism = metabolism;
		this.sugar = initSugar;
		this.place = c;
		updatePos();
		this.toFront();
	}
	
	public SugarCell getCell() {
		return place;
	}
	
	public void setCell(SugarCell sc) {
		place = sc;
		
	}
	
	public void updateState() {
		lookAndMove();
		
		sugar -= metabolism;
		if(sugar <= 0) {
			place.setAgent(null);
			MainView.getGroup().getChildren().remove(this);
		} else {
			updatePos();
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
			}
		}
		
		sugar += place.getState();
		place.setState(0);
	}
	
}
