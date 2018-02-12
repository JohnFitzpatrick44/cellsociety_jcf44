package agents;

import javafx.scene.shape.Circle;
import rectCells.Cell;

/**
 * Abstract class for Agents, which accompany cells. They will all be circles superimposed on the cell grid.
 * @author team_03
 *
 */
public abstract class Agent extends Circle {
	
	/**
	 * Constructor called, only argument is radius of circle
	 * @param radius Radius of agent
	 */
	public Agent(double radius) {
		super(radius);
	}
	
	/**
	 * Updates the agent state
	 */
	public abstract void updateState();
	
	/**
	 * Updates the agent position
	 * @param c The owner cell of the agent
	 */
	public void updatePos(Cell c) {
		setCenterX(c.getPoints().get(0) + cellWidth(c)/2);
		setCenterY(c.getPoints().get(1) + cellWidth(c)/2);
		this.toFront();
	}
	
	public static double cellWidth(Cell c) {
		return c.getPoints().get(2)-c.getPoints().get(0);
	}
	
}
