package agents;

import javafx.scene.shape.Circle;
import rectCells.Cell;

public abstract class Agent extends Circle {
	
	public Agent(double radius) {
		super(radius);
	}
	
	public abstract void updateState();
	
	public void updatePos(Cell place) {
		setCenterX(place.getPoints().get(0) + cellWidth(place)/2);
		setCenterY(place.getPoints().get(1) + cellWidth(place)/2);
		this.toFront();
	}
	
	public static double cellWidth(Cell c) {
		return c.getPoints().get(2)-c.getPoints().get(0);
	}
	
}
